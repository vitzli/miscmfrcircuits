package vitzli.miscmfrcircuits.circuits.analog;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class PIDController implements IRedNetLogicCircuit {

    private static final String[] inputPinNames = new String[] { 
    	"PV", // 0 
    	"SP", "Kp", "Ki", // 1-3 
    	"Kd", "dt" , "RST"}; // 6
    
    private static final String[] outputPinNames = new String[] {
    	"Out", "err", "int", "RST"
    };

    private long lastRecalc = 0;
    private int previous_error = 0;
    private int integral = 0;
    private int outputInt = 0;
    
    
	@Override
	public int getInputCount() {
		return 7;
	}

	@Override
	public int getOutputCount() {
		return 4;
	}
	
	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		double derivative = 0;
		double output = 0;

		int error = 0;
		int Kp = inputValues[2];
		int Ki = inputValues[3];
		int Kd = inputValues[4];
		int dt = ValueFunctions.ConstraintInt(inputValues[5], 1, 255);
		int reset = 0;

		if (inputValues[6] != 0) {
			integral = 0;
			reset = 15;
		}
		
		if ((worldTime - lastRecalc) >= dt) {
			error = inputValues[1] - inputValues[0];
			if (Ki != 0) {
				integral = integral + error * dt;
			}
			derivative = (error - previous_error) / (double) dt;
			output = ((double) Kp * (double) error
					+ (double) Ki * ((double) integral)
					+ (double) Kd * derivative) / 100.0D;
			outputInt = (int) output;
			previous_error = error;
			lastRecalc = worldTime;
		}

		return new int[] { outputInt, error, integral, reset};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.PID";
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
		outputInt = tag.getInteger("outputInt");
		lastRecalc = tag.getLong("lastRecalc");
		previous_error = tag.getInteger("previous_error");
		integral = tag.getInteger("integral");
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setInteger("outputInt", outputInt);
		tag.setLong("lastRecalc", lastRecalc);
		tag.setInteger("previous_error", previous_error);
		tag.setInteger("integral", integral);
	}	 
	

}
