package vitzli.miscmfrcircuits.circuits.analog;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

/*
 * Inputs:
 * Ts   - 1..255 use square wave generator for shorter periods of time
 *           255 is a bit uncommon, but you can set 150 seconds in one field 
 * Tm   - 0..255 - minute setting
 * Th   - 0..24 - hour setting
 * DC   - Duty Cycle; 0 is for 1 tick width, 1..100%
 * EN#  - send activate signal and it will stop counting for 
 *      the duration of given signal, it will continue from the moment it was interrupted 
 * RST  - Reset the timer.
 * 
 * Outputs:
 * Q    - stays active during activePeriod
 * Qs   - activates every second for 4 ticks of activePeriod
 * Qm   - every minute
 * Qh   - every hour
 *   
 * 
 */ 

public class LongTimer implements IRedNetLogicCircuit {

    private static final String[] inputPinNames = new String[] { "Ts", "Tm", "Th", "DC",
            "EN#", "RST" };
    private static final String[] outputPinNames = new String[] { "Q", "Qs", "Qm", "Qh" };

    private int Ts = 0, // values from interface, 1..255
            Tm = 0, // 0..255
            Th = 0, // 0.. 24
            dutyCycle = 50; // 50%
    
    private int period = 1; // total pulse period T
    private int activePeriod = 0; // duty period D.T
    private int currentShift = 0; // ticks from last rising edge of current period
    
    private boolean state = true; // timer state
    private boolean timerDisabled = false; // disabled via interface

    private long startMoment = 0; // worldTime of the last rising edge

    private int currTs, currTm, currTh, currDC; // internal cycle variables
    private boolean reset; // reset timer

    @Override
    public byte getInputCount() {
        return 6;
    }

    @Override
    public byte getOutputCount() {
        return 4;
    }

    @Override
    public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
        timerDisabled = inputValues[4] != 0 ? true : false;
        if (timerDisabled) {
            // don't change the state !!!
            startMoment++; // shift beginning when timer is disabled 
            return new int[] { 0, 0, 0, 0 };
        }

        reset = inputValues[5] != 0 ? true : false;
        currTs = ValueFunctions.ConstraintInt(inputValues[0], 1, 255);
        currTm = ValueFunctions.ConstraintInt(inputValues[1], 0, 255);
        currTh = ValueFunctions.ConstraintInt(inputValues[2], 0, 24);
        currDC = ValueFunctions.ConstraintInt(inputValues[3], 0, 100);

        if (currTs != Ts || currTm != Tm || currTh != Th
                || currDC != dutyCycle) {
            changeParameters();
        }

        if (reset) {
            changeParameters();
            state = true;
            startMoment = worldTime;
        }
        
        currentShift = (int) (worldTime - startMoment); 
        state = currentShift < activePeriod;
        
        if (currentShift >= period) {
            // here goes new pulse
            state = true;
            startMoment = worldTime;
            currentShift = (int) (worldTime - startMoment);
        }
        
        return new int[] { state ? 15 : 0,
                (currentShift % 20 < 5 && state) ? 15 : 0,
                (currentShift % 1200 < 5 && state) ? 15 : 0,
                (currentShift % 72000 < 5 && state) ? 15 : 0 };
    }

    private void changeParameters() {
        Ts = currTs;
        Tm = currTm;
        Th = currTh;
        dutyCycle = currDC;

        period = 20 * (Ts + Tm * 60 + Th * 60);
        activePeriod = ((int) Math.round((float) period
                * ((float) currDC / 100)));
        activePeriod = activePeriod == 0 ? 1 : activePeriod;
    }

    @Override
    public String getUnlocalizedName() {
        return "miscICs.analog.looongtimer";
    }

    @Override
    public String getInputPinLabel(int pin) {
        return inputPinNames[pin];
    }

    @Override
    public String getOutputPinLabel(int pin) {
        return outputPinNames[pin];
    }

    @Override
    public void readFromNBT(NBTTagCompound tag) {
        state = tag.getBoolean("state");
        currTs = tag.getInteger("Ts");
        currTm = tag.getInteger("Tm");
        currTh = tag.getInteger("Th");
        currDC = tag.getInteger("dutyCycle");
        timerDisabled = tag.getBoolean("timerDisabled");
        startMoment = tag.getLong("startMoment");
        changeParameters();
    }

    @Override
    public void writeToNBT(NBTTagCompound tag) {
        tag.setBoolean("state", state);
        tag.setInteger("Ts", Ts);
        tag.setInteger("Tm", Tm);
        tag.setInteger("Th", Th);
        tag.setInteger("dutyCycle", dutyCycle);
        tag.setBoolean("timerDisabled", timerDisabled);
        tag.setLong("startMoment", startMoment);
        
    }

}
