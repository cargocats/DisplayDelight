package com.github.cargocats.init;

import net.minecraft.block.Block;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.registry.RegistryKeys;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DisplayDelightItems {
    public static final Item SMALL_EMPTY_PLATE = register(DisplayDelightBlocks.SMALL_EMPTY_PLATE);
    public static final Item EMPTY_PLATE = register(DisplayDelightBlocks.EMPTY_PLATE);

    public static final List<Item> BLOCK_ITEMS = new ArrayList<>();

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.forEach(DisplayDelightItems::registerFoodBlockItem);
        DisplayDelightBlocks.PLATEABLE_BLOCKS.forEach(DisplayDelightItems::registerFoodBlockItem);
        DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.forEach(DisplayDelightItems::registerFoodBlockItem);
    }

    private static void registerFoodBlockItem(Block block) {
        BLOCK_ITEMS.add(register(block));
    }

    public static Item register(Block block) {
        return register(block, BlockItem::new);
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory) {
        return register(block, factory, new Item.Settings());
    }

    public static Item register(Block block, BiFunction<Block, Item.Settings, Item> factory, Item.Settings settings) {
        return register(
                keyOf(Registries.BLOCK.getKey(block).get()), itemSettings -> factory.apply(block, itemSettings), settings
        );
    }

    private static RegistryKey<Item> keyOf(RegistryKey<Block> blockKey) {
        return RegistryKey.of(RegistryKeys.ITEM, blockKey.getValue());
    }

    public static Item register(RegistryKey<Item> key, Function<Item.Settings, Item> factory, Item.Settings settings) {
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.appendBlocks(Item.BLOCK_ITEMS, item);
        }

        return Registry.register(Registries.ITEM, key, item);
    }
}
