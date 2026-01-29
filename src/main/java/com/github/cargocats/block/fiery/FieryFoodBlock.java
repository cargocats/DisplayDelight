package com.github.cargocats.block.fiery;

import com.github.cargocats.block.FoodBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.Identifier;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class FieryFoodBlock extends FoodBlock {
    public FieryFoodBlock(Identifier foodItemId, Properties settings) {
        super(foodItemId, settings);
    }

    @Override
    public void animateTick(@NonNull BlockState blockState, @NonNull Level level, @NonNull BlockPos blockPos, @NonNull RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);

        if (randomSource.nextFloat() < 0.25F) {
            double x = (double) blockPos.getX() + 0.5D + (randomSource.nextDouble() * 0.6D - 0.3D);
            double y = (double) blockPos.getY() + 0.4D;
            double z = (double) blockPos.getZ() + 0.5D + (randomSource.nextDouble() * 0.6D - 0.3D);
            level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
}
