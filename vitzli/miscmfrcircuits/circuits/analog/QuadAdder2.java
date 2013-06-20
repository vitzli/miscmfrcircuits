package vitzli.miscmfrcircuits.circuits.analog;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.StatelessCircuit;

public class QuadAdder2 extends StatelessCircuit implements IRedNetLogicCircuit {

	@Override
	public int getInputCount() {
		return 8;
	}

	@Override
	public int getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int y0, y1, y2, y3;
		y0 = inputValues[0] + inputValues[1];
		y1 = inputValues[2] + inputValues[3];
		y2 = inputValues[4] + inputValues[5];
		y3 = inputValues[6] + inputValues[7];
		return new int[] { y0, y1, y2, y3 };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.QuadAdder2";
	}

	@Override
	public String getInputPinLabel(int pin) {
		String[] inputPinNames = new String[] { "A0", "B0", "A1", "B1", "A2",
				"B2", "A3", "B3" };
		return inputPinNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		// TODO Auto-generated method stub
		return "Y" + pin;
	}

}
