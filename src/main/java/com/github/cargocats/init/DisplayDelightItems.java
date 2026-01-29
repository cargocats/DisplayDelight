package com.github.cargocats.init;

import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.BlockItem;
import net.minecraft.world.item.Item;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DisplayDelightItems {
    public static final Item SMALL_EMPTY_PLATE = registerBlock(DisplayDelightBlocks.SMALL_EMPTY_PLATE);
    public static final Item EMPTY_PLATE = registerBlock(DisplayDelightBlocks.EMPTY_PLATE);

    public static final List<Item> BLOCK_ITEMS = new ArrayList<>();

    public static void init() {
        DisplayDelightBlocks.DISPLAYABLE_BLOCKS.forEach(DisplayDelightItems::registerFoodBlockItem);
        DisplayDelightBlocks.PLATEABLE_BLOCKS.forEach(DisplayDelightItems::registerFoodBlockItem);
        DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.forEach(DisplayDelightItems::registerFoodBlockItem);
    }

    private static void registerFoodBlockItem(Block block) {
        BLOCK_ITEMS.add(registerBlock(block));
    }

    public static Item registerBlock(Block block) {
        return registerBlock(block, BlockItem::new);
    }

    private static ResourceKey<Item> blockIdToItemId(ResourceKey<Block> resourceKey) {
        return ResourceKey.create(Registries.ITEM, resourceKey.identifier());
    }

    public static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> biFunction) {
        return registerBlock(block, biFunction, new Item.Properties());
    }

    public static Item registerBlock(Block block, BiFunction<Block, Item.Properties, Item> biFunction, Item.Properties properties) {
        return registerItem(
                blockIdToItemId(block.builtInRegistryHolder().key()), propertiesx -> biFunction.apply(block, propertiesx), properties.useBlockDescriptionPrefix()
        );
    }

    public static Item registerItem(ResourceKey<Item> resourceKey, Function<Item.Properties, Item> function, Item.Properties properties) {
        Item item = function.apply(properties.setId(resourceKey));
        if (item instanceof BlockItem blockItem) {
            blockItem.registerBlocks(Item.BY_BLOCK, item);
        }

        return Registry.register(BuiltInRegistries.ITEM, resourceKey, item);
    }
}
