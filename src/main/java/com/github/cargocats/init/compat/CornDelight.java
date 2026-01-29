package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class CornDelight {
    public static final Block CD_NACHOS_BOWL = DisplayDelightBlocks.createFoodBlock("cd_nachos_bowl");
    public static final Block CD_CREAMY_CORN_DRINK = DisplayDelightBlocks.createHotDrinkFoodBlock("cd_creamy_corn_drink");
    public static final Block CD_CORNBREAD_STUFFING = DisplayDelightBlocks.createFoodBlock("cd_cornbread_stuffing");
    public static final Block CD_CORN_SOUP = DisplayDelightBlocks.createFoodBlock("cd_corn_soup");
    public static final Block CD_CREAMED_CORN = DisplayDelightBlocks.createFoodBlock("cd_creamed_corn");

    public static final Block CD_GRILLED_CORN = DisplayDelightBlocks.createStackablePlatedBlock("cd_plated_grilled_corn", 2);
    public static final Block CD_CLASSIC_CORN_DOG = DisplayDelightBlocks.createStackablePlatedBlock("cd_plated_classic_corn_dog", 2);
    public static final Block CD_TACO = DisplayDelightBlocks.createStackablePlatedBlock("cd_plated_taco", 2);

    public static void init() {
        DisplayDelight.LOG.info("Initialized Corn Delight compatibility");
    }
}
