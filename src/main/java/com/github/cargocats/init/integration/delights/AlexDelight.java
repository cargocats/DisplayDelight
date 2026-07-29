package com.github.cargocats.init.integration.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class AlexDelight {
    public static final Block AD_MAGGOT_SALAD = DisplayDelightBlocks.createFoodBlock("ad_maggot_salad");
    public static final Block AD_KANGAROO_STEW = DisplayDelightBlocks.createFoodBlock("ad_kangaroo_stew");
    public static final Block AD_ACACIA_BLOSSOM_SOUP = DisplayDelightBlocks.createFoodBlock("ad_acacia_blossom_soup");
    public static final Block AD_LOBSTER_PASTA = DisplayDelightBlocks.createWideFoodBlock("ad_lobster_pasta");
    public static final Block AD_KANGAROO_PASTA = DisplayDelightBlocks.createWideFoodBlock("ad_kangaroo_pasta");

    public static final Block AD_BUNFUNBUS_SANDWICH = DisplayDelightBlocks.createPlatedBlock("ad_plated_bunfungus_sandwich");
    public static final Block AD_BISON_BURGER = DisplayDelightBlocks.createPlatedBlock("ad_plated_bison_burger");
    public static final Block AD_GONGYLIDIA_BRUSCHETTA = DisplayDelightBlocks.createStackablePlatedBlock("ad_plated_gongylidia_bruschetta", 2);

    public static void init() {
        DisplayDelight.loadedCompatibility.add("Alex's Delight");
    }
}
