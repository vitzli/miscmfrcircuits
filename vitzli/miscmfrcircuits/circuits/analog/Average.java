package vitzli.miscmfrcircuits.circuits.analog;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class Average implements IRedNetLogicCircuit {
	
	private boolean lastClockState = false;
	private boolean clockState = false;
	
	private long sum = 0;
	private long clockCount = 0;
	
	private int avg = 0;
	private int signalInput = 0;
	

	@Override
	public int getInputCount() {
		return 3;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		signalInput = ValueFunctions.ConstraintInt(inputValues[0], 1,
				1<<16);
		
		clockState = inputValues[2] != 0;

		if (clockState && !lastClockState) {
			clockCount++;
			sum += signalInput;
		}

		if (clockCount >= inputValues[1]) {
			if (clockCount != 0) {
				avg = (int) Math.round((float) sum / (float) clockCount);
			} else {
				avg = (int) Math.round((float) sum);
			}
			clockCount = 0;
			sum = 0;
		}
		lastClockState = clockState;
		return new int[] { avg };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.average";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin == 0 ? "X" : pin == 1 ? "Ta" : "CLK";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "RSLT";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.clockCount = tag.getLong("clockCount");
		this.avg = tag.getInteger("average");
		this.lastClockState = tag.getBoolean("lastClockState");
		this.sum = tag.getLong("sum");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setLong("clockCount", this.clockCount);
		tag.setInteger("average", this.avg);
		tag.setBoolean("lastClockState", this.lastClockState);
		tag.setLong("sum", this.sum);
	}

}
