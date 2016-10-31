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

	public Potion func_76399_b(int x,int y){
		super.func_76399_b(x, y);
		return (Potion)this;
	}

	public int func_76392_e(){
		Minecraft.func_71410_x().field_71446_o.func_110577_a(icon);
		return super.func_76392_e();
	}
	public boolean func_76398_f(){
		return false;
	}
}
