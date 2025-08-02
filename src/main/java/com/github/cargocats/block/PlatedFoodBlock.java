package com.github.cargocats.block;

import com.github.cargocats.util.BlockAssociations;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.state.StateManager;
import net.minecraft.state.property.IntProperty;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class PlatedFoodBlock extends FoodBlock implements StackablePlate {
    public static final IntProperty STACKS = IntProperty.of("stacks", 1, 6);
    private final int maxStacks;

    public PlatedFoodBlock(Settings settings, int maxStacks) {
        super(settings);
        this.setDefaultState(this.getDefaultState().with(STACKS, maxStacks));
        this.maxStacks = maxStacks;
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createCuboidShape(1, 0, 1, 15, 6, 15);
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(BlockAssociations.PLATE_BLOCK_ITEM_MAP.getOrDefault(state.getBlock(), Items.AIR));
    }

    public BlockState incrementStackState(BlockState state) {
        return state.with(STACKS, Math.clamp(state.get(STACKS) + 1, 1, getMaxStacks()));
    }

    public BlockState decrementStackState(BlockState state) {
        return state.with(STACKS, Math.clamp(state.get(STACKS) - 1, 1, getMaxStacks()));
    }

    public int getStacks(BlockState state) {
        return state.get(STACKS);
    }

    @Override
    public int getMaxStacks() {
        return maxStacks;
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(STACKS);
    }
}
