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
	
    public static int[] opAdd(int opA, int opB) {
        return new int[] { opA + opB,
                ValueFunctions.CheckADDOverflow(opA, opB) ? 15 : 0 };
    }
    
    public static int[] opMul(int opA, int opB) {
        long result = (long) opA * (long) opB;
        boolean overflow = (result > Integer.MAX_VALUE) || (result < Integer.MIN_VALUE);
        return new int[] {(int) result, overflow ? 15: 0};
    }
    
    public static int[] opDiv(int opA, int opB) {
        int q = 0;
        int r = 0;
        if (opB == 0) {
            return new int[] {0, 0, 15};
        }
        q = (int) (opA / opB);
        r = opA % opB;
        return new int[] {q, r, 0};
    }

	
}
