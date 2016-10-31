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
		ItemStack sword=itemStacks[0].func_77946_l();
		if(getEnch(itemStacks)!=null){
			if(EnchantmentHelper.func_77506_a(enchantmentWither.field_77352_x, sword)==0){sword.func_77966_a(getEnch(itemStacks), 1);}
			return  sword;
		}
		return null;
		
	}
	
	
	private Enchantment getEnch(ItemStack[] itemStacks) {
		if(itemStacks[1]!=null && itemStacks[2]!=null&&itemStacks[3]!=null){
			if(itemStacks[1].func_77973_b()== ACItems.WitherOilBottle&& itemStacks[2].func_77973_b()==ACItems.WitherOilBottle&&itemStacks[3].func_77973_b()==ACItems.WitherOilBottle)return enchantmentWither;
			if(itemStacks[1].func_77973_b()== ACItems.FrostOilBottle&& itemStacks[2].func_77973_b()==ACItems.FrostOilBottle&&itemStacks[3].func_77973_b()==ACItems.FrostOilBottle)return enchantmentFrost;
			if(itemStacks[1].func_77973_b()== ACItems.FireOilBottle&& itemStacks[2].func_77973_b()==ACItems.FireOilBottle&&itemStacks[3].func_77973_b()==ACItems.FireOilBottle)return enchantmentFire ;
			if(itemStacks[1].func_77973_b()== ACItems.CorpseOilBottle&& itemStacks[2].func_77973_b()==ACItems.PurifyPotion&&itemStacks[3].func_77973_b()==ACItems.PurifyPotion)return enchantmentZombieWrangle;
			if(itemStacks[1].func_77973_b()== ACItems.PsychePotion&& itemStacks[2].func_77973_b()==ACItems.PsychePotion&&itemStacks[3].func_77973_b()==ACItems.PsychePotion)return enchantmentPsyche;
			if(itemStacks[1].func_77973_b()== ACItems.PoisonOilBottle&& itemStacks[2].func_77973_b()==ACItems.PoisonOilBottle&&itemStacks[3].func_77973_b()==ACItems.PoisonOilBottle)return enchantmentPoison;
		}
		return null;
	}
}
