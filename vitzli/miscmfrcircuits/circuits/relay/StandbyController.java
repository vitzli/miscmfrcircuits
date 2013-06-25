package vitzli.miscmfrcircuits.circuits.relay;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class StandbyController implements IRedNetLogicCircuit {

	private static final String[] inputPinNames = new String[] {"Mok", "Sok", "Td", "RST"};

	private boolean mainOk = true;
	private boolean sbyOk = true;
	private boolean reset = false;
	private boolean state = false; // true when in stand-by mode
	private boolean alarm = false;
	private int timer = 0;
	private int Td = 0;
	
	@Override
	public int getInputCount() {
		return 4;
	}

	@Override
	public int getOutputCount() {
		return 3;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		mainOk = inputValues[0] !=0 ? true : false;
		sbyOk = inputValues[1] !=0 ? true : false;
		Td = ValueFunctions.ConstraintInt(inputValues[2], 0, 255) * 20;
		reset = inputValues[3] !=0 ? true : false;
		
		if ((!mainOk) && sbyOk && (!state) && (timer<=Td)) {
			timer++;
			alarm = true;
		}
		
		if ((!mainOk) && (timer>Td) && (!state)) {
			state = true;
			alarm = false;
			timer = 0;
		}
		
		if (mainOk && sbyOk && state && reset) {
			state = false;
			alarm = false;
		}
		
		if ((!mainOk) && (!sbyOk)) {
			alarm = true;
		}
		
		return new int[] {state ? 15 : 0, state ? 0 : 15, alarm ? 15 : 0};
	}

	@Override
	public String getUnlocalizedName() {
		return "miscICs.relay.standby_control";
	}

	@Override
	public String getInputPinLabel(int pin) {
		return inputPinNames[pin];
	}

	@Override
	public String getOutputPinLabel(int pin) {
		return pin == 0 ? "ENS" : pin==1 ? "ENM" : "ALM";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		state = tag.getBoolean("state");
		alarm = tag.getBoolean("alarm");
		timer = tag.getInteger("timer");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("state", state);
		tag.setBoolean("alarm", alarm);
		tag.setInteger("timer", timer);
	}

}
