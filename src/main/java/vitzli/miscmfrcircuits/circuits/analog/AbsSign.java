package vitzli.miscmfrcircuits.circuits.analog;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

import java.lang.Math;
import java.lang.Integer;

public class AbsSign extends StatelessCircuit {

	private static final String[] outputPinNames = new String[] { "ABS", "SGN", "POS", "==0", "<>0", "NEG" };
	
	@Override
	public byte getInputCount() {
		return 1;
	}

	@Override
	public byte getOutputCount() {
		return 6;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { Math.abs(inputValues[0]),
				Integer.signum(inputValues[0]),
				inputValues[0] > 0 ? 15 : 0, 
			    inputValues[0] == 0 ? 15 : 0,
			    inputValues[0] != 0 ? 15 : 0,
			    inputValues[0] < 0 ? 15 : 0
			    		};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.AbsSign";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "I";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return outputPinNames[pin];
	}

}
