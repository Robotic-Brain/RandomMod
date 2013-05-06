package de.roboticbrain.randommod.core.proxy;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.world.World;
import cpw.mods.fml.common.network.IGuiHandler;
import de.roboticbrain.randommod.inventory.ContainerBag;
import de.roboticbrain.randommod.inventory.GuiBag;
import de.roboticbrain.randommod.lib.Reference;

public class CommonProxy implements IGuiHandler {

    @Override
    public Object getServerGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == Reference.BAG_GUI_ID) {
            return new ContainerBag(player.getCurrentEquippedItem(), player);
        }
        
        return null;
    }

    @Override
    public Object getClientGuiElement(int id, EntityPlayer player, World world, int x, int y, int z) {
        if (id == Reference.BAG_GUI_ID) {
            return new GuiBag(player.getCurrentEquippedItem(), player);
        }
        
        return null;
    }
    
}
