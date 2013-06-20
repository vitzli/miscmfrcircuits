package vitzli.miscmfrcircuits.circuits.logic;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;

/**
 * @author Vitzli Edge detection circuit for MFR
 * 
 */
public class EdgeDetection implements IRedNetLogicCircuit {

	private boolean lastState;

	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 2;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int rEdge, fEdge;
		boolean currentState = (inputValues[0] != 0);

		if (currentState ^ lastState) {
			rEdge = currentState ? 15 : 0;
			fEdge = !currentState ? 15 : 0;
		} else {
			rEdge = 0;
			fEdge = 0;
		}
		lastState = currentState;
		return new int[] { rEdge, fEdge };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.edgedetector";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin == 0 ? "RI" : "FA";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		// TODO Auto-generated method stub
		
	}

}
