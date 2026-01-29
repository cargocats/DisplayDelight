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

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            ED_ASPARAGUS_SOUP,
            ED_ASPARAGUS_SOUP_CREAMY,
            ED_ASPARAGUS_AND_BACON_CHEESY,
            ED_PEPERONATA,
            ED_PEANUT_HONEY_SOUP,
            ED_MAC_AND_CHEESE,
            ED_PEANUT_SALAD,
            ED_SWEET_POTTATO_SALAD,
            ED_CINNAMON_RICE,
            ED_CINNAMON_APPLES,
            ED_APPLE_JUICE,
            ED_SWEET_BERRY_JUICE,
            ED_GLOW_BERRY_JUICE
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);

        DisplayDelight.LOG.info("Initialized Expanded Delight compatibility");
    }
}
