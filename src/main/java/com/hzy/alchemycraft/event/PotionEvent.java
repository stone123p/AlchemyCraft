package com.hzy.alchemycraft.event;

import java.util.Random;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.potions.ACPotions;

import ibxm.Player;
import net.minecraft.entity.EntityAgeable;
import net.minecraft.entity.passive.EntityAnimal;
import net.minecraft.entity.passive.EntityPig;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PotionEvent {
	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent e){
		if(e.entityLiving.isPotionActive(ACPotions.Flying.id)){
			if(e.entityLiving.getActivePotionEffect(ACPotions.Flying).getDuration()==0){
				e.entityLiving.removePotionEffect(ACPotions.Flying.id);
				return ;
			}
			if(e.entityLiving instanceof EntityPlayer){
				((EntityPlayer)e.entityLiving).capabilities.allowFlying = true;
			}else{
				if(e.entityLiving.motionY<30)
				e.entityLiving.motionY+=0.1f;
				
				
			}
				
		}else{
			if(e.entityLiving instanceof EntityPlayer){
				if(!((EntityPlayer)e.entityLiving).capabilities.isCreativeMode){
					((EntityPlayer)e.entityLiving).capabilities.allowFlying = false;
					((EntityPlayer)e.entityLiving).capabilities.isFlying = false;
					((EntityPlayer)e.entityLiving).sendPlayerAbilities();
				}
			}		
		}
		Random random = new Random();
		if(e.entityLiving.isPotionActive(ACPotions.Love.id)){
			
			if(e.entityLiving.getActivePotionEffect(ACPotions.Love).getDuration()==0){
				e.entityLiving.removePotionEffect(ACPotions.Love.id);
				return ;
			}
			if(random.nextInt(20)==1){
				if(e.entityLiving instanceof EntityPlayer){
					e.entityLiving.worldObj.spawnParticle(EnumParticleTypes.HEART, e.entityLiving.posX, e.entityLiving.posY+1.5f, e.entityLiving.posZ, 0, 0, 0, 0);
					e.entityLiving.addPotionEffect(new PotionEffect(Potion.blindness.getId(),1000,1));
				}else{
					if(e.entityLiving instanceof EntityAnimal){
						if(!((EntityAnimal)e.entityLiving).isChild())
						((EntityAnimal)e.entityLiving).setGrowingAge(0);
						((EntityAnimal)e.entityLiving).setInLove(null);
					}
				}
			}
		}else{
			if(e.entityLiving instanceof EntityPlayer){
				if(!((EntityPlayer)e.entityLiving).capabilities.isCreativeMode){
					((EntityPlayer)e.entityLiving).capabilities.allowFlying = false;
					((EntityPlayer)e.entityLiving).capabilities.isFlying = false;
					((EntityPlayer)e.entityLiving).sendPlayerAbilities();
				}
			}		
		}
	}
}
