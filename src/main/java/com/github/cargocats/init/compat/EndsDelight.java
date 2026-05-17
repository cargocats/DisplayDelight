package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class EndsDelight {
    public static final Block EDD_DRAGON_BREATH_AND_CHORUS_SOUP = DisplayDelightBlocks.createFoodBlock("edd_dragon_breath_and_chorus_soup");
    public static final Block EDD_SHULKER_SOUP = DisplayDelightBlocks.createFoodBlock("edd_shulker_soup");
    public static final Block EDD_ENDER_NOODLE = DisplayDelightBlocks.createFoodBlock("edd_ender_noodle");
    public static final Block EDD_ENDERMAN_GRISTLE_STEW = DisplayDelightBlocks.createFoodBlock("edd_enderman_gristle_stew");
    public static final Block EDD_STIR_FRIED_SHULKER_MEAT = DisplayDelightBlocks.createWideFoodBlock("edd_stir_fried_shulker_meat");
    public static final Block EDD_ROASTED_DRAGON_STEAK = DisplayDelightBlocks.createWideFoodBlock("edd_roasted_dragon_steak");
    public static final Block EDD_END_MIXED_SALAD = DisplayDelightBlocks.createFoodBlock("edd_end_mixed_salad");
    public static final Block EDD_ASSORTED_SALAD = DisplayDelightBlocks.createFoodBlock("edd_assorted_salad");
    public static final Block EDD_ENDER_CONGEE = DisplayDelightBlocks.createFoodBlock("edd_ender_congee");
    public static final Block EDD_CHORUS_FRUIT_MILK_TEA = DisplayDelightBlocks.createHotDrinkFoodBlock("edd_chorus_fruit_milk_tea");
    public static final Block EDD_CHORUS_FRUIT_WINE = DisplayDelightBlocks.createDrinkFoodBlock("edd_chorus_fruit_wine");
    public static final Block EDD_BUBBLE_TEA = DisplayDelightBlocks.createHotDrinkFoodBlock("edd_bubble_tea");
    public static final Block EDD_DRAGON_BREATH_SODA = DisplayDelightBlocks.createDrinkFoodBlock("edd_dragon_breath_soda");
    public static final Block EDD_CHORUS_FLOWER_TEA = DisplayDelightBlocks.createHotDrinkFoodBlock("edd_chorus_flower_tea");
    public static final Block EDD_GRILLED_SHULKER = DisplayDelightBlocks.createFoodBlock("edd_grilled_shulker");
    public static final Block EDD_DRAGON_MEAT_STEW = DisplayDelightBlocks.createFoodBlock("edd_dragon_meat_stew");
    public static final Block EDD_STEAMED_DRAGON_EGG = DisplayDelightBlocks.createFoodBlock("edd_steamed_dragon_egg");
    public static final Block EDD_DRAGON_LEG_WITH_SAUCE = DisplayDelightBlocks.createFoodBlock("edd_dragon_leg_with_sauce");

    public static final Block EDD_PLATED_STUFFED_RICE_CAKE = DisplayDelightBlocks.createStackablePlatedBlock("edd_plated_stuffed_rice_cake", 3);
    public static final Block EDD_PLATED_CHORUS_FLOWER_PIE = DisplayDelightBlocks.createPlatedBlock("edd_plated_chorus_flower_pie");
    public static final Block EDD_PLATED_ENDER_BAMBOO_RICE = DisplayDelightBlocks.createStackablePlatedBlock("edd_plated_ender_bamboo_rice", 2);
    public static final Block EDD_PLATED_CHORUS_FRUIT_POPSICLE = DisplayDelightBlocks.createStackablePlatedBlock("edd_plated_chorus_fruit_popsicle", 2);
    public static final Block EDD_PLATED_END_BARBECUE_STICK = DisplayDelightBlocks.createStackablePlatedBlock("edd_plated_end_barbecue_stick", 3);

    public static final Block EDD_SMALL_PLATED_CHORUS_FRUIT_PIE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("edd_small_plated_chorus_fruit_pie_slice");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("End's Delight");
    }
}
