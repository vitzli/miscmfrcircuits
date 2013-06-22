package vitzli.miscmfrcircuits.circuits.analog;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class LongTimer implements IRedNetLogicCircuit {

	private String[] inputPinNames = new String[] { "Ts", "Tm", "Th", "DC",
			"EN#", "RST" };
	private String[] outputPinNames = new String[] { "Q", "Qs", "Qm", "Qh" };

	private int Ts = 0, Tm = 0, Th = 0, duty_cycle = 1;
	private int period = 1;
	private int activePeriod = 0;
	private int currentShift = 0;
	private boolean state = true;
	private boolean timerDisabled = false;

	private long pickupMoment = 0;

	private int currTs, currTm, currTh, currDC;
	private boolean reset;

	private int[] result = new int[4];

	@Override
	public int getInputCount() {
		return 6;
	}

	@Override
	public int getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		timerDisabled = inputValues[4] != 0 ? true : false;
		if (timerDisabled) {
			state = false;
			return new int[] { 0, 0, 0, 0 };
		}

		reset = inputValues[5] != 0 ? true : false;
		currTs = ValueFunctions.ConstraintInt(inputValues[0], 1, 255);
		currTm = ValueFunctions.ConstraintInt(inputValues[1], 0, 255);
		currTh = ValueFunctions.ConstraintInt(inputValues[2], 0, 24);
		currDC = ValueFunctions.ConstraintInt(inputValues[3], 0, 100);

		if (currTs != Ts || currTm != Tm || currTh != Th
				|| currDC != duty_cycle) {
			changeParameters();
		}

		if (reset) {
			changeParameters();
			state = true;
			pickupMoment = worldTime;
		}
		
		currentShift = (int) (worldTime - pickupMoment); 
		state = currentShift < activePeriod;
		
		if (currentShift >= period) {
			// here goes new pulse
			state = true;
			pickupMoment = worldTime;
			currentShift = (int) (worldTime - pickupMoment);
		}
		
		result[0] = state ? 15 : 0;
		result[1] = (currentShift % 20 == 0 && state) ? 15 : 0; // 1 second
		result[2] = (currentShift % 1200 == 0 && state) ? 15 : 0; // 1 minute
		result[3] = (currentShift % 72000 == 0 && state) ? 15 : 0; // 1 hour

		return new int[] { result[0], result[1], result[2], result[3] };
	}

	private void changeParameters() {
		Ts = currTs;
		Tm = currTm;
		Th = currTh;
		duty_cycle = currDC;

		period = 20 * (Ts + Tm * 60 + Th * 60);
		activePeriod = ((int) Math.round((float) period
				* ((float) currDC / 100)));
		activePeriod = activePeriod == 0 ? 1 : activePeriod;
	}

	@Override
	public String getUnlocalizedName() {
		// TODO Auto-generated method stub
		return "miscIC.analog.longtimer";
	}

	@Override
	public String getInputPinLabel(int pin) {
		// TODO Auto-generated method stub
		return inputPinNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		// TODO Auto-generated method stub
		return outputPinNames[pin];
	}

}
