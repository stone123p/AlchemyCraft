package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MovingObjectPosition;
import net.minecraft.world.World;

public class DistilledBottle extends Item {

	public DistilledBottle(){
		setCreativeTab(AlchemyCraft.alchemycraftTab);
		setUnlocalizedName("DistilledBottle");
		
	}
	
	@Override
	 public ItemStack onItemRightClick(ItemStack itemStack, World world, EntityPlayer player)
   {
		player.worldObj.playSoundAtEntity(player, "liquid.water", 0.5F, 4.0F);
		
		if(!world.isRemote){
			MovingObjectPosition movingobjectposition = this.getMovingObjectPositionFromPlayer(world, player, true);
			
			int i = movingobjectposition.getBlockPos().getX();
			int j = movingobjectposition.getBlockPos().getY();
			int k = movingobjectposition.getBlockPos().getZ();
			Block block = world.getBlockState(movingobjectposition.getBlockPos()).getBlock();
			if ( block==Blocks.water)
	        {
	            --itemStack.stackSize;
	            player.inventory.addItemStackToInventory(new ItemStack(ACItems.FullDistilledBottle,1));
	        }
		}
		
		
		return itemStack;
	}





	@Override
	public EnumAction getItemUseAction(ItemStack p_77661_1_)
   {
       return EnumAction.DRINK;
   }

}
