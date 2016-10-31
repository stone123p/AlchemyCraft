package com.hzy.alchemycraft.items;

import java.util.List;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.handler.PlantMutandisHandler;

import net.minecraft.block.Block;
import net.minecraft.block.state.BlockState;
import net.minecraft.block.state.IBlockState;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.util.BlockPos;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class PlantMutandis extends Item {
	public PlantMutandis() {
		this.func_77637_a(AlchemyCraft.alchemycraftTab);
		this.func_77655_b("PlantMutandis");
	}

	@Override
	public ItemStack func_77659_a(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(!worldIn.field_72995_K){
			MovingObjectPosition movingobjectposition = this.func_77621_a(worldIn, playerIn, true);
			BlockPos pos =movingobjectposition.func_178782_a();	
			Block block = playerIn.field_70170_p.func_180495_p(pos).func_177230_c();
			if(new PlantMutandisHandler().isPlant(block)&&itemStackIn.func_77978_p() !=null){
	    		if(itemStackIn.func_77978_p().func_74764_b("mutandisBush")){
	    			NBTTagCompound nbt = (NBTTagCompound) itemStackIn.func_77978_p().func_74781_a("mutandisBush");
	    			--itemStackIn.field_77994_a;	
	    			
	    			Item BushItem =Item.func_150899_d(nbt.func_74762_e("BushId"));
	    			Block BushBlock = Block.func_149634_a(BushItem);
	    			playerIn.field_70170_p.func_72956_a(playerIn, "random.fizz",1F, 4.0F);
	    			playerIn.field_70170_p.func_175656_a(pos, BushBlock.func_176203_a(nbt.func_74762_e("BushMetadata")));
	    			
	    		}
			}
		}
		return itemStackIn;
	}

	@Override
	public void func_77624_a(ItemStack itemStack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.func_77624_a(itemStack, playerIn, tooltip, advanced);
		if(itemStack.func_77978_p() !=null){
			if(itemStack.func_77978_p().func_74764_b("mutandisBush")){
				NBTTagCompound nbt = (NBTTagCompound) itemStack.func_77978_p().func_74781_a("mutandisBush");
				tooltip.add(nbt.func_74779_i("BushName"));
			}
		}
	}

}
