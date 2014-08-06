package vitzli.miscmfrcircuits;

// MiscMFRcircuits

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;

import vitzli.miscmfrcircuits.handlers.RegistryHandler;
import vitzli.miscmfrcircuits.ref.Reference;
import vitzli.miscmfrcircuits.lib.LogHelper;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:MineFactoryReloaded")
public class MiscMFRcircuits {
    @Instance(value=Reference.MOD_ID)
    public static MiscMFRcircuits instance;


    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        // log.setParent(FMLLog.getLogger());   	
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
    	LogHelper.info("Registering circuits...");
        try {
            RegistryHandler.InitRedNetRegistry();
        } catch (Exception x) {
        	LogHelper.error("Error during circuit registration");
            x.printStackTrace();
        }
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        // nop
    }

}