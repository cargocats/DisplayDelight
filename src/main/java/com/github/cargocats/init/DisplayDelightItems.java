package com.github.cargocats.init;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

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

    public static Item register(Block block, BiFunction<Block, Item.Properties, Item> factory) {
        return register(block, factory, new Item.Properties());
    }

    public static Item register(Block block, BiFunction<Block, Item.Properties, Item> factory, Item.Properties settings) {
        return register(
                keyOf(BuiltInRegistries.BLOCK.getResourceKey(block).get()), itemSettings -> factory.apply(block, itemSettings), settings
        );
    }

    private static ResourceKey<Item> keyOf(ResourceKey<Block> blockKey) {
        return ResourceKey.create(Registries.ITEM, blockKey.location());
    }

    public static Item register(ResourceKey<Item> key, Function<Item.Properties, Item> factory, Item.Properties settings) {
        Item item = factory.apply(settings);
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, key, item);
    }
}
