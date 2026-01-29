package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class ExpandedDelight {
    public static final Block ED_ASPARAGUS_SOUP = DisplayDelightBlocks.createFoodBlock("ed_asparagus_soup");
    public static final Block ED_ASPARAGUS_SOUP_CREAMY = DisplayDelightBlocks.createFoodBlock("ed_asparagus_soup_creamy");
    public static final Block ED_ASPARAGUS_AND_BACON_CHEESY = DisplayDelightBlocks.createWideFoodBlock("ed_asparagus_and_bacon_cheesy");
    public static final Block ED_PEPERONATA = DisplayDelightBlocks.createWideFoodBlock("ed_peperonata");
    public static final Block ED_PEANUT_HONEY_SOUP = DisplayDelightBlocks.createFoodBlock("ed_peanut_honey_soup");
    public static final Block ED_MAC_AND_CHEESE = DisplayDelightBlocks.createFoodBlock("ed_mac_and_cheese");
    public static final Block ED_PEANUT_SALAD = DisplayDelightBlocks.createFoodBlock("ed_peanut_salad");
    public static final Block ED_SWEET_POTTATO_SALAD = DisplayDelightBlocks.createFoodBlock("ed_sweet_potato_salad");
    public static final Block ED_CINNAMON_RICE = DisplayDelightBlocks.createFoodBlock("ed_cinnamon_rice");
    public static final Block ED_CINNAMON_APPLES = DisplayDelightBlocks.createFoodBlock("ed_cinnamon_apples");
    public static final Block ED_APPLE_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("ed_apple_juice");
    public static final Block ED_SWEET_BERRY_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("ed_sweet_berry_juice");
    public static final Block ED_GLOW_BERRY_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("ed_glow_berry_juice");
    public static final Block ED_CRANBERRY_JUICE = DisplayDelightBlocks.createDrinkFoodBlock("ed_cranberry_juice");
    public static final Block ED_CRANBERRY_CHICKEN = DisplayDelightBlocks.createWideFoodBlock("ed_cranberry_chicken");
    public static final Block ED_ASPARAGUS_MUSHROOM_PASTA = DisplayDelightBlocks.createWideFoodBlock("ed_asparagus_mushroom_pasta");
    public static final Block ED_SWEET_POTATO_CASSEROLE = DisplayDelightBlocks.createWideFoodBlock("ed_sweet_potato_casserole");

    public static final Block ED_PEANUT_BUTTER_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ed_plated_peanut_butter_sandwich");
    public static final Block ED_PEANUT_BUTTER_AND_HONEY_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ed_plated_peanut_butter_honey_sandwich");
    public static final Block ED_GLOW_BERRY_JELLY_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ed_plated_glow_berry_jelly_sandwich");
    public static final Block ED_SWEET_BERRY_JELLY_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ed_plated_sweet_berry_jelly_sandwich");
    public static final Block ED_CHEESE_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ed_plated_cheese_sandwich");
    public static final Block ED_GRILLED_CHEESE = DisplayDelightBlocks.createPlatedBlock("ed_plated_grilled_cheese");

    public static final Block ED_CHOCOLATE_COOKIE = DisplayDelightBlocks.createStackablePlatedBlock("ed_plated_chocolate_cookie", 4);
    public static final Block ED_SUGAR_COOKIE = DisplayDelightBlocks.createStackablePlatedBlock("ed_plated_sugar_cookie", 4);
    public static final Block ED_SNICKERDOODLE = DisplayDelightBlocks.createStackablePlatedBlock("ed_plated_snickerdoodle", 4);
    public static final Block ED_SWEET_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ed_plated_sweet_roll", 4);
    public static final Block ED_BERRY_SWEET_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ed_plated_berry_sweet_roll", 4);
    public static final Block ED_GLOW_BERRY_SWEET_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("ed_plated_glow_berry_sweet_roll", 4);

    public static final Block ED_SMALL_PLATED_CRANBERRY_COBBLER_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("ed_small_plated_cranberry_cobbler_slice");
    public static final Block ED_SMALL_PLATED_HONEYED_GOAT_CHEESE_TART_SLICE = DisplayDelightBlocks.createSmallPlatedBlock("ed_small_plated_honeyed_goat_cheese_tart_slice");

    public static void init() {
        DisplayDelight.LOG.info("Initialized Expanded Delight compatibility");
    }
}
