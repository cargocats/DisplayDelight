package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class NethersDelight {
    public static final Block ND_PLATE_OF_STUFFED_HOGLIN_SNOUT = DisplayDelightBlocks.createFoodBlock("nd_plate_of_stuffed_hoglin_snout");
    public static final Block ND_PLATE_OF_STUFFED_HOGLIN_HAM = DisplayDelightBlocks.createFoodBlock("nd_plate_of_stuffed_hoglin_ham");
    public static final Block ND_PLATE_OF_STUFFED_HOGLIN_ROAST = DisplayDelightBlocks.createFoodBlock("nd_plate_of_stuffed_hoglin_roast");
    public static final Block ND_STRIDER_MOSS_STEW = DisplayDelightBlocks.createFoodBlock("nd_strider_moss_stew");
    public static final Block ND_WARPED_MOLDY_MEAT = DisplayDelightBlocks.createWideFoodBlock("nd_warped_moldy_meat");
    public static final Block ND_GRILLED_STRIDER = DisplayDelightBlocks.createWideFoodBlock("nd_grilled_strider");

    public static final Block ND_NETHER_SKEWER = DisplayDelightBlocks.createStackablePlatedBlock("nd_plated_nether_skewer", 2);

    public static void init() {
        DisplayDelight.LOG.info("Initialized Nether's Delight compatibility");
    }
}
