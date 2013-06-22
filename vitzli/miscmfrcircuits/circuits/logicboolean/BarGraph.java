package vitzli.miscmfrcircuits.circuits.logicboolean;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class BarGraph extends StatelessCircuit implements IRedNetLogicCircuit {

	@Override
	public int getInputCount() {
		return 2;
	}

	@Override
	public int getOutputCount() {
		return 12;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int[] result = new int[12]; 
		int bargraphValue = ValueFunctions.ConstraintInt(inputValues[0], 0, 10);
		
		for (int i = 1; i <=(bargraphValue + 1); i++) {
			result[i] = 15;
		}
		
		if (inputValues[0] <0 || inputValues[0] > 10) {
			result[0] = 15;
		}
		
		if (inputValues[1] != 0) {
			return new int[] {0,
					15, 15, 15, 15, 15, 15, 15, 15, 15, 15, 15};
		} else {
			return result;
		}
		
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.decoder.bargraph";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==0 ? "A" : "TST";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin==0 ? "OL" : "Y"+(pin - 1);
	}

}
