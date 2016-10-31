package com.hzy.alchemycraft.blocks;

import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.block.material.Material;

public class OreSetting extends Block {
	Random r;
	public OreSetting(String MineralName) {
		super(Material.rock);
		
		this.setUnlocalizedName(MineralName);
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setHardness(3.0F);
		//setHarvestLevel("pickaxe", new MineralData( MineralIndex).HarvestLevel());
	}
}
