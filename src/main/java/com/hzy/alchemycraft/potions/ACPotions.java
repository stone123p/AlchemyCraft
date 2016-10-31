package com.hzy.alchemycraft.potions;

import net.minecraft.potion.Potion;
import net.minecraft.util.ResourceLocation;
import net.minecraft.util.StatCollector;

public class ACPotions {
	
	public static Potion Flying=new FlyingEffect(25,new ResourceLocation("flying"),false,0).setIconIndex(0, 0)
    		.setPotionName(StatCollector.translateToLocal("effect.flying.name"));
	
	public static Potion Love=new FlyingEffect(26,new ResourceLocation("love"),false,0).setIconIndex(0, 1)
    		.setPotionName(StatCollector.translateToLocal("effect.love.name"));
	
	public ACPotions(){
		
	}
}
