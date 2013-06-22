package vitzli.miscmfrcircuits.circuits.base;

import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class RelayDT extends RelayGen {
	private int signalValue = 0;
	public int pickupSetting = 0;
	public int setDT = 0;
	
	// private boolean lastClockState = false;

	// public boolean tripped = false;

	public RelayDT(String nameHandle) {
		super(nameHandle);
	}

	@Override
	public void parseInputValues(long worldTime, int[] inputValues) {
		// boolean clockState = inputValues[4] != 0 ? true : false;

		this.signalValue = ValueFunctions.ConstraintInt(inputValues[0], 0,
				1 << 16 - 1);
		this.pickupSetting = ValueFunctions.ConstraintInt(inputValues[1], 0,
				1 << 16 - 1);
		this.setDT = ValueFunctions.ConstraintInt(inputValues[2], 0,
				1 << 16 - 1);

		boolean enabledState = inputValues[3] == 0;

		if (enabledState) {
			if (this.compare(this.signalValue, this.pickupSetting)) {
				if (this.cntCLK >= this.setDT) {
					if (this.state != State.TRIP) {
						this.tripMoment = worldTime;
						this.state = State.TRIP;
						this.onTrip();
					}
				} else {
					this.state = State.ACTIVE;
					if (this.pickupMoment == 0) {
						this.pickupMoment = worldTime;
					}
					this.cntCLK += 1;
				}
			} else {
				this.state = State.IDLE;
				this.onIdle();
			}
		} else {
			this.state = State.PAUSE;
		}

	}

	public boolean compare(int par1, int par2) {
		return par1 >= par2 ? true : false;
	}

}
