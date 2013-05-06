package de.roboticbrain.randommod.item;

import java.util.logging.Level;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;
import cpw.mods.fml.common.registry.LanguageRegistry;
import de.roboticbrain.randommod.RandomMod;
import de.roboticbrain.randommod.core.helper.LogHelper;
import de.roboticbrain.randommod.lib.Reference;
import de.roboticbrain.randommod.lib.Strings;


public class ItemBag extends CommonItemBase {

    public ItemBag(int id) {
        super(id);
        setUnlocalizedName(Strings.BACK_PACK_NAME);
        LanguageRegistry.instance().addStringLocalization(getUnlocalizedName() + ".name", "en_US", "BagTest");
    }
    
    @Override
    public ItemStack onItemRightClick(ItemStack stack, World world, EntityPlayer player) {
        if (!world.isRemote) {
            player.openGui(RandomMod.instance, Reference.BAG_GUI_ID, player.worldObj, (int)player.posX, (int)player.posY, (int)player.posZ);
            LogHelper.log(Level.INFO, "Opened Bag");
        }
        
        return stack;
    }
    
}
