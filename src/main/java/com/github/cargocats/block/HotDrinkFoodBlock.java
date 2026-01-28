package com.github.cargocats.block;

import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class HotDrinkFoodBlock extends DrinkFoodBlock {
    public HotDrinkFoodBlock(Identifier foodItemId, Properties settings) {
        super(foodItemId, settings);
    }

    @Override
    public void animateTick(@NonNull BlockState state, @NonNull Level world, @NonNull BlockPos pos, @NonNull RandomSource random) {
        super.animateTick(state, world, pos, random);

        if (random.nextFloat() < 0.25f) {
            double x = (double) pos.getX() + 0.5D + (random.nextDouble() * 0.3D - 0.15D);
            double y = (double) pos.getY() + 0.6D;
            double z = (double) pos.getZ() + 0.5D + (random.nextDouble() * 0.3D - 0.15D);

            world.addParticle(ParticleTypes.WHITE_SMOKE, x, y, z, 0.0d, 0.0d, 0.0d);
        }
    }
}
