package vitzli.miscmfrcircuits.circuits.relay;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.RelayDT;

// import vitzli.miscmfrcircuits.lib.CircuitFunctions;

public class MaxDTcircuit implements IRedNetLogicCircuit {

	private String[] inputNames = new String[] { "I", "Imx", "TD", "EN#" };
	private String[] outputNames = new String[] { "TRP", "ST", "TRP#", "ST#" };

	class RelayMax extends RelayDT {
		public RelayMax(String nameHandle) {
			super(nameHandle);
		}

		@Override
		public boolean compare(int par1, int par2) {
			return par1 >= par2 ? true : false;
		}
	}

	private RelayMax relay = new RelayMax("relay.max_dT");

	@Override
	public byte getInputCount() {
		return 4;
	}

	@Override
	public byte getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int[] result;

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
		default:
			result = new int[] { 0, 0, 15, 15 };
			break;
		}
		return result;
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.relay.max_dt";
	}

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
		// Auto-generated method stub
		// state, pickupSetting, setDT, cntDT, cntCLK, pickupMoment, tripMoment
		this.relay.setStateValue(tag.getInteger("state"));
		this.relay.pickupSetting = tag.getInteger("pickupSetting");
		this.relay.setDT = tag.getInteger("setDT");
		// this.relay.cntDT = tag.getInteger("cntDT");
		this.relay.cntCLK = tag.getInteger("cntCLK");
		this.relay.pickupMoment = tag.getLong("pickupMoment");
		this.relay.tripMoment = tag.getLong("tripMoment");
		this.relay.tripped = tag.getBoolean("tripped");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("state", this.relay.getStateValue());
		tag.setInteger("pickupSetting", this.relay.pickupSetting);
		tag.setInteger("setDT", this.relay.setDT);
		// tag.setInteger("cntDT", this.relay.cntDT);
		tag.setInteger("cntCLK", this.relay.cntCLK);
		tag.setLong("pickupMoment", this.relay.pickupMoment);
		tag.setLong("tripMoment", this.relay.tripMoment);
		tag.setBoolean("tripped", this.relay.tripped);
		// Auto-generated method stub
		
	}
}
