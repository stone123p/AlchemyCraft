package com.hzy.alchemycraft.tileentity;

import java.util.Random;

import com.hzy.alchemycraft.handler.PlantMutandisHandler;
import com.hzy.alchemycraft.handler.SwordEnchHandler;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.items.ItemPotion;
import com.hzy.alchemycraft.recipes.AlchemyRecipes;
import com.hzy.alchemycraft.recipes.ConvertRecipes;
import com.hzy.alchemycraft.recipes.LowerConvertRecipes;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.init.Items;
import net.minecraft.inventory.IInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.util.IChatComponent;
import net.minecraft.util.ITickable;

public class TileEntityAlchemyTable  extends TileEntity implements IInventory, ITickable{
	public ItemStack[] AlchemyTableItemStack =new ItemStack[5];
	private ItemStack[][] recipes=AlchemyRecipes.AlchemyTableRecipes;
	private boolean flag =false;
	public int ProgressScaled=0;
	private int deff=0;
	private Random random;
	
	public String sss="";
	public int[] AccessibleSlotsId=new int[]{4,4,1,0,3,2};
	
	public ItemStack findMatchingRecipe(){
		if(AlchemyTableItemStack[0] != null){
			if(AlchemyTableItemStack[0].func_77973_b() instanceof ItemSword){
				return new SwordEnchHandler().getSword(AlchemyTableItemStack);
			}
			if(AlchemyTableItemStack[0].func_77973_b()==ACItems.ingotPreciousMetal){
				return LowerAlchemy(AlchemyTableItemStack);
			}
			if(AlchemyTableItemStack[0].func_77973_b()==ACItems.HigherPhilosopherStone && AlchemyTableItemStack[0].func_77952_i()<AlchemyTableItemStack[0].func_77958_k()){
				return HigherAlchemy(AlchemyTableItemStack);	
			}
			if(AlchemyTableItemStack[0].func_77973_b()==new ItemStack(Items.field_151100_aR,1,15).func_77973_b() &&AlchemyTableItemStack[0].field_77994_a==8){
				return PlantMutandis(AlchemyTableItemStack);
			}
		}
		for(int i=0;i<this.recipes.length;i++){
			ItemStack[] itemstack = this.recipes[i];
	    	if (isMatchesA(itemstack)){
	    		return itemstack[0];
	    	}
		}
		return null;
	 }
	private ItemStack PlantMutandis(ItemStack[] itemStacks){
		if(itemStacks[1] != null && itemStacks[2] != null&& itemStacks[3] != null){
			if(Block.func_149634_a(itemStacks[1].func_77973_b()) instanceof BlockBush && itemStacks[2].func_77973_b()==ACItems.ConversionOilBottle
																					&& itemStacks[3].func_77973_b()==ACItems.ConversionOilBottle){
				return new PlantMutandisHandler().getMutandis(itemStacks[1]);
			}
		}
		return null;
	}
	private ItemStack LowerAlchemy(ItemStack[] itemStacks) {
		if(itemStacks[1] != null && itemStacks[2] != null&&itemStacks[3] != null){
			if(itemStacks[2].func_77973_b().equals(ACItems.GrowthOilBottle)&&itemStacks[3].func_77973_b().equals(ACItems.GrowthOilBottle)){
				String name=new LowerConvertRecipes().getMetalName(itemStacks[1]);
				return new LowerConvertRecipes().getPreciousMetals(name);	
			}
		}
		return null;
	 }
	public ItemStack HigherAlchemy(ItemStack[] itemStacks){	
		 int up=0;
		 int down=0;
		 int c=-1;
		if(itemStacks[1] != null){ 
			c=new ConvertRecipes().getElementIndex(itemStacks[1]);
		}else{
			c=-1;
		}
		if(itemStacks[2] != null){ 
			if(itemStacks[2].func_77973_b()==new ItemStack(Items.field_151100_aR,1,0).func_77973_b()){//left
				down=itemStacks[2].field_77994_a;	
			}	
		}else{
			down=0;
		}
		if(itemStacks[3] != null){
			if(itemStacks[3].func_77973_b()==new ItemStack(Items.field_151100_aR,1,15).func_77973_b()){//right
				up=itemStacks[3].field_77994_a;
			}
		}else{
			up=0;
		}			
		if(c >= 0 && (c+up-down>=0)){
			deff=up-down;
			return new ConvertRecipes().getFinElement(c+up-down);
		}else{
			return null;
		}
	 }
	@Override
	public String func_70005_c_() {
		return "";
	}

	@Override
	public boolean func_145818_k_() {
		return false;
	}
	public Boolean isMatchesA(ItemStack[] R){
    	int haveResult=0;
    	ItemStack[] itemstack=new ItemStack[4];
    	for(int i=0;i<4;i++){
    		itemstack[i]=AlchemyTableItemStack[i];
    		if(itemstack[i] != null && R[i+1] != null){
    			if(itemstack[i].func_77973_b()==R[i+1].func_77973_b() && itemstack[i].field_77994_a==R[i+1].field_77994_a)
    				haveResult++;
    		}
    		if(itemstack[i] == null && R[i+1] == null){
    			haveResult++;
    		}
    	}
    	if(haveResult==4){
    		return true;		
    	}
		return false;
 }

	

