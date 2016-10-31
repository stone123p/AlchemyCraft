package com.hzy.alchemycraft.blocks;

import java.util.List;
import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.items.ItemPotion;
import com.hzy.alchemycraft.tileentity.TileEntityDiffuserBlock;

import net.minecraft.block.Block;
import net.minecraft.block.BlockContainer;
import net.minecraft.block.ITileEntityProvider;
import net.minecraft.block.material.Material;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.Entity;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.AxisAlignedBB;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;

public class Diffuser extends BlockContainer implements ITileEntityProvider {
	TileEntityDiffuserBlock TileEntity;
    private Random random = new Random();
    
	public Diffuser(Material materialIn) {
		super(materialIn);
		this.setUnlocalizedName("Diffuser");
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.setHardness(0.3f);
		this.setLightLevel(0.4f);
	
	}

	@Override
	public boolean isOpaqueCube() {
		return false;
	}
	

	@Override
	public TileEntity createNewTileEntity(World worldIn, int meta) {
		return new TileEntityDiffuserBlock();
	}

	@Override
	public void addCollisionBoxesToList(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity collidingEntity) {
		this.setBlockBounds(0.3f, 0.0f, 0.3f, 0.7f, 0.6f, 0.7f);
		super.addCollisionBoxesToList(worldIn, pos, state, mask, list, collidingEntity);
	}

	@Override
	public void randomDisplayTick(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.randomDisplayTick(worldIn, pos, state, rand);
		worldIn.spawnParticle(EnumParticleTypes.FLAME, (double)pos.getX()+ 0.5, (double)pos.getY() + 0.30000001192092896, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0);
	}

	@Override
	public boolean onBlockActivated(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		 this.TileEntity = (TileEntityDiffuserBlock)worldIn.getTileEntity(pos);
	        ItemStack HeldItem = playerIn.getHeldItem();
	        if (HeldItem != null) {
	            if (ItemPotion.getEffects((Item)HeldItem.getItem()) != null) {
	                this.TileEntity.setHeldItem(HeldItem.getItem());
	                --playerIn.getHeldItem().stackSize;
	                playerIn.inventory.addItemStackToInventory(new ItemStack(Items.glass_bottle, 1));
	            }
	            if (HeldItem.getItem() == Items.redstone) {
	                this.TileEntity.s2 = 1;
	                --playerIn.getHeldItem().stackSize;
	            }
	            if (HeldItem.getItem() == Items.glowstone_dust) {
	                this.TileEntity.s2 = 2;
	                --playerIn.getHeldItem().stackSize;
	            }
	            if (HeldItem.getItem() == Items.sugar) {
	                this.TileEntity.s2 = 0;
	                --playerIn.getHeldItem().stackSize;
	            }
	        }
	        return true;
	}

	@Override
	public boolean onBlockEventReceived(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
		if (eventParam == 0) {
			worldIn.spawnParticle(EnumParticleTypes.SPELL_WITCH, (double)pos.getX() + 0.5, (double)pos.getY() + 0.8, (double)pos.getZ() + 0.5, 0.0, 0.0, 0.0);
        }
		return true;
	}

}
