package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jetbrains.annotations.NotNull;

public class EmptySmallPlatedFoodBlock extends SmallPlatedFoodBlock {
    public EmptySmallPlatedFoodBlock(Properties settings) {
        super(ResourceLocation.withDefaultNamespace("air"), settings);
    }

    @Override
    public Item getFoodItem() {
        return Items.AIR;
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE);
    }
}