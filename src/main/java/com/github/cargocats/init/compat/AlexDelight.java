package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import java.util.ArrayList;
import java.util.List;
import net.minecraft.world.level.block.Block;

public class AlexDelight {
    public static final Block AD_MAGGOT_SALAD = DisplayDelightBlocks.createFoodBlock("ad_maggot_salad");
    public static final Block AD_KANGAROO_STEW = DisplayDelightBlocks.createFoodBlock("ad_kangaroo_stew");
    public static final Block AD_ACACIA_BLOSSOM_SOUP = DisplayDelightBlocks.createFoodBlock("ad_acacia_blossom_soup");
    public static final Block AD_LOBSTER_PASTA = DisplayDelightBlocks.createWideFoodBlock("ad_lobster_pasta");
    public static final Block AD_KANGAROO_PASTA = DisplayDelightBlocks.createWideFoodBlock("ad_kangaroo_pasta");

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            AD_MAGGOT_SALAD,
            AD_KANGAROO_STEW,
            AD_ACACIA_BLOSSOM_SOUP,
            AD_LOBSTER_PASTA,
            AD_KANGAROO_PASTA
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);

        DisplayDelight.LOG.info("Initialized Alex Delight compatibility");
    }
}
