package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import net.minecraft.block.BlockState;
import net.minecraft.item.ItemStack;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.world.WorldView;

public class EmptySmallPlatedFoodBlock extends SmallPlatedFoodBlock {
    public EmptySmallPlatedFoodBlock(Settings settings) {
        super(Identifier.ofVanilla("air"), settings);
    }

    @Override
    protected ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state, boolean includeData) {
        return new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE);
    }
}
