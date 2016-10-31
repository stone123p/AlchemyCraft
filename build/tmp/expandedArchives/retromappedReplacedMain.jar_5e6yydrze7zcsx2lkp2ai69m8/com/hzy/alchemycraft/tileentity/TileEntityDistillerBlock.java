package com.hzy.alchemycraft.tileentity;

import com.hzy.alchemycraft.blocks.Distiller;
import com.hzy.alchemycraft.items.ACItems;
import com.hzy.alchemycraft.recipes.DistillerRecipes;

import net.minecraft.block.Block;
import net.minecraft.util.ITickable;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.inventory.Container;
import net.minecraft.inventory.IInventory;
import net.minecraft.inventory.ISidedInventory;
import net.minecraft.item.Item;
import net.minecraft.item.ItemBlock;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.NBTTagCompound;
import net.minecraft.tileentity.TileEntity;
import net.minecraft.tileentity.TileEntityFurnace;
import net.minecraft.util.EnumFacing;
import net.minecraft.util.IChatComponent;
import net.minecraftforge.fml.common.registry.GameRegistry;
import net.minecraftforge.fml.relauncher.Side;
import net.minecraftforge.fml.relauncher.SideOnly;

public class TileEntityDistillerBlock  extends TileEntity implements IInventory, ITickable{

	public ItemStack[] furnaceItemStacks = new ItemStack[4];

	public int furnaceBurnTime=0;
	public int currentBurnTime=0;
	public int furnaceCookTime=0;

	private String furnaceName;

	
	
	@Override
	public int func_70302_i_() {
		return this.furnaceItemStacks.length;
	}

	@Override
	public ItemStack func_70301_a(int index) {
		return this.furnaceItemStacks[index];
	}

	@Override
	public ItemStack func_70298_a(int index, int count) {
		if (this.furnaceItemStacks[index] != null) {
			ItemStack itemstack;
			if (this.furnaceItemStacks[index].field_77994_a <= count) {
				itemstack = this.furnaceItemStacks[index];
				this.furnaceItemStacks[index] = null;
				return itemstack;
			} else {
				itemstack = this.furnaceItemStacks[index].func_77979_a(count);

				if (this.furnaceItemStacks[index].field_77994_a == 0) {
					this.furnaceItemStacks[index] = null;
				}
				return itemstack;
			}
		} else {
			return null;
		}
	}

	@Override
	public ItemStack func_70304_b(int index) {
		return  this.furnaceItemStacks[index];
	}

	@Override
	public void func_70299_a(int index, ItemStack stack) {
		this.furnaceItemStacks[index] = stack;

		if (stack != null && stack.field_77994_a > this.func_70297_j_()) {
			stack.field_77994_a = this.func_70297_j_();
		}
		
	}

	@Override
	public int func_70297_j_() {
		return 64;
	}

	@Override
	public boolean func_70300_a(EntityPlayer player) {
		return this.field_145850_b.func_175625_s(this.field_174879_c) != this ? false : player.func_70092_e(this.field_174879_c.func_177958_n() + 0.5D, this.field_174879_c.func_177956_o() + 0.5D, this.field_174879_c.func_177952_p() + 0.5D) <= 64.0D;
	}

	
	@SideOnly(Side.CLIENT)
	public int getCookProgressScaled(int par1) {
		return this.furnaceCookTime * par1 / 200;
	}

	@SideOnly(Side.CLIENT)
	public int getBurnTimeRemainingScaled(int par1) {
		if (this.currentBurnTime == 0) {
			this.currentBurnTime = 200;
		}

		return this.furnaceBurnTime * par1 / this.currentBurnTime;
	}

	public boolean isBurning() {
		return this.furnaceBurnTime > 0;
	}

	
	@SideOnly(Side.CLIENT)
	public static boolean func_174903_a(IInventory parIInventory){
		return true;
	}

