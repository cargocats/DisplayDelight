package com.github.cargocats.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class HotDrinkFoodBlock extends DrinkFoodBlock {
    public HotDrinkFoodBlock(ResourceLocation foodItemId, Properties settings) {
        super(foodItemId, settings);
    }

    @Override
    public void animateTick(BlockState state, Level world, BlockPos pos, RandomSource random) {
        super.animateTick(state, world, pos, random);

        if (random.nextFloat() < 0.25f) {
            double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.3D - 0.15D);
            double y = (double) pos.getY() + 0.6D;
            double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.3D - 0.15D);

            world.addParticle(ParticleTypes.SMOKE, x, y, z, 0.0d, 0.0d, 0.0d);
        }
    }
}
