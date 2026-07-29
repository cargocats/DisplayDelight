package com.github.cargocats.init.integration.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class PineappleDelight {
    public static final Block PD_PINEAPPLE_FRIED_RICE = DisplayDelightBlocks.createFoodBlock("pd_pineapple_fried_rice");
    public static final Block PD_PINEAPPLE_ICE_CREAM = DisplayDelightBlocks.createDrinkFoodBlock("pd_pineapple_ice_cream");
    public static final Block PD_PINEAPPLE_MILK_SHAKE = DisplayDelightBlocks.createDrinkFoodBlock("pd_pineapple_milk_shake");
    public static final Block PD_PINEAPPLE_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("pd_pineapple_juice");

    public static final Block PD_SMALL_PLATED_PINEAPPLE_PIE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("pd_small_plated_pineapple_pie_side");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("Pineapple Delight");
    }
}
