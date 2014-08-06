package vitzli.miscmfrcircuits.circuits.bus;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class LShiftbus extends StatelessCircuit {
	@Override
	public int getInputCount() {
		return 2;
	}

	@Override
	public int getOutputCount() {
		return 2;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int carry = 0;
		if (inputValues[1]>=33) {
			carry = 15;
		}
		return new int[] { inputValues[0] << inputValues[1], carry };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.bus.lshift";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==0 ? "A" : "n";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin==0 ? "Y" : "C";
	}
}
