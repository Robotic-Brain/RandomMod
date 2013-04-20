package de.roboticbrain.randommod.creativetab;

import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.item.Item;

public class CreativeTabRandomMod extends CreativeTabs {

    public CreativeTabRandomMod(int par1, String par2Str) {
        super(par1, par2Str);
        LanguageRegistry.instance().addStringLocalization("itemGroup.randommod", "en_US", "Test");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public int getTabIconItemIndex() {
        return Item.diamond.itemID;
    }
}
