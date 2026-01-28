package com.github.cargocats.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class DrinkFoodBlock extends FoodBlock {
    public DrinkFoodBlock(Identifier foodItemId, Properties settings) {
        super(foodItemId, settings);
    }

    @Override
    protected @NotNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter world, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return box(4, 0, 4, 12, 10, 12);
    }
}
