package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import net.minecraft.core.BlockPos;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.state.BlockState;
import org.jspecify.annotations.NonNull;

public class EmptySmallPlatedFoodBlock extends SmallPlatedFoodBlock {
    public EmptySmallPlatedFoodBlock(Properties settings) {
        super(Identifier.withDefaultNamespace("air"), settings);
    }

    @Override
    public Item getFoodItem() {
        return Items.AIR;
    }

    @Override
    protected @NonNull ItemStack getCloneItemStack(@NonNull LevelReader levelReader, @NonNull BlockPos blockPos, @NonNull BlockState blockState, boolean bl) {
        return new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE);
    }
}