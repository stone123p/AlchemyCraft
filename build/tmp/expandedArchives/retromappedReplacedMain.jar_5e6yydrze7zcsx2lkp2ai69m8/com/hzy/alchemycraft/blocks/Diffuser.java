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
		this.func_149663_c("Diffuser");
		this.func_149647_a(AlchemyCraft.alchemycraftTab);
		this.func_149711_c(0.3f);
		this.func_149715_a(0.4f);
	
	}

	@Override
	public boolean func_149662_c() {
		return false;
	}
	

	@Override
	public TileEntity func_149915_a(World worldIn, int meta) {
		return new TileEntityDiffuserBlock();
	}

	@Override
	public void func_180638_a(World worldIn, BlockPos pos, IBlockState state, AxisAlignedBB mask,
			List<AxisAlignedBB> list, Entity collidingEntity) {
		this.func_149676_a(0.3f, 0.0f, 0.3f, 0.7f, 0.6f, 0.7f);
		super.func_180638_a(worldIn, pos, state, mask, list, collidingEntity);
	}

	@Override
	public void func_180655_c(World worldIn, BlockPos pos, IBlockState state, Random rand) {
		super.func_180655_c(worldIn, pos, state, rand);
		worldIn.func_175688_a(EnumParticleTypes.FLAME, (double)pos.func_177958_n()+ 0.5, (double)pos.func_177956_o() + 0.30000001192092896, (double)pos.func_177952_p() + 0.5, 0.0, 0.0, 0.0);
	}

	@Override
	public boolean func_180639_a(World worldIn, BlockPos pos, IBlockState state, EntityPlayer playerIn,
			EnumFacing side, float hitX, float hitY, float hitZ) {
		 this.TileEntity = (TileEntityDiffuserBlock)worldIn.func_175625_s(pos);
	        ItemStack HeldItem = playerIn.func_70694_bm();
	        if (HeldItem != null) {
	            if (ItemPotion.getEffects((Item)HeldItem.func_77973_b()) != null) {
	                this.TileEntity.setHeldItem(HeldItem.func_77973_b());
	                --playerIn.func_70694_bm().field_77994_a;
	                playerIn.field_71071_by.func_70441_a(new ItemStack(Items.field_151069_bo, 1));
	            }
	            if (HeldItem.func_77973_b() == Items.field_151137_ax) {
	                this.TileEntity.s2 = 1;
	                --playerIn.func_70694_bm().field_77994_a;
	            }
	            if (HeldItem.func_77973_b() == Items.field_151114_aO) {
	                this.TileEntity.s2 = 2;
	                --playerIn.func_70694_bm().field_77994_a;
	            }
	            if (HeldItem.func_77973_b() == Items.field_151102_aT) {
	                this.TileEntity.s2 = 0;
	                --playerIn.func_70694_bm().field_77994_a;
	            }
	        }
	        return true;
	}

	@Override
	public boolean func_180648_a(World worldIn, BlockPos pos, IBlockState state, int eventID, int eventParam) {
		if (eventParam == 0) {
			worldIn.func_175688_a(EnumParticleTypes.SPELL_WITCH, (double)pos.func_177958_n() + 0.5, (double)pos.func_177956_o() + 0.8, (double)pos.func_177952_p() + 0.5, 0.0, 0.0, 0.0);
        }
		return true;
	}

}
