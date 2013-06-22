package vitzli.miscmfrcircuits.lib;

public class ValueFunctions {
	
	public static int Constraint4bit(int n) {
		return ConstraintInt(n, 0, 15);
	}
	
	public static int Constraint8bit(int n) {
		return ConstraintInt(n, 0, 255);
	}
	
	public static int ConstraintInt(int n, int min, int max) {
		if (n>max) {
			return max;
		} else if (n<min) {
			return min;
		} else {
			return n;
		}
	}
	
	
	public static boolean hysteresisCheck(int PV, int onSP, int offSP, boolean isRising) {
		if (PV < offSP) {
			return false;
		} else if (PV >= offSP && PV <= onSP) {
			return !isRising;
		} else {
			return true;
		}
	}
	
	public static boolean isSignalRising(int currentValue, int lastValue) {
		return currentValue > lastValue;
	}
}
