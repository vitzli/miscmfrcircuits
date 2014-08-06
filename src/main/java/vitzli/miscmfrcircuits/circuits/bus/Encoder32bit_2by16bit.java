package vitzli.miscmfrcircuits.circuits.bus;

import vitzli.miscmfrcircuits.lib.ValueFunctions;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Encoder32bit_2by16bit extends StatelessCircuit {

	@Override
	public byte getInputCount() {
		return 2;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { ValueFunctions.ConstraintInt(inputValues[0], 0,
				0xFFFF)
				| (ValueFunctions.ConstraintInt(inputValues[1], 0, 0xFFFF) << 16) };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.encoder32.2by16bit";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin == 0 ? "Lo" : "Hi";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}

}
