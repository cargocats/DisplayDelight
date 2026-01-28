package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.*;
import com.github.cargocats.util.DisplayDelightAssociations;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

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
                        .sound(SoundType.GLASS)
        );
    }

    public static Block createHotDrinkFoodBlock(String name, Identifier foodItemId) {
        return register(
                name,
                settings -> new HotDrinkFoodBlock(foodItemId, settings),
                baseBlockSettings()
                        .sound(SoundType.GLASS)
        );
    }

    public static Block createDrinkFoodBlock(String name) {
        return createDrinkFoodBlock(name, DisplayDelightAssociations.getId(name));
    }

    public static Block createHotDrinkFoodBlock(String name) {
        return createHotDrinkFoodBlock(name, DisplayDelightAssociations.getId(name));
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

    public static BlockBehaviour.Properties baseBlockSettings() {
        return BlockBehaviour.Properties.of()
                .noOcclusion()
                .noTerrainParticles()
                .instabreak()
                .pushReaction(PushReaction.DESTROY)
                .sound(SoundType.WOOD);
    }

    private static Block register(String id, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        return register(keyOf(id), factory, settings);
    }

    private static ResourceKey<Block> keyOf(String id) {
        return ResourceKey.create(Registries.BLOCK, DisplayDelight.id(id));
    }

    public static Block register(ResourceKey<Block> key, Function<BlockBehaviour.Properties, Block> factory, BlockBehaviour.Properties settings) {
        Block block = factory.apply(settings.setId(key));
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }
}
