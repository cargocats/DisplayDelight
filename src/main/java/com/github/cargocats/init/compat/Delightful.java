package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class Delightful {
    public static final Block DF_MATCHA_ICE_CREAM = DisplayDelightBlocks.createFoodBlock("df_matcha_ice_cream");
    public static final Block DF_MATCHA_MILKSHAKE = DisplayDelightBlocks.createDrinkFoodBlock("df_matcha_milkshake");
    public static final Block DF_SALMONBERRY_ICE_CREAM = DisplayDelightBlocks.createFoodBlock("df_salmonberry_ice_cream");
    public static final Block DF_SALMONBERRY_MILKSHAKE = DisplayDelightBlocks.createDrinkFoodBlock("df_salmonberry_milkshake");
    public static final Block DF_MATCHA_LATTE = DisplayDelightBlocks.createHotDrinkFoodBlock("df_matcha_latte");
    public static final Block DF_ENDER_NECTAR = DisplayDelightBlocks.createHotDrinkFoodBlock("df_ender_nectar");
    public static final Block DF_BERRY_MATCHA_LATTE = DisplayDelightBlocks.createDrinkFoodBlock("df_berry_matcha_latte");
    public static final Block DF_CACTUS_CHILI = DisplayDelightBlocks.createFoodBlock("df_cactus_chili");
    public static final Block DF_FIELD_SALAD = DisplayDelightBlocks.createFoodBlock("df_field_salad");
    public static final Block DF_STUFFED_CANTALOUPE = DisplayDelightBlocks.createFoodBlock("df_stuffed_cantaloupe");
    public static final Block DF_SINIGANG = DisplayDelightBlocks.createFoodBlock("df_sinigang");
    public static final Block DF_CACTUS_SOUP = DisplayDelightBlocks.createFoodBlock("df_cactus_soup");

    public static final Block DF_SMORE = DisplayDelightBlocks.createPlatedBlock("df_plated_smore");
    public static final Block DF_CHEESEBURGER = DisplayDelightBlocks.createPlatedBlock("df_plated_cheeseburger");
    public static final Block DF_DELUXE_CHEESEBURGER = DisplayDelightBlocks.createPlatedBlock("df_plated_deluxe_cheeseburger");
    public static final Block DF_NUT_BUTTER_AND_JELLY_SANDWICH = DisplayDelightBlocks.createPlatedBlock("df_plated_nut_butter_and_jelly_sandwich");

    public static final Block DF_COOKED_MARSHMELLOW_STICK = DisplayDelightBlocks.createStackablePlatedBlock("df_plated_cooked_marshmallow_stick",3);
    public static final Block DF_CANTALOUPE_POPSICLE = DisplayDelightBlocks.createStackablePlatedBlock("df_plated_cantaloupe_popsicle",2);
    public static final Block DF_CANTALOUPE_BREAD = DisplayDelightBlocks.createStackablePlatedBlock("df_plated_cantaloupe_bread",2);
    public static final Block DF_WRAPPED_CANTALOUPE = DisplayDelightBlocks.createStackablePlatedBlock("df_plated_wrapped_cantaloupe",2);

    public static final Block DF_SALMONBERRY_PIE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("df_small_plated_salmonberry_pie_slice");
    public static final Block DF_PUMPKIN_PIE_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("df_small_plated_pumpkin_pie_slice");
    
    public static void init() {
        DisplayDelight.LOG.info("Initialized Delightful compatibility");
    }
}
