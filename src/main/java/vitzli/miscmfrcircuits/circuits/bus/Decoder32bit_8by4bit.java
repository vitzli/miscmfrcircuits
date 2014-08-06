package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Decoder32bit_8by4bit extends StatelessCircuit {

	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 8;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { inputValues[0] & 0x0000000F,
				(inputValues[0] & 0x000000F0) >>> 4,
				(inputValues[0] & 0x00000F00) >>> 8,
				(inputValues[0] & 0x0000F000) >>> 12,
				(inputValues[0] & 0x000F0000) >>> 16,
				(inputValues[0] & 0x00F00000) >>> 20,
				(inputValues[0] & 0x0F000000) >>> 24,
				(inputValues[0] & 0xF0000000) >>> 28 };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.decoder32.8by4bit";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y" + pin;
	}

}
