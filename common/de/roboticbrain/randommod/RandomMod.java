package de.roboticbrain.randommod;

import cpw.mods.fml.common.Mod;
import cpw.mods.fml.common.Mod.Init;
import cpw.mods.fml.common.Mod.PostInit;
import cpw.mods.fml.common.Mod.PreInit;
import cpw.mods.fml.common.event.FMLInitializationEvent;
import cpw.mods.fml.common.event.FMLPostInitializationEvent;
import cpw.mods.fml.common.event.FMLPreInitializationEvent;
import cpw.mods.fml.common.network.NetworkMod;
import de.roboticbrain.randommod.block.ModBlocks;
import de.roboticbrain.randommod.lib.Reference;

@Mod(modid = Reference.MOD_ID,
        name = Reference.MOD_NAME,
        version = Reference.VERSION_STRING)
@NetworkMod(clientSideRequired = true,
                serverSideRequired = false)
public class RandomMod {
    
    @PreInit
    public void preInit(FMLPreInitializationEvent event) {
        
        ModBlocks.init();
    }
    
    @Init
    public void init(FMLInitializationEvent event) {
        
    }
    
    @PostInit
    public void postInit(FMLPostInitializationEvent event) {
        
    }
}
