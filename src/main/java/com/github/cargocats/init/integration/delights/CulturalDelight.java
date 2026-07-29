package com.github.cargocats.init.integration.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class CulturalDelight {
    public static final Block CTD_HEARTY_SALAD = DisplayDelightBlocks.createFoodBlock("ctd_hearty_salad");
    public static final Block CTD_CREAMED_CORN = DisplayDelightBlocks.createFoodBlock("ctd_creamed_corn");
    public static final Block CTD_SPICY_CURRY = DisplayDelightBlocks.createFoodBlock("ctd_spicy_curry");
    public static final Block CTD_FRIED_EGGPLANT_PASTA = DisplayDelightBlocks.createWideFoodBlock("ctd_fried_eggplant_pasta");
    public static final Block CTD_POACHED_EGGPLANTS = DisplayDelightBlocks.createFoodBlock("ctd_poached_eggplants");
    public static final Block CTD_EGGPLANT_PARMESAN = DisplayDelightBlocks.createFoodBlock("ctd_eggplant_parmesan");

    public static final Block CTD_ELOTE = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_elote", 2);
    public static final Block CTD_EMPANADA = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_empanada", 2);
    public static final Block CTD_BEEF_BURRITO = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_beef_burrito", 2);
    public static final Block CTD_MUTTON_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ctd_plated_mutton_sandwich");
    public static final Block CTD_EGGPLANT_BURGER = DisplayDelightBlocks.createPlatedBlock("ctd_plated_eggplant_burger");
    public static final Block CTD_AVOCADO_TOAST = DisplayDelightBlocks.createPlatedBlock("ctd_plated_avocado_toast");
    public static final Block CTD_CHICKEN_TACO = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_chicken_taco", 2);
    public static final Block CTD_PORK_WRAP = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_pork_wrap", 2);
    public static final Block CTD_FISH_TACO = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_fish_taco", 2);

    public static final Block CTD_CHICKEN_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_chicken_roll", 3);
    public static final Block CTD_MIDORI_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_midori_roll", 3);
    public static final Block CTD_CHICKEN_ROLL_SLICE = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_chicken_roll_slice", 6);
    public static final Block CTD_MIDORI_ROLL_SLICE = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_midori_roll_slice", 6);
    public static final Block CTD_PUFFERFISH_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_pufferfish_roll", 6);
    public static final Block CTD_TROPICAL_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_tropical_roll", 6);
    public static final Block CTD_RICE_BALL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_rice_ball", 4);
    public static final Block CTD_EGG_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_egg_roll", 6);
    public static final Block CTD_CALAMARI_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ctd_plated_calamari_roll", 6);

    public static final Block CTD_SMALL_CHICKEN_ROLL_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_chicken_roll_slice");
    public static final Block CTD_SMALL_MIDORI_ROLL_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_midori_roll_slice");
    public static final Block CTD_SMALL_PUFFERFISH_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_pufferfish_roll");
    public static final Block CTD_SMALL_TROPICAL_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_tropical_roll");
    public static final Block CTD_SMALL_EGG_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_egg_roll");
    public static final Block CTD_SMALL_CALAMARI_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_calamari_roll");
    public static final Block CTD_CUT_PICKLE = DisplayDelightBlocks.createSmallPlatedBlock("ctd_small_plated_cut_pickle");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("Cultural Delight");
    }
}
