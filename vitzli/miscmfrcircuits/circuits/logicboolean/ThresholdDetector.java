package vitzli.miscmfrcircuits.circuits.logicboolean;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;

public class ThresholdDetector implements IRedNetLogicCircuit {

	private boolean state = false;
	private boolean lastState = false;
	private int spOn = 8;
	private int spOff = 4;
	private int currentSignalValue = 0;

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

		currentSignalValue = inputValues[0];
		
		spOn = Math.max(inputValues[2], inputValues[1]);
		spOff = Math.min(inputValues[2], inputValues[1]);

		if (currentSignalValue <= spOff) {
			state = false;
		} else {
			if (currentSignalValue > spOff && currentSignalValue <= spOn) {
				state = lastState;
			} else {
				state = true;
			}
		}

		lastState = state;
		return new int[] { state ? 15 : 0 };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logicboolean.hysteresis";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin == 0 ? "PV" : pin == 1 ? "S0" : "S1";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Q";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		lastState = tag.getBoolean("lastState");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("lastState", lastState);

	}	 
	

}
