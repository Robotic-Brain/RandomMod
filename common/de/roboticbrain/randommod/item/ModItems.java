package de.roboticbrain.randommod.item;

import cpw.mods.fml.common.registry.GameRegistry;
import net.minecraft.item.Item;
import de.roboticbrain.randommod.lib.ItemIds;
import de.roboticbrain.randommod.lib.Strings;

public class ModItems {
    public static Item backPack;
    
    public static void init() {
        backPack = new ItemBag(ItemIds.BACK_PACK);
        
        GameRegistry.registerItem(backPack, Strings.BACK_PACK_NAME);
    }
}
