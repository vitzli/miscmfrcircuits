package vitzli.miscmfrcircuits.circuits.bus;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;

public class RAM_1W implements IRedNetLogicCircuit {

	private int memoryValue = 0;
	private boolean writeState = false;
	private boolean lastClockState = false;
	private String[] InputPinNames = new String[] {"D", "WR", "CLK"};
	
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
		if (inputValues[1] != 0 && inputValues[2] != 0 && !this.lastClockState) {
			this.memoryValue = inputValues[0];
		}
		this.writeState = inputValues[1] !=0;
		this.lastClockState = inputValues[2] !=0;
		return new int[] {this.memoryValue};
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
		this.writeState = tag.getBoolean("writeState");
		this.lastClockState = tag.getBoolean("lastClockState");
		this.memoryValue = tag.getInteger("memoryValue");

	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("writeState", this.writeState);
		tag.setBoolean("lastClockState", this.lastClockState);
		tag.setInteger("memoryValue", this.memoryValue);
	}

}
