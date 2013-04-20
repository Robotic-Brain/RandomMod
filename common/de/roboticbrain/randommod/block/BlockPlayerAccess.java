package de.roboticbrain.randommod.block;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.util.Direction;
import net.minecraft.util.Icon;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.common.registry.LanguageRegistry;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.roboticbrain.randommod.lib.Reference;
import de.roboticbrain.randommod.lib.Strings;

public class BlockPlayerAccess extends CommonBlockBase {
    
    @SideOnly(Side.CLIENT)
    private Icon sideIcon;
    
    public BlockPlayerAccess(int id) {
        super(id, Material.iron);
        setUnlocalizedName(Strings.PLAYER_ACCESS_BLOCK_NAME);
        LanguageRegistry.instance().addStringLocalization(getUnlocalizedName() + ".name", "en_US", "USTest");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getUnlocalizedName2() + "_top");
        sideIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getUnlocalizedName2() + "_side");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return (side == 2) ? this.blockIcon : this.sideIcon;
    }
}
