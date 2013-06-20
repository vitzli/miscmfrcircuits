package vitzli.miscmfrcircuits.circuits.bus;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.StatelessCircuit;

public class NOTbus extends StatelessCircuit implements IRedNetLogicCircuit {
	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { ~inputValues[0] };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.bus.not";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}
}
