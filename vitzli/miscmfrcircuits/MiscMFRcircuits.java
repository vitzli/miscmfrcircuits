package vitzli.miscmfrcircuits;

// MiscMFRcircuits

import java.util.logging.Logger;
import java.util.logging.Level;

import net.minecraftforge.common.Configuration;
import cpw.mods.fml.common.FMLLog;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.EventHandler;
import cpw.mods.fml.common.Mod.Instance;
import cpw.mods.fml.common.SidedProxy;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;

import vitzli.miscmfrcircuits.handlers.RegistryHandler;

@Mod(modid = MiscMFRcircuits.modID, name = MiscMFRcircuits.modName, version = MiscMFRcircuits.version, dependencies = "required-after:MineFactoryReloaded")
@NetworkMod(clientSideRequired = true)
public class MiscMFRcircuits {
    public static final String modID = "miscmfrcircuits";
    public static final String modName = "Misc MFR circuits";
    public static final String version = "0.5.1";

    @Instance(value=modID)
    public static MiscMFRcircuits instance;

    public static Logger log = Logger.getLogger(MiscMFRcircuits.modID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log.setParent(FMLLog.getLogger());
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        log.log(Level.INFO, "miscIC here. Attempt to register my circuits");

        try {
            RegistryHandler.InitRedNetRegistry();
        } catch (Exception x) {
            log.log(Level.SEVERE,
                    "miscIC here. I cannot do my job and now I'm sad");
            x.printStackTrace();
        }
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        // nop
    }

}