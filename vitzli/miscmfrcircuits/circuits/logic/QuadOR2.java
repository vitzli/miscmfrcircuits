package vitzli.miscmfrcircuits.circuits.logic;


import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class QuadOR2 extends StatelessCircuit implements IRedNetLogicCircuit
{

    private String inputNames[] = new String[] {"A0", "B0", "A1", "B1", "A2", "B2", "A3", "B3"};
    @Override
    public int getInputCount()
    {
        return 8;
    }
    
    @Override
    public int getOutputCount()
    {
        return 4;
    }
    
    @Override
    public int[] recalculateOutputValues(long worldTime, int[] inputValues)
    {
        return new int[] { (inputValues[0]!=0) || (inputValues[1]!=0) ? 15 : 0,
                           (inputValues[2]!=0) || (inputValues[3]!=0) ? 15 : 0,
                           (inputValues[4]!=0) || (inputValues[5]!=0) ? 15 : 0,
                           (inputValues[6]!=0) || (inputValues[7]!=0) ? 15 : 0};
    }
    
    @Override
    public String getUnlocalizedName()
    {
        return "miscICs.logic.quad_or2";
    }
    
    @Override
    public String getInputPinLabel(int pin)
    {
        return inputNames[pin];
    }
    
    @Override
    public String getOutputPinLabel(int pin)
    {
        return "Y" + pin;
    }
}
