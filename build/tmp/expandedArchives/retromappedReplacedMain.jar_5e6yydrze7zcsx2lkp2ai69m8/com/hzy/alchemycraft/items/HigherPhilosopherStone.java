package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class HigherPhilosopherStone extends Item {
	public HigherPhilosopherStone(){
		func_77637_a(AlchemyCraft.alchemycraftTab);
		func_77655_b("HigherPhilosopherStone");
		func_77656_e(500);
	}
	@Override
	@SideOnly(Side.CLIENT)
	public boolean func_77636_d(ItemStack p_77636_1_) {
		return true;
	}

}
