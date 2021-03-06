package vitzli.miscmfrcircuits.circuits.bus;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Bin2GrayBus extends StatelessCircuit {
	@Override
	public byte getInputCount() {
		return 1;
	}

	@Override
	public byte getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		return new int[] { (inputValues[0] >>> 1) ^ inputValues[0] };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.bus.bin2gray";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "Bin";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Gry";
	}
}
