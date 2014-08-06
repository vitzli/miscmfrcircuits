package vitzli.miscmfrcircuits.circuits.bus;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;
import vitzli.miscmfrcircuits.ref.Constants;

public class VGAROM extends StatelessCircuit {

	private int ascii_code = 0;
	
	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 8;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		ascii_code = ValueFunctions.Constraint8bit(inputValues[0]);
		return Constants.VGAROM[ascii_code];
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.bus.vgarom";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "A";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y"+pin;
	}

}
