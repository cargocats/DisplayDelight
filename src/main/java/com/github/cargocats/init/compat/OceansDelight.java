package com.github.cargocats.init.compat;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

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

    public static final Block OD_SMALL_ELDER_GUARDIAN_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("od_small_plated_elder_guardian_roll");
    public static final Block OD_SMALL_FUGU_ROLL = DisplayDelightBlocks.createSmallPlatedBlock("od_small_plated_fugu_roll");

    public static void init() {
        DisplayDelight.loadedCompatibility.add("Ocean's Delight");
    }
}
