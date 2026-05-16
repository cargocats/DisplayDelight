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
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jspecify.annotations.NonNull;

public class SmallPlatedFoodBlock extends FoodBlock implements PlateHolder {
    public static final BooleanProperty PLATE_HIDDEN = DisplayDelightProperties.PLATE_HIDDEN;

    public SmallPlatedFoodBlock(Identifier foodItemId, Properties settings) {
        super(foodItemId, settings);
        this.registerDefaultState(this.defaultBlockState().setValue(PLATE_HIDDEN, false));
    }

    @Override
    protected @NotNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter world, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return box(4, 0, 4, 12, 5, 12);
    }

    public boolean hasPlate(BlockState state) {
        return !state.getValue(PLATE_HIDDEN);
    }

    @Override
    public ItemStack getPlate() {
        return new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(PLATE_HIDDEN);
    }
}