package com.github.cargocats.block;

import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.state.BlockState;

public interface PlateHolder {
    boolean hasPlate(BlockState state);
    ItemStack getPlate();

    default Item getFoodItem() {
        return Items.AIR;
    }
}