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
		this.setUnlocalizedName("Distiller");
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.isBlockContainer = true;
		this.setHardness(0.4f);
		
	}
	


	@Override
	public void randomTick(World worldIn, BlockPos pos, IBlockState state, Random random) {
		super.randomTick(worldIn, pos, state, random);
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}

	@Override
	public int getRenderType() {
	    return  -1;
	}
	
	@Override
	public TileEntity createNewTileEntity(World world, int id) {
		return new TileEntityDistillerBlock();
	}
	
	

	@Override
	public void breakBlock(World worldIn, BlockPos pos, IBlockState state) {
		super.breakBlock(worldIn, pos, state);
		worldIn.removeTileEntity(pos);
		if(!worldIn.isRemote){
			worldIn.spawnEntityInWorld(new EntityItem(worldIn));	
		}
		
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		TileEntity entity=worldIn.getTileEntity(pos);
		
		if(worldIn.isRemote){
			return true;
		}else if(entity !=null){
			FMLNetworkHandler.openGui(playerIn, AlchemyCraft.instance, AlchemyCraft.Distiller_GUIID, worldIn, pos.getX(), pos.getY(), pos.getZ());
		}
		return true;
		
	}


	
	@Override
	@SideOnly(Side.CLIENT)
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(worldIn, pos, state, rand);
		TileEntityDistillerBlock tileentity = (TileEntityDistillerBlock)worldIn.getTileEntity(pos);
		float f1 = pos.getX() + 0.4F;
		float f2 = pos.getY() + 0.1F;
		float f3 = pos.getZ() + 0.6F;
		if(tileentity.isBurning())
			worldIn.spawnParticle(EnumParticleTypes.FLAME, (f1), f2, (f3), 0.0D, 0.0D, 0.0D);
	}



	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			java.util.List<AxisAlignedBB> list, Entity collidingEntity) {
		this.setBlockBounds(0.2f, 0.0f, 0.45f, 0.55f, 0.5f, 0.8f);
		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
	}


}
