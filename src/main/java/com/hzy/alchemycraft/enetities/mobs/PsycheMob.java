package com.hzy.alchemycraft.enetities.mobs;

import net.minecraft.entity.EntityLivingBase;
import net.minecraft.entity.monster.EntityCreeper;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;

public class PsycheMob {
	private EntityLivingBase EntityLiving;
	public PsycheMob(EntityLivingBase entityLiving1){
		this.EntityLiving=entityLiving1;
		
		World world = entityLiving1.worldObj;
		if(entityLiving1 instanceof EntityZombie && !(entityLiving1 instanceof EntityPsycheZombie)){
			entityLiving1.setDead();
			EntityPsycheZombie PsycheMonster = new EntityPsycheZombie(world);
			PsycheMonster.setLocationAndAngles(entityLiving1.posX, entityLiving1.posY, entityLiving1.posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
			world.spawnEntityInWorld(PsycheMonster);
		}
		if(entityLiving1 instanceof EntitySkeleton && !(entityLiving1 instanceof EntityPsycheSkeleton)){
			entityLiving1.setDead();
			EntityPsycheSkeleton PsycheMonster = new EntityPsycheSkeleton(world);
			PsycheMonster.setCurrentItemOrArmor(0, new ItemStack(Items.bow));
			PsycheMonster.setLocationAndAngles(entityLiving1.posX, entityLiving1.posY, entityLiving1.posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
			world.spawnEntityInWorld(PsycheMonster);
		}
		if(entityLiving1 instanceof EntityCreeper && !(entityLiving1 instanceof EntityPsycheCreeper)){
			entityLiving1.setDead();
			EntityPsycheCreeper PsycheMonster = new EntityPsycheCreeper(world);
			PsycheMonster.setLocationAndAngles(entityLiving1.posX, entityLiving1.posY, entityLiving1.posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
			world.spawnEntityInWorld(PsycheMonster);
		}
		if(entityLiving1 instanceof EntityWitch && !(entityLiving1 instanceof EntityPsycheWitch)){
			entityLiving1.setDead();
			EntityPsycheWitch PsycheMonster = new EntityPsycheWitch(world);
			PsycheMonster.setLocationAndAngles(entityLiving1.posX, entityLiving1.posY, entityLiving1.posZ, MathHelper.wrapAngleTo180_float(world.rand.nextFloat() * 360.0F), 0.0F);
			world.spawnEntityInWorld(PsycheMonster);
		}
		
	}
}
