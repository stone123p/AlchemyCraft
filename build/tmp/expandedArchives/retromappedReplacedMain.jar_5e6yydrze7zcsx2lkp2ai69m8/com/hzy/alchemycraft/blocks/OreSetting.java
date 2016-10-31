package com.hzy.alchemycraft.blocks;

import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreSetting extends Block {
	Random r;
	public OreSetting(String MineralName) {
		super(Material.field_151576_e);
		
		this.func_149663_c(MineralName);
		func_149647_a(AlchemyCraft.alchemycraftTab);
		func_149711_c(3.0F);
		//setHarvestLevel("pickaxe", new MineralData( MineralIndex).HarvestLevel());
	}
}
