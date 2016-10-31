package com.hzy.alchemycraft.gui;

import org.lwjgl.opengl.GL11;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.container.ContainerDistiller;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;
import com.sun.imageio.plugins.common.I18N;

import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;

public class GuiDistiller extends GuiContainer{

	private final ResourceLocation res = new ResourceLocation(AlchemyCraft.MODID+":textures/guis/distiller.png");
	private TileEntityDistillerBlock entity;
	
	public GuiDistiller(InventoryPlayer inv,TileEntityDistillerBlock entity){
		super(new ContainerDistiller(inv,entity));
		this.entity=entity;
		this.xSize = 176; 
		this.ySize = 166;
	}

	@Override
	protected void drawGuiContainerForegroundLayer(int part1,int part2){
		String name = this.entity.hasCustomName()? this.entity.getName()  : I18n.format(this.entity.getName(), new Object[0]);
		this.fontRendererObj.drawString(name, this.xSize/2-this.fontRendererObj.getStringWidth(name)/2,6 , 4210752);
		this.fontRendererObj.drawString(I18N.getString("container.inventor"), 8,this.ySize-96+2, 4210752);
		
	
	}
 	
	@Override
	protected void drawGuiContainerBackgroundLayer(float part1, int part2, int part3) {
		GL11.glColor4f(1F, 1F, 1F, 1F);
		
		this.mc.getTextureManager().bindTexture(res);
        int k = (this.width - this.xSize) / 2;
        int l = (this.height - this.ySize) / 2;
        this.drawTexturedModalRect(k, l, 0, 0, this.xSize, this.ySize);
        int i1;

        if (this.entity.isBurning())
        {
            i1 = this.entity.getBurnTimeRemainingScaled(24);
            this.drawTexturedModalRect(k + 44,l + 41+14-i1, 178, 68-i1, 14, i1+2 );
        }

        i1 = this.entity.getCookProgressScaled(24);
        this.drawTexturedModalRect(k + 51, l + 5, 178, 5, i1*4,35);//圖要放的位置,原圖位置,大小
		

	}
}
