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
		this.setUnlocalizedName("Tripod");
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.isBlockContainer = true;
		this.setHardness(0.4f);
	}
	public boolean isFullCube()
    {
        return false;
    }
	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	

	@Override
	public int getRenderType() {
		return -1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityTripodBlock();
	}
	
	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		
		if(!worldIn.isRemote){
			worldIn.spawnEntityInWorld(new EntityItem(worldIn));	
		}
		worldIn.removeTileEntity(pos);
	}
	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity collidingEntity) {
		this.setBlockBounds(0.2f, 0.0f, 0.45f, 0.55f, 0.2f, 0.8f);
		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
		
	}
	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(worldIn, pos, state, rand);
		TileEntityTripodBlock tileEntity= (TileEntityTripodBlock)worldIn.getTileEntity(pos);
		float f1 = pos.getX() + 0.4F;
		float f2 = pos.getY() + 0.1F;
		float f3 = pos.getZ() + 0.6F;
		if(tileEntity.BurningTime>0)
		worldIn.spawnParticle(EnumParticleTypes.FLAME, (f1), f2, (f3), 0.0D, 0.0D, 0.0D);
	}
	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntityTripodBlock tileEntity= (TileEntityTripodBlock)worldIn.getTileEntity(pos);
		
		ItemStack HeldItem=playerIn.getHeldItem();
			if(HeldItem!=null){
				if(HeldItem.getItem()==Items.coal){
					tileEntity.BurningTime=1200;
					HeldItem.stackSize--;	
				}
				if(HeldItem.getItem()!=Items.coal&&tileEntity.CookItem==null){
					tileEntity.CookItem=HeldItem.copy();
					HeldItem.stackSize--;
					
				}
			}
			
			if(HeldItem==null&&tileEntity.CookItem!=null){
				if(!worldIn.isRemote){
					worldIn.spawnEntityInWorld(new EntityItem(worldIn, pos.getX(), pos.getY(), pos.getZ(), tileEntity.CookItem));
				}
					tileEntity.CookItem=null;
					tileEntity.food=null;
					tileEntity.ingot=null;
			}
		return true;
	}

}
