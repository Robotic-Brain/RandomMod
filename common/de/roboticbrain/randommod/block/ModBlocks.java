package de.roboticbrain.randommod.block;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.block.Block;
import de.roboticbrain.randommod.lib.BlockIds;
import de.roboticbrain.randommod.lib.Strings;

public class ModBlocks {
    
    public static Block accessBlock;
    
    public static void init() {
        accessBlock = new BlockPlayerAccess(BlockIds.PLAYER_ACCESS_BLOCK);
        
        GameRegistry.registerBlock(accessBlock, Strings.PLAYER_ACCESS_BLOCK_NAME);
    }
}
