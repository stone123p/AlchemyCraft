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
		this.setCreativeTab(AlchemyCraft.alchemycraftTab);
		this.setUnlocalizedName("PlantMutandis");
	}

	@Override
	public ItemStack onItemRightClick(ItemStack itemStackIn, World worldIn, EntityPlayer playerIn) {
		if(!worldIn.isRemote){
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(worldIn, playerIn, true);
			BlockPos pos =movingobjectposition.getBlockPos();	
			Block block = playerIn.worldObj.getBlockState(pos).getBlock();
			if(new PlantMutandisHandler().isPlant(block)&&itemStackIn.getTagCompound() !=null){
	    		if(itemStackIn.getTagCompound().hasKey("mutandisBush")){
	    			NBTTagCompound nbt = (NBTTagCompound) itemStackIn.getTagCompound().getTag("mutandisBush");
	    			--itemStackIn.stackSize;	
	    			
	    			Item BushItem =Item.getItemById(nbt.getInteger("BushId"));
	    			Block BushBlock = Block.getBlockFromItem(BushItem);
	    			playerIn.worldObj.playSoundAtEntity(playerIn, "random.fizz",1F, 4.0F);
	    			playerIn.worldObj.setBlockState(pos, BushBlock.getStateFromMeta(nbt.getInteger("BushMetadata")));
	    			
	    		}
			}
		}
		return itemStackIn;
	}

	@Override
	public void addInformation(ItemStack itemStack, EntityPlayer playerIn, List<String> tooltip, boolean advanced) {
		super.addInformation(itemStack, playerIn, tooltip, advanced);
		if(itemStack.getTagCompound() !=null){
			if(itemStack.getTagCompound().hasKey("mutandisBush")){
				NBTTagCompound nbt = (NBTTagCompound) itemStack.getTagCompound().getTag("mutandisBush");
				tooltip.add(nbt.getString("BushName"));
			}
		}
	}

}
