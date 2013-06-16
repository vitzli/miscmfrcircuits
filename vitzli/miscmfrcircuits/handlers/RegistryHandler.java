package vitzli.miscmfrcircuits.handlers;

import java.io.IOException;

import cpw.mods.fml.common.registry.LanguageRegistry;

import powercrystals.minefactoryreloaded.api.FarmingRegistry;

import vitzli.miscmfrcircuits.circuits.ADC;
import vitzli.miscmfrcircuits.circuits.BarGraph;
import vitzli.miscmfrcircuits.circuits.DAC;
import vitzli.miscmfrcircuits.circuits.Encoder32bit_4by8bit;
import vitzli.miscmfrcircuits.circuits.Encoder32bit_8by4bit;
import vitzli.miscmfrcircuits.circuits.RAM_1W;
import vitzli.miscmfrcircuits.circuits.RAM_8W;
import vitzli.miscmfrcircuits.circuits.RAM_16W;


public class RegistryHandler {
    public static void InitRedNetRegistry() {
        FarmingRegistry.registerRedNetLogicCircuit(new ADC());
        FarmingRegistry.registerRedNetLogicCircuit(new BarGraph());
        FarmingRegistry.registerRedNetLogicCircuit(new DAC());
        FarmingRegistry.registerRedNetLogicCircuit(new Encoder32bit_4by8bit());
        FarmingRegistry.registerRedNetLogicCircuit(new Encoder32bit_8by4bit());
        FarmingRegistry.registerRedNetLogicCircuit(new RAM_1W());
        FarmingRegistry.registerRedNetLogicCircuit(new RAM_8W());
        FarmingRegistry.registerRedNetLogicCircuit(new RAM_16W());
    }

    public static void InitLanguageRegistry() {
        try{
            LanguageRegistry.instance().addStringLocalization("miscICs.decoder16.ADC", "misc IC: ADC");
            LanguageRegistry.instance().addStringLocalization("miscICs.decoder.bargraph", "misc IC: Bargraph");
            LanguageRegistry.instance().addStringLocalization("miscICs.encoder16.DAC", "misc IC: DAC");
            LanguageRegistry.instance().addStringLocalization("miscICs.encoder32.4by8bit", "misc IC: Enc 4by8bit");
            LanguageRegistry.instance().addStringLocalization("miscICs.encoder32.8by4bit", "misc IC: Enc 8by4bit");
            LanguageRegistry.instance().addStringLocalization("miscICs.RAM.1W", "misc IC: RAM 1W (32bit)");
            LanguageRegistry.instance().addStringLocalization("miscICs.RAM.8W", "misc IC: RAM 8W (32bit)");
            LanguageRegistry.instance().addStringLocalization("miscICs.RAM.16W", "misc IC: RAM 16W (32bit)");
        }
        catch(Exception x){
            x.printStackTrace();
        }
        
        
    }
}
