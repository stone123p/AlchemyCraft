package com.hzy.alchemycraft.blocks;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class Herbs extends BlockBush {
	public Herbs(String name){
		setUnlocalizedName(name);
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setHardness(0.0F);
	    setStepSound(soundTypeGrass);
	    
	    
	    
	    float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block){
		return block == Blocks.sand || block == Blocks.hardened_clay || block == Blocks.stained_hardened_clay || block == Blocks.dirt;
	}
	
}
