package vitzli.miscmfrcircuits.circuits.analog;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class QuadAdder2 extends StatelessCircuit {

	private static final String[] inputPinNames = new String[] { "A0", "B0", "A1",
			"B1", "A2", "B2", "A3", "B3" }; 
	
	@Override
	public byte getInputCount() {
		return 8;
	}

	@Override
	public byte getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { inputValues[0] + inputValues[1],
				inputValues[2] + inputValues[3],
				inputValues[4] + inputValues[5],
				inputValues[6] + inputValues[7] };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.quadadder2";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return inputPinNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y" + pin;
	}

}
