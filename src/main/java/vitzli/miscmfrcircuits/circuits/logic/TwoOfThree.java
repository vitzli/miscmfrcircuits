package vitzli.miscmfrcircuits.circuits.logic;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class TwoOfThree extends StatelessCircuit {

	private int pinCount;
	
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
		pinCount = 0;
		pinCount += (inputValues[0]!=0 ? 1 : 0);
		pinCount += (inputValues[1]!=0 ? 1 : 0);
		pinCount += (inputValues[2]!=0 ? 1 : 0);
		return new int[] {pinCount>=2 ? 15 : 0};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.2of3";
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
