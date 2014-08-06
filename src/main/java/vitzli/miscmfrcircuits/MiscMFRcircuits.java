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
import vitzli.miscmfrcircuits.ref.Reference;

@Mod(modid = Reference.MOD_ID, name = Reference.MOD_NAME, version = Reference.VERSION, dependencies = "required-after:MineFactoryReloaded")
@NetworkMod(clientSideRequired = true)
public class MiscMFRcircuits {
    @Instance(value=Reference.MOD_ID)
    public static MiscMFRcircuits instance;

    public static Logger log = Logger.getLogger(Reference.MOD_ID);

    @EventHandler
    public void preInit(FMLPreInitializationEvent event) {
        log.setParent(FMLLog.getLogger());
    }

    @EventHandler
    public void Init(FMLInitializationEvent event) {
        log.log(Level.INFO, "Registering circuits...");

        try {
            RegistryHandler.InitRedNetRegistry();
        } catch (Exception x) {
            log.log(Level.SEVERE,
                    "Error during circuit registration");
            x.printStackTrace();
        }
    }

    @EventHandler
    public void PostInit(FMLPostInitializationEvent event) {
        // nop
    }

}