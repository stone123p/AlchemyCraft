package com.hzy.alchemycraft.event;

import java.util.ArrayList;
import java.util.Random;

import com.hzy.alchemycraft.blocks.ACBlocks;
import com.hzy.alchemycraft.enetities.mobs.PsycheMob;
import com.hzy.alchemycraft.handler.SwordEnchHandler;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.potions.ACPotions;

import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.Entity;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.EntityList;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.entity.monster.EntityPigZombie;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityCow;
import net.minecraft.entity.passive.EntityPig;
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
import net.minecraftforge.event.entity.living.LivingDeathEvent;
import net.minecraftforge.event.entity.player.AttackEntityEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class EnchEvent {
	public int targetId;
	public int[] effectIds =new int[]{
			SwordEnchHandler.enchantmentWither.effectId,
			SwordEnchHandler.enchantmentFrost.effectId,
			SwordEnchHandler.enchantmentFire.effectId,
			SwordEnchHandler.enchantmentZombieWrangle.effectId,
			SwordEnchHandler.enchantmentPsyche.effectId,
			SwordEnchHandler.enchantmentPoison.effectId,
			SwordEnchHandler.enchantmentProdigy.effectId
			};

	
	@SubscribeEvent
	public void hitEndermanWithDagger(AttackEntityEvent event){
		
		int j;
		ItemStack playerHeldItem =event.entityPlayer.getHeldItem();
		
		if(playerHeldItem!=null){
			for(int i=0;i<effectIds.length;i++){
				j=EnchantmentHelper.getEnchantmentLevel(effectIds[i], playerHeldItem);
				if(j>0){addEffectToLiving((EntityLiving)event.target,event.entityPlayer,i);}else{
					targetId=0;
				};
			}
		}else{
			targetId=0;
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
			if(!player.worldObj.isRemote)PurifyZombie(target);
		break;
		case 4:
			if(random.nextInt(3)==1&&! player.worldObj.isRemote)new PsycheMob(target);
		break;
		case 5:
			target.addPotionEffect(new PotionEffect(Potion.poison.id, 600, 7));
		break;
		case 6:
				targetId=target.getEntityId();
			
		break;
		}
	}
	@SubscribeEvent
	public void OnEntityDeath(LivingDeathEvent event){
		if(event.entityLiving.getEntityId()==targetId){
			GetSoul((EntityLiving) event.entityLiving);
		}
	}
	private void GetSoul(EntityLiving target ) {
		if(!target.worldObj.isRemote){
			ItemStack SoulItem= new ItemStack(ACItems.Soul);
			String EnName=target.toString().substring(6, target.toString().indexOf("["));
				if(SoulItem.getTagCompound()==null){
					SoulItem.setTagCompound(new NBTTagCompound());
				}
				NBTTagCompound nbt = new NBTTagCompound();
				nbt.setString("name", target.getName());
				nbt.setInteger("id",EntityList.getIDFromString(EnName));
				SoulItem.getTagCompound().setTag("soul", nbt);
				target.entityDropItem(SoulItem, 1);
		}
	}
	public void PurifyZombie(EntityLivingBase target){
		Random random = new Random();
		World world = target.worldObj;
		EntityLivingBase  PurifyLiving =null;
		
		if(target instanceof EntityZombie)PurifyLiving = new EntityVillager(world);
		if(target instanceof EntityPigZombie)PurifyLiving = new EntityPig(world);
		
		if(PurifyLiving!=null && random.nextInt(3)==1 ){
			PurifyLiving.setLocationAndAngles(target.posX, target.posY, target.posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
			target.setDead();
			world.spawnEntityInWorld(PurifyLiving);
		}
		
	}
	
	
}
