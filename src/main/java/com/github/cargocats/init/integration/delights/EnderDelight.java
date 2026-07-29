package com.github.cargocats.init.integration.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class EnderDelight {
    public static final Block ERD_CHORUS_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("erd_chorus_juice");
    public static final Block ERD_AMBERVEIL_STEW = DisplayDelightBlocks.createFoodBlock("erd_amberveil_stew");
    public static final Block ERD_AMBERVEILED_CURRY = DisplayDelightBlocks.createFoodBlock("erd_amberveiled_curry");
    public static final Block ERD_CHORUS_STEW = DisplayDelightBlocks.createFoodBlock("erd_chorus_stew");
    public static final Block ERD_TWISTED_CEREAL = DisplayDelightBlocks.createFoodBlock("erd_twisted_cereal");
    public static final Block ERD_ENDERMITE_STEW = DisplayDelightBlocks.createFoodBlock("erd_endermite_stew");
    public static final Block ERD_ENDER_PAELLA = DisplayDelightBlocks.createWideFoodBlock("erd_ender_paella");
    public static final Block ERD_CHICKEN_CURRY = DisplayDelightBlocks.createWideFoodBlock("erd_chicken_curry");
    public static final Block ERD_STEAK_FRIES = DisplayDelightBlocks.createWideFoodBlock("erd_steak_fries");
    public static final Block ERD_VEIL_OF_FLAMES_RISOTTO = DisplayDelightBlocks.createWideFoodBlock("erd_veil_of_flames_risotto");
    public static final Block ERD_PEARL_PASTA = DisplayDelightBlocks.createWideFoodBlock("erd_pearl_pasta");
    public static final Block ERD_STUFFED_SHULKER_BOWL = DisplayDelightBlocks.createFoodBlock("erd_stuffed_shulker_bowl");

    public static final Block ERD_PLATED_UNCANNY_COOKIES = DisplayDelightBlocks.createStackablePlatedBlock("erd_plated_uncanny_cookies", 4);
    public static final Block ERD_PLATED_CRISPY_SKEWER = DisplayDelightBlocks.createStackablePlatedBlock("erd_plated_crispy_skewer", 3);
    public static final Block ERD_PLATED_STRANGE_ECLAIR = DisplayDelightBlocks.createStackablePlatedBlock("erd_plated_strange_eclair", 3);
    public static final Block ERD_PLATED_CRAWLING_SANDWICH = DisplayDelightBlocks.createStackablePlatedBlock("erd_plated_crawling_sandwich", 2);

    public static final Block ERD_SMALL_PLATED_CHORUS_PIE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("erd_small_plated_chorus_pie_slice");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("Ender's Delight");
    }
}
