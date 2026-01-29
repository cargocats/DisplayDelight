package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.block.state.BlockState;

public class EmptyPlatedFoodBlock extends PlatedFoodBlock {
    public EmptyPlatedFoodBlock(Properties settings) {
        super(new ResourceLocation("air"), 1, settings);
    }

    @Override
    public Item getFoodItem() {
        return Items.AIR;
    }

    @Override
    public ItemStack getCloneItemStack(BlockGetter blockGetter, BlockPos blockPos, BlockState blockState) {
        return new ItemStack(DisplayDelightItems.EMPTY_PLATE);
    }
}
