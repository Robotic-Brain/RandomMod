package de.roboticbrain.randommod.block;

import java.util.logging.Level;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.common.ForgeDirection;
import cpw.mods.fml.relauncher.Side;
import cpw.mods.fml.relauncher.SideOnly;
import de.roboticbrain.randommod.RandomMod;
import de.roboticbrain.randommod.core.helper.LogHelper;
import de.roboticbrain.randommod.lib.Reference;

public class CommonBlockBase extends Block {
    
    public CommonBlockBase(int id, Material material) {
        super(id, material);
        this.setCreativeTab(RandomMod.creativeTab);
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public void registerIcons(IconRegister par1IconRegister) {
        this.blockIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":"
                + getUnlocalizedName2());
    }
    
    @Override
    public void onBlockPlacedBy(World world, int x, int y, int z, EntityLiving entityLiving, ItemStack itemStack) {
        int direction = determineOrientation(world, x, y, z, entityLiving);
        /*int facing = MathHelper.floor_double(entityLiving.rotationYaw * 4.0F / 360.0F + 0.5D) & 3;
        
        LogHelper.log(Level.INFO, "Entity Yaw: " + entityLiving.rotationYaw);
        LogHelper.log(Level.INFO, "Entity Pitch: " + entityLiving.rotationPitch);
        
        if (entityLiving.rotationPitch >= 45.0f) {
            direction = ForgeDirection.UP.ordinal();
        } else if (entityLiving.rotationPitch <= -45.0f) {
            direction = ForgeDirection.DOWN.ordinal();
        } else if (facing == 0) {
            direction = ForgeDirection.NORTH.ordinal();
        } else if (facing == 1) {
            direction = ForgeDirection.EAST.ordinal();
        } else if (facing == 2) {
            direction = ForgeDirection.SOUTH.ordinal();
        } else if (facing == 3) {
            direction = ForgeDirection.WEST.ordinal();
        }*/
        
        world.setBlockMetadataWithNotify(x, y, z, direction, 3);
        
    }
    
    /**
     * determineOrientation from BlockPistonBase:
     * 
     * gets the way this piston should face for that entity that placed it.
     */
    public static int determineOrientation(World par0World, int par1, int par2, int par3, EntityLiving par4EntityLiving)
    {
        if (MathHelper.abs((float)par4EntityLiving.posX - (float)par1) < 2.0F && MathHelper.abs((float)par4EntityLiving.posZ - (float)par3) < 2.0F)
        {
            double d0 = par4EntityLiving.posY + 1.82D - (double)par4EntityLiving.yOffset;

            if (d0 - (double)par2 > 2.0D)
            {
                return 1;
            }

            if ((double)par2 - d0 > 0.0D)
            {
                return 0;
            }
        }

        int l = MathHelper.floor_double((double)(par4EntityLiving.rotationYaw * 4.0F / 360.0F) + 0.5D) & 3;
        return l == 0 ? 2 : (l == 1 ? 5 : (l == 2 ? 3 : (l == 3 ? 4 : 0)));
    }
}
