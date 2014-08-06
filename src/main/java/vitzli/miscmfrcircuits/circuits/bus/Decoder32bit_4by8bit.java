package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Decoder32bit_4by8bit extends StatelessCircuit {

	@Override
	public byte getInputCount() {
		return 1;
	}

	@Override
	public byte getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { inputValues[0] & 0x000000FF,
				(inputValues[0] & 0x0000FF00) >>> 8,
				(inputValues[0] & 0x00FF0000) >>> 16,
				(inputValues[0] & 0xFF000000) >>> 24 };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.decoder32.4by8bit";
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
