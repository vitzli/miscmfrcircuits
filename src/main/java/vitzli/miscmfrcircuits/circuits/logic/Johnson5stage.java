package vitzli.miscmfrcircuits.circuits.logic;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;

public class Johnson5stage implements IRedNetLogicCircuit {
	
	private int state = 0; 
	private boolean currentCP0 = false;
	private boolean currentCP1 = false;
	private boolean lastCP0 = false;
	private boolean lastCP1 = false;
	private boolean memoryReset = false;
	
	@Override
	public int getInputCount() {
		return 3;
	}

	@Override
	public int getOutputCount() {
		return 11;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int[] result = new int[11];
		currentCP0 = inputValues[0] != 0;
		currentCP1 = inputValues[1] != 0;
		boolean transition = (!lastCP0 && currentCP0 && !currentCP1) || 
				(currentCP0 && lastCP1 && !currentCP1);
		memoryReset = (inputValues[2] !=0);
		if (memoryReset) {
			result[0] = 15;
			result[10] = 15;
			return result;
		}
		
		if (transition) {
			state = (state + 1) % 10;
		}
		
		if (state<5) {
			result[10] = 15;
		}
		
		result[state] = 15;
		lastCP0 = currentCP0;
		lastCP1 = currentCP1;
		return result;
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.counter4017";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==0 ? "C0" : pin==1 ? "C1#" : "MR";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin==10 ? "Q#" : "Q"+pin;
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		state = tag.getInteger("state");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("state", state);
		
	}

}
