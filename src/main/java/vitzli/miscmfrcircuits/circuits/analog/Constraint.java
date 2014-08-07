package vitzli.miscmfrcircuits.circuits.analog;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class Constraint extends StatelessCircuit {

    private static final String[] inputPinNames = new String[] { "I", "Imn", "Imx" };
	
    @Override
    public byte getInputCount() {
        return 3;
    }

    @Override
    public byte getOutputCount() {
        return 1;
    }

    @Override
    public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
    	return new int[] {ValueFunctions.ConstraintInt(inputValues[0], inputValues[1], inputValues[2])};
    }

    @Override
    public String getUnlocalizedName() {
        return "miscICs.analog.constraint";
    }

    @Override
    public String getInputPinLabel(int pin) {
        return inputPinNames[pin];
    }

    @Override
    public String getOutputPinLabel(int pin) {
        return "Q";
    }

}
