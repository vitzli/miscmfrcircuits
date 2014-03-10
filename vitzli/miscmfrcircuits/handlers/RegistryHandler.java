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
		FactoryRegistry.registerRedNetLogicCircuit(new Adder8());
		FactoryRegistry.registerRedNetLogicCircuit(new Average());
		FactoryRegistry.registerRedNetLogicCircuit(new QuadAdder2());
		FactoryRegistry.registerRedNetLogicCircuit(new LongTimer());
//		// -- analog
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.analog.Adder8", "miscIC:A: Adder (8 in)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.analog.average", "miscIC:A: Average");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.analog.QuadAdder2",
//				"miscIC:A: Quad Adder (4*2 in)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.analog.looongtimer",
//				"miscIC:A: hr:min:s timer (is looong, analog)");
	}

	private static void RegisterLogicBooleanCircuits() {
		FactoryRegistry.registerRedNetLogicCircuit(new ADC());
		FactoryRegistry.registerRedNetLogicCircuit(new BarGraph());
		FactoryRegistry.registerRedNetLogicCircuit(new DAC());
		FactoryRegistry.registerRedNetLogicCircuit(new ThresholdDetector());

//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.decoder16.ADC", "miscIC:LB: ADC");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.encoder16.DAC", "miscIC:LB: DAC");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.decoder.bargraph", "miscIC:LB: Bargraph");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logicboolean.hysteresis", "miscIC:LB: Hysteresis thres.");

	}

	private static void RegisterBusCircuits() {
		// -- bus -- 15
		// decoders -- 3
		FactoryRegistry.registerRedNetLogicCircuit(new Decoder32bit_2by16bit());
		FactoryRegistry.registerRedNetLogicCircuit(new Decoder32bit_4by8bit());
		FactoryRegistry.registerRedNetLogicCircuit(new Decoder32bit_8by4bit());

		// encoders -- 3
		FactoryRegistry.registerRedNetLogicCircuit(new Encoder32bit_2by16bit());
		FactoryRegistry.registerRedNetLogicCircuit(new Encoder32bit_4by8bit());
		FactoryRegistry.registerRedNetLogicCircuit(new Encoder32bit_8by4bit());

		// Gray<->Binary code conversion -- 2
		FactoryRegistry.registerRedNetLogicCircuit(new Bin2GrayBus());
		FactoryRegistry.registerRedNetLogicCircuit(new Gray2BinBus());

		// Bus-wise logic gates -- 4
		FactoryRegistry.registerRedNetLogicCircuit(new AND2bus());
		FactoryRegistry.registerRedNetLogicCircuit(new NOTbus());
		FactoryRegistry.registerRedNetLogicCircuit(new OR2bus());
		FactoryRegistry.registerRedNetLogicCircuit(new XOR2bus());

		// RAM -- 3
		FactoryRegistry.registerRedNetLogicCircuit(new RAM_1W());
		FactoryRegistry.registerRedNetLogicCircuit(new RAM_8W());
		FactoryRegistry.registerRedNetLogicCircuit(new RAM_16W());
		FactoryRegistry.registerRedNetLogicCircuit(new VGAROM());

//		LanguageRegistry.instance().addStringLocalization("miscICs.bus.and2",
//				"miscIC:B: AND2 (32bit bus)");
//		LanguageRegistry.instance().addStringLocalization("miscICs.bus.or2",
//				"miscIC:B: OR2 (32bit bus)");
//		LanguageRegistry.instance().addStringLocalization("miscICs.bus.xor2",
//				"miscIC:B: XOR2 (32bit bus)");
//		LanguageRegistry.instance().addStringLocalization("miscICs.bus.not",
//				"miscIC:B: NOT (32bit bus)");
//
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.bus.bin2gray", "miscIC:B: Bin2Gray (32bit bus)");
//		LanguageRegistry.instance().addStringLocalization("miscICs.bus.gr2bin",
//				"miscIC:B: Gray2Bin (32bit bus)");
//
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.decoder32.2by16bit", "miscIC:B: Dec 2*16bit(bus)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.decoder32.4by8bit", "miscIC:B: Dec 4*8bit(bus)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.decoder32.8by4bit", "miscIC:B: Dec 8*4bit(bus)");
//
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.encoder32.2by16bit", "miscIC:B: Enc 2*16bit");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.encoder32.4by8bit", "miscIC:B: Enc 4*8bit");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.encoder32.8by4bit", "miscIC:B: Enc 8*4bit");
//
//		LanguageRegistry.instance().addStringLocalization("miscICs.RAM.1W",
//				"miscIC:B: RAM 1W (32bit)");
//		LanguageRegistry.instance().addStringLocalization("miscICs.RAM.8W",
//				"miscIC:B: RAM 8W (32bit)");
//		LanguageRegistry.instance().addStringLocalization("miscICs.RAM.16W",
//				"miscIC:B: RAM 16W (32bit)");
//		
//		LanguageRegistry.instance().addStringLocalization("miscICs.bus.vgarom",
//				"miscIC:B: CG ROM");
		
	}

	private static void RegisterLogicCircuits() {
		FactoryRegistry.registerRedNetLogicCircuit(new EdgeDetection());
		FactoryRegistry.registerRedNetLogicCircuit(new QuadAND2());
		FactoryRegistry.registerRedNetLogicCircuit(new QuadNOT());
		FactoryRegistry.registerRedNetLogicCircuit(new QuadOR2());
		FactoryRegistry.registerRedNetLogicCircuit(new QuadXOR2());

		FactoryRegistry.registerRedNetLogicCircuit(new AllTheSame());
		FactoryRegistry.registerRedNetLogicCircuit(new Even());
		FactoryRegistry.registerRedNetLogicCircuit(new LogicThreshold());
		FactoryRegistry.registerRedNetLogicCircuit(new NAndOnlyN());
		FactoryRegistry.registerRedNetLogicCircuit(new Odd());
		FactoryRegistry.registerRedNetLogicCircuit(new TwoOfThree());
		FactoryRegistry.registerRedNetLogicCircuit(new Johnson5stage());

//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.edgedetector", "miscIC:L: Edge detector");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.quad_and2", "miscIC:L: Quad AND2 (discrete)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.quad_not", "miscIC:L: Quad NOT (discrete)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.quad_or2", "miscIC:L: Quad OR2 (discrete)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.quad_xor2", "miscIC:L: Quad XOR2 (discrete)");
//
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.allthesame", "miscIC:L: All the same");
//		LanguageRegistry.instance().addStringLocalization("miscICs.logic.even",
//				"miscIC:L: Even qty active");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.threshold8", "miscIC:L: At least N active");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.nandonlyn", "miscIC:L: N and only N");
//		LanguageRegistry.instance().addStringLocalization("miscICs.logic.odd",
//				"miscIC:L: Odd qty active");
//		LanguageRegistry.instance().addStringLocalization("miscICs.logic.2of3",
//				"miscIC:L: 2 of 3 active");
//		
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.logic.counter4017", "miscIC:L: Johnson 5-stage");
	}

	private static void RegisterRelayCircuits() {
		FactoryRegistry.registerRedNetLogicCircuit(new MaxDTcircuit());
		FactoryRegistry.registerRedNetLogicCircuit(new MinDTcircuit());
		FactoryRegistry.registerRedNetLogicCircuit(new DiskCircuit());
		FactoryRegistry.registerRedNetLogicCircuit(new StandbyController());

//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.relay.max_dt", "miscIC:R: Max Relay (DT)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.relay.min_dt", "miscIC:R: Min Relay (DT)");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.relay.induction", "miscIC:R: Inv time relay");
//		LanguageRegistry.instance().addStringLocalization(
//				"miscICs.relay.standby_control", "miscIC:R:Stand-by controller");
	}
}
