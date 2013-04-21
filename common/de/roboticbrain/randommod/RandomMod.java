package de.roboticbrain.randommod;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import de.roboticbrain.randommod.block.ModBlocks;
import de.roboticbrain.randommod.configuration.ConfigurationHandler;
import de.roboticbrain.randommod.core.helper.LogHelper;
import de.roboticbrain.randommod.creativetab.CreativeTabRandomMod;
import de.roboticbrain.randommod.lib.Reference;

@Mod(modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION_STRING)
@NetworkMod(clientSideRequired = true,
                serverSideRequired = false)
public class RandomMod {
    
    public static CreativeTabs creativeTab = new CreativeTabRandomMod(CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // Initialize logger
        LogHelper.init();
        
        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
        
        // Initialize mod blocks
        ModBlocks.init();
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
