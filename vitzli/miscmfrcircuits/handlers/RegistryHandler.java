package vitzli.miscmfrcircuits.handlers;

import java.io.IOException;

import cpw.mods.fml.common.registry.LanguageRegistry;

import powercrystals.minefactoryreloaded.api.FarmingRegistry;

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
		FarmingRegistry.registerRedNetLogicCircuit(new Adder8());
		FarmingRegistry.registerRedNetLogicCircuit(new Average());
		FarmingRegistry.registerRedNetLogicCircuit(new QuadAdder2());
		FarmingRegistry.registerRedNetLogicCircuit(new LongTimer());
		// -- analog
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.analog.Adder8", "miscIC:A: Adder (8 in)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.analog.average", "miscIC:A: Average");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.analog.QuadAdder2",
				"miscIC:A: Quad Adder (4*2 in)");
		LanguageRegistry.instance().addStringLocalization(
				"miscIC.analog.looongtimer",
				"miscIC:A: hr:min:s timer (is looong, analog)");
	}

	private static void RegisterLogicBooleanCircuits() {
		FarmingRegistry.registerRedNetLogicCircuit(new ADC());
		FarmingRegistry.registerRedNetLogicCircuit(new BarGraph());
		FarmingRegistry.registerRedNetLogicCircuit(new DAC());
		FarmingRegistry.registerRedNetLogicCircuit(new ThresholdDetector());

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.decoder16.ADC", "miscIC:LB: ADC");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.encoder16.DAC", "miscIC:LB: DAC");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.decoder.bargraph", "miscIC:LB: Bargraph");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logicboolean.hysteresis", "miscIC:LB: Hysteresis thres.");

	}

	private static void RegisterBusCircuits() {
		// -- bus -- 15
		// decoders -- 3
		FarmingRegistry.registerRedNetLogicCircuit(new Decoder32bit_2by16bit());
		FarmingRegistry.registerRedNetLogicCircuit(new Decoder32bit_4by8bit());
		FarmingRegistry.registerRedNetLogicCircuit(new Decoder32bit_8by4bit());

		// encoders -- 3
		FarmingRegistry.registerRedNetLogicCircuit(new Encoder32bit_2by16bit());
		FarmingRegistry.registerRedNetLogicCircuit(new Encoder32bit_4by8bit());
		FarmingRegistry.registerRedNetLogicCircuit(new Encoder32bit_8by4bit());

		// Gray<->Binary code conversion -- 2
		FarmingRegistry.registerRedNetLogicCircuit(new Bin2GrayBus());
		FarmingRegistry.registerRedNetLogicCircuit(new Gray2BinBus());

		// Bus-wise logic gates -- 4
		FarmingRegistry.registerRedNetLogicCircuit(new AND2bus());
		FarmingRegistry.registerRedNetLogicCircuit(new NOTbus());
		FarmingRegistry.registerRedNetLogicCircuit(new OR2bus());
		FarmingRegistry.registerRedNetLogicCircuit(new XOR2bus());

		// RAM -- 3
		FarmingRegistry.registerRedNetLogicCircuit(new RAM_1W());
		FarmingRegistry.registerRedNetLogicCircuit(new RAM_8W());
		FarmingRegistry.registerRedNetLogicCircuit(new RAM_16W());
		FarmingRegistry.registerRedNetLogicCircuit(new VGAROM());

		LanguageRegistry.instance().addStringLocalization("miscICs.bus.and2",
				"miscIC:B: AND2 (32bit bus)");
		LanguageRegistry.instance().addStringLocalization("miscICs.bus.or2",
				"miscIC:B: OR2 (32bit bus)");
		LanguageRegistry.instance().addStringLocalization("miscICs.bus.xor2",
				"miscIC:B: XOR2 (32bit bus)");
		LanguageRegistry.instance().addStringLocalization("miscICs.bus.not",
				"miscIC:B: NOT (32bit bus)");

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.bus.bin2gray", "miscIC:B: Bin2Gray (32bit bus)");
		LanguageRegistry.instance().addStringLocalization("miscICs.bus.gr2bin",
				"miscIC:B: Gray2Bin (32bit bus)");

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.decoder32.2by16bit", "miscIC:B: Dec 2*16bit(bus)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.decoder32.4by8bit", "miscIC:B: Dec 4*8bit(bus)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.decoder32.8by4bit", "miscIC:B: Dec 8*4bit(bus)");

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.encoder32.2by16bit", "miscIC:B: Enc 2*16bit");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.encoder32.4by8bit", "miscIC:B: Enc 4*8bit");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.encoder32.8by4bit", "miscIC:B: Enc 8*4bit");

		LanguageRegistry.instance().addStringLocalization("miscICs.RAM.1W",
				"miscIC:B: RAM 1W (32bit)");
		LanguageRegistry.instance().addStringLocalization("miscICs.RAM.8W",
				"miscIC:B: RAM 8W (32bit)");
		LanguageRegistry.instance().addStringLocalization("miscICs.RAM.16W",
				"miscIC:B: RAM 16W (32bit)");
		
		LanguageRegistry.instance().addStringLocalization("miscICs.bus.vgarom",
				"miscIC:B: CG ROM");
		
	}

	private static void RegisterLogicCircuits() {
		FarmingRegistry.registerRedNetLogicCircuit(new EdgeDetection());
		FarmingRegistry.registerRedNetLogicCircuit(new QuadAND2());
		FarmingRegistry.registerRedNetLogicCircuit(new QuadNOT());
		FarmingRegistry.registerRedNetLogicCircuit(new QuadOR2());
		FarmingRegistry.registerRedNetLogicCircuit(new QuadXOR2());

		FarmingRegistry.registerRedNetLogicCircuit(new AllTheSame());
		FarmingRegistry.registerRedNetLogicCircuit(new Even());
		FarmingRegistry.registerRedNetLogicCircuit(new LogicThreshold());
		FarmingRegistry.registerRedNetLogicCircuit(new NAndOnlyN());
		FarmingRegistry.registerRedNetLogicCircuit(new Odd());
		FarmingRegistry.registerRedNetLogicCircuit(new TwoOfThree());
		FarmingRegistry.registerRedNetLogicCircuit(new Johnson5stage());

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.edgedetector", "miscIC:L: Edge detector");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.quad_and2", "miscIC:L: Quad AND2 (discrete)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.quad_not", "miscIC:L: Quad NOT (discrete)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.quad_or2", "miscIC:L: Quad OR2 (discrete)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.quad_xor2", "miscIC:L: Quad XOR2 (discrete)");

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.allthesame", "miscIC:L: All the same");
		LanguageRegistry.instance().addStringLocalization("miscICs.logic.even",
				"miscIC:L: Even qty active");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.threshold8", "miscIC:L: At least N active");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.nandonlyn", "miscIC:L: N and only N");
		LanguageRegistry.instance().addStringLocalization("miscICs.logic.odd",
				"miscIC:L: Odd qty active");
		LanguageRegistry.instance().addStringLocalization("miscICs.logic.2of3",
				"miscIC:L: 2 of 3 active");
		
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.logic.counter4017", "miscIC:L: Johnson 5-stage");
	}

	private static void RegisterRelayCircuits() {
		FarmingRegistry.registerRedNetLogicCircuit(new MaxDTcircuit());
		FarmingRegistry.registerRedNetLogicCircuit(new MinDTcircuit());
		FarmingRegistry.registerRedNetLogicCircuit(new DiskCircuit());
		FarmingRegistry.registerRedNetLogicCircuit(new StandbyController());

		LanguageRegistry.instance().addStringLocalization(
				"miscICs.relay.max_dt", "miscIC:R: Max Relay (DT)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.relay.min_dt", "miscIC:R: Min Relay (DT)");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.relay.induction", "miscIC:R: Inv time relay");
		LanguageRegistry.instance().addStringLocalization(
				"miscICs.relay.standby_control", "miscIC:R:Stand-by controller");
	}
}
