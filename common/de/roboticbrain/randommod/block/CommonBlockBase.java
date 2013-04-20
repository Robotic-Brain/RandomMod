package de.roboticbrain.randommod.block;

import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import de.roboticbrain.randommod.RandomMod;
import de.roboticbrain.randommod.lib.Reference;

public class CommonBlockBase extends Block {

    public CommonBlockBase(int id, Material material) {
        super(id, material);
        this.setCreativeTab(RandomMod.creativeTab);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getUnlocalizedName2());
    }
    
}
