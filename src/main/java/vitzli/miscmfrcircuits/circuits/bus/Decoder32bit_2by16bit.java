package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Decoder32bit_2by16bit extends StatelessCircuit {

	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 2;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { inputValues[0] & 0x0000FFFF,
				(inputValues[0] & 0xFFFF0000) >>> 16 };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.decoder32.2by16bit";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin == 0 ? "Lo" : "Hi";
	}

}
