package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class CulturalDelight {
    public static final Block CTD_HEARTY_SALAD = DisplayDelightBlocks.createFoodBlock("ctd_hearty_salad");
    public static final Block CTD_CREAMED_CORN = DisplayDelightBlocks.createFoodBlock("ctd_creamed_corn");
    public static final Block CTD_SPICY_CURRY = DisplayDelightBlocks.createFoodBlock("ctd_spicy_curry");
    public static final Block CTD_FRIED_EGGPLANT_PASTA = DisplayDelightBlocks.createWideFoodBlock("ctd_fried_eggplant_pasta");

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            CTD_HEARTY_SALAD,
            CTD_CREAMED_CORN,
            CTD_SPICY_CURRY,
            CTD_FRIED_EGGPLANT_PASTA
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);

        DisplayDelight.LOG.info("Initialized Cultural Delight compatibility");
    }
}
