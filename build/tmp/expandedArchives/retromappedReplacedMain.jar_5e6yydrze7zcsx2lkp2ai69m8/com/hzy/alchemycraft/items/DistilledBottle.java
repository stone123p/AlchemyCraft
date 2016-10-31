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
		func_77637_a(AlchemyCraft.alchemycraftTab);
		func_77655_b("DistilledBottle");
		
	}
	
	@Override
	 public ItemStack func_77659_a(ItemStack itemStack, World world, EntityPlayer player)
   {
		player.field_70170_p.func_72956_a(player, "liquid.water", 0.5F, 4.0F);
		
		if(!world.field_72995_K){
			MovingObjectPosition movingobjectposition = this.func_77621_a(world, player, true);
			
			int i = movingobjectposition.func_178782_a().func_177958_n();
			int j = movingobjectposition.func_178782_a().func_177956_o();
			int k = movingobjectposition.func_178782_a().func_177952_p();
			Block block = world.func_180495_p(movingobjectposition.func_178782_a()).func_177230_c();
			if ( block==Blocks.field_150355_j)
	        {
	            --itemStack.field_77994_a;
	            player.field_71071_by.func_70441_a(new ItemStack(ACItems.FullDistilledBottle,1));
	        }
		}
		
		
		return itemStack;
	}





	@Override
	public EnumAction func_77661_b(ItemStack p_77661_1_)
   {
       return EnumAction.DRINK;
   }

}
