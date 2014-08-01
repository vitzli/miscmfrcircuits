package vitzli.miscmfrcircuits.circuits.bus;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class XNOR2bus extends StatelessCircuit {
	@Override
	public int getInputCount() {
		return 2;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { ~(inputValues[0] ^ inputValues[1]) };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.bus.xnor2";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin == 0 ? "A" : "B";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}
}
