package com.hzy.alchemycraft.blocks;

import java.util.List;
import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.tileentity.TileEntityTripodBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class Tripod extends BlockContainer implements ITileEntityProvider {

	public Tripod(Material materialIn) {
		super(materialIn);
		this.func_149663_c("Tripod");
		this.func_149647_a(AlchemyCraft.alchemycraftTab);
		this.field_149758_A = true;
		this.func_149711_c(0.4f);
	}
	@Override
	public boolean func_149662_c() {
		return false;
	}
	

	@Override
	public int func_149645_b() {
		return -1;
	}
	
	@Override
	public TileEntity func_149915_a(World worldIn, int meta) {
		return new TileEntityTripodBlock();
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
	public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity collidingEntity) {
		this.func_149676_a(0.2f, 0.0f, 0.45f, 0.55f, 0.2f, 0.8f);
		super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
	}
	@Override
	public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.func_180655_c(worldIn, pos, state, rand);
		TileEntityTripodBlock tileEntity= (TileEntityTripodBlock)worldIn.func_175625_s(pos);
		float f1 = pos.func_177958_n() + 0.4F;
		float f2 = pos.func_177956_o() + 0.1F;
		float f3 = pos.func_177952_p() + 0.6F;
		if(tileEntity.BurningTime>0)
		worldIn.func_175688_a(EnumParticleTypes.FLAME, (f1), f2, (f3), 0.0D, 0.0D, 0.0D);
	}
	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityTripodBlock tileEntity= (TileEntityTripodBlock)worldIn.func_175625_s(pos);
		
		ItemStack HeldItem=playerIn.func_70694_bm();
			if(HeldItem!=null){
				if(HeldItem.func_77973_b()==Items.field_151044_h){
					tileEntity.BurningTime=1200;
					HeldItem.field_77994_a--;	
				}
				if(HeldItem.func_77973_b()!=Items.field_151044_h&&tileEntity.CookItem==null){
					tileEntity.CookItem=HeldItem.func_77946_l();
					HeldItem.field_77994_a--;
					
				}
			}
			
			if(HeldItem==null&&tileEntity.CookItem!=null){
				if(!worldIn.field_72995_K){
					worldIn.func_72838_d(new EntityItem(worldIn, pos.func_177958_n(), pos.func_177956_o(), pos.func_177952_p(), tileEntity.CookItem));
				}
					tileEntity.CookItem=null;
					tileEntity.food=null;
					tileEntity.ingot=null;
			}
		return true;
	}

}
