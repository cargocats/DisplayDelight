package com.github.cargocats.init.compat.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class MyNethersDelight {
    public static final Block MND_SIZZLING_PUDDING = DisplayDelightBlocks.createFoodBlock("mnd_sizzling_pudding");
    public static final Block MND_ROCK_SOUP = DisplayDelightBlocks.createFieryFoodBlock("mnd_rock_soup");
    public static final Block MND_SPICY_NOODLE_SOUP = DisplayDelightBlocks.createFieryFoodBlock("mnd_spicy_noodle_soup");
    public static final Block MND_STRIDER_STEW = DisplayDelightBlocks.createFoodBlock("mnd_strider_stew");
    public static final Block MND_GHAST_SALAD = DisplayDelightBlocks.createFoodBlock("mnd_ghast_salad");
    public static final Block MND_DRIED_GHAST_WITH_MILK = DisplayDelightBlocks.createFoodBlock("mnd_dried_ghast_with_milk");
    public static final Block MND_SAUSAGE_AND_POTATOES = DisplayDelightBlocks.createFoodBlock("mnd_sausage_and_potatoes");
    public static final Block MND_SPICY_HOGLIN_STEW = DisplayDelightBlocks.createFieryFoodBlock("mnd_spicy_hoglin_stew");
    public static final Block MND_EGG_SOUP = DisplayDelightBlocks.createFoodBlock("mnd_egg_soup");
    public static final Block MND_BREAKFAST_SAMPLER = DisplayDelightBlocks.createWideFoodBlock("mnd_breakfast_sampler");
    public static final Block MND_FRIED_HOGLIN_CHOP = DisplayDelightBlocks.createWideFoodBlock("mnd_fried_hoglin_chop");
    public static final Block MND_TWISTED_GHASTA = DisplayDelightBlocks.createWideFoodBlock("mnd_twisted_ghasta");
    public static final Block MND_STRIDER_WITH_GRILLED_FUNGUS = DisplayDelightBlocks.createWideFoodBlock("mnd_strider_with_grilled_fungus");
    public static final Block MND_SCOTCH_EGGS = DisplayDelightBlocks.createWideFoodBlock("mnd_scotch_eggs");
    public static final Block MND_GIANT_TAKOYAKI = DisplayDelightBlocks.createWideFoodBlock("mnd_giant_takoyaki");
    public static final Block MND_BLUE_TENDERLOIN_STEAK = DisplayDelightBlocks.createWideFoodBlock("mnd_blue_tenderloin_steak");
    public static final Block MND_CRIMSON_STROGANOFF = DisplayDelightBlocks.createWideFoodBlock("mnd_crimson_stroganoff");
    public static final Block MND_SPICY_CURRY = DisplayDelightBlocks.createFieryWideFoodBlock("mnd_spicy_curry");
    public static final Block MND_BLEEDING_TARTAR = DisplayDelightBlocks.createWideFoodBlock("mnd_bleeding_tartar");
    public static final Block MND_HOT_WINGS = DisplayDelightBlocks.createFieryWideFoodBlock("mnd_hot_wings");

    public static final Block MND_PLATE_OF_GHASTA_WITH_CREAM = DisplayDelightBlocks.createFoodBlock("mnd_plate_of_ghasta_with_cream");
    public static final Block MND_PLATE_OF_STUFFED_HOGLIN_SNOUT = DisplayDelightBlocks.createFoodBlock("mnd_plate_of_stuffed_hoglin_snout");
    public static final Block MND_PLATE_OF_STUFFED_HOGLIN_HAM = DisplayDelightBlocks.createFoodBlock("mnd_plate_of_stuffed_hoglin_ham");
    public static final Block MND_PLATE_OF_STUFFED_HOGLIN = DisplayDelightBlocks.createFoodBlock("mnd_plate_of_stuffed_hoglin");
    public static final Block MND_PLATE_OF_COLD_STRIDERLOAF = DisplayDelightBlocks.createFoodBlock("mnd_plate_of_cold_striderloaf");
    public static final Block MND_PLATE_OF_STRIDERLOAF = DisplayDelightBlocks.createFoodBlock("mnd_plate_of_striderloaf");

    public static final Block MND_PLATED_STUFFED_PEPPER = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_stuffed_pepper", 2);
    public static final Block MND_PLATED_HOTDOG_WITH_MIXED_SALAD = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_hotdog_with_mixed_salad", 2);
    public static final Block MND_PLATED_HOTDOG_WITH_NETHER_SALAD = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_hotdog_with_nether_salad", 2);
    public static final Block MND_PLATED_CHILIDOG = DisplayDelightBlocks.createFieryStackablePlatedBlock("mnd_plated_chilidog", 2);
    public static final Block MND_PLATED_SPICY_COTTON = DisplayDelightBlocks.createPlatedBlock("mnd_plated_spicy_cotton");
    public static final Block MND_PLATED_FRIES_GHASTA = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_fries_ghasta", 2);
    public static final Block MND_PLATED_SPICY_SKEWER = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_spicy_skewer", 2);
    public static final Block MND_PLATED_RED_LOIN_ON_A_STICK = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_red_loin_on_a_stick", 3);
    public static final Block MND_PLATED_NETHER_BURGER = DisplayDelightBlocks.createPlatedBlock("mnd_plated_nether_burger");
    public static final Block MND_PLATED_BACON_WRAPPED_SAUSAGE_STICK = DisplayDelightBlocks.createStackablePlatedBlock("mnd_plated_bacon-wrapped_sausage_on_a_stick", 2);

    public static final Block MND_SMALL_PLATED_MAGMA_CAKE_SLICE = DisplayDelightBlocks.createFierySmallPlatedBlock("mnd_small_plated_magma_cake_slice");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("My Nether's Delight");
    }
}
