package com.hzy.alchemycraft.enetities.mobs;

import java.util.Random;
import net.minecraft.entity.EntityLiving;
import net.minecraft.entity.ai.EntityAIAttackOnCollide;
import net.minecraft.entity.ai.EntityAIHurtByTarget;
import net.minecraft.entity.ai.EntityAILookIdle;
import net.minecraft.entity.ai.EntityAIMoveThroughVillage;
import net.minecraft.entity.ai.EntityAIMoveTowardsRestriction;
import net.minecraft.entity.ai.EntityAINearestAttackableTarget;
import net.minecraft.entity.ai.EntityAISwimming;
import net.minecraft.entity.ai.EntityAIWander;
import net.minecraft.entity.ai.EntityAIWatchClosest;
import net.minecraft.entity.monster.EntityZombie;
import net.minecraft.entity.passive.EntityChicken;
import net.minecraft.entity.passive.EntityVillager;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.ItemStack;
import net.minecraft.pathfinding.PathNavigateGround;
import net.minecraft.util.BlockPos;
import net.minecraft.util.EnumParticleTypes;
import net.minecraft.util.MathHelper;
import net.minecraft.world.World;


public class EntityPsycheZombie extends EntityZombie {
	private Random random =new Random();
	public EntityPsycheZombie(World p_i1738_1_) {
		super(p_i1738_1_);
		 ((PathNavigateGround)this.func_70661_as()).func_179688_b(true);
	        this.field_70714_bg.func_75776_a(0, new EntityAISwimming(this));
	        this.field_70714_bg.func_75776_a(2, new EntityAIAttackOnCollide(this, EntityZombie.class, 1.0D, false));
	        this.field_70714_bg.func_75776_a(5, new EntityAIMoveTowardsRestriction(this, 1.0D));
	        this.field_70714_bg.func_75776_a(7, new EntityAIWander(this, 1.0D));
	        this.field_70714_bg.func_75776_a(8, new EntityAIWatchClosest(this, EntityZombie.class, 8.0F));
	        this.field_70714_bg.func_75776_a(8, new EntityAILookIdle(this));
	        this.func_175456_n();
	        this.func_70105_a(0.6F, 1.95F);
	}
	@Override
	public void func_70636_d()
    {
		if(random.nextInt(3)==1){
    		this.field_70170_p.func_175688_a(EnumParticleTypes.SPELL_WITCH, this.field_70165_t, this.field_70163_u+1.5d, this.field_70161_v, 0.0D, 0.0D, 0.0D);
    	
    	}
		
    	 if (this.field_70170_p.func_72935_r() && !this.field_70170_p.field_72995_K && !this.func_70631_g_())
         {
             float f = this.func_70013_c(1.0F);
             BlockPos blockpos = new BlockPos(this.field_70165_t, (double)Math.round(this.field_70163_u), this.field_70161_v);

             if (f > 0.5F && this.field_70146_Z.nextFloat() * 30.0F < (f - 0.4F) * 2.0F && this.field_70170_p.func_175678_i(blockpos))
             {
                 boolean flag = true;
                 ItemStack itemstack = this.func_71124_b(4);

                 if (itemstack != null)
                 {
                     if (itemstack.func_77984_f())
                     {
                         itemstack.func_77964_b(itemstack.func_77952_i() + this.field_70146_Z.nextInt(2));

                         if (itemstack.func_77952_i() >= itemstack.func_77958_k())
                         {
                             this.func_70669_a(itemstack);
                             this.func_70062_b(4, (ItemStack)null);
                         }
                     }

                     flag = false;
                 }

                 if (flag)
                 {
                     this.func_70015_d(8);
                 }
             }
         }

         if (this.func_70115_ae() && this.func_70638_az() != null && this.field_70154_o instanceof EntityChicken)
         {
             ((EntityLiving)this.field_70154_o).func_70661_as().func_75484_a(this.func_70661_as().func_75505_d(), 1.5D);
         }

         super.func_70636_d();
    }
	

}
