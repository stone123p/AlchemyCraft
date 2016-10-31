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
			this.field_146999_f = 176;
			this.field_147000_g = 220;
			
		}

		
		@Override
		public void func_146281_b() {
			super.func_146281_b();
		}
		

		
		@Override
		protected void func_146979_b(int i, int j) {
			
			this.field_146289_q.func_78276_b(StatCollector.func_74838_a("Alchemy Table"), 100, 5, 0xFFFFFF);
			
		}
		
		@Override
		protected void func_146976_a(float var1, int var2, int var3) {
			int k = (this.field_146294_l - this.field_146999_f) / 2;
		    int l = (this.field_146295_m - this.field_147000_g) / 2;
			int t1=this.entity.getProgressScaled(30);
			
			GL11.glColor4f(1F, 1F, 1F, 1F);
			Minecraft.func_71410_x().func_110434_K().func_110577_a(texture);
			func_73729_b(field_147003_i, field_147009_r, 0, 0, field_146999_f, field_147000_g);
			
			this.func_73729_b(k + 77, l +  54,179 ,54, t1,27);//圖要放的位置,原圖位置,大小
			
			field_146297_k.func_175599_af().func_180450_b(this.entity.findMatchingRecipe(),k+83,l+60);
			
			field_146289_q.func_78279_b(this.entity.sss, k+20, l+95, 116, 0);
			
		}

}
