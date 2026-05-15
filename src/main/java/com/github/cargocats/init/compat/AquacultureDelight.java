package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class AquacultureDelight {
    public static final Block ACD_POOR_FISHER_CHOWDER = DisplayDelightBlocks.createFoodBlock("acd_poor_fisher_chowder");
    public static final Block ACD_JELLYFISH_JELLY = DisplayDelightBlocks.createFoodBlock("acd_jellyfish_jelly");
    public static final Block ACD_UNUSUAL_FISH_SOUP = DisplayDelightBlocks.createFoodBlock("acd_unusual_fish_soup");
    public static final Block ACD_BASS_STEW = DisplayDelightBlocks.createFoodBlock("acd_bass_stew");
    public static final Block ACD_FISH_CHORBA = DisplayDelightBlocks.createFoodBlock("acd_fish_chorba");
    public static final Block ACD_FISH_AND_CHIPS = DisplayDelightBlocks.createFoodBlock("acd_fish_and_chips");
    public static final Block ACD_HALASZLE = DisplayDelightBlocks.createFoodBlock("acd_halaszle");
    public static final Block ACD_CRISPY_NORI_KELP = DisplayDelightBlocks.createFoodBlock("acd_crispy_nori_kelp");
    public static final Block ACD_BAKED_POLLOCK_WITH_CARROTS = DisplayDelightBlocks.createWideFoodBlock("acd_baked_pollock_with_carrots");
    public static final Block ACD_LARGE_FISH_WITH_VEGETABLES = DisplayDelightBlocks.createWideFoodBlock("acd_large_fish_with_vegetables");
    public static final Block ACD_ROLLMOPS = DisplayDelightBlocks.createWideFoodBlock("acd_rollmops");
    public static final Block ACD_TUNA_SPAGHETTI = DisplayDelightBlocks.createWideFoodBlock("acd_tuna_spaghetti");
    public static final Block ACD_HALIBUT_WITH_TARTAR_SAUCE = DisplayDelightBlocks.createWideFoodBlock("acd_halibut_with_tartar_sauce");
    public static final Block ACD_BUCKLING = DisplayDelightBlocks.createWideFoodBlock("acd_buckling");
    public static final Block ACD_TURTLE_MEAT_DISH = DisplayDelightBlocks.createWideFoodBlock("acd_turtle_meat_dish");

    public static final Block ACD_PLATED_CATFISH_BARBECUE = DisplayDelightBlocks.createStackablePlatedBlock("acd_plated_catfish_barbecue", 3);

    public static final Block ACD_SMALL_PLATED_RAW_FISH_FILLET_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("acd_small_plated_raw_fish_fillet_roll");
    public static final Block ACD_SMALL_PLATED_FRIED_PERCH_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("acd_small_plated_fried_perch_roll");

    public static void init() {
        DisplayDelight.LOG.info("Initialized Aquaculture Delight compatibility");
    }
}
