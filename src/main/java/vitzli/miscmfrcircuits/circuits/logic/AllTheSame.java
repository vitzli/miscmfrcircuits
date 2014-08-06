package vitzli.miscmfrcircuits.circuits.logic;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class AllTheSame extends StatelessCircuit {
	
	private int pinCount;
	private int usedPins;
	private int idx;

	@Override
	public byte getInputCount() {
		return 9;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		usedPins = ValueFunctions.ConstraintInt(inputValues[8], 1, 8);
		pinCount = 0;
		for (idx=0; idx<=usedPins-1; idx++) {
			pinCount += (inputValues[idx] == inputValues[0] ? 1 : 0);
		}
		return new int[] { pinCount==usedPins ? 15 : 0};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.allthesame";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==8 ? "CNT" : "A"+pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}

}
