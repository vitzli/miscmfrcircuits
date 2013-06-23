package vitzli.miscmfrcircuits.circuits.logic;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class Even extends StatelessCircuit implements IRedNetLogicCircuit {

	private int pinCount;
	private int usedPins;
	private int idx;
	
	@Override
	public int getInputCount() {
		return 8;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		pinCount = 0;
		for (idx=0; idx<=7; idx++) {
			pinCount += (inputValues[idx] !=0 ? 1 : 0);
		}
		return new int[] {pinCount % 2==0 ? 15:0};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.even";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A"+pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}

}
