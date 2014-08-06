package vitzli.miscmfrcircuits.circuits.analog;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.CircuitFunctions;

public class MulDiv extends StatelessCircuit {

    private int[] inputArray = new int[3];
    private int[] outputArray = new int[] {0, 0, 15};

    
    @Override
    public int getInputCount() {
        return 3;
    }

    @Override
    public int getOutputCount() {
        return 3;
    }

    // Does Q = M1*M2/D
    
    @Override
    public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
        if (!inputValues.equals(inputArray)) {
            inputArray = inputValues.clone();
            outputArray = CircuitFunctions.opDiv(inputValues[0]*inputValues[1], inputValues[2]);
        }
        return outputArray.clone();
    }

    @Override
    public String getUnlocalizedName() {
        return "miscICs.analog.MulDiv";
    }

    @Override
    public String getInputPinLabel(int pin) {
        return pin==0 ? "M1" : pin==1 ? "M2" : "D";
    }

    @Override
    public String getOutputPinLabel(int pin) {
        return pin==0 ? "Q" : pin==1 ? "R" : "Err";
    }

}