	@Override
	public void func_73660_a() {
		if(AlchemyTableItemStack[4]==null  && findMatchingRecipe() != null){
			ProgressScaled++;
			if(ProgressScaled==200){
				ItemStack itemstack =findMatchingRecipe();
				AlchemyTableItemStack[4] = itemstack.func_77946_l();
				AlchemyDone();
			}
		 }else{
			 ProgressScaled=0;
		 }
		
	}
	
	public void AlchemyDone(){
		 for(int i=0;i<4;i++){
			 if(AlchemyTableItemStack[i] != null){
				 if((AlchemyTableItemStack[i].func_77973_b()==ACItems.HigherPhilosopherStone)){
					 ItemStack j=AlchemyTableItemStack[0];
					 AlchemyTableItemStack[0] =new ItemStack(j.func_77973_b(),1,j.func_77952_i()+deff);
					 AlchemyTableItemStack[1]=null;
					 return;
				 }else if((AlchemyTableItemStack[i].func_77973_b()==ACItems.PhilosopherStone)){
					 ItemStack j=AlchemyTableItemStack[0];
					 AlchemyTableItemStack[0] =new ItemStack(j.func_77973_b(),1,j.func_77952_i()+53);
					 if(j.func_77952_i()+deff>=j.func_77958_k())AlchemyTableItemStack[0] =null;
					 if(AlchemyTableItemStack[4] !=null)if(AlchemyTableItemStack[4].func_77973_b() ==ACItems.HigherPhilosopherStone)AlchemyTableItemStack[0] =null;
					 AlchemyTableItemStack[1]=null;
					 AlchemyTableItemStack[2]=null;
					 AlchemyTableItemStack[3]=null;
					 return;
				 }else if(AlchemyTableItemStack[i].func_77973_b() instanceof ItemPotion|| AlchemyTableItemStack[i].func_77973_b()==Items.field_151068_bn){
					 AlchemyTableItemStack[i]=new ItemStack(Items.field_151069_bo);
				 }else if(AlchemyTableItemStack[i].func_77973_b() ==Items.field_151131_as){
					 AlchemyTableItemStack[i]=new ItemStack(Items.field_151133_ar);
				 }else{
					 AlchemyTableItemStack[i]=null;
				 }	
			 }
		 }
		 ProgressScaled=0;
		 return;
	}
	
	@Override
	public IChatComponent func_145748_c_() {
		return null;
	}

	@Override
	public int func_70302_i_() {
		return AlchemyTableItemStack.length;
	}

	@Override
	public ItemStack func_70301_a(int index) {
		return AlchemyTableItemStack[index];
	}

	@Override
	public ItemStack func_70298_a(int index, int count) {
		if (this.AlchemyTableItemStack[index] != null) {
			ItemStack itemstack;
			if (this.AlchemyTableItemStack[index].field_77994_a <= count) {
				itemstack = this.AlchemyTableItemStack[index];
				this.AlchemyTableItemStack[index] = null;
				return itemstack;
			} else {
				itemstack = this.AlchemyTableItemStack[index].func_77979_a(count);

				if (this.AlchemyTableItemStack[index].field_77994_a == 0) {
					this.AlchemyTableItemStack[index] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack func_70304_b(int index) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void func_70299_a(int index, ItemStack stack) {
		this.AlchemyTableItemStack[index] = stack;

		if (stack != null && stack.field_77994_a > this.func_70297_j_()) {
			stack.field_77994_a = this.func_70297_j_();
		}
	}

	@Override
	public int func_70297_j_() {
		return 100;
	}

	@Override
	public boolean func_70300_a(EntityPlayer player) {
		return field_145850_b.func_175625_s(this.field_174879_c) != this ? false : player.func_70092_e(this.field_174879_c.func_177958_n()+0.5f, this.field_174879_c.func_177956_o()+0.5f, this.field_174879_c.func_177952_p()+0.5f) <= 64.0D;
	}

	@Override
	public void func_174889_b(EntityPlayer player) {
		
	}

	@Override
	public void func_174886_c(EntityPlayer player) {
		
	}

	@Override
	public boolean func_94041_b(int index, ItemStack stack) {
		return true;
	}

	@Override
	public int func_174887_a_(int id) {
		return 0;
	}

	@Override
	public void func_174885_b(int id, int value) {
		
	}

	@Override
	public int func_174890_g() {
		return 0;
	}

	@Override
	public void func_174888_l() {
		
	}
	public int getProgressScaled(int i) {
		return this.ProgressScaled * i / 200;
	}
}
