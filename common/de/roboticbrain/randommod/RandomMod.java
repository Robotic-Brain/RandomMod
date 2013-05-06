package de.roboticbrain.randommod;

import java.io.File;

import net.minecraft.creativetab.CreativeTabs;
import net.minecraftforge.common.MinecraftForge;
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
import cpw.mods.fml.common.network.NetworkRegistry;
import de.roboticbrain.randommod.block.ModBlocks;
import de.roboticbrain.randommod.configuration.ConfigurationHandler;
import de.roboticbrain.randommod.core.helper.LogHelper;
import de.roboticbrain.randommod.core.proxy.CommonProxy;
import de.roboticbrain.randommod.creativetab.CreativeTabRandomMod;
import de.roboticbrain.randommod.event.CreeperLivingSpawnEvent;
import de.roboticbrain.randommod.item.ModItems;
import de.roboticbrain.randommod.lib.Reference;

@Mod(modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION_STRING)
@NetworkMod(clientSideRequired = true,
                serverSideRequired = false)
public class RandomMod {
    
    @Instance(Reference.MOD_ID)
    public static RandomMod instance;
    
    @SidedProxy(
            clientSide = Reference.CLIENT_PROXY_CLASS,
            serverSide = Reference.SERVER_PROXY_CLASS)
    public static CommonProxy proxy;
    
    public static CreativeTabs creativeTab = new CreativeTabRandomMod(CreativeTabs.getNextID(), Reference.MOD_ID);

    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        // Initialize logger
        LogHelper.init();
        
        // Initialize the configuration
        ConfigurationHandler.init(new File(event.getModConfigurationDirectory().getAbsolutePath() + File.separator + Reference.CHANNEL_NAME + File.separator + Reference.MOD_ID + ".cfg"));
        
        // Initialize mod blocks
        ModBlocks.init();
        
        // Initialize mod items
        ModItems.init();
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        // Register the GUI Handler
        NetworkRegistry.instance().registerGuiHandler(instance, proxy);
        
        // Prevent creeper spawn
        MinecraftForge.EVENT_BUS.register(new CreeperLivingSpawnEvent());
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
