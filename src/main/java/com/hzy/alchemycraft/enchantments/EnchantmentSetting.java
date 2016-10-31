package com.hzy.alchemycraft.enchantments;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnumEnchantmentType;
import net.minecraft.item.ItemStack;

public class EnchantmentSetting extends Enchantment {
	public EnchantmentSetting(int id, int rarity,String name){
		super(id, null, rarity, EnumEnchantmentType.ARMOR);
		this.setName(name);
	}
	@Override
	public int getMaxLevel() {
		return 1;
	}

	@Override
	public boolean canApplyAtEnchantingTable(ItemStack stack) {
		return false;
	}


}
