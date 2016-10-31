package com.hzy.alchemycraft.handler;

import java.util.ArrayList;

import com.hzy.alchemycraft.enchantments.EnchantmentSetting;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import scala.actors.threadpool.Arrays;

public class SwordEnchHandler {
	public static final Enchantment enchantmentWither = new EnchantmentSetting(84,5,"enchantmentWither"); 
	public static final Enchantment enchantmentFrost = new EnchantmentSetting(85,5,"enchantmentFrost"); 
	public static final Enchantment enchantmentFire = new EnchantmentSetting(86,5,"enchantmentFire"); 
	public static final Enchantment enchantmentZombieWrangle = new EnchantmentSetting(87,5,"enchantmentZombieWrangle"); 
	public static final Enchantment enchantmentPsyche = new EnchantmentSetting(88,5,"enchantmentPsyche"); 
	public static final Enchantment enchantmentPoison = new EnchantmentSetting(89,5,"enchantmentPoison"); 
	public static final Enchantment enchantmentProdigy = new EnchantmentSetting(90,5,"enchantmentProdigy");
	
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
			if(itemStacks[1].getItem()== ACItems.ProdigyOilBottle&& itemStacks[2].getItem()==ACItems.ProdigyOilBottle&&itemStacks[3].getItem()==ACItems.ProdigyOilBottle)return enchantmentProdigy;
		}
		return null;
	}

	public ItemStack getSword(ItemStack sword, ArrayList<Item> cp, int[] cpSize) {
		if(getEnch(cp, cpSize)!=null){
			ItemStack S=sword.copy();
			S.addEnchantment(getEnch(cp, cpSize), 1);
			return S;
		}
		return sword;
	}

	private Enchantment getEnch(ArrayList<Item> cp, int[] cpSize) {
		int index;
		if(cp.indexOf(ACItems.WitherOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.WitherOilBottle)]==24){return enchantmentWither;}
		if(cp.indexOf(ACItems.FrostOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.FrostOilBottle)]==24){return enchantmentFrost;}
		if(cp.indexOf(ACItems.FireOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.FireOilBottle)]==24){return enchantmentFire;}
		if(cp.indexOf(ACItems.PurifyPotion)!=-1&&cp.indexOf(ACItems.CorpseOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.PurifyPotion)]==8 &&cpSize[cp.indexOf(ACItems.CorpseOilBottle)]==8){return enchantmentZombieWrangle;}
		if(cp.indexOf(ACItems.PsychePotion)!=-1)if(cpSize[cp.indexOf(ACItems.PsychePotion)]==24){return enchantmentPsyche;}
		if(cp.indexOf(ACItems.PoisonOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.PoisonOilBottle)]==24){return enchantmentPoison;}
		if(cp.indexOf(ACItems.ProdigyOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.ProdigyOilBottle)]==24){return enchantmentProdigy;}
		return null;
	}


	public ItemStack[] getUsePotion( ArrayList<Item> cp,int[] cpSize) {
		ItemStack[] P=cp.indexOf(ACItems.PurifyPotion)!=-1?new ItemStack[]{new ItemStack(ACItems.PurifyPotion,8),new ItemStack(ACItems.CorpseOilBottle,8)}:new ItemStack[]{new ItemStack(cp.get(0),24)};
		System.out.println(Arrays.toString(P));
		return P;
	}

}
