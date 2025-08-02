package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.block.Block;

import java.util.ArrayList;
import java.util.List;

public class OceansDelight {
    public static final Block OD_BOWL_OF_GUARDIAN_SOUP = DisplayDelightBlocks.createFoodBlock("od_bowl_of_guardian_soup");
    public static final Block OD_BRAISED_SEA_PICKLE = DisplayDelightBlocks.createFoodBlock("od_braised_sea_pickle");
    public static final Block OD_SEAGRASS_SALAD = DisplayDelightBlocks.createFoodBlock("od_seagrass_salad");
    public static final Block OD_SQUID_RINGS = DisplayDelightBlocks.createFoodBlock("od_squid_rings");

    public static final Block OD_BACKED_TENTACLE_ON_A_STICK = DisplayDelightBlocks.createStackablePlatedBlock("od_plated_baked_tentacle_on_a_stick", 2);
    public static final Block OD_ELDER_GUARDIAN_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("od_plated_elder_guardian_roll", 6);
    public static final Block OD_FUGU_ROLL = DisplayDelightBlocks.createStackablePlatedBlock("od_plated_fugu_roll", 6);
    public static final Block OD_HONEY_FRIED_KELP = DisplayDelightBlocks.createPlatedBlock("od_plated_honey_fried_kelp");
    public static final Block OD_COOKED_STUFFED_COD = DisplayDelightBlocks.createStackablePlatedBlock("od_plated_cooked_stuffed_cod", 2);

    public static final ArrayList<Block> displayableBlocks = new ArrayList<>(List.of(
            OD_BOWL_OF_GUARDIAN_SOUP,
            OD_BRAISED_SEA_PICKLE,
            OD_SEAGRASS_SALAD,
            OD_SQUID_RINGS
    ));

    public static final ArrayList<Block> plateableBlocks = new ArrayList<>(List.of(
            OD_BACKED_TENTACLE_ON_A_STICK,
            OD_ELDER_GUARDIAN_ROLL,
            OD_FUGU_ROLL,
            OD_HONEY_FRIED_KELP,
            OD_COOKED_STUFFED_COD
    ));

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.addAll(displayableBlocks);
        DisplayDelightBlocks.PLATEABLE_BLOCKS.addAll(plateableBlocks);

        DisplayDelight.LOG.info("Initialized Oceans Delight compatibility");
    }
}
