package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import java.util.ArrayList;
import java.util.List;
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

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            DF_MATCHA_ICE_CREAM,
            DF_MATCHA_MILKSHAKE,
            DF_SALMONBERRY_ICE_CREAM,
            DF_SALMONBERRY_MILKSHAKE,
            DF_MATCHA_LATTE,
            DF_ENDER_NECTAR,
            DF_BERRY_MATCHA_LATTE,
            DF_CACTUS_CHILI,
            DF_FIELD_SALAD,
            DF_STUFFED_CANTALOUPE,
            DF_SINIGANG,
            DF_CACTUS_SOUP
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);

        DisplayDelight.LOG.info("Initialized Delightful compatibility");
    }
}
