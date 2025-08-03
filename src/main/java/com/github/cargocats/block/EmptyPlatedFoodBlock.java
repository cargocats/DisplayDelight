package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class EmptyPlatedFoodBlock extends PlatedFoodBlock {
    public EmptyPlatedFoodBlock(Settings settings) {
        super(Identifier.ofVanilla("air"), 1, settings);
    }

    @Override
    public Item getFoodItem() {
        return Items.AIR;
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(DisplayDelightItems.EMPTY_PLATE);
    }
}
