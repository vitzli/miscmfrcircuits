package vitzli.miscmfrcircuits.circuits.logic;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class NAndOnlyN extends StatelessCircuit {
	
	private int threshold;
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
		threshold = ValueFunctions.ConstraintInt(inputValues[8], 1, 8);
		pinCount = 0;
		for (idx=0; idx<=7; idx++) {
			pinCount += inputValues[idx]!=0 ? 1 : 0;
		}
		return new int[] { pinCount==threshold ? 15 : 0};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.nandonlyn";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==9 ? "CNT" : pin==8 ? "N" : "A"+pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}

}
