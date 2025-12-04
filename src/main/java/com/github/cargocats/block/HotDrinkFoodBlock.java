package com.github.cargocats.block;

import net.minecraft.block.BlockState;
import net.minecraft.particle.ParticleTypes;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.random.Random;
import net.minecraft.world.World;

public class HotDrinkFoodBlock extends DrinkFoodBlock {
    public HotDrinkFoodBlock(Identifier foodItemId, Settings settings) {
        super(foodItemId, settings);
    }

    @Override
    public void randomDisplayTick(BlockState state, World world, BlockPos pos, Random random) {
        super.randomDisplayTick(state, world, pos, random);

        if (random.nextFloat() < 0.25f) {
            double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.3D - 0.15D);
            double y = (double) pos.getY() + 0.6D;
            double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.3D - 0.15D);

            world.addParticle(ParticleTypes.WHITE_SMOKE, x, y, z, 0.0d, 0.0d, 0.0d);
        }
    }
}
