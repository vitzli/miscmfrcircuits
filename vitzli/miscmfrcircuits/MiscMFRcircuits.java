package vitzli.miscmfrcircuits;

// MiscMFRcircuits

import java.util.logging.Logger;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import vitzli.miscmfrcircuits.handlers.RegistryHandler;

@Mod(modid = MiscMFRcircuits.modID, name = MiscMFRcircuits.modName, version = MiscMFRcircuits.version, dependencies = "required-after:MineFactoryReloaded")
@NetworkMod(clientSideRequired = true)

public class MiscMFRcircuits {
    public static final String modID = "MiscMFRcircuits";
    public static final String modName = "Misc MFR circuits";
    public static final String version = "0.0.0.2";
    
    @Instance(modID)
    public static MiscMFRcircuits instance;
    
    public static Logger log;
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        
    }
    
    @Init
    public void Init(FMLInitializationEvent event) {
        RegistryHandler.InitRedNetRegistry();
        RegistryHandler.InitLanguageRegistry();
    }
    
    @PostInit
    public void PostInit(FMLPostInitializationEvent event) {
        
    }
    
}