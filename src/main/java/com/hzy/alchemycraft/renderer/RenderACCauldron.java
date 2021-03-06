package com.hzy.alchemycraft.renderer;

import org.lwjgl.opengl.GL11;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.model.ModelCauldron;
import com.hzy.alchemycraft.model.ModelDiffuser;
import com.hzy.alchemycraft.model.ModelDistiller;
import com.hzy.alchemycraft.tileentity.TileEntityACCauldron;
import com.hzy.alchemycraft.tileentity.TileEntityDiffuserBlock;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.texture.TextureAtlasSprite;
import net.minecraft.client.renderer.texture.TextureMap;
import net.minecraft.client.renderer.tileentity.TileEntitySpecialRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.client.model.b3d.B3DModel;

public class RenderACCauldron extends TileEntitySpecialRenderer<TileEntityACCauldron>{
	private static final ResourceLocation texture = new ResourceLocation(AlchemyCraft.MODID+":"+"textures/models/Cauldron.png");
	private static final ResourceLocation texture2 = new ResourceLocation(AlchemyCraft.MODID+":"+"textures/models/water.png");
	private ModelCauldron model;
	public RenderACCauldron(){
		this.model = new ModelCauldron();
	}
	@Override
	public void renderTileEntityAt(TileEntityACCauldron te, double x, double y, double z, float partialTicks,
			int destroyStage) {
		GL11.glPushMatrix();
		GL11.glTranslatef((float) x + 0.5F, (float) y + 1.5F, (float) z + 0.5F);
		GL11.glRotatef(180, 0F, 0F, 1F);
		this.bindTexture(texture);
		GL11.glPushMatrix();
			this.model.renderModel(0.0625F);
		GL11.glPopMatrix();
		GL11.glPopMatrix();
		
		float s = 1F / 256F * 14F;
		float v = 1F / 8F;
		float w = -v * 3.5F;

		this.bindTexture(texture2);
		GlStateManager.pushMatrix();
		GlStateManager.enableBlend();
		GlStateManager.blendFunc(GL11.GL_SRC_ALPHA, GL11.GL_ONE_MINUS_SRC_ALPHA);
		GlStateManager.disableAlpha();
		GlStateManager.color(1F, 1F, 1F, 0.9f);
		GlStateManager.translate((float) x + 0.0625F, (float) y + 0.15F/8*te.WaterLevel, (float) z + 0.0625F);
		GlStateManager.rotate(90F, 1F, 0F, 0F);
		GlStateManager.scale(s, s, s);


			DrawWater(0, 0, 16, 16, 240);

		GlStateManager.enableAlpha();
		GlStateManager.disableBlend();
		GlStateManager.popMatrix();
	} 
	public void DrawWater(int par1, int par2, int par4, int par5, int brightness){;
		TextureAtlasSprite sprite = Minecraft.getMinecraft().getTextureMapBlocks().getAtlasSprite(texture2.toString());
		
		Tessellator tessellator = Tessellator.getInstance();
		tessellator.getWorldRenderer().begin(GL11.GL_QUADS, DefaultVertexFormats.POSITION_TEX);
		tessellator.getWorldRenderer().pos(par1 + 0, par2 + par5, 0).tex(sprite.getMinU(), sprite.getMaxV()).endVertex();
		tessellator.getWorldRenderer().pos(par1 + par4, par2 + par5, 0).tex(sprite.getMaxU(), sprite.getMaxV()).endVertex();
		tessellator.getWorldRenderer().pos(par1 + par4, par2 + 0, 0).tex(sprite.getMaxU(), sprite.getMinV()).endVertex();
		tessellator.getWorldRenderer().pos(par1 + 0, par2 + 0, 0).tex(sprite.getMinU(), sprite.getMinV()).endVertex();
		tessellator.draw();
	}

}
