package vitzli.miscmfrcircuits.circuits.relay;

import net.minecraft.nbt.NBTTagCompound;
import powercrystals.minefactoryreloaded.api.rednet.IRedNetLogicCircuit;
import vitzli.miscmfrcircuits.lib.ValueFunctions;

public class StandbyController implements IRedNetLogicCircuit {

	private static final String[] inputPinNames = new String[] {"Mok", "Sok", "Td", "RST"};

	private boolean mainOk;
	private boolean sbyOk;
	private boolean reset = false;
	private boolean standbyMode = false; // true when in stand-by mode
	private boolean alarm = false;
	private boolean powerLoss = false;
	private int timer = 0;
	private int Td = 0;
	
	@Override
	public byte getInputCount() {
		return 4;
	}

	@Override
	public byte getOutputCount() {
		return 4;
	}

	@Override
	public int[] recalculateOutputValues(long worldTime, int[] inputValues) {
		mainOk = inputValues[0] !=0 ? true : false;
		sbyOk = inputValues[1] !=0 ? true : false;
		Td = ValueFunctions.ConstraintInt(inputValues[2], 0, 255) * 20;
		reset = inputValues[3] !=0 ? true : false;
		
		alarm = ! (mainOk && sbyOk);
		
		if ((!mainOk) && (!sbyOk)) {
				powerLoss = true;
				standbyMode = false;
				timer = Td;
				return new int[] {0, 0, 15, 15};				
		}
		
		if (mainOk && (reset || powerLoss)) {
			standbyMode = false;
			timer = 0;
			powerLoss = false;
			return new int[] {0, 15, alarm ? 15 : 0, 0};
		}
		
		if (sbyOk && powerLoss) {
			powerLoss = false;
			standbyMode = true;
			timer = 0;
			return new int[] {15, 0, alarm ? 15 : 0, 0};
		}
		
		if (!mainOk && sbyOk && (!standbyMode)) {
			timer++;
			if (timer>Td) {
				standbyMode = true;
				timer = 0;
			}
		}
		
		if (mainOk && !sbyOk && standbyMode) {
			timer++;
			if (timer>Td) {
				standbyMode = false;
				timer = 0;
			}
		}
			
		return new int[] {standbyMode ? 15 : 0, standbyMode ? 0 : 15, alarm ? 15 : 0, powerLoss ? 15 : 0};
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
		return pin == 0 ? "EnS" : pin==1 ? "EnM" : pin==2 ? "ALM" : "ERR";
	}

	@Override
	public void readFromNBT(NBTTagCompound tag) {
		standbyMode = tag.getBoolean("state");
		timer = tag.getInteger("timer");
		
	}

	@Override
	public void writeToNBT(NBTTagCompound tag) {
		tag.setBoolean("state", standbyMode);
		tag.setInteger("timer", timer);
	}

}
