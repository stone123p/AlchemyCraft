package com.hzy.alchemycraft.blocks;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.world.IBlockAccess;
import net.minecraftforge.common.EnumPlantType;

public class Herbs extends BlockBush {
	public Herbs(String name){
		func_149663_c(name);
		func_149647_a(AlchemyCraft.alchemycraftTab);
		func_149711_c(0.0F);
	    func_149672_a(field_149779_h);
	    
	    
	    
	    float f = 0.4F;
		func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
	protected boolean func_149854_a(Block block){
		return block == Blocks.field_150354_m || block == Blocks.field_150405_ch || block == Blocks.field_150406_ce || block == Blocks.field_150346_d;
	}
	
}
