package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class FestiveDelight {
    public static final Block FD_FESTIVE_CHICKEN = DisplayDelightBlocks.createFoodBlock("fd_festive_chicken");
    public static final Block FD_CHRISTMAS_TEA = DisplayDelightBlocks.createHotDrinkFoodBlock("fd_christmas_tea");
    public static final Block FD_SALMON_VERRINES = DisplayDelightBlocks.createDrinkFoodBlock("fd_salmon_verrines");

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            FD_FESTIVE_CHICKEN,
            FD_CHRISTMAS_TEA,
            FD_SALMON_VERRINES
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);

        DisplayDelight.LOG.info("Initialized Festive Delight compatibility");
    }
}
