package vitzli.miscmfrcircuits.circuits.relay;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.RelayGen;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class DiskCircuit implements IRedNetLogicCircuit {

	class RelayInteg extends RelayGen {
		public float integSum = 0;
		public int pickupSetting = 1;
		public int L1Setting = 1;
		public int Ki = 1;
		public float L2Setting = 1.0f;
		public boolean enabledState = false;
		
		public RelayInteg(String name_handle) {
			super(name_handle);
		}

		@Override
		public void parseInputValues(long worldTime, int[] inputValues) {
			int signalValue = inputValues[0];
			pickupSetting = ValueFunctions.ConstraintInt(inputValues[1], 1,
					1 << 16);
			L1Setting = ValueFunctions.ConstraintInt(inputValues[2], 1,
					1 << 16);
			Ki = ValueFunctions.ConstraintInt(inputValues[3], 1, 1000) * 100;
			L2Setting = (float) (pickupSetting * ValueFunctions.ConstraintInt(
					inputValues[4], 64, 255)) / 64;
			enabledState = inputValues[5] == 0;

			if (enabledState) {
				if (signalValue > pickupSetting) {
					if (integSum > L1Setting || (signalValue >= L2Setting)) {
						if (this.state != State.TRIP) {
							this.state = State.TRIP;
							this.tripMoment = worldTime;
//							System.out.println("IntegSum=" + integSum);
							this.onTrip();
						}
					} else {
						this.state = State.ACTIVE;
						if (this.pickupMoment == 0) {
							this.pickupMoment = worldTime;
						}
						this.cntCLK++;
						integSum += ((float) signalValue / (float) Ki);
//						System.out.println("signal =" + signalValue
//								+ " / Sint = " + integSum);
					}
				} else {
					this.state = State.IDLE;
					integSum = 0;
					this.onIdle();
				}
			} else {
				this.state = State.PAUSE;
			}
		}
	}

	private RelayInteg relay = new RelayInteg("relay.induction");
	
	private final String[] inputNames = new String[] { "I", "I1p", "I1i",
			"I1k", "I2", "EN#" };
	private final String[] outputNames = new String[] { "TR", "ST", "TR#",
			"ST#" };

	@Override
	public int getInputCount() {
		return 6;
	}

	@Override
	public int getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int[] result = new int[4];
		this.relay.parseInputValues(worldTime, inputValues);
		switch (this.relay.state) {
		case IDLE:
			result = new int[] { 0, 0, 15, 15 };
			break;
		case ACTIVE:
			result = new int[] { 0, 15, 15, 0 };
			break;
		case TRIP:
			result = new int[] { 15, 15, 0, 0 };
			break;
		case PAUSE:
			result = new int[] { 0, 0, 15, 15 };
			break;
		}
		return result;
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.relay.induction";
	}

	/*
	 * As soon I>I1p: I_sum += I / (100 * I1k) When I_sum > I1i or I>I2 relay
	 * trips
	 * 
	 * @see powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit#
	 * getInputPinLabel(int)
	 */

	@Override
	public String getInputPinLabel(int pin) {
		return inputNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return outputNames[pin];
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.relay.setStateValue(tag.getInteger("state"));
		this.relay.pickupSetting = tag.getInteger("pickupSetting");
		this.relay.cntCLK = tag.getInteger("cntCLK");
		this.relay.pickupMoment = tag.getLong("pickupMoment");
		this.relay.tripMoment = tag.getLong("tripMoment");
		this.relay.tripped = tag.getBoolean("tripped");
		this.relay.enabledState = tag.getBoolean("enabled");
		this.relay.integSum = tag.getFloat("integSum");
		this.relay.Ki = tag.getInteger("Ki");
		this.relay.L1Setting = tag.getInteger("L1Setting");
		this.relay.L2Setting = tag.getFloat("L2Setting");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("state", this.relay.getStateValue());
		tag.setInteger("pickupSetting", this.relay.pickupSetting);
		tag.setInteger("cntCLK", this.relay.cntCLK);
		tag.setLong("pickupMoment", this.relay.pickupMoment);
		tag.setLong("tripMoment", this.relay.tripMoment);
		tag.setBoolean("enabled", this.relay.enabledState);
		tag.setFloat("integSum", this.relay.integSum);
		tag.setInteger("Ki", this.relay.Ki);
		tag.setInteger("L1Setting", this.relay.L1Setting);
		tag.setFloat("L2Setting", this.relay.L2Setting);
	}

}
