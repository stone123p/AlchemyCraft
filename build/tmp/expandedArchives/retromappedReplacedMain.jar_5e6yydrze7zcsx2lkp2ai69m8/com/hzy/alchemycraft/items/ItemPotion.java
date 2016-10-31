package com.hzy.alchemycraft.items;

import java.util.*;
import com.hzy.alchemycraft.AlchemyCraft;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;

import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.projectile.EntityPotion;
import net.minecraft.init.Items;
import net.minecraft.item.EnumAction;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.potion.Potion;
import net.minecraft.potion.PotionEffect;
import net.minecraft.world.World;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class ItemPotion extends Item
{
	/**
     * Contains a map from integers to the list of potion effects that potions with that damage value confer (to prevent
     * recalculating it).
     */
    private HashMap effectCache = new HashMap();

    public ItemPotion()
    {
        this.func_77625_d(20);
        this.func_77627_a(true);
        this.func_77656_e(0);
        this.func_77637_a(AlchemyCraft.alchemycraftTab);
        
    }

    

    public static PotionEffect getEffects(Item item)
    {
    	PotionEffect potiones = null;

    	
    	if(item==  ACItems.MinorHealingPotion)potiones=new PotionEffect(Potion.field_76432_h.func_76396_c(),1,0);
    	if(item==  ACItems.ElixirofMinorFortitude)potiones=new PotionEffect(Potion.field_76444_x.func_76396_c(),5000,0);
    	if(item==  ACItems.ElixirofMinorAgility)potiones=new PotionEffect(Potion.field_76424_c.func_76396_c(),5000,0);  
    	if(item==  ACItems.ElixirofMinorDefense)potiones=new PotionEffect(Potion.field_76429_m.func_76396_c(),5000,0);
    	if(item==  ACItems.ElixirofMinorStrength)potiones=new PotionEffect(Potion.field_76420_g.func_76396_c(),5000,0);
    	if(item==  ACItems.ElixirofMinorInvisibility)potiones=new PotionEffect(Potion.field_76441_p.func_76396_c(),5000,0);
    	if(item==  ACItems.ElixirofMinorWaterBreathing)potiones=new PotionEffect(Potion.field_76427_o.func_76396_c(),5000,0);
    	if(item==  ACItems.ElixirofMinorNightVision)potiones=new PotionEffect(Potion.field_76439_r.func_76396_c(),5000,0);
    	
    	if(item==  ACItems.HealingPotion)potiones=new PotionEffect(Potion.field_76432_h.func_76396_c(),1,2);
    	if(item==  ACItems.FortitudePotion)potiones=new PotionEffect(Potion.field_76444_x.func_76396_c(),10000,2);
    	if(item==  ACItems.AgilityPotion)potiones=new PotionEffect(Potion.field_76424_c.func_76396_c(),10000,2);
    	if(item==  ACItems.DefensePotion)potiones=new PotionEffect(Potion.field_76429_m.func_76396_c(),10000,2);
    	if(item==  ACItems.StrengthPotion)potiones=new PotionEffect(Potion.field_76420_g.func_76396_c(),10000,2);
    	if(item==  ACItems.InvisibilityPotion)potiones=new PotionEffect(Potion.field_76441_p.func_76396_c(),10000,2);
    	if(item==  ACItems.WaterBreathingPotion)potiones=new PotionEffect(Potion.field_76427_o.func_76396_c(),10000,2);
    	if(item==  ACItems.NightVisionPotion)potiones=new PotionEffect(Potion.field_76439_r.func_76396_c(),10000,2);
    	if(item==  ACItems.FireResistancePotion)potiones=new PotionEffect(Potion.field_76426_n.func_76396_c(),10000,2);
    	if(item==  ACItems.PurifyPotion)potiones=new PotionEffect(Potion.field_76432_h.func_76396_c(),1,0);
    	if(item==  ACItems.PsychePotion)potiones=new PotionEffect(Potion.field_76431_k .func_76396_c(),10000,2);
    	if(item==  ACItems.RegenerationPotion)potiones=new PotionEffect(Potion.field_76428_l.func_76396_c(),10000,2);
    	if(item==  ACItems.FlyingPotion)potiones=new PotionEffect(AlchemyCraft.Flying.field_76415_H,10000,0);
    	
    	if(item==  ACItems.FishOilBottle)potiones=new PotionEffect(Potion.field_76439_r.func_76396_c(),200,0);
    	if(item==  ACItems.CorpseOilBottle)potiones=new PotionEffect(Potion.field_76440_q.func_76396_c(),0,0);
    	if(item==  ACItems.WitherOilBottle)potiones=new PotionEffect(Potion.field_82731_v.func_76396_c(),160,7);
    	if(item==  ACItems.YinYangOilBottle)potiones=new PotionEffect(Potion.field_76431_k .func_76396_c(),200,0);
    	if(item==  ACItems.FireOilBottle)potiones=new PotionEffect(Potion.field_76440_q.func_76396_c(),0,0);
    	if(item==  ACItems.GrowthOilBottle)potiones=new PotionEffect(Potion.field_76440_q.func_76396_c(),0,0);
    	if(item==  ACItems.ConversionOilBottle)potiones=new PotionEffect(Potion.field_76440_q.func_76396_c(),0,0);
    	if(item==  ACItems.FrostOilBottle)potiones=new PotionEffect(Potion.field_76421_d.func_76396_c(),160,7);
    	if(item==  ACItems.PoisonOilBottle)potiones=new PotionEffect(Potion.field_76436_u.func_76396_c(),160,7);
    	if(item==  ACItems.ProdigyOilBottle)potiones=new PotionEffect(Potion.field_76436_u.func_76396_c(),0,0);
    	
    	return potiones;
        
    }

    @Override
	public ItemStack func_77654_b(ItemStack itemstack, World world, EntityPlayer player)
    {
    	// player.addPotionEffect(new PotionEffect(Main.Flying.id,200,0));
        if (!player.field_71075_bZ.field_75098_d)
        {
            --itemstack.field_77994_a;
        }

        if (!world.field_72995_K)
        {
        	 PotionEffect potioneffect = ItemPotion.getEffects(itemstack.func_77973_b());

            if (potioneffect != null)
            {
              if(itemstack.func_77973_b()==ACItems.FireOilBottle){
            	  player.func_70015_d(7);
              }else if(itemstack.func_77973_b()==ACItems.PurifyPotion){
            	  for(int i = 0; i <30; i++)player.func_82170_o(i);
              }else if(itemstack.func_77973_b()==ACItems.ProdigyOilBottle){
            	  player.func_70106_y();
              }else{
            	  player.func_70690_d(new PotionEffect(potioneffect));
               }
            }
        }

        if (!player.field_71075_bZ.field_75098_d)
        {
            if (itemstack.field_77994_a <= 0)
            {
                return new ItemStack(Items.field_151069_bo);
            }

            player.field_71071_by.func_70441_a(new ItemStack(Items.field_151069_bo));
        }

        return itemstack;
    }

    private void removePotionEffect(EntityPlayer player) {
    	
    
	}



	/**
     * How long it takes to use or consume an item
     */
    @Override
	public int func_77626_a(ItemStack p_77626_1_)
    {
        return 32;
    }

    /**
     * returns the action that specifies what animation to play when the items is being used
     */
    @Override
	public EnumAction func_77661_b(ItemStack p_77661_1_)
    {
        return EnumAction.DRINK;
    }

    /**
     * Called whenever this item is equipped and the right mouse button is pressed. Args: itemStack, world, entityPlayer
     */
    @Override
	public ItemStack func_77659_a(ItemStack p_77659_1_, World p_77659_2_, EntityPlayer p_77659_3_)
    {
    	
        if (isSplash(p_77659_1_.func_77952_i()))
        {
            if (!p_77659_3_.field_71075_bZ.field_75098_d)
            {
                --p_77659_1_.field_77994_a;
            }

            
            p_77659_2_.func_72956_a(p_77659_3_, "random.bow", 0.5F, 0.4F / (field_77697_d.nextFloat() * 0.4F + 0.8F));

            if (!p_77659_2_.field_72995_K)
            {
                p_77659_2_.func_72838_d(new EntityPotion(p_77659_2_, p_77659_3_, p_77659_1_));
            }

            return p_77659_1_;
        }
        else
        {
            p_77659_3_.func_71008_a(p_77659_1_, this.func_77626_a(p_77659_1_));
            return p_77659_1_;
        }
    }


    /**
     * returns wether or not a potion is a throwable splash potion based on damage value
     */
    public static boolean isSplash(int p_77831_0_)
    {
        return (p_77831_0_ & 16384) != 0;
    }


    
 

    @Override
	@SideOnly(Side.CLIENT)
    public boolean func_77636_d(ItemStack p_77636_1_)
    {
        return false;
    }

    



   
  
}