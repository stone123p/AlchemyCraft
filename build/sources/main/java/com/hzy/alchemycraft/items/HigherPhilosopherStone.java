package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HigherPhilosopherStone extends Item {
	public HigherPhilosopherStone(){
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setUnlocalizedName("HigherPhilosopherStone");
		setMaxDamage(500);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean hasEffect(ItemStack p_77636_1_) {
		return true;
	}

}
