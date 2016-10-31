package com.hzy.alchemycraft.event;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PotionEvent {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent e){
		if(e.entityLiving.isPotionActive(AlchemyCraft.Flying.id)){
			if(e.entityLiving.getActivePotionEffect(AlchemyCraft.Flying).getDuration()==0){
				e.entityLiving.removePotionEffect(AlchemyCraft.Flying.id);
				return ;
			}
			if(e.entityLiving instanceof EntityPlayer){
				((EntityPlayer)e.entityLiving).capabilities.allowFlying = true;
			}else{
				if(e.entityLiving.motionY<30)
				e.entityLiving.motionY+=0.1f;
			}
				
		}else {
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