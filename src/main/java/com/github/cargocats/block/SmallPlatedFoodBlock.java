package com.github.cargocats.block;

import com.github.cargocats.util.BlockAssociations;
import net.minecraft.block.BlockState;
import net.minecraft.block.ShapeContext;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldView;

public class SmallPlatedFoodBlock extends FoodBlock {
    public SmallPlatedFoodBlock(Settings settings) {
        super(settings);
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createCuboidShape(4, 0, 4, 12, 5, 12);
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(BlockAssociations.SMALL_PLATE_BLOCK_ITEM_MAP.getOrDefault(state.getBlock(), Items.AIR));
    }
}