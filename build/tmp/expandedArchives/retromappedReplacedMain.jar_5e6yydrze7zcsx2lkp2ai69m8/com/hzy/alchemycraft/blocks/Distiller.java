package com.hzy.alchemycraft.blocks;

import java.awt.List;
import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.tileentity.TileEntityDistillerBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.IBlockAccess;
import net.minecraft.world.World;
import net.minecraftforge.fml.common.network.internal.FMLNetworkHandler;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class Distiller  extends BlockContainer implements ITileEntityProvider {


	public Distiller(Material materialIn) {
		super(materialIn);
		this.func_149663_c("Distiller");
		this.func_149647_a(AlchemyCraft.alchemycraftTab);
		this.field_149758_A = true;
		this.func_149711_c(0.4f);
		
	}
	


	@Override
	public void func_180645_a(World worldIn, BlockPos pos, IBlockState state, Random random) {
		super.func_180645_a(worldIn, pos, state, random);
	}

	@Override
	public boolean func_149662_c() {
		return false;
	}

	@Override
	public int func_149645_b() {
	    return  -1;
	}
	
	@Override
	public TileEntity func_149915_a(World world, int id) {
		return new TileEntityDistillerBlock();
	}
	
	

	@Override
	public void func_180663_b(World worldIn, BlockPos pos, IBlockState state) {
		super.func_180663_b(worldIn, pos, state);
		worldIn.func_175713_t(pos);
		if(!worldIn.field_72995_K){
			worldIn.func_72838_d(new EntityItem(worldIn));	
		}
		
	}

	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity entity=worldIn.func_175625_s(pos);
		
		if(worldIn.field_72995_K){
			return true;
		}else if(entity !=null){
			FMLNetworkHandler.openGui(playerIn, AlchemyCraft.instance, AlchemyCraft.Distiller_GUIID, worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p());
		}
		return true;
		
	}


	
	@Override
	@SideOnly(Side.CLIENT)
	public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.func_180655_c(worldIn, pos, state, rand);
		TileEntityDistillerBlock tileentity = (TileEntityDistillerBlock)worldIn.func_175625_s(pos);
		float f1 = pos.func_177958_n() + 0.4F;
		float f2 = pos.func_177956_o() + 0.1F;
		float f3 = pos.func_177952_p() + 0.6F;
		if(tileentity.isBurning())
			worldIn.func_175688_a(EnumParticleTypes.FLAME, (f1), f2, (f3), 0.0D, 0.0D, 0.0D);
	}



	@Override
	public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			java.util.List<AxisAlignedBB> list, Entity collidingEntity) {
		this.func_149676_a(0.2f, 0.0f, 0.45f, 0.55f, 0.5f, 0.8f);
		super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
	}


}
