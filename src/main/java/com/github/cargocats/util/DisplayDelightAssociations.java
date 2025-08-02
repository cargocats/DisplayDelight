package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayDelightAssociations {
    private static final ConcurrentHashMap<Identifier, Block> BLOCK_CACHE = new ConcurrentHashMap<>();
    private static final ConcurrentHashMap<Identifier, Item> ITEM_CACHE = new ConcurrentHashMap<>();

    public static Block getSmallPlateBlockForItem(Item item) {
        return getPrefixedBlockForItem(item, "small_plated_");
    }

    public static Block getPlateBlockForItem(Item item) {
        return getPrefixedBlockForItem(item, "plated_");
    }

    public static Block getDisplayBlockForItem(Item item) {
        return getPrefixedBlockForItem(item, "");
    }

    public static Block getPrefixedBlockForItem(Item item, String prefix) {
        Identifier itemId = Registries.ITEM.getId(item);
        Block cached = BLOCK_CACHE.get(itemId);
        if (cached != null) return cached;

        Identifier translatedId = DisplayDelight.id(getExpandedShortPrefix(itemId.getNamespace()) + prefix + itemId.getPath());

        Optional<Block> optBlock = Registries.BLOCK.getOrEmpty(translatedId);
        Block block = optBlock.orElse(Blocks.AIR);

        if (block.equals(Blocks.AIR)) {
            DisplayDelight.LOG.warn("Could not find prefix {} block {} for item {}", prefix, translatedId, item);
        }

        BLOCK_CACHE.put(itemId, block);
        return block;
    }

    public static Item getFoodItem(Identifier foodItemId) {
        Item cached = ITEM_CACHE.get(foodItemId);
        if (cached != null) return cached;

        Identifier translatedId = Identifier.of(foodItemId.getNamespace(), removePrefixes(foodItemId.getPath()));
        Optional<Item> optItem = Registries.ITEM.getOrEmpty(translatedId);
        Item foodItem = optItem.orElse(Items.AIR);

        if (foodItem.equals(Items.AIR)) {
            DisplayDelight.LOG.warn("Could not find item from registry with food item id: {}", foodItemId);
        }

        ITEM_CACHE.put(foodItemId, foodItem);
        return foodItem;
    }

    public static Identifier getId(String name) {
        return Identifier.of(getExpandedLongPrefix(getPrefix(name)), removePrefixes(name));
    }

    public static String removePrefixes(String str) {
        return str.replaceFirst("^(plated|small_plated|vna_plated|vna|od|od_plated)_", "");
    }

    public static String getExpandedShortPrefix(String prefix) {
        switch (prefix) {
            case "minecraft" -> {
                return "vna_";
            }
            case "oceansdelight" -> {
                return "od_";
            }
        }

        // Farmers delight
        return "";
    }

    public static String getExpandedLongPrefix(String prefix) {
        switch (prefix) {
            case "vna" -> {
                return "minecraft";
            }
            case "od" -> {
                return "oceansdelight";
            }
        }

        return "farmersdelight";
    }

    public static String getPrefix(String id) {
        int firstUnderscore = id.indexOf('_');
        if (firstUnderscore == -1) return id;
        return id.substring(0, firstUnderscore);
    }
}