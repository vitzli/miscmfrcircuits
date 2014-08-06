package vitzli.miscmfrcircuits.circuits.analog;

import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class WorldTick extends StatelessCircuit{

	int Lo = 0, Hi = 0;

	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 2;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		if (inputValues[0]!=0) {
			return new int[] {0, 0};
		}
		
		Hi = (int)(worldTime / (long) Integer.MAX_VALUE);
		Lo = (int)(worldTime - (long )Hi * (long) Integer.MAX_VALUE);
		
		return new int[] {Lo, Hi};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.analog.worldtick";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "#EN";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin==0 ? "Lo" : "Hi";
	}

}
