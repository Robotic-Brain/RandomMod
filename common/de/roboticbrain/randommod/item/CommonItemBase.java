package de.roboticbrain.randommod.item;

import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.item.Item;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.roboticbrain.randommod.RandomMod;
import de.roboticbrain.randommod.lib.Reference;

public class CommonItemBase extends Item {
    
    public CommonItemBase(int id) {
        super(id);
        this.setCreativeTab(RandomMod.creativeTab);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.itemIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getUnlocalizedName());
    }
}
