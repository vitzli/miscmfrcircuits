package vitzli.miscmfrcircuits.circuits.analog;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Adder8 extends StatelessCircuit {

	@Override
	public byte getInputCount() {
		return 8;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { inputValues[0] + inputValues[1] + inputValues[2]
				+ inputValues[3] + inputValues[4] + inputValues[5]
				+ inputValues[6] + inputValues[7] };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.adder8";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "X" + pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "RSLT";
	}

}
