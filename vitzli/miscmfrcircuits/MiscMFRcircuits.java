package vitzli.miscmfrcircuits;

// MiscMFRcircuits

import java.util.logging.Logger;
import java.util.logging.Level;

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
    public static final String version = "0.0.0.5";

    @Instance(modID)
    public static MiscMFRcircuits instance;

    public static Logger log = Logger.getLogger(MiscMFRcircuits.modID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        log.setParent(FMLLog.getLogger());
    }

    @Init
    public void Init(FMLInitializationEvent event) {
        log.log(Level.INFO, "miscIC here. Registering all my circuits");

        try {
            RegistryHandler.InitRedNetRegistry();
        } catch (Exception x) {
            log.log(Level.SEVERE,
                    "miscIC here. I cannot do my job and now I'm sad");
            x.printStackTrace();
        }
    }

    @PostInit
    public void PostInit(FMLPostInitializationEvent event) {

    }

}