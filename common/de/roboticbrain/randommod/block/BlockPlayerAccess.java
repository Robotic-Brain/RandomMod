package de.roboticbrain.randommod.block;

import java.util.Iterator;
import java.util.List;
import java.util.Random;

import net.minecraft.block.material.Material;
import net.minecraft.client.renderer.texture.IconRegister;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.monster.IMob;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.DamageSource;
import net.minecraft.util.Icon;
import net.minecraft.world.World;
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
        this.sideIcon = par1IconRegister.registerIcon(Reference.MOD_ID + ":" + getUnlocalizedName2() + "_side");
    }
    
    @Override
    @SideOnly(Side.CLIENT)
    public Icon getIcon(int side, int meta) {
        return (side == meta) ? this.blockIcon : this.sideIcon;
    }
    
    @Override
    public void onBlockAdded(World world, int x, int y, int z) {
        super.onBlockAdded(world, x, y, z);
        
        if (world.getBlockId(x, y, z) == this.blockID) {
            world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
        }
    }
    
    @Override
    public void updateTick(World world, int x, int y, int z, Random par5Random) {
        super.updateTick(world, x, y, z, par5Random);
        
        int size = 2;
        
        List entityList = world.getEntitiesWithinAABB(IMob.class, AxisAlignedBB.getBoundingBox(x - size, y - size, z - size, x + size, y + size, z + size));
        Iterator iter = entityList.iterator();
        
        while (iter.hasNext())
        {
            EntityLiving entity = (EntityLiving) iter.next();
            
            entity.attackEntityFrom(DamageSource.generic, 10);
        }
        
        if (world.getBlockId(x, y, z) == this.blockID) {
            world.scheduleBlockUpdate(x, y, z, this.blockID, this.tickRate(world));
        }
    }
}
