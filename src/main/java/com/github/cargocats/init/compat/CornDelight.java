package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class CornDelight {
    public static final Block CD_NACHOS_BOWL = DisplayDelightBlocks.createFoodBlock("cd_nachos_bowl");
    public static final Block CD_CREAMY_COR_DRINK = DisplayDelightBlocks.createDrinkFoodBlock("cd_creamy_corn_drink");
    public static final Block CD_CORNBREAD_STUFFING = DisplayDelightBlocks.createFoodBlock("cd_cornbread_stuffing");
    public static final Block CD_CORN_SOUP = DisplayDelightBlocks.createFoodBlock("cd_corn_soup");
    public static final Block CD_CREAMED_CORN = DisplayDelightBlocks.createFoodBlock("cd_creamed_corn");

    public static final Block CD_GRILLED_CORN = DisplayDelightBlocks.createStackablePlatedBlock("cd_plated_grilled_corn", 2);
    public static final Block CD_CLASSIC_CORN_DOG = DisplayDelightBlocks.createStackablePlatedBlock("cd_plated_classic_corn_dog", 2);
    public static final Block CD_TACO = DisplayDelightBlocks.createStackablePlatedBlock("cd_plated_taco", 2);

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            CD_NACHOS_BOWL,
            CD_CREAMY_COR_DRINK,
            CD_CORNBREAD_STUFFING,
            CD_CORN_SOUP,
            CD_CREAMED_CORN
    ));

    public static final ArrayList<Block> plateableBlocks = new ArrayList<>(List.of(
            CD_GRILLED_CORN,
            CD_CLASSIC_CORN_DOG,
            CD_TACO
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);
        DisplayDelightBlocks.PLATEABLE_BLOCKS.addAll(plateableBlocks);

        DisplayDelight.LOG.info("Initialized Corn Delight compatibility");
    }
}
