package com.hzy.alchemycraft.gui;

import org.lwjgl.opengl.GL11;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.container.ContainerAlchemyTable;
import com.hzy.alchemycraft.tileentity.TileEntityAlchemyTable;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.entity.RenderItem;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class GuiAlchemyTable extends GuiContainer {
	private ResourceLocation texture = new ResourceLocation(AlchemyCraft.MODID + ":" + "textures/guis/AlchemyTable.png");
	private TileEntityAlchemyTable entity;
		public GuiAlchemyTable(InventoryPlayer inv,TileEntityAlchemyTable entity) {
			super(new ContainerAlchemyTable(inv,entity));
			this.entity=entity;
			this.xSize = 176;
			this.ySize = 220;
			
		}

		
		@Override
		public void onGuiClosed() {
			super.onGuiClosed();
		}
		

		
		@Override
		protected void drawGuiContainerForegroundLayer(int i, int j) {
			
			this.fontRendererObj.drawString(StatCollector.translateToLocal("Alchemy Table"), 100, 5, 0xFFFFFF);
			
		}
		
		@Override
		protected void drawGuiContainerBackgroundLayer(float var1, int var2, int var3) {
			int k = (this.width - this.xSize) / 2;
		    int l = (this.height - this.ySize) / 2;
			int t1=this.entity.getProgressScaled(30);
			
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Minecraft.getMinecraft().getTextureManager().bindTexture(texture);
			drawTexturedModalRect(guiLeft, guiTop, 0, 0, xSize, ySize);
			
			this.drawTexturedModalRect(k + 77, l +  54,179 ,54, t1,27);//圖要放的位置,原圖位置,大小
			
			mc.getRenderItem().renderItemAndEffectIntoGUI(this.entity.findMatchingRecipe(),k+83,l+60);
			
			fontRendererObj.drawSplitString(this.entity.sss, k+20, l+95, 116, 0);
			
		}

}
