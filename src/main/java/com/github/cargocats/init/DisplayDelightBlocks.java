package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.DrinkFoodBlock;
import com.github.cargocats.block.EmptyPlatedFoodBlock;
import com.github.cargocats.block.EmptySmallPlatedFoodBlock;
import com.github.cargocats.block.FoodBlock;
import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.block.SmallPlatedFoodBlock;
import com.github.cargocats.block.WideFoodBlock;
import com.github.cargocats.util.DisplayDelightAssociations;
import net.minecraft.block.AbstractBlock;
import net.minecraft.block.Block;
import net.minecraft.block.piston.PistonBehavior;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.sound.BlockSoundGroup;
import net.minecraft.util.Identifier;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

public class DisplayDelightBlocks {
    public static final ArrayList<Block> DISPLAYABLE_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> PLATEABLE_BLOCKS = new ArrayList<>();
    public static final ArrayList<Block> SMALL_PLATEABLE_BLOCKS = new ArrayList<>();

    public static final Block SMALL_EMPTY_PLATE = register(
            "small_food_plate",
            EmptySmallPlatedFoodBlock::new,
            baseBlockSettings()
    );
    public static final Block EMPTY_PLATE = register(
            "food_plate",
            EmptyPlatedFoodBlock::new,
            baseBlockSettings()
    );

    public static final Block MUSHROOM_STEW = createFoodBlock("vna_mushroom_stew");
    public static final Block RABBIT_STEW = createFoodBlock("vna_rabbit_stew");
    public static final Block BEETROOT_STEW = createFoodBlock("vna_beetroot_soup");

    public static final Block PLATED_COOKIE = createStackablePlatedBlock("vna_plated_cookie",4);
    public static final Block PLATED_PUMPKIN_PIE = createPlatedBlock("vna_plated_pumpkin_pie");

    public static void init() {
        DISPLAYABLE_BLOCKS.addAll(List.of(
                MUSHROOM_STEW,
                RABBIT_STEW,
                BEETROOT_STEW
        ));

        PLATEABLE_BLOCKS.addAll(List.of(
                PLATED_COOKIE,
                PLATED_PUMPKIN_PIE
        ));
    }

    public static Block createFoodBlock(String name, Identifier foodItemId) {
        return register(
                name,
                settings -> new FoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createWideFoodBlock(String name, Identifier foodItemId) {
        return register(
                name,
                settings -> new WideFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createDrinkFoodBlock(String name, Identifier foodItemId) {
        return register(
                name,
                settings -> new DrinkFoodBlock(foodItemId, settings),
                baseBlockSettings()
                        .sounds(BlockSoundGroup.GLASS)
        );
    }

    public static Block createDrinkFoodBlock(String name) {
        return createDrinkFoodBlock(name, DisplayDelightAssociations.getId(name));
    }

    public static Block createFoodBlock(String name) {
        return createFoodBlock(name, DisplayDelightAssociations.getId(name));
    }

    public static Block createWideFoodBlock(String name) {
        return createWideFoodBlock(name, DisplayDelightAssociations.getId(name));
    }

    public static Block createSmallPlatedBlock(String name, Identifier foodItemId) {
        return register(
                name,
                settings -> new SmallPlatedFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createSmallPlatedBlock(String name) {
        return createSmallPlatedBlock(name, DisplayDelightAssociations.getId(name));
    }

    public static Block createStackablePlatedBlock(String name, Identifier foodItemId, int maxStacks) {
        return register(
                name,
                settings -> new PlatedFoodBlock(foodItemId, maxStacks, settings),
                baseBlockSettings()
        );
    }

    public static Block createStackablePlatedBlock(String name, int maxStacks) {
        return createStackablePlatedBlock(name, DisplayDelightAssociations.getId(name), maxStacks);
    }

    public static Block createPlatedBlock(String name) {
        return createStackablePlatedBlock(name, 1);
    }

    public static AbstractBlock.Settings baseBlockSettings() {
        return AbstractBlock.Settings.create()
                .nonOpaque()
                .noBlockBreakParticles()
                .breakInstantly()
                .pistonBehavior(PistonBehavior.DESTROY)
                .sounds(BlockSoundGroup.WOOD);
    }

    private static Block register(String id, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        return register(keyOf(id), factory, settings);
    }

    private static RegistryKey<Block> keyOf(String id) {
        return RegistryKey.of(RegistryKeys.BLOCK, DisplayDelight.id(id));
    }

    public static Block register(RegistryKey<Block> key, Function<AbstractBlock.Settings, Block> factory, AbstractBlock.Settings settings) {
        Block block = factory.apply(settings);
        return Registry.register(Registries.BLOCK, key, block);
    }
}
