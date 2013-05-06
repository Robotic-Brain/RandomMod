package de.roboticbrain.randommod.inventory;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.Slot;
import net.minecraft.item.ItemStack;
import net.minecraft.world.World;


public class ContainerBag extends Container {
    
    private final int BAG_START_X = 8, BAG_START_Y = 18;

    private final int PLAYER_INV_SHARED_OFFSET_X = 12, PLAYER_INV_SHARED_OFFSET_Y = 86;

    private int startX = BAG_START_X, startY = BAG_START_Y;
    private int sharedOffsetX = 0, sharedOffsetY = 0;
    
    private int rows = 4, cols = 13;
    
    private BagInventory inv = null;
    private IInventory playerInv = null;
    private World theWorld;
    
    public ContainerBag(ItemStack is, EntityPlayer player) {
        playerInv = player.inventory;
        theWorld = player.worldObj;
        inv = new BagInventory(is);
        
        addInventory(inv, startX, startY + sharedOffsetY);
        addPlayerInventory(player.inventory, startY + sharedOffsetY + PLAYER_INV_SHARED_OFFSET_Y);
    }
    
    private void addInventory(IInventory in, int x, int y) {
        for(int r = 0; r < rows; r++)
            for(int c = 0; c < cols; c++)
                addSlotToContainer(new Slot(in, c + r * cols, x + c * 18, y + r * 18));
    }

    private void addPlayerInventory( InventoryPlayer ip, int ystart ) {
        // Add the player's action bar slots to the container
        for (int actionBarSlotIndex = 0; actionBarSlotIndex < 9; ++actionBarSlotIndex) {
            this.addSlotToContainer(new Slot(ip, actionBarSlotIndex, 44 + sharedOffsetX + actionBarSlotIndex * 18, 58 + ystart));
        }

        // Add the player's inventory slots to the container
        for (int inventoryRowIndex = 0; inventoryRowIndex < 3; ++inventoryRowIndex) {
            for (int inventoryColumnIndex = 0; inventoryColumnIndex < 9; ++inventoryColumnIndex) {
                this.addSlotToContainer(new Slot(ip, inventoryColumnIndex + inventoryRowIndex * 9 + 9, sharedOffsetX + 44 + inventoryColumnIndex * 18, ystart + inventoryRowIndex * 18));
            }
        }
    }

    @Override
    public ItemStack transferStackInSlot(EntityPlayer entityPlayer, int slotIndex) {

        ItemStack newItemStack = null;
        ItemStack stack = null;
        Slot slot = (Slot) inventorySlots.get(slotIndex);
        if(slot == null || !slot.getHasStack()) return null;
            stack = slot.getStack();
            newItemStack = stack.copy();

        if(slot.inventory instanceof BagInventory) {
                int start = getSlotFromInventory(playerInv, 0).slotNumber;
                if(!mergeItemStack(stack, start, start + playerInv.getSizeInventory() - 4, true)) {
                    return null;
                }
        } else { //player Inv
            int end = getSlotFromInventory(inv, 0).slotNumber + inv.getSizeInventory();
            if(!mergeItemStack(stack, 0, end, false))
                return null;
        }

        if(stack.stackSize <= 0) {
            slot.putStack(null);
        } else
            slot.onSlotChanged();

        return newItemStack;
    }
    
    @Override
    public ItemStack slotClick(int slotId, int buttonPressed, int flag, EntityPlayer player) {
        // TODO Auto-generated method stub
        return super.slotClick(slotId, buttonPressed, flag, player);
    }
    
    @Override
    public boolean canInteractWith(EntityPlayer entityplayer) {
        return true;
    }
    
    @Override
    public void onCraftGuiClosed(EntityPlayer player) {

        super.onCraftGuiClosed(player);

        inv.writeBagContents(player.getCurrentEquippedItem());
    }
    
}
