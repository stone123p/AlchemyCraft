package com.hzy.alchemycraft.event;

import com.hzy.alchemycraft.AlchemyCraft;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraftforge.event.entity.living.LivingEvent.LivingUpdateEvent;
import net.minecraftforge.fml.common.eventhandler.SubscribeEvent;

public class PotionEvent {

	@SubscribeEvent
	public void onEntityUpdate(LivingUpdateEvent e){
		if(e.entityLiving.func_82165_m(AlchemyCraft.Flying.field_76415_H)){
			if(e.entityLiving.func_70660_b(AlchemyCraft.Flying).func_76459_b()==0){
				e.entityLiving.func_82170_o(AlchemyCraft.Flying.field_76415_H);
				return ;
			}
			if(e.entityLiving instanceof EntityPlayer){
				((EntityPlayer)e.entityLiving).field_71075_bZ.field_75101_c = true;
			}else{
				if(e.entityLiving.field_70181_x<30)
				e.entityLiving.field_70181_x+=0.1f;
			}
				
		}else {
			if(e.entityLiving instanceof EntityPlayer){
				if(!((EntityPlayer)e.entityLiving).field_71075_bZ.field_75098_d){
					((EntityPlayer)e.entityLiving).field_71075_bZ.field_75101_c = false;
					((EntityPlayer)e.entityLiving).field_71075_bZ.field_75100_b = false;
					((EntityPlayer)e.entityLiving).func_71016_p();
				}
			}		
		}
	}
}
