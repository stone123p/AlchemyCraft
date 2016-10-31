package com.hzy.alchemycraft.handler;

import com.hzy.alchemycraft.enchantments.EnchantmentSetting;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.ItemStack;

public class SwordEnchHandler {
	public static final Enchantment enchantmentWither = new EnchantmentSetting(84,5,"enchantmentWither"); 
	public static final Enchantment enchantmentFrost = new EnchantmentSetting(85,5,"enchantmentFrost"); 
	public static final Enchantment enchantmentFire = new EnchantmentSetting(86,5,"enchantmentFire"); 
	public static final Enchantment enchantmentZombieWrangle = new EnchantmentSetting(87,5,"enchantmentZombieWrangle"); 
	public static final Enchantment enchantmentPsyche = new EnchantmentSetting(88,5,"enchantmentPsyche"); 
	public static final Enchantment enchantmentPoison = new EnchantmentSetting(89,5,"enchantmentPoison"); 
	
	public SwordEnchHandler(){
	
	}

	public ItemStack getSword(ItemStack[] itemStacks) {
		ItemStack sword=itemStacks[0].copy();
		if(getEnch(itemStacks)!=null){
			if(EnchantmentHelper.getEnchantmentLevel(enchantmentWither.effectId, sword)==0){sword.addEnchantment(getEnch(itemStacks), 1);}
			return  sword;
		}
		return null;
		
	}
	
	
	private Enchantment getEnch(ItemStack[] itemStacks) {
		if(itemStacks[1]!=null && itemStacks[2]!=null&&itemStacks[3]!=null){
			if(itemStacks[1].getItem()== ACItems.WitherOilBottle&& itemStacks[2].getItem()==ACItems.WitherOilBottle&&itemStacks[3].getItem()==ACItems.WitherOilBottle)return enchantmentWither;
			if(itemStacks[1].getItem()== ACItems.FrostOilBottle&& itemStacks[2].getItem()==ACItems.FrostOilBottle&&itemStacks[3].getItem()==ACItems.FrostOilBottle)return enchantmentFrost;
			if(itemStacks[1].getItem()== ACItems.FireOilBottle&& itemStacks[2].getItem()==ACItems.FireOilBottle&&itemStacks[3].getItem()==ACItems.FireOilBottle)return enchantmentFire ;
			if(itemStacks[1].getItem()== ACItems.CorpseOilBottle&& itemStacks[2].getItem()==ACItems.PurifyPotion&&itemStacks[3].getItem()==ACItems.PurifyPotion)return enchantmentZombieWrangle;
			if(itemStacks[1].getItem()== ACItems.PsychePotion&& itemStacks[2].getItem()==ACItems.PsychePotion&&itemStacks[3].getItem()==ACItems.PsychePotion)return enchantmentPsyche;
			if(itemStacks[1].getItem()== ACItems.PoisonOilBottle&& itemStacks[2].getItem()==ACItems.PoisonOilBottle&&itemStacks[3].getItem()==ACItems.PoisonOilBottle)return enchantmentPoison;
		}
		return null;
	}
}
