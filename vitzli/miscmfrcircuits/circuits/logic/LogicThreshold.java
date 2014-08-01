package vitzli.miscmfrcircuits.circuits.logic;

import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.circuits.base.StatelessCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

/**
 * 
 * @author Vitzli
 *	8 port logic threshold, A0..A7 - inputs, THR - threshold;
 *	Result is logic 1 when more than THR inputs active
 */

public class LogicThreshold extends StatelessCircuit {

	private int threshold, pinCount;
	private int idx;
	
	@Override
	public int getInputCount() {
		return 9;
	}

	@Override
	public int getOutputCount() {
		return 1;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		threshold = ValueFunctions.ConstraintInt(inputValues[8], 1, 8);
		pinCount = 0;
		for(idx=0; idx<=7; idx++) {
			if (inputValues[idx]!=0) {
				pinCount++;
			}
		}
		return new int[] {pinCount>=threshold ? 15 : 0};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.logic.threshold8";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return pin==8 ? "N" : "A"+pin;
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return "Y";
	}

}
