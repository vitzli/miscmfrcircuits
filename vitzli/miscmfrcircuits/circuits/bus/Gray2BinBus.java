package vitzli.miscmfrcircuits.circuits.bus;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;

public class Gray2BinBus extends StatelessCircuit implements
		IRedNetLogicCircuit {
	@Override
	public int getInputCount() {
		return 1;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		int result = inputValues[0] >>> 1;
		for (int mask = result; mask != 0; mask = mask >> 1) {
			result = result ^ mask;
		}
		return new int[] { result };
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.bus.gr2bin";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return "Gry";
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Bin";
	}
}
