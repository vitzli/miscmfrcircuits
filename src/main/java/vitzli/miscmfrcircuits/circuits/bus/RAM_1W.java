package vitzli.miscmfrcircuits.circuits.bus;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;

public class RAM_1W implements IRedNetLogicCircuit {

	private int memoryValue = 0;
	private boolean writeState = false;
	private boolean lastClockState = false;
	private boolean clockState = false;
	private static final String[] InputPinNames = new String[] {"D", "WR", "CLK"};
	
	@Override
	public byte getInputCount() {
		return 3;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		writeState = inputValues[1] != 0;
		clockState = inputValues[2] != 0;
		if (!lastClockState && writeState && clockState) {
			memoryValue = inputValues[0];
		}
		lastClockState = clockState;
		return new int[] {memoryValue, };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.RAM.1W";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return this.InputPinNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "OUT";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		writeState = tag.getBoolean("writeState");
		lastClockState = tag.getBoolean("lastClockState");
		memoryValue = tag.getInteger("memoryValue");

	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("writeState", writeState);
		tag.setBoolean("lastClockState", lastClockState);
		tag.setInteger("memoryValue", memoryValue);
	}

}
