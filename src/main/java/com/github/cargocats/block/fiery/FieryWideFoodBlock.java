package com.github.cargocats.block.fiery;

import com.github.cargocats.block.WideFoodBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.particles.ParticleTypes;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.RandomSource;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;

public class FieryWideFoodBlock extends WideFoodBlock {
    public FieryWideFoodBlock(ResourceLocation foodItemId, Properties settings) {
        super(foodItemId, settings);
    }

    @Override
    public void animateTick(BlockState blockState, Level level, BlockPos blockPos, RandomSource randomSource) {
        super.animateTick(blockState, level, blockPos, randomSource);

        if (randomSource.nextFloat() < 0.3F) {
            double x = (double) blockPos.getX() + 0.5D + (randomSource.nextDouble() * 0.7D - 0.35D);
            double y = (double) blockPos.getY() + 0.45D;
            double z = (double) blockPos.getZ() + 0.5D + (randomSource.nextDouble() * 0.7D - 0.35D);

            level.addParticle(ParticleTypes.FLAME, x, y, z, 0.0D, 0.0D, 0.0D);
        }
    }
}
