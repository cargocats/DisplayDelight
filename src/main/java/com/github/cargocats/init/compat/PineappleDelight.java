package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class PineappleDelight {
    public static final Block PD_PINEAPPLE_FRIED_RICE = DisplayDelightBlocks.createFoodBlock("pd_pineapple_fried_rice");
    public static final Block PD_PINEAPPLE_ICE_CREAM = DisplayDelightBlocks.createDrinkFoodBlock("pd_pineapple_ice_cream");
    public static final Block PD_PINEAPPLE_MILK_SHAKE = DisplayDelightBlocks.createDrinkFoodBlock("pd_pineapple_milk_shake");
    public static final Block PD_PINEAPPLE_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("pd_pineapple_juice");

    public static final Block PD_SMALL_PLATED_PINEAPPLE_PIE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("pd_small_plated_pineapple_pie_side");

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            PD_PINEAPPLE_FRIED_RICE,
            PD_PINEAPPLE_ICE_CREAM,
            PD_PINEAPPLE_MILK_SHAKE,
            PD_PINEAPPLE_JUICE
    ));

    public static final ArrayList<Block> smallPlateableBlocks = new ArrayList<>(List.of(
            PD_SMALL_PLATED_PINEAPPLE_PIE_SLICE
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);
        DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.addAll(smallPlateableBlocks);

        DisplayDelight.LOG.info("Initialized Pineapple Delight compatibility");
    }
}
