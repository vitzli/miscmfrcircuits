package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class Encoder32bit_8by4bit extends StatelessCircuit {

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
		int result = 0;
		result += (1 << 0) * ValueFunctions.Constraint4bit(inputValues[0]);
		result += (1 << 4) * ValueFunctions.Constraint4bit(inputValues[1]);
		result += (1 << 8) * ValueFunctions.Constraint4bit(inputValues[2]);
		result += (1 << 12) * ValueFunctions.Constraint4bit(inputValues[3]);
		result += (1 << 16) * ValueFunctions.Constraint4bit(inputValues[4]);
		result += (1 << 20) * ValueFunctions.Constraint4bit(inputValues[5]);
		result += (1 << 24) * ValueFunctions.Constraint4bit(inputValues[6]);
		result += (1 << 28) * ValueFunctions.Constraint4bit(inputValues[7]);
		return new int[] { result };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.encoder32.8by4bit";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A" + pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y" + pin;
	}

}
