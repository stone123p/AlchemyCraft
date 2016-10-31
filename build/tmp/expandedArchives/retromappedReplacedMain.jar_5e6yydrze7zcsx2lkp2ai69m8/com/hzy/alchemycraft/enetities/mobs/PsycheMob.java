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
		
		World world = entityLiving1.field_70170_p;
		if(entityLiving1 instanceof EntityZombie && !(entityLiving1 instanceof EntityPsycheZombie)){
			entityLiving1.func_70106_y();
			EntityPsycheZombie PsycheMonster = new EntityPsycheZombie(world);
			PsycheMonster.func_70012_b(entityLiving1.field_70165_t, entityLiving1.field_70163_u, entityLiving1.field_70161_v, MathHelper.func_76142_g(world.field_73012_v.nextFloat() * 360.0F), 0.0F);
			world.func_72838_d(PsycheMonster);
		}
		if(entityLiving1 instanceof EntitySkeleton && !(entityLiving1 instanceof EntityPsycheSkeleton)){
			entityLiving1.func_70106_y();
			EntityPsycheSkeleton PsycheMonster = new EntityPsycheSkeleton(world);
			PsycheMonster.func_70062_b(0, new ItemStack(Items.field_151031_f));
			PsycheMonster.func_70012_b(entityLiving1.field_70165_t, entityLiving1.field_70163_u, entityLiving1.field_70161_v, MathHelper.func_76142_g(world.field_73012_v.nextFloat() * 360.0F), 0.0F);
			world.func_72838_d(PsycheMonster);
		}
		if(entityLiving1 instanceof EntityCreeper && !(entityLiving1 instanceof EntityPsycheCreeper)){
			entityLiving1.func_70106_y();
			EntityPsycheCreeper PsycheMonster = new EntityPsycheCreeper(world);
			PsycheMonster.func_70012_b(entityLiving1.field_70165_t, entityLiving1.field_70163_u, entityLiving1.field_70161_v, MathHelper.func_76142_g(world.field_73012_v.nextFloat() * 360.0F), 0.0F);
			world.func_72838_d(PsycheMonster);
		}
		if(entityLiving1 instanceof EntityWitch && !(entityLiving1 instanceof EntityPsycheWitch)){
			entityLiving1.func_70106_y();
			EntityPsycheWitch PsycheMonster = new EntityPsycheWitch(world);
			PsycheMonster.func_70012_b(entityLiving1.field_70165_t, entityLiving1.field_70163_u, entityLiving1.field_70161_v, MathHelper.func_76142_g(world.field_73012_v.nextFloat() * 360.0F), 0.0F);
			world.func_72838_d(PsycheMonster);
		}
		
	}
}
