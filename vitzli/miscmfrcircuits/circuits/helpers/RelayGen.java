package vitzli.miscmfrcircuits.circuits.helpers;

public class RelayGen {

	public long pickupMoment = 0;
	public long tripMoment = 0;
	public String relay_name;
	public int cntCLK = 0;

	public boolean tripped = false;

	public enum State {
		IDLE, ACTIVE, TRIP, PAUSE;
	}

	public State state = State.IDLE;

	public RelayGen(String name_handle) {
		this.relay_name = name_handle;
	}

	public void parseInputValues(long worldTime, int[] inputValues) {

	}

	protected void onTrip() {
		this.tripped = true;

// 		long time_delay = this.tripMoment - this.pickupMoment;
//		System.out.println("Relay " + this.relay_name + " tripped @WorldTime:"
//				+ this.tripMoment + " after " + this.cntCLK + " pulses ("
//				+ time_delay + " total time passed)");
	}

	protected void onIdle() {
		this.tripped = false;
		this.cntCLK = 0;
		this.pickupMoment = 0;
		this.tripMoment = 0;
	}

	public void initParameters() {
		// TODO NBT parameters
	}
	
	public int getStateValue(){
		switch (this.state) {
			case IDLE:
				return 0;
			case ACTIVE:
				return 1;
			case TRIP:
				return 2;
			case PAUSE:
				return 3;
			default:
				return 0;
		}
	}
	
	public void setStateValue(int stateValue) {
		switch (stateValue) {
		case 0:
			this.state = State.IDLE;
			break;
		case 1:
			this.state = State.ACTIVE;
			break;
		case 2:
			this.state = State.TRIP;
			break;
		case 3:
			this.state = State.PAUSE;
			break;
		default:
			this.state = State.IDLE;
			break;
		}
	}

}