package vitzli.miscmfrcircuits.circuits.logic;


import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class QuadNOT extends StatelessCircuit {

    @Override
    public byte getInputCount()
    {
        return 4;
    }
    
    @Override
    public byte getOutputCount()
    {
        return 4;
    }
    
    @Override
    public int[] recalculateOutputValues(long worldTime, int[] inputValues)
    {
        return new int[] { (inputValues[0]==0) ? 15 : 0,
                           (inputValues[1]==0) ? 15 : 0,
                           (inputValues[2]==0) ? 15 : 0,
                           (inputValues[3]==0) ? 15 : 0};
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return "miscICs.logic.quad_not";
    }
    
    @Override
    public String getInputPinLabel(int pin)
    {
        return "A" + pin;
    }
    
    @Override
    public String getOutputPinLabel(int pin)
    {
        return "Y" + pin;
    }
}
