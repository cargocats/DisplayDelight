package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.*;
import com.github.cargocats.block.fiery.FieryFoodBlock;
import com.github.cargocats.block.fiery.FieryPlatedFoodBlock;
import com.github.cargocats.block.fiery.FierySmallPlatedFoodBlock;
import com.github.cargocats.block.fiery.FieryWideFoodBlock;
import com.github.cargocats.util.DisplayDelightAssociations;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.material.PushReaction;

import java.util.ArrayList;
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
        DisplayDelight.LOG.info("Initialized Display Delight Blocks");
    }

    public static Block createFoodBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new FoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createWideFoodBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new WideFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createDrinkFoodBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new DrinkFoodBlock(foodItemId, settings),
                baseBlockSettings()
                        .sound(SoundType.GLASS)
        );
    }

    public static Block createHotDrinkFoodBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new HotDrinkFoodBlock(foodItemId, settings),
                baseBlockSettings()
                        .sound(SoundType.GLASS)
        );
    }

    public static Block createFieryFoodBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new FieryFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createFieryWideFoodBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new FieryWideFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createDrinkFoodBlock(String name) {
        Block block = createDrinkFoodBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createHotDrinkFoodBlock(String name) {
        Block block = createHotDrinkFoodBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createFoodBlock(String name) {
        Block block = createFoodBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createFieryFoodBlock(String name) {
        Block block = createFieryFoodBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createFieryWideFoodBlock(String name) {
        Block block =  createFieryWideFoodBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createWideFoodBlock(String name) {
        Block block = createWideFoodBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createSmallPlatedBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new SmallPlatedFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createFierySmallPlatedBlock(String name, ResourceLocation foodItemId) {
        return register(
                name,
                settings -> new FierySmallPlatedFoodBlock(foodItemId, settings),
                baseBlockSettings()
        );
    }

    public static Block createSmallPlatedBlock(String name) {
        Block block = createSmallPlatedBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createFierySmallPlatedBlock(String name) {
        Block block = createFierySmallPlatedBlock(name, DisplayDelightAssociations.getId(name));
        DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createStackablePlatedBlock(String name, ResourceLocation foodItemId, int maxStacks) {
        return register(
                name,
                settings -> new PlatedFoodBlock(foodItemId, maxStacks, settings),
                baseBlockSettings()
        );
    }

    public static Block createFieryStackablePlatedBlock(String name, ResourceLocation foodItemId, int maxStacks) {
        return register(
                name,
                settings -> new FieryPlatedFoodBlock(foodItemId, maxStacks, settings),
                baseBlockSettings()
        );
    }

    public static Block createStackablePlatedBlock(String name, int maxStacks) {
        Block block = createStackablePlatedBlock(name, DisplayDelightAssociations.getId(name), maxStacks);
        DisplayDelightBlocks.PLATEABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createFieryStackablePlatedBlock(String name, int maxStacks) {
        Block block = createFieryStackablePlatedBlock(name, DisplayDelightAssociations.getId(name), maxStacks);
        DisplayDelightBlocks.PLATEABLE_BLOCKS.add(block);

        return block;
    }

    public static Block createPlatedBlock(String name) {
        return createStackablePlatedBlock(name, 1);
    }

    public static BlockBehaviour.Properties baseBlockSettings() {
        return BlockBehaviour.Properties.of()
                .noOcclusion()
                .noParticlesOnBreak()
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
        Block block = factory.apply(settings);
        return Registry.register(BuiltInRegistries.BLOCK, key, block);
    }
}
