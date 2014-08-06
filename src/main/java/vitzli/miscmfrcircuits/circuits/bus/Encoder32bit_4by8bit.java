package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;


public class Encoder32bit_4by8bit extends StatelessCircuit {
	
	@Override
	public int getInputCount() {
		return 4;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int result = 0;
		result += (1 << 0) * ValueFunctions.Constraint8bit(inputValues[0]);
		result += (1 << 8) * ValueFunctions.Constraint8bit(inputValues[1]);
		result += (1 << 16) * ValueFunctions.Constraint8bit(inputValues[2]);
		result += (1 << 24) * ValueFunctions.Constraint8bit(inputValues[3]);
		return new int[] {result};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.encoder32.4by8bit";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A"+pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y"+pin;
	}

}
