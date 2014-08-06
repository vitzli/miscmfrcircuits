package vitzli.miscmfrcircuits.circuits.logicboolean;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class DAC extends StatelessCircuit {

	@Override
	public byte getInputCount() {
		return 16;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int result = 0;
		for (int i = 0; i < 16; i++) {
			result += inputValues[i] != 0 ? (1 << i) : 0;
		}
		return new int[] { result };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.encoder16.DAC";
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
