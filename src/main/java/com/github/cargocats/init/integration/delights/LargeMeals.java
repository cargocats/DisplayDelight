package com.github.cargocats.init.integration.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class LargeMeals {
    public static final Block LM_PUFFERFISH_BROTH = DisplayDelightBlocks.createFoodBlock("lm_pufferfish_broth");
    public static final Block LM_POTATO_SOUP = DisplayDelightBlocks.createFoodBlock("lm_potato_soup");
    public static final Block LM_RED_SOUP = DisplayDelightBlocks.createFoodBlock("lm_red_soup");
    public static final Block LM_TOMATO_EGG_SOUP = DisplayDelightBlocks.createFoodBlock("lm_tomato_egg_soup");
    public static final Block LM_COD_DELUXE = DisplayDelightBlocks.createWideFoodBlock("lm_cod_deluxe");
    public static final Block LM_HEARTY_LUNCH = DisplayDelightBlocks.createWideFoodBlock("lm_hearty_lunch");
    public static final Block LM_CHICKEN_CURRY = DisplayDelightBlocks.createWideFoodBlock("lm_chicken_curry");
    public static final Block LM_PASTA_WITH_MUSHROOM_SAUCE = DisplayDelightBlocks.createWideFoodBlock("lm_pasta_with_mushroom_sauce");
    public static final Block LM_OMURICE = DisplayDelightBlocks.createFoodBlock("lm_omurice");
    public static final Block LM_MUSHROOM_POT_PIE = DisplayDelightBlocks.createFoodBlock("lm_mushroom_pot_pie");
    public static final Block LM_ROASTED_MUTTON_RACK = DisplayDelightBlocks.createFoodBlock("lm_roasted_mutton_rack");
    public static final Block LM_SWEET_BERRY_CUSTARD = DisplayDelightBlocks.createDrinkFoodBlock("lm_sweet_berry_custard");
    public static final Block LM_RICE_PUDDING = DisplayDelightBlocks.createFoodBlock("lm_rice_pudding");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("Large Meals");
    }
}
