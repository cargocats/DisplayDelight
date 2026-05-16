package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.init.DisplayDelightProperties;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class PlatedFoodBlock extends FoodBlock implements StackablePlate, PlateHolder {
    public static final IntegerProperty STACKS = DisplayDelightProperties.STACKS;
    public static final BooleanProperty PLATE_HIDDEN = DisplayDelightProperties.PLATE_HIDDEN;

    private final int maxStacks;

    public PlatedFoodBlock(Identifier foodItemId, int maxStacks, Properties settings) {
        super(foodItemId, settings);
        this.registerDefaultState(this.defaultBlockState().setValue(STACKS, maxStacks).setValue(PLATE_HIDDEN, false).setValue(SUPPORT, false));
        this.maxStacks = maxStacks;
    }
    /*
    public BlockState getStateFrom(LevelAccessor level, BlockState blockState, BlockPos pos, Direction direction, int count) {
        return this.defaultBlockState().setValue(FACING, direction.getOpposite())
                .setValue(STACKS, Math.min(count, getMaxStacks()))
                .setValue(FoodBlock.SUPPORT, BlockSupport.needSupport(level, pos));
    }*/

    @Override
    protected @NotNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter world, @NonNull BlockPos pos, @NonNull CollisionContext context) {
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

    public boolean hasPlate(BlockState state) {
        return !state.getValue(PLATE_HIDDEN);
    }

    @Override
    public ItemStack getPlate() {
        return new ItemStack(DisplayDelightItems.EMPTY_PLATE);
    }

    @Override
    public int getMaxStacks() {
        return maxStacks;
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(STACKS, PLATE_HIDDEN);
    }
}
