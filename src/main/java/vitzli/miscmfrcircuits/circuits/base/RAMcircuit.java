package vitzli.miscmfrcircuits.circuits.base;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.RAMdata;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class RAMcircuit implements IRedNetLogicCircuit {

	protected int ramsize;
	protected RAMdata RAM;

	private boolean lastClockState = false;
	private static final String[] InputPinNames = new String[] { "D", "ADR", "WR", "CLK",
			"RST" };

	public void initSize(int memsize) {
		this.ramsize = memsize;
		this.RAM = new RAMdata(memsize);
	}
	
	private int addr;
	private boolean writeState, clockState, resetState;

	@Override
	public byte getInputCount() {
		return 5;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		addr = ValueFunctions.ConstraintInt(inputValues[1], 0,
				this.ramsize - 1); // ADDR

		writeState = inputValues[2] != 0; // WR
		clockState = inputValues[3] != 0; // CLK
		resetState = inputValues[4] != 0; // RST

		if (!lastClockState && clockState) {
			if (resetState) {
				RAM.reset();
			} else if (writeState) {
				RAM.write(inputValues[0], addr);
			}
		}

		lastClockState = clockState;
		return new int[] { RAM.read(addr) };

	}

	@Override
	public String getInputPinLabel(int pin) {
		return InputPinNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "OUT";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		this.ramsize = tag.getInteger("ramsize");
		this.lastClockState = tag.getBoolean("lastClockState");
		this.RAM.init(this.ramsize, tag.getIntArray("memory"));
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("ramsize", this.ramsize);
		tag.setBoolean("lastClockState", this.lastClockState);
		tag.setIntArray("memory", this.RAM.getArray());

	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.RAM";
	}

}
