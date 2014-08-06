package vitzli.miscmfrcircuits.handlers;

import java.io.IOException;

import cpw.mods.fml.common.registry.LanguageRegistry;
import powercrystals.minefactoryreloaded.api.FactoryRegistry;
import vitzli.miscmfrcircuits.circuits.analog.*;
import vitzli.miscmfrcircuits.circuits.bus.*;
import vitzli.miscmfrcircuits.circuits.logic.*;
import vitzli.miscmfrcircuits.circuits.logicboolean.*;
import vitzli.miscmfrcircuits.circuits.relay.*;

public class RegistryHandler {
	public static void InitRedNetRegistry() {
		RegisterLogicBooleanCircuits();
		RegisterAnalogCircuits();
		RegisterBusCircuits();
		RegisterLogicCircuits();
		RegisterRelayCircuits();
	}

	private static void RegisterAnalogCircuits() {
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new AbsSign());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Adder8());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Average());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Constraint());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Divide());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new LongTimer());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new MulDiv());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Multiply());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new PIDController());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new QuadAdder2());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new WorldTick());
	}

	private static void RegisterLogicBooleanCircuits() {
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new ADC());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new BarGraph());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new DAC());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new ThresholdDetector());
	}

	private static void RegisterBusCircuits() {
		// -- bus -- 15
		// decoders -- 3
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Decoder32bit_2by16bit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Decoder32bit_4by8bit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Decoder32bit_8by4bit());

		// encoders -- 3
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Encoder32bit_2by16bit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Encoder32bit_4by8bit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Encoder32bit_8by4bit());

		// Gray<->Binary code conversion -- 2
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Bin2GrayBus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Gray2BinBus());

		// Bus-wise logic gates -- 4
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new AND2bus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new NOTbus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new OR2bus());
		
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new XOR2bus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new NAND2bus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new NOR2bus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new XNOR2bus());

		// RAM -- 3
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new RAM_1W());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new RAM_8W());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new RAM_16W());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new VGAROM());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new LShiftbus());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new RShiftbus());
	}

	private static void RegisterLogicCircuits() {
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new EdgeDetection());
		
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new QuadAND2());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new QuadNOT());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new QuadOR2());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new QuadXOR2());

		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new AllTheSame());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Even());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Johnson5stage());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new LogicThreshold());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new NAndOnlyN());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new Odd());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new TwoOfThree());
	}

	private static void RegisterRelayCircuits() {
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new DiskCircuit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new MaxDTcircuit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new MinDTcircuit());
		FactoryRegistry.sendMessage("registerRedNetLogicCircuit", new StandbyController());
	}
}
