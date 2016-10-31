package com.hzy.alchemycraft.recipes;

import java.util.ArrayList;

import com.hzy.alchemycraft.handler.LibHandler;
import com.hzy.alchemycraft.handler.SwordEnchHandler;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.entity.item.EntityItem;
import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.ItemSword;
import net.minecraft.item.crafting.FurnaceRecipes;
import scala.actors.threadpool.Arrays;

public class AlchemyRecipes {
	
	public static ArrayList<ItemStack[][]> recipies=new ArrayList();
	public  AlchemyRecipes(){
		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.glowstone_dust)},{new ItemStack(Items.redstone)},{new ItemStack(ACItems.ConversionOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.glowstone_dust)},{new ItemStack(Items.redstone),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.glowstone_dust)},{new ItemStack(Items.redstone),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});

		recipies.add(new ItemStack[][]{{new ItemStack(Items.redstone)},{new ItemStack(Items.glowstone_dust)},{new ItemStack(ACItems.ConversionOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.redstone)},{new ItemStack(Items.glowstone_dust),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.redstone)},{new ItemStack(Items.glowstone_dust),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});

		recipies.add(new ItemStack[][]{{new ItemStack(Items.diamond)},{new ItemStack(Items.coal,64),new ItemStack(Items.quartz)},{new ItemStack(ACItems.ConversionOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.diamond)},{new ItemStack(Items.coal,64),new ItemStack(Items.quartz),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.diamond)},{new ItemStack(Items.coal,64),new ItemStack(Items.quartz),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});

		recipies.add(new ItemStack[][]{{new ItemStack(Items.coal,64)},{new ItemStack(Items.diamond)},{new ItemStack(ACItems.ConversionOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.coal,64)},{new ItemStack(Items.diamond),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.coal,64)},{new ItemStack(Items.diamond),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});

		recipies.add(new ItemStack[][]{{new ItemStack(Items.emerald)},{new ItemStack(Items.clay_ball,16),new ItemStack(Items.quartz)},{new ItemStack(ACItems.ConversionOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.emerald)},{new ItemStack(Items.clay_ball,16),new ItemStack(Items.quartz),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.emerald)},{new ItemStack(Items.clay_ball,16),new ItemStack(Items.quartz),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});

		recipies.add(new ItemStack[][]{{new ItemStack(Items.clay_ball,16)},{new ItemStack(Items.emerald)},{new ItemStack(ACItems.ConversionOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.clay_ball,16)},{new ItemStack(Items.emerald),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.clay_ball,16)},{new ItemStack(Items.emerald),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.ender_pearl)},{new ItemStack(Items.quartz,1)},{new ItemStack(ACItems.YinYangOilBottle,4),new ItemStack(ACItems.ConversionOilBottle,2)}});		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.ender_pearl)},{new ItemStack(Items.quartz,1),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(ACItems.YinYangOilBottle,4)}});		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.ender_pearl)},{new ItemStack(Items.quartz,1),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(ACItems.YinYangOilBottle,4)}});		
		
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.end_stone)},{new ItemStack(Blocks.cobblestone,1)},{new ItemStack(ACItems.YinYangOilBottle,4),new ItemStack(ACItems.ConversionOilBottle,2)}});		
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.end_stone)},{new ItemStack(Blocks.cobblestone,1),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(ACItems.YinYangOilBottle,4)}});		
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.end_stone)},{new ItemStack(Blocks.cobblestone,1),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(ACItems.YinYangOilBottle,4)}});		
		
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.cobblestone)},{new ItemStack(Blocks.end_stone,1)},{new ItemStack(ACItems.YinYangOilBottle,4),new ItemStack(ACItems.ConversionOilBottle,2)}});		
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.cobblestone)},{new ItemStack(Blocks.end_stone,1),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(ACItems.YinYangOilBottle,4)}});		
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.cobblestone)},{new ItemStack(Blocks.end_stone,1),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(ACItems.YinYangOilBottle,4)}});		
		
		recipies.add(new ItemStack[][]{{new ItemStack(ACItems.ingotPreciousMetal)},{new ItemStack(ACItems.ingotBaseMetal),new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(ACItems.ingotPreciousMetal)},{new ItemStack(ACItems.ingotBaseMetal),new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(Items.potionitem,4,0)}});
		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.potato)},{new ItemStack(Items.poisonous_potato)},{new ItemStack(ACItems.PurifyPotion,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.leather)},{new ItemStack(Items.rotten_flesh)},{new ItemStack(ACItems.PurifyPotion,2)}});
		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.slime_ball),new ItemStack(Items.glass_bottle,1)},{new ItemStack(Items.potionitem,1,0),new ItemStack(Blocks.tallgrass,1,1)},{new ItemStack(Items.potionitem,4,0)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.blaze_rod)},{new ItemStack(Items.stick,1)},{new ItemStack(ACItems.FireOilBottle,16)}});

		recipies.add(new ItemStack[][]{{new ItemStack(Items.skull, 1, 1)},{new ItemStack(Items.skull, 1, 0)},{new ItemStack(ACItems.WitherOilBottle,8)}});	
		recipies.add(new ItemStack[][]{{new ItemStack(ACItems.PhilosopherStone)},{new ItemStack(Items.diamond)},{new ItemStack(ACItems.ConversionOilBottle,24)}});	
		recipies.add(new ItemStack[][]{{new ItemStack(ACItems.HigherPhilosopherStone)},{new ItemStack(ACItems.PhilosopherStone),new ItemStack(Items.nether_star),new ItemStack(Blocks.redstone_block,2)},{new ItemStack(ACItems.ConversionOilBottle,24)}});	
		
		recipies.add(new ItemStack[][]{{new ItemStack(Items.bucket,1),new ItemStack(Blocks.ice,1)},{new ItemStack(Items.water_bucket)},{new ItemStack(ACItems.FrostOilBottle,2)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.wheat,2)},{new ItemStack(Items.wheat_seeds)},{new ItemStack(ACItems.GrowthOilBottle,4)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.pumpkin,2)},{new ItemStack(Items.pumpkin_seeds)},{new ItemStack(ACItems.GrowthOilBottle,4)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.melon_block,2)},{ new ItemStack(Items.melon_seeds)},{ new ItemStack(ACItems.GrowthOilBottle,4)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.potato,4)},{new ItemStack(Items.potato)},{new ItemStack(ACItems.GrowthOilBottle,4)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.carrot,4)},{new ItemStack(Items.carrot)},{new ItemStack(ACItems.GrowthOilBottle,4)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Blocks.cactus,5)},{new ItemStack(Blocks.cactus)},{new ItemStack(ACItems.GrowthOilBottle,4)}});
		recipies.add(new ItemStack[][]{{new ItemStack(Items.reeds,5)},{new ItemStack(Items.reeds)},{new ItemStack(ACItems.GrowthOilBottle,4)}});
	}
	public static ItemStack[][] newRecipes(ArrayList<EntityItem> entityItem,ArrayList<ItemStack>  Psp){
		ArrayList<Item> cp = new ArrayList();
		ItemStack[][] Recipes = new ItemStack[3][0];
		ItemStack[] inputs=new ItemStack[entityItem.size()];
		int i=0;
		for(EntityItem ET:entityItem){
			inputs[i]=ET.getEntityItem().copy();
			i++;
		}
		int[] cpSize=new int[Psp.size()];
		
		i=0;
		for(ItemStack P:Psp){
			if(P.stackSize>0){
				cp.add(P.copy().getItem());
				cpSize[i]=P.copy().stackSize;
				i++;
			}
		}
		if(inputs[0]!=null)if(inputs[0].getItem() instanceof ItemSword){
			if(new SwordEnchHandler().getSword(inputs[0],cp,cpSize)!=null){
				inputs[0].stackSize=1;
				Recipes[0]=new ItemStack[]{new SwordEnchHandler().getSword(inputs[0],cp,cpSize)};
				Recipes[1]=new ItemStack[]{inputs[0]};
				Recipes[2]=new SwordEnchHandler().getUsePotion(cp,cpSize);
				return Recipes;
			}
		}
		if(cp.indexOf(ACItems.CorpseOilBottle)!=-1&&cp.indexOf(ACItems.RegenerationPotion)!=-1)
			if(cpSize[cp.indexOf(ACItems.CorpseOilBottle)]>=8&&cpSize[cp.indexOf(ACItems.RegenerationPotion)]>=8){
			if(inputs[0].getItem()==ACItems.Soul&&inputs[0].stackSize==1&&new Resurrection().getEgg(inputs[0])!=null){
				inputs[0].stackSize=1;
				Recipes[0]=new ItemStack[]{new Resurrection().getEgg(inputs[0])};
				Recipes[1]=new ItemStack[]{inputs[0],new ItemStack(Items.egg)};
				Recipes[2]=new ItemStack[]{new ItemStack(ACItems.RegenerationPotion,8),new ItemStack(ACItems.CorpseOilBottle,8)};
				return Recipes;
			}
		}
		if(cp.indexOf(ACItems.FireOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.FireOilBottle)]>=2){
			if(FurnaceRecipes.instance().getSmeltingResult(inputs[0])!=null){
				inputs[0].stackSize=1;
				Recipes[0]=new ItemStack[]{FurnaceRecipes.instance().getSmeltingResult(inputs[0])};
				Recipes[1]=new ItemStack[]{inputs[0]};
				Recipes[2]=new ItemStack[]{new ItemStack(ACItems.FireOilBottle,2)};
				return Recipes;
			}
		}
		if(cp.indexOf(ACItems.GrowthOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.GrowthOilBottle)]>=16){
			if(inputs[0].getItem()==ACItems.ingotPreciousMetal&&inputs[1]!=null&&inputs[0].stackSize==1){
				String name=new LowerConvertRecipes().getMetalName(inputs[1]);
				inputs[0].stackSize=1;
				if(name!="XXX"){
					Recipes[0]=new ItemStack[]{new LowerConvertRecipes().getPreciousMetals(name)};
					Recipes[1]=inputs;
					Recipes[2]=new ItemStack[]{new ItemStack(ACItems.GrowthOilBottle,16)};
					return Recipes;
				}
			}
		}
		
		if(cp.indexOf(ACItems.GrowthOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.GrowthOilBottle)]>=2){
			if(Block.getBlockFromItem(inputs[0].getItem()) instanceof BlockBush){
				Recipes[0]=new ItemStack[]{new ItemStack(inputs[0].copy().getItem(),2,inputs[0].copy().getMetadata())};
				Recipes[1]=new ItemStack[]{new ItemStack(inputs[0].copy().getItem(),1,inputs[0].copy().getMetadata())};
				Recipes[2]=new ItemStack[]{new ItemStack(ACItems.GrowthOilBottle,2)};
				return Recipes;
			}
		}
		if(cp.indexOf(ACItems.ConversionOilBottle)!=-1)if(cpSize[cp.indexOf(ACItems.ConversionOilBottle)]>=16){
			if(Block.getBlockFromItem(inputs[0].getItem()) instanceof BlockBush){
				
				if(inputs[1]!=null)if(inputs[1].getItem()==Items.dye&&inputs[1].getMetadata()==15&&inputs[1].stackSize>=8){
					inputs[0].stackSize=1;
					inputs[1].stackSize=8;
					Recipes[0]=new ItemStack[]{new PlantMutandisRecipes().getMutandis(inputs[0])};
					Recipes[1]=inputs;
					Recipes[2]=new ItemStack[]{new ItemStack(ACItems.ConversionOilBottle,16)};
					return Recipes;
				}
			}
		}
		if(cp.indexOf(Items.potionitem)!=-1)if(cpSize[cp.indexOf(Items.potionitem)]>=2){
			if(inputs.length==3)if(inputs[1]!=null&&inputs[2]!=null)if(inputs[1].getItem()==ACItems.HigherPhilosopherStone&&inputs[2].getItem()==Items.dye&&(inputs[2].getMetadata()==0||inputs[2].getMetadata()==15)){
				new ConvertRecipes().SetElements();
				
				int c=new ConvertRecipes().getElementIndex(inputs[0]);
				String type=new ConvertRecipes().getElementType(inputs[0],c);
				int up=0;
				int down=0;
				if(inputs[2].getMetadata()==0)down=inputs[2].stackSize;	
				if(inputs[2].getMetadata()==15)up=inputs[2].stackSize;	
				int deff =up-down;
				
				if(c >= 0 && c+deff>0&&ConvertRecipes.element.length>(c+deff)){
					System.out.println(c+deff);
					if(new ConvertRecipes().getFinElement(c+deff,type)==null)return null;
					entityItem.get(1).getEntityItem().setItemDamage(inputs[1].getItemDamage()+deff);
					Recipes[0]=new ItemStack[]{new ConvertRecipes().getFinElement(c+deff,type)};
					Recipes[1]=new ItemStack[]{inputs[0]};
					Recipes[2]=new ItemStack[]{new ItemStack(Items.potionitem,1,0)};
					return Recipes;
				}
			}
		}
		return null;
	}
	public static ItemStack[][] AlchemyTableRecipes= new ItemStack[][]{};
		
		public static String Recipes[]={
		"\n馬鈴薯：\n 1.毒馬鈴薯\n 2.淨化藥水",
		"\n皮革：\n 1.腐肉\n 2.淨化藥水",
		"\n熟牛肉 x 8:\n 1.火焰之油\n 2.生牛肉 x 8",
		"\n熟雞肉 x 8:\n 1.火焰之油\n 2.生雞肉 x 8",
		"\n熟魚肉 x 8:\n 1.火焰之油\n 2.生魚肉 x 8",
		"\n熟豬肉 x 8:\n 1.火焰之油\n 2.生豬肉 x 8",
		"\n熟羊肉 x 8:\n 1.火焰之油\n 2.生羊肉 x 8",
		"\n熟兔肉 x 8:\n 1.火焰之油\n 2.生兔肉 x 8",
		"\n烤馬鈴薯 x 8:\n 1.火焰之油\n 2.馬鈴薯 x 8",
		"\n紅石 x 8:\n 1.螢光粉 x 8\n 2.轉換之油",
		"\n螢光粉 x 8:\n 1.紅石 x 8\n 2.轉換之油",
		"\n鑽石:\n 1.煤炭 x 64\n 2.轉換之油",
		"\n煤炭 x 64:\n 1.鑽石\n 2.轉換之油",
		"\n貴金屬合金：\n 1.賤金屬合金\n 2.賢者之石",
		"\n重生蛋：\n 1.靈魂\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n冰：\n 1.水桶\n 2.冰霜之油",//--
		"\n史萊姆球：\n 1.水瓶\n 2.草\n 3.轉換之油",
		"\n烈焰桿:\n 1.火焰之油\n 2.火焰之油\n 3.木棒",
		"\n終界珍珠：\n 1.地獄石英\n 2.陰陽之油\n 3.轉換之油",
		"\n凋零骷髏頭顱:\n 1.骷髏頭顱\n 2.凋零之油",
		"\n賢者之石：\n 1.轉換之油\n 2.轉換之油\n 3.轉換之油\n 4.鑽石",
		"\n高階賢者之石：\n 1.賢者之石\n 2.地獄之星\n 3.紅石磚\n 4.紅石磚",
		"\n凋零之劍：\n 1.凋零之油 x 3\n 2.劍",
		"\n冰霜之劍：\n 1.冰霜之油 x 3\n 2.劍",
		"\n火焰之劍：\n 1.火焰之油 x 3\n 2.劍",
		"\n殭屍剋星：\n 1.屍油\n 2.淨化藥水\n 3.淨化藥水\n 4.劍",
		"\n迷幻之劍：\n 1.迷幻之油\n 2.迷幻之油\n 3.迷幻之油\n 4.劍",
		"\n邪毒之劍：\n 1.邪毒之油\n 2.邪毒之油\n 3.邪毒之油\n 4.劍",
		"\n奪魂之劍：\n 1.奪魂之油\n 2.奪魂之油\n 3.奪魂之油\n 4.劍",
		"\n小麥 x 2:\n 1.小麥種子\n 2.生長之油",
		"\n南瓜 x 2:\n 1.南瓜種子\n 2.生長之油",
		"\n西瓜 x 2:\n 1.西瓜種子\n 2.生長之油",
		"\n馬鈴薯 x 4:\n 1.馬鈴薯\n 2.生長之油",
		"\n胡蘿蔔 x 4:\n 1.作物種子\n 2.生長之油",
		"\n仙人掌 x 5:\n 1.仙人掌\n 2.生長之油",	
		"\n甘蔗 x 5:\n 1.甘蔗\n 2.生長之油",
		"\n原木 x 8：\n 1.樹苗\n 2.生長之油",//--
		"\n藥草 x 2:\n 1.藥草\n 2.生長之油",	
		"\n植物轉生粉 x 8：\n 1.骨粉 x 8\n 2.植物\n 3.轉換之油\n 4.轉換之油",
		"\n貴金屬合金(賦予靈氣)：\n 1.貴金屬合金 x 8\n 2.金屬粒\n 3.生長之油\n 4.生長之油",
 };

}
