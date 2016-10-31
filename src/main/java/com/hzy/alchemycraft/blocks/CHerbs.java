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
		setUnlocalizedName(name);
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setHardness(0.0F);
		this.setLightLevel(1);
	    setStepSound(soundTypeGrass);
	    
	    
	    float f = 0.4F;
		setBlockBounds(0.5F - f, 0.0F, 0.5F - f, 0.5F + f, f * 2.0F, 0.5F + f);
	}
	
	@Override
	protected boolean canPlaceBlockOn(Block block){
		return block == Blocks.sand || block == Blocks.hardened_clay || block == Blocks.stained_hardened_clay || block == Blocks.dirt;
	}
	

	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(worldIn, pos, state, rand);
		
		float f1 = pos.getX() + 0.5F;
		float f2 = pos.getY() + 0.7F;
		float f3 = pos.getZ() + 0.5F;
		worldIn.spawnParticle(EnumParticleTypes.FLAME, (f1), f2, (f3), 0.0D, 0.0D, 0.0D);
	}



}
