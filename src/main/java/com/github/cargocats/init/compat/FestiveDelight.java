package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class FestiveDelight {
    public static final Block FD_FESTIVE_CHICKEN = DisplayDelightBlocks.createFoodBlock("fd_festive_chicken");
    public static final Block FD_CHRISTMAS_TEA = DisplayDelightBlocks.createHotDrinkFoodBlock("fd_christmas_tea");
    public static final Block FD_SALMON_VERRINES = DisplayDelightBlocks.createDrinkFoodBlock("fd_salmon_verrines");

    public static void init() {
        DisplayDelight.LOG.info("Initialized Festive Delight compatibility");
    }
}
