package com.hzy.alchemycraft.blocks;

import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.init.Blocks;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class CHerbs  extends BlockBush {
	public CHerbs(String name){
		func_149663_c(name);
		func_149647_a(AlchemyCraft.alchemycraftTab);
		func_149711_c(0.0F);
		this.func_149715_a(1);
	    func_149672_a(field_149779_h);
	    
	    
	    float f = 0.4F;
		func_149676_a(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
	protected boolean func_149854_a(Block block){
		return block == Blocks.field_150354_m || block == Blocks.field_150405_ch || block == Blocks.field_150406_ce || block == Blocks.field_150346_d;
	}
	

	@Override
	@SideOnly(Side.CLIENT)
	public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.func_180655_c(worldIn, pos, state, rand);
		
		float f1 = pos.func_177958_n() + 0.5F;
		float f2 = pos.func_177956_o() + 0.7F;
		float f3 = pos.func_177952_p() + 0.5F;
		worldIn.func_175688_a(EnumParticleTypes.FLAME, (f1), f2, (f3), 0.0D, 0.0D, 0.0D);
	}



}
