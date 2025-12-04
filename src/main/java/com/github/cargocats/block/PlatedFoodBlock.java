package com.github.cargocats.block;

import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;

public class PlatedFoodBlock extends FoodBlock implements StackablePlate {
    public static final IntegerProperty STACKS = IntegerProperty.create("stacks", 1, 6);
    private final int maxStacks;

    public PlatedFoodBlock(ResourceLocation foodItemId, int maxStacks, Properties settings) {
        super(foodItemId, settings);
        this.registerDefaultState(this.defaultBlockState().setValue(STACKS, maxStacks));
        this.maxStacks = maxStacks;
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(1, 0, 1, 15, 6, 15);
    }

    public BlockState incrementStackState(BlockState state) {
        return incrementStackState(state, 1);
    }

    public BlockState incrementStackState(BlockState state, int count) {
        return state.setValue(STACKS, Math.clamp(state.getValue(STACKS) + count, 1, getMaxStacks()));
    }

    public BlockState decrementStackState(BlockState state) {
        return state.setValue(STACKS, Math.clamp(state.getValue(STACKS) - 1, 1, getMaxStacks()));
    }

    public int getStacks(BlockState state) {
        return state.getValue(STACKS);
    }

    @Override
    public int getMaxStacks() {
        return maxStacks;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STACKS);
    }
}
