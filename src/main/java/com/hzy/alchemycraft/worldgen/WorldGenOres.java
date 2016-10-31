package com.hzy.alchemycraft.worldgen;

import java.util.Random;

import com.hzy.alchemycraft.blocks.ACBlocks;

import net.minecraft.block.Block;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.chunk.IChunkProvider;
import net.minecraft.world.gen.feature.WorldGenMinable;
import net.minecraftforge.fml.common.IWorldGenerator;

public class WorldGenOres implements IWorldGenerator{

	@Override
	public void generate(Random random, int x, int z, World w, IChunkProvider arg4, IChunkProvider arg5) {
		switch(w.provider.getDimensionId()){
		case 0:
			generateSurface(random,x*16,z*16,w);
			break;
		case 1:
			break;
		case -1:
		   break;
		}
		
	}

	private void generateSurface(Random random, int x, int z, World w) {
		addOreSpawn(ACBlocks.oreCuprite,w,random,x,z,16,16,4+random.nextInt(8),5,1 ,50);
		addOreSpawn(ACBlocks.oreGalena,w,random,x,z,16,16,4+random.nextInt(8),5,1 ,50);
		addOreSpawn(ACBlocks.oreStannite,w,random,x,z,16,16,4+random.nextInt(8),5,1 ,50);
	}

	private void addOreSpawn(Block block, World w, Random random, int blockXPos, int blockZPos, int maxX, int maxZ, int maxVeinSize, int chancesToSpawn, int minY,int maxY) {
		// TODO Auto-generated method stub
		int diffBtwnMinMax = maxY - minY;
		for(int i=0;i<chancesToSpawn;i++){
			int XPos = blockXPos  + random.nextInt(maxX);
			int YPos = minY  + random.nextInt(diffBtwnMinMax);
			int ZPos = blockZPos  + random.nextInt(minY);
			
			new WorldGenMinable(block.getDefaultState(),maxVeinSize).generate(w, random,new BlockPos(XPos,YPos,ZPos));
		}
	}


}
