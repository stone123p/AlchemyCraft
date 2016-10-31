package com.hzy.alchemycraft.enetities.mobs;

import java.util.Random;

import net.minecraft.entity.ai.EntityAIArrowAttack;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntitySkeleton;
import net.minecraft.entity.monster.EntityWitch ;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.world.World;
import net.minecraft.entity.monster.EntityWitch;
public class EntityPsycheWitch extends EntityWitch{
	private Random random =new Random();
	 public EntityPsycheWitch(World p_i1744_1_)
	    {
	        super(p_i1744_1_);
	        this.field_70714_bg.field_75782_a.clear();
		    this.field_70715_bh.field_75782_a.clear();
	        this.field_70714_bg.func_75776_a(1, new EntityAISwimming(this));
	        this.field_70714_bg.func_75776_a(2, new EntityAIArrowAttack(this, 1.0D, 60, 10.0F));
	        this.field_70714_bg.func_75776_a(2, new EntityAIWander(this, 1.0D));
	        this.field_70714_bg.func_75776_a(3, new EntityAIWatchClosest(this, EntityWitch.class, 8.0F));
	        this.field_70714_bg.func_75776_a(3, new EntityAILookIdle(this));
	        this.field_70715_bh.func_75776_a(1, new EntityAIHurtByTarget(this, false));
	        this.field_70715_bh.func_75776_a(2, new EntityAINearestAttackableTarget(this, EntityWitch.class, true));
	    }

	@Override
	public void func_70071_h_() {
		super.func_70071_h_();
		if(random.nextInt(3)==1){
    		this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t, this.field_70163_u+1.5d, this.field_70161_v, 0.0D, 0.0D, 0.0D);
    	
    	}
		
	}
	 
	 
}
