package de.roboticbrain.randommod.inventory;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.util.StatCollector;

import org.lwjgl.opengl.GL11;

public class GuiBag extends GuiContainer {

    public GuiBag(ItemStack is, EntityPlayer player) {
        super(new ContainerBag(is, player));
    }

    private String renderTexture = "/gui/trap.png";

    @Override
    protected void drawGuiContainerForegroundLayer(int x, int y) {

        fontRenderer.drawString(StatCollector.translateToLocal("container.bag"), 8, 6, 4210752);
        fontRenderer.drawString(StatCollector.translateToLocal("container.inventory"), 44, ySize - 96 + 2, 4210752);
    }

    @Override
    protected void drawGuiContainerBackgroundLayer(float opacity, int x, int y) {

        GL11.glColor4f(1.0F, 1.0F, 1.0F, 1.0F);
        mc.renderEngine.bindTexture(renderTexture);
        this.drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
    }
    
}
