package com.hzy.alchemycraft.enetities;

import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.enetities.mobs.EntityPsycheCreeper;
import com.hzy.alchemycraft.enetities.mobs.EntityPsycheSkeleton;
import com.hzy.alchemycraft.enetities.mobs.EntityPsycheWitch;
import com.hzy.alchemycraft.enetities.mobs.EntityPsycheZombie;

import net.minecraft.entity.EntityList;
import net.minecraftforge.fml.common.registry.EntityRegistry;

public class ACEntity {
	public static void mainRegistry(){
		registerEntitys();
	}

	private static void registerEntitys() {
		createEntity(EntityPsycheZombie.class,"PsycheZombie",0x00004f,0xff00e1);
		createEntity(EntityPsycheSkeleton.class,"PsycheSkeleton",0x00005f,0xff00e2);
		createEntity(EntityPsycheCreeper.class,"PsycheCreeper",0x00005f,0xff00e2);
		createEntity(EntityPsycheWitch.class,"PsycheWitch",0x00005f,0xff00e2);
	}

	public static void createEntity(Class entityClass, String entityName,int soldColor,int spotColor){
		int randomId = EntityRegistry.findGlobalUniqueEntityId();
		EntityRegistry.registerGlobalEntityID(entityClass, entityName, randomId);
		EntityRegistry.registerModEntity(entityClass, entityName, randomId, AlchemyCraft.instance, 64, 1, true);
		createEgg(randomId,soldColor,spotColor);
	}

	private static void createEgg(int randomId, int soldColor, int spotColor) {
		EntityList.entityEggs.put(Integer.valueOf(randomId), new EntityList.EntityEggInfo(randomId, soldColor, spotColor));
		
	}
}
