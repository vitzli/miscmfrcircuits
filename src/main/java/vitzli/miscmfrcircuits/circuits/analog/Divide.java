package vitzli.miscmfrcircuits.circuits.analog;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.CircuitFunctions;

public class Divide extends StatelessCircuit {

	private int[] inputArray = new int[2];
	private int[] outputArray = new int[] {0, 0, 15};

	
	@Override
	public byte getInputCount() {
		return 2;
	}

	@Override
	public byte getOutputCount() {
		return 3;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		if (!inputValues.equals(inputArray)) {
			inputArray = inputValues.clone();
			outputArray = CircuitFunctions.opDiv(inputValues[0], inputValues[1]);
		}
		return outputArray.clone();
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.divide";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==0 ? "A" : "B";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin==0 ? "Q" : pin==1 ? "R" : "Err";
	}

}
