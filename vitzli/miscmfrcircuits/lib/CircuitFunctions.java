package vitzli.miscmfrcircuits.lib;

import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class CircuitFunctions {

	public static int SetBit(int n, int bit) {
		int bit_c = ValueFunctions.ConstraintInt(bit, 0, 31);
		return (n | (1 << bit_c));
	}

	public static int FlipBit(int n, int bit) {
		int bit_c = ValueFunctions.ConstraintInt(bit, 0, 31);
		return (n ^ (1 << bit_c));
	}

	public static int GetBit(int n, int bit) {
		int bit_c = ValueFunctions.ConstraintInt(bit, 0, 31);
		return (n & (1 << bit_c)) != 0 ? 15 : 0;
	}
	
}