	@Override
	public void func_73660_a() {
	
		boolean flag = this.furnaceBurnTime > 0;
		boolean flag1 = false;
		if (this.furnaceBurnTime > 0 ) {
			--this.furnaceBurnTime;
		}
		

		if (!this.field_145850_b.field_72995_K) {
			if (this.furnaceBurnTime == 0 && this.canSmelt()) {
				this.currentBurnTime = this.furnaceBurnTime = getItemBurnTime(this.furnaceItemStacks[1]);

				if (this.furnaceBurnTime > 0) {
					flag1 = true;
					if (this.furnaceItemStacks[1] != null) {

						--this.furnaceItemStacks[1].field_77994_a;

						if (this.furnaceItemStacks[1].field_77994_a == 0) {
							this.furnaceItemStacks[1] = furnaceItemStacks[1].func_77973_b().getContainerItem(this.furnaceItemStacks[1]);
						}
					}
				}
			}

			if (this.canSmelt() && isBurning()) {
				++this.furnaceCookTime;
				if (this.furnaceCookTime == 150) {
					this.furnaceCookTime = 0;
					this.smeltItem();
					flag1 = true;
				}
			} else {
				this.furnaceCookTime = 0;
			}
		}

		if (flag != this.furnaceBurnTime > 0) {
			flag1 = true;
			//Distiller.updateBlockState(this.furnaceBurnTime > 0, this.worldObj,this.pos.getX(), this.pos.getY(), this.pos.getZ());
		}

		if (flag1) {
			this.func_70296_d();
		}
	}

	


	private boolean canSmelt() {
		if (this.furnaceItemStacks[0] == null || this.furnaceItemStacks[3]== null) {
			return false;
		} else {
			ItemStack itemstack = DistillerRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0],0);

			if(this.furnaceItemStacks[3].func_77973_b() != Items.field_151069_bo)return false;
			if (itemstack == null) return false;
			if (this.furnaceItemStacks[2] == null) return  true;
			if (!this.furnaceItemStacks[2].func_77969_a(itemstack)) return false;
			int result = furnaceItemStacks[2].field_77994_a + itemstack.field_77994_a;
			return ( result <= func_70297_j_() && result <= this.furnaceItemStacks[2].func_77976_d());

		}
	}

	public void smeltItem() {
		if (this.canSmelt()) {
			//主產品
			ItemStack itemstack = DistillerRecipes.smelting().getSmeltingResult(this.furnaceItemStacks[0],0);

			ItemStack j=furnaceItemStacks[0];
			if (this.furnaceItemStacks[2] == null) {
				this.furnaceItemStacks[2] = itemstack.func_77946_l();
			} else if (this.furnaceItemStacks[2].func_77973_b() == itemstack.func_77973_b()) {
				this.furnaceItemStacks[2].field_77994_a += itemstack.field_77994_a;
			}

			this.furnaceItemStacks[3].field_77994_a--;
			if(this.furnaceItemStacks[3].field_77994_a == 0){
				this.furnaceItemStacks[3]=null;
			}
			furnaceItemStacks[0]=new ItemStack(j.func_77973_b(),1,j.func_77952_i()+ (isOil(furnaceItemStacks[0])?3:1));
			if(furnaceItemStacks[0].func_77952_i()>=furnaceItemStacks[0].func_77958_k()){
				--this.furnaceItemStacks[0].field_77994_a;
				this.furnaceItemStacks[0]=new ItemStack(ACItems.DistilledBottle);
				if(this.furnaceItemStacks[0].field_77994_a == 0){
					this.furnaceItemStacks[0] = null;
				}
			}
		}
	}
	
	private boolean isOil(ItemStack itemStack) {
		for(int i=40;i<66;i=i+2){
			if(DistillerRecipes.RecipesList[i].func_77973_b()==itemStack.func_77973_b())return true;
		}
		return false;
	}

	public static int getItemBurnTime(ItemStack itemstack){
		if(itemstack == null){
			return 0;
		}else{
			Item item = itemstack.func_77973_b();
			if(item == Items.field_151044_h){
				return 1000;
			}
			if(item instanceof ItemBlock && Block.func_149634_a(item) != Blocks.field_150350_a){
				Block block = Block.func_149634_a(item);				
			}
			
			return GameRegistry.getFuelValue(itemstack);
		}
	}

	public static boolean isItemFuel(ItemStack itemstack){
		return getItemBurnTime(itemstack) > 0;
	}
	@Override
	public void func_174889_b(EntityPlayer player) {
		
	}

	@Override
	public void func_174886_c(EntityPlayer player) {
		
	}

	@Override
	public boolean func_94041_b(int index, ItemStack stack) {
		return false;
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

	@Override
	public String func_70005_c_() {
		return "";
	}

	@Override
	public boolean func_145818_k_() {
		return false;
	}

	@Override
	public IChatComponent func_145748_c_() {
		return null;
	}

	

	
		

	


	


}
