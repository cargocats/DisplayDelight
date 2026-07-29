package com.github.cargocats.init.compat.delights;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.world.level.block.Block;

public class CrabbersDelight {
    public static final Block CRD_KELP_SHAKE = DisplayDelightBlocks.createDrinkFoodBlock("crd_kelp_shake");
    public static final Block CRD_COCONUT_PUDDING = DisplayDelightBlocks.createDrinkFoodBlock("crd_coconut_pudding");
    public static final Block CRD_COOCNUT_MILK = DisplayDelightBlocks.createDrinkFoodBlock("crd_coconut_milk");
    public static final Block CRD_CLAM_BAKE = DisplayDelightBlocks.createWideFoodBlock("crd_clam_bake");
    public static final Block CRD_SURF_AND_TURF = DisplayDelightBlocks.createWideFoodBlock("crd_surf_and_turf");
    public static final Block CRD_SEAFOOD_GUMBO = DisplayDelightBlocks.createFoodBlock("crd_seafood_gumbo");
    public static final Block CRD_SHRIMP_FRIED_RICE = DisplayDelightBlocks.createFoodBlock("crd_shrimp_fried_rice");
    public static final Block CRD_CORAL_CRUNCH = DisplayDelightBlocks.createFoodBlock("crd_coral_crunch");
    public static final Block CRD_CLAM_CHOWDER = DisplayDelightBlocks.createFoodBlock("crd_clam_chowder");
    public static final Block CRD_BISQUE = DisplayDelightBlocks.createFoodBlock("crd_bisque");

    public static final Block CRD_FROG_LEG_KEBAB = DisplayDelightBlocks.createPlatedBlock("crd_plated_frog_leg_kebab");
    public static final Block CRD_SQUID_KEBAB = DisplayDelightBlocks.createPlatedBlock("crd_plated_squid_kebab");
    public static final Block CRD_SHRIMP_SKEWER = DisplayDelightBlocks.createStackablePlatedBlock("crd_plated_shrimp_skewer", 2);
    public static final Block CRD_FISH_STICK = DisplayDelightBlocks.createPlatedBlock("crd_plated_fish_stick");
    public static final Block CRD_STUFFED_NAUTILUS_SHELL = DisplayDelightBlocks.createPlatedBlock("crd_plated_stuffed_nautilus_shell");


    public static void init() {
        DisplayDelight.loadedCompatibility.add("Crabber's Delight");
    }
}
