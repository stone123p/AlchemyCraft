package com.hzy.alchemycraft.event;

import java.util.ArrayList;
import java.util.Random;

import com.hzy.alchemycraft.enetities.mobs.PsycheMob;
import com.hzy.alchemycraft.handler.SwordEnchHandler;


import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.nbt.NBTTagList;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.event.entity.player.PlayerInteractEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;
import net.minecraftforge.oredict.OreDictionary;

public class EnchEvent {
	public int[] effectIds =new int[]{
			SwordEnchHandler.enchantmentWither.effectId,
			SwordEnchHandler.enchantmentFrost.effectId,
			SwordEnchHandler.enchantmentFire.effectId,
			SwordEnchHandler.enchantmentZombieWrangle.effectId,
			SwordEnchHandler.enchantmentPsyche.effectId,
			SwordEnchHandler.enchantmentPoison.effectId
			};

	
	@SubscribeEvent
	public void hitEndermanWithDagger(AttackEntityEvent event){
		
		int j;
		ItemStack playerHeldItem =event.entityPlayer.getHeldItem();
		
		if(playerHeldItem!=null){
			for(int i=0;i<effectIds.length;i++){
				j=EnchantmentHelper.getEnchantmentLevel(effectIds[i], playerHeldItem);
				if(j>0)addEffectToLiving((EntityLiving)event.target,event.entityPlayer,i);
			}
			
		}
	}
	public void addEffectToLiving(EntityLiving target ,EntityPlayer player, int index){
		Random random = new Random();
		switch(index){
		case 0:
			target.addPotionEffect(new PotionEffect(Potion.wither.id, 600, 7));
		break;
		case 1:
			target.addPotionEffect(new PotionEffect(Potion.moveSlowdown.id, 600, 7));
		break;
		case 2:
			target.setFire(5);
		break;
		case 3:
			if(target instanceof EntityZombie && !player.worldObj.isRemote)hitZombie(target);
		break;
		case 4:
			if(random.nextInt(3)==1&&! player.worldObj.isRemote)new PsycheMob(target);
		break;
		case 5:
			target.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 7));
		break;
		}
	}
	public void hitZombie(EntityLivingBase EntityLiving1){
		Random random = new Random();
		World world = EntityLiving1.worldObj;
		EntityVillager Villager = new EntityVillager(world);
		Villager.setLocationAndAngles(EntityLiving1.posX, EntityLiving1.posY, EntityLiving1.posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
		if(random.nextInt(3)==1){
			EntityLiving1.setDead();
			world.spawnEntityInWorld(Villager);
		}
	}
}
