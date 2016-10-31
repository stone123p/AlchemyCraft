package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.item.Item;

public class IngotSetting extends Item {
	public IngotSetting(String itemName) {
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.setUnlocalizedName(itemName);
	}
}
