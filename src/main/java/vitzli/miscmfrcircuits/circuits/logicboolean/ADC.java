package vitzli.miscmfrcircuits.circuits.logicboolean;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.CircuitFunctions;

public class ADC extends StatelessCircuit {

	@Override
	public byte getInputCount() {
		return 1;
	}

	@Override
	public byte getOutputCount() {
		return 16;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int [] result;
		result = new int[16];
		
		for (int i=0; i<16; i++) {
			result[i] = CircuitFunctions.GetBit(inputValues[0], i);
		}
		return result;
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.decoder16.ADC";
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
