package vitzli.miscmfrcircuits.handlers;

import java.io.IOException;

import cpw.mods.fml.common.registry.LanguageRegistry;

import powercrystals.minefactoryreloaded.api.FarmingRegistry;

import vitzli.miscmfrcircuits.circuits.ADC;
import vitzli.miscmfrcircuits.circuits.BarGraph;
import vitzli.miscmfrcircuits.circuits.DAC;

import vitzli.miscmfrcircuits.circuits.analog.*;

import vitzli.miscmfrcircuits.circuits.bus.*;
import vitzli.miscmfrcircuits.circuits.logic.*;

import vitzli.miscmfrcircuits.circuits.relay.MaxDTcircuit;
import vitzli.miscmfrcircuits.circuits.relay.MinDTcircuit;
import vitzli.miscmfrcircuits.circuits.relay.DiskCircuit;

public class RegistryHandler {
	public static void InitRedNetRegistry() {
		try {

			// 26 new circuits as of 2013-06-20

			// -- conversion -- 3
			FarmingRegistry.registerRedNetLogicCircuit(new ADC());
			FarmingRegistry.registerRedNetLogicCircuit(new BarGraph());
			FarmingRegistry.registerRedNetLogicCircuit(new DAC());

			// -- analog -- 3
			FarmingRegistry.registerRedNetLogicCircuit(new Adder8());
			FarmingRegistry.registerRedNetLogicCircuit(new Average());
			FarmingRegistry.registerRedNetLogicCircuit(new QuadAdder2());

			// -- bus -- 15
			// decoders -- 3
			FarmingRegistry
					.registerRedNetLogicCircuit(new Decoder32bit_2by16bit());
			FarmingRegistry
					.registerRedNetLogicCircuit(new Decoder32bit_4by8bit());
			FarmingRegistry
					.registerRedNetLogicCircuit(new Decoder32bit_8by4bit());

			// encoders -- 3
			FarmingRegistry
					.registerRedNetLogicCircuit(new Encoder32bit_2by16bit());
			FarmingRegistry
					.registerRedNetLogicCircuit(new Encoder32bit_4by8bit());
			FarmingRegistry
					.registerRedNetLogicCircuit(new Encoder32bit_8by4bit());

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

			// -- logic -- 5
			FarmingRegistry.registerRedNetLogicCircuit(new EdgeDetection());
			FarmingRegistry.registerRedNetLogicCircuit(new QuadAND2());
			FarmingRegistry.registerRedNetLogicCircuit(new QuadNOT());
			FarmingRegistry.registerRedNetLogicCircuit(new QuadOR2());
			FarmingRegistry.registerRedNetLogicCircuit(new QuadXOR2());

			// -- relay -- 3
			FarmingRegistry.registerRedNetLogicCircuit(new MaxDTcircuit());
			FarmingRegistry.registerRedNetLogicCircuit(new MinDTcircuit());
			FarmingRegistry.registerRedNetLogicCircuit(new DiskCircuit());

		} catch (Exception x) {
			x.printStackTrace();
		}
	}

	public static void InitLanguageRegistry() {
		try {

			// -- conversion
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.decoder16.ADC", "miscIC: ADC");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.encoder16.DAC", "miscIC: DAC");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.decoder.bargraph", "miscIC: Bargraph");

			// -- analog
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.analog.Adder8", "miscIC: Adder (8 in, analog)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.analog.average", "miscIC: Average (analog)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.analog.QuadAdder2",
					"miscIC: Quad Adder (2 in, analog)");

			// -- bus
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.bus.and2", "miscIC: AND2 (32bit bus)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.bus.or2", "miscIC: OR2 (32bit bus)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.bus.xor2", "miscIC: XOR2 (32bit bus)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.bus.not", "miscIC: NOT (32bit bus)");

			LanguageRegistry.instance().addStringLocalization(
					"miscICs.bus.bin2gray", "miscIC: Bin2Gray (32bit bus)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.bus.gr2bin", "miscIC: Gray2Bin (32bit bus)");

			LanguageRegistry.instance().addStringLocalization(
					"miscICs.decoder32.2by16bit", "miscIC: Dec 2*16bit(bus)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.decoder32.4by8bit", "miscIC: Dec 4*8bit(bus)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.decoder32.8by4bit", "miscIC: Dec 8*4bit(bus)");

			LanguageRegistry.instance().addStringLocalization(
					"miscICs.encoder32.2by16bit", "miscIC: Enc 2*16bit");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.encoder32.4by8bit", "miscIC: Enc 4*8bit");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.encoder32.8by4bit", "miscIC: Enc 8*4bit");

			LanguageRegistry.instance().addStringLocalization("miscICs.RAM.1W",
					"miscIC: RAM 1W (32bit)");
			LanguageRegistry.instance().addStringLocalization("miscICs.RAM.8W",
					"miscIC: RAM 8W (32bit)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.RAM.16W", "miscIC: RAM 16W (32bit)");

			// -- logic
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.logic.edgedetector", "miscIC: Edge detector");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.logic.quad_and2", "miscIC: Quad AND2 (discrete)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.logic.quad_not", "miscIC: Quad NOT (discrete)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.logic.quad_or2", "miscIC: Quad OR2 (discrete)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.logic.quad_xor2", "miscIC: Quad XOR2 (discrete)");

			// -- relay
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.relay.max_dt", "miscIC: Max Relay (DT)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.relay.min_dt", "miscIC: Min Relay (DT)");
			LanguageRegistry.instance().addStringLocalization(
					"miscICs.relay.induction", "miscIC: Inv time relay");

		} catch (Exception x) {
			x.printStackTrace();
		}

	}
}
