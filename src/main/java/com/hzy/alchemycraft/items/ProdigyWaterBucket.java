package com.hzy.alchemycraft.items;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.block.Block;
import net.minecraft.init.Items;
import net.minecraft.item.ItemBucket;

public class ProdigyWaterBucket extends ItemBucket{

	public ProdigyWaterBucket(Block containedBlock) {
		super(containedBlock);
		this.setUnlocalizedName("ProdigyWaterBucket");
		this.setMaxStackSize(1);
		this.setContainerItem(Items.bucket);
		this.setCreativeTab(AlchemyCraft.alchemycraftTab );
	}

}
