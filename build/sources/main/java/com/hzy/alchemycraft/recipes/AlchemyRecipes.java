package com.hzy.alchemycraft.recipes;

import com.hzy.alchemycraft.handler.LibHandler;
import com.hzy.alchemycraft.items.ACItems;

import net.minecraft.init.Blocks;
import net.minecraft.init.Items;
import net.minecraft.item.ItemStack;

public class AlchemyRecipes {
	public static ItemStack[][] AlchemyTableRecipes= new ItemStack[][]{
		{new ItemStack(Items.potato),new ItemStack(Items.poisonous_potato),new ItemStack(ACItems.PurifyPotion),null,null}, //馬鈴薯＝毒馬鈴薯＋淨化藥水
		{new ItemStack(Items.leather),new ItemStack(Items.rotten_flesh),new ItemStack(ACItems.PurifyPotion),null,null},//皮革＝腐肉＋淨化藥水
		{new ItemStack(Items.cooked_beef,8),new ItemStack(Items.beef,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟牛肉＝火焰之油＋生牛肉
		{new ItemStack(Items.cooked_chicken,8),new ItemStack(Items.chicken,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟雞肉＝火焰之油＋生雞肉
		{new ItemStack(Items.cooked_fish,8), new ItemStack(Items.fish,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟魚肉＝火焰之油＋生魚肉
		{new ItemStack(Items.cooked_porkchop,8),new ItemStack(Items.porkchop,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟豬肉＝火焰之油＋生豬肉
		{new ItemStack(Items.cooked_mutton,8),new ItemStack(Items.mutton,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟羊肉＝火焰之油＋生羊肉
		{new ItemStack(Items.cooked_rabbit,8),new ItemStack(Items.rabbit,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟兔肉＝火焰之油＋生兔肉
		{new ItemStack(Items.baked_potato,8),new ItemStack(Items.potato,8),new ItemStack(ACItems.FireOilBottle),null,null},//熟豬肉＝火焰之油＋生豬肉
		{new ItemStack(Items.skull, 1, 1),new ItemStack(Items.skull, 1, 0),new ItemStack(ACItems.WitherOilBottle),null,null},//凋零骷髏頭顱＝骷髏頭顱+凋零之油
		{new ItemStack(Items.glowstone_dust,8),new ItemStack(Items.redstone,8),new ItemStack(ACItems.ConversionOilBottle),null,null},//紅石＝螢光粉+轉換之油
		{new ItemStack(Items.redstone,8),new ItemStack(Items.glowstone_dust,8),new ItemStack(ACItems.ConversionOilBottle),null,null},//紅石＝螢光粉+轉換之油
		{new ItemStack(Items.blaze_rod),new ItemStack(Items.stick),new ItemStack(ACItems.FireOilBottle),new ItemStack(ACItems.FireOilBottle),null},//烈焰桿＝2*火焰之油＋木棒
		{new ItemStack(Items.ender_pearl),new ItemStack(Items.quartz),new ItemStack(ACItems.YinYangOilBottle),new ItemStack(ACItems.ConversionOilBottle),null},//終界珍珠＝石英＋陰陽之油＋轉換之油
		{new ItemStack(Items.slime_ball),new ItemStack(Items.potionitem,1,0),new ItemStack(Blocks.tallgrass,1,1),new ItemStack(ACItems.ConversionOilBottle),null},
		{new ItemStack(Blocks.ice),new ItemStack(Items.water_bucket),new ItemStack(ACItems.FrostOilBottle),null,null},
		{new ItemStack(Items.diamond),new ItemStack(Items.coal,64),new ItemStack(ACItems.ConversionOilBottle),null,null},//鑽石=煤炭*64+轉換之油
		{new ItemStack(Items.coal,64),new ItemStack(Items.diamond),new ItemStack(ACItems.ConversionOilBottle),null,null},
		{new ItemStack(ACItems.ingotPreciousMetal),new ItemStack(ACItems.PhilosopherStone),new ItemStack(ACItems.ingotBaseMetal),null,null},
		{new ItemStack(ACItems.PhilosopherStone),new ItemStack(Items.diamond),new ItemStack(ACItems.ConversionOilBottle),new ItemStack(ACItems.ConversionOilBottle),new ItemStack(ACItems.ConversionOilBottle)},
		{new ItemStack(ACItems.HigherPhilosopherStone),new ItemStack(ACItems.PhilosopherStone),new ItemStack(Items.nether_star),new ItemStack(Blocks.redstone_block),new ItemStack(Blocks.redstone_block)},
		{new ItemStack(Items.spawn_egg,1,93),new ItemStack(Items.egg),new ItemStack(Items.chicken),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.RegenerationPotion)},
		{new ItemStack(Items.spawn_egg,1,90),new ItemStack(Items.egg),new ItemStack(Items.porkchop),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.RegenerationPotion)},
		{new ItemStack(Items.spawn_egg,1,92),new ItemStack(Items.egg),new ItemStack(Items.beef),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.RegenerationPotion)},
		{new ItemStack(Items.spawn_egg,1,91),new ItemStack(Items.egg),new ItemStack(Items.mutton),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.RegenerationPotion)},
		{new ItemStack(Items.spawn_egg,1,101),new ItemStack(Items.egg),new ItemStack(Items.rabbit),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.RegenerationPotion)},
		{new ItemStack(Items.spawn_egg,1,120),new ItemStack(Items.egg),new ItemStack(Items.emerald),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.RegenerationPotion)},
		{new ItemStack(Items.iron_sword),new ItemStack(Items.iron_sword),new ItemStack(ACItems.WitherOilBottle),new ItemStack(ACItems.WitherOilBottle),new ItemStack(ACItems.WitherOilBottle)}, //凋零之劍
		{new ItemStack(Items.iron_sword),new ItemStack(Items.iron_sword),new ItemStack(ACItems.FrostOilBottle),new ItemStack(ACItems.FrostOilBottle),new ItemStack(ACItems.FrostOilBottle)},
		{new ItemStack(Items.iron_sword),new ItemStack(Items.iron_sword),new ItemStack(ACItems.FireOilBottle),new ItemStack(ACItems.FireOilBottle),new ItemStack(ACItems.FireOilBottle)},
		{new ItemStack(Items.iron_sword),new ItemStack( Items.iron_sword),new ItemStack(ACItems.CorpseOilBottle),new ItemStack(ACItems.PurifyPotion),new ItemStack(ACItems.PurifyPotion)},
		{new ItemStack(Items.iron_sword),new ItemStack( Items.iron_sword),new ItemStack(ACItems.PsychePotion),new ItemStack(ACItems.PsychePotion),new ItemStack(ACItems.PsychePotion)},//
		{new ItemStack(Items.iron_sword),new ItemStack( Items.iron_sword),new ItemStack(ACItems.PoisonOilBottle),new ItemStack(ACItems.PoisonOilBottle),new ItemStack(ACItems.PoisonOilBottle)},//
		{new ItemStack(Items.wheat,2),new ItemStack(Items.wheat_seeds),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.pumpkin,2),new ItemStack(Items.pumpkin_seeds),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.melon_block,2), new ItemStack(Items.melon_seeds), new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Items.potato,4),new ItemStack(Items.potato),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Items.carrot,4),new ItemStack(Items.carrot),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.cactus,5),new ItemStack(Blocks.cactus),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Items.reeds,5),new ItemStack(Items.reeds),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.log,8,0),new ItemStack(Blocks.sapling,1,0),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[0],2),new ItemStack(LibHandler.Herbs[0]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(ACItems.plantMutandis,8),new ItemStack(Items.dye,8,15),new ItemStack(Blocks.yellow_flower),new ItemStack(ACItems.ConversionOilBottle),new ItemStack(ACItems.ConversionOilBottle)},
		{new ItemStack(ACItems.ingotPreciousMetal),new ItemStack(ACItems.ingotPreciousMetal),new ItemStack(Items.gold_nugget),new ItemStack(ACItems.GrowthOilBottle),new ItemStack(ACItems.GrowthOilBottle)},
		{new ItemStack(Blocks.log,8,1),new ItemStack(Blocks.sapling,1,1),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.log,8,2),new ItemStack(Blocks.sapling,1,2),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.log,8,3),new ItemStack(Blocks.sapling,1,3),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.log,8,4),new ItemStack(Blocks.sapling,1,4),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(Blocks.log,8,5),new ItemStack(Blocks.sapling,1,5),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[1],2),new ItemStack(LibHandler.Herbs[1]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[2],2),new ItemStack(LibHandler.Herbs[2]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[3],2),new ItemStack(LibHandler.Herbs[3]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[4],2),new ItemStack(LibHandler.Herbs[4]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[5],2),new ItemStack(LibHandler.Herbs[5]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[6],2),new ItemStack(LibHandler.Herbs[6]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[7],2),new ItemStack(LibHandler.Herbs[7]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[8],2),new ItemStack(LibHandler.Herbs[8]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[9],2),new ItemStack(LibHandler.Herbs[9]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[10],2),new ItemStack(LibHandler.Herbs[10]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[11],2),new ItemStack(LibHandler.Herbs[11]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		{new ItemStack(LibHandler.Herbs[12],2),new ItemStack(LibHandler.Herbs[12]),new ItemStack(ACItems.GrowthOilBottle),null,null},
		};
		
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
		"\n凋零骷髏頭顱:\n 1.骷髏頭顱\n 2.凋零之油",
		"\n紅石 x 8:\n 1.螢光粉 x 8\n 2.轉換之油",
		"\n螢光粉 x 8:\n 1.紅石 x 8\n 2.轉換之油",
		"\n烈焰桿:\n 1.火焰之油\n 2.火焰之油\n 3.木棒",
		"\n終界珍珠：\n 1.地獄石英\n 2.陰陽之油\n 3.轉換之油",
		"\n史萊姆球：\n 1.水瓶\n 2.草\n 3.轉換之油",
		"\n冰：\n 1.水桶\n 2.冰霜之油",
		"\n鑽石:\n 1.煤炭 x 64\n 2.轉換之油",
		"\n煤炭 x 64:\n 1.鑽石\n 2.轉換之油",
		"\n貴金屬合金：\n 1.賤金屬合金\n 2.賢者之石",
		"\n賢者之石：\n 1.轉換之油\n 2.轉換之油\n 3.轉換之油\n 4.鑽石",
		"\n高階賢者之石：\n 1.賢者之石\n 2.地獄之星\n 3.紅石磚\n 4.紅石磚",
		"\n雞重生蛋：\n 1.生雞肉\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n豬重生蛋：\n 1.生豬肉\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n牛重生蛋：\n 1.生牛肉\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n羊重生蛋：\n 1.生羊肉\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n兔子重生蛋：\n 1.生兔肉\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n村民重生蛋：\n 1.綠寶石\n 2.屍油\n 3.重生藥水\n 4.雞蛋" ,
		"\n凋零之劍：\n 1.凋零之油 x 3\n 2.劍",
		"\n冰霜之劍：\n 1.冰霜之油 x 3\n 2.劍",
		"\n火焰之劍：\n 1.火焰之油 x 3\n 2.劍",
		"\n殭屍剋星：\n 1.屍油\n 2.淨化藥水\n 3.淨化藥水\n 4.劍",
		"\n迷幻之劍：\n 1.迷幻之油\n 2.迷幻之油\n 3.迷幻之油\n 4.劍",
		"\n邪毒之劍：\n 1.邪毒之油\n 2.邪毒之油\n 3.邪毒之油\n 4.劍",
		"\n小麥 x 2:\n 1.小麥種子\n 2.生長之油",
		"\n南瓜 x 2:\n 1.南瓜種子\n 2.生長之油",
		"\n西瓜 x 2:\n 1.西瓜種子\n 2.生長之油",
		"\n馬鈴薯 x 4:\n 1.馬鈴薯\n 2.生長之油",
		"\n胡蘿蔔 x 4:\n 1.作物種子\n 2.生長之油",
		"\n仙人掌 x 5:\n 1.仙人掌\n 2.生長之油",	
		"\n甘蔗 x 5:\n 1.甘蔗\n 2.生長之油",
		"\n原木 x 8：\n 1.樹苗\n 2.生長之油",
		"\n藥草 x 2:\n 1.藥草\n 2.生長之油",	
		"\n植物轉生粉 x 8：\n 1.骨粉 x 8\n 2.植物\n 3.轉換之油\n 4.轉換之油",
		"\n貴金屬合金(賦予靈氣)：\n 1.貴金屬合金 x 8\n 2.金屬粒\n 3.生長之油\n 4.生長之油",
 };
public  AlchemyRecipes(){
	
}
}
