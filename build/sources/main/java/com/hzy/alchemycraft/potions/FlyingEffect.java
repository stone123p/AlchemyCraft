package com.hzy.alchemycraft.potions;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.texture.ITextureObject;
import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraftforge.fml.common.Mod.Instance;

public class FlyingEffect extends Potion{
	
	public FlyingEffect(int potionID, ResourceLocation location, boolean badEffect, int potionColor) {
		super(potionID, location, badEffect, potionColor);
		// TODO Auto-generated constructor stub
	}
	public static final ResourceLocation icon = new ResourceLocation(AlchemyCraft.MODID+":textures/guis/inventory.png");

	public Potion setIconIndex(int x,int y){
		super.setIconIndex(x, y);
		return (Potion)this;
	}

	public int getStatusIconIndex(){
		Minecraft.getMinecraft().renderEngine.bindTexture(icon);
		return super.getStatusIconIndex();
	}
	public boolean isBadEffect(){
		return false;
	}
}
