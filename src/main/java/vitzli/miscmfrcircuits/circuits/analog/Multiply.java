package vitzli.miscmfrcircuits.circuits.analog;

// import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.CircuitFunctions;

public class Multiply extends StatelessCircuit {

	private int[] inputArray = new int[2];
	private int[] outputArray = new int[2];
	
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
		if (!inputValues.equals(inputArray)) {
			inputArray = inputValues.clone();
			outputArray = CircuitFunctions.opMul(inputValues[0], inputValues[1]);
		}
		return outputArray.clone();   
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.Multiply";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==0 ? "A" : "B";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin==0 ? "Y" : "OF";
	}

}
