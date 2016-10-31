package com.hzy.alchemycraft.worldgen;

import java.util.Random;
import net.minecraft.block.Block;
import net.minecraft.block.BlockBush;
import net.minecraft.block.BlockFlower;
import net.minecraft.block.state.IBlockState;
import net.minecraft.util.BlockPos;
import net.minecraft.world.World;
import net.minecraft.world.gen.feature.WorldGenerator;

public class WorldGenBushs extends WorldGenerator
{
    private BlockBush flower;
    private IBlockState field_175915_b;

    public WorldGenBushs(BlockBush p_i45632_1)
    {
        this.setGeneratedBlock(p_i45632_1);
    }

    public void setGeneratedBlock(BlockBush p_175914_1_)
    {
        this.flower = p_175914_1_;
        this.field_175915_b = p_175914_1_.getDefaultState();
    }

    public boolean generate(World worldIn, Random rand, BlockPos position)
    {
        for (int i = 0; i < 16; ++i)
        {
            BlockPos blockpos = position.add(rand.nextInt(8) , rand.nextInt(4) , rand.nextInt(8));

            if (worldIn.isAirBlock(blockpos) && (!worldIn.provider.getHasNoSky() || blockpos.getY() < 255) && this.flower.canBlockStay(worldIn, blockpos, this.field_175915_b))
            {
                worldIn.setBlockState(blockpos,this.field_175915_b, 2);
            }
        }

        return true;
    }

	
}
