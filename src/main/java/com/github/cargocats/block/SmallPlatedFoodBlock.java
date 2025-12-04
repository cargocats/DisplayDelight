package com.github.cargocats.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class SmallPlatedFoodBlock extends FoodBlock {
    public SmallPlatedFoodBlock(ResourceLocation foodItemId, Properties settings) {
        super(foodItemId, settings);
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(4, 0, 4, 12, 5, 12);
    }
}