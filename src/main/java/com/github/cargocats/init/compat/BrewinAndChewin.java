package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class BrewinAndChewin {
    public static final Block BNC_FIERY_FONDUE = DisplayDelightBlocks.createFoodBlock("bnc_fiery_fondue");
    public static final Block BNC_SCARLET_PIEROGI = DisplayDelightBlocks.createWideFoodBlock("bnc_scarlet_pierogi");
    public static final Block BNC_HORROR_LASAGNA = DisplayDelightBlocks.createWideFoodBlock("bnc_horror_lasagna");
    public static final Block BNC_CHEESY_PASTA = DisplayDelightBlocks.createWideFoodBlock("bnc_cheesy_pasta");
    public static final Block BNC_CREAMY_ONION_SOUP = DisplayDelightBlocks.createFoodBlock("bnc_creamy_onion_soup");
    public static final Block BNC_VEGETABLE_OMELET = DisplayDelightBlocks.createFoodBlock("bnc_vegetable_omelet");

    public static final Block BNC_PLATED_HAM_AND_CHEESE_SANDWICH = DisplayDelightBlocks.createPlatedBlock("bnc_plated_ham_and_cheese_sandwich");

    public static final Block BNC_SMALL_PLATED_QUICHE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("bnc_small_plated_quiche_slice");

    public static void init() {
        DisplayDelight.LOG.info("Initialized Brewin n Chewin compatibility");
    }
}
