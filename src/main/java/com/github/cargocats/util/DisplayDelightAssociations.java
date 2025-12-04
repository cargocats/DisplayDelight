package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

public class DisplayDelightAssociations {
    public static final ConcurrentHashMap<ResourceLocation, Block> BLOCK_CACHE = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<ResourceLocation, Item> ITEM_CACHE = new ConcurrentHashMap<>();
    private static final ArrayList<String> allPrefixes = new ArrayList<>(List.of("small_plated_", "plated_"));
    private static final String[] typePrefixes = new String[] {
            "plated_", "small_plated_", ""
    };

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
        ResourceLocation itemId = BuiltInRegistries.ITEM.getKey(item);
        ResourceLocation cacheKey = itemId.withPrefix(prefix);

        Block cached = BLOCK_CACHE.get(cacheKey);
        if (cached != null) return cached;

        ResourceLocation translatedId = DisplayDelight.id(getNamespace(itemId.getNamespace()) + prefix + itemId.getPath());

        Optional<Block> optBlock = BuiltInRegistries.BLOCK.getOptional(translatedId);
        Block block = optBlock.orElse(Blocks.AIR);

        if (block.equals(Blocks.AIR)) {
            DisplayDelight.LOG.warn("Could not find prefix {} block {} for item {}", prefix, translatedId, item);
        }

        BLOCK_CACHE.put(cacheKey, block);
        return block;
    }

    public static Item getFoodItem(ResourceLocation foodItemId) {
        Item cached = ITEM_CACHE.get(foodItemId);
        if (cached != null) return cached;

        ResourceLocation translatedId = ResourceLocation.fromNamespaceAndPath(foodItemId.getNamespace(), removeFirstPrefix(foodItemId.getPath()));
        Optional<Item> optItem = BuiltInRegistries.ITEM.getOptional(translatedId);
        Item foodItem = optItem.orElse(Items.AIR);

        if (foodItem.equals(Items.AIR)) {
            DisplayDelight.LOG.warn("Could not find item from registry with food item id: {}", foodItemId);
        }

        ITEM_CACHE.put(foodItemId, foodItem);
        return foodItem;
    }

    public static ResourceLocation getId(String name) {
        return ResourceLocation.fromNamespaceAndPath(getLongNamespace(getPrefix(name)), removeFirstPrefix(name));
    }

    private static String removeFirstPrefix(String path) {
        for (String prefix : DisplayDelightAssociations.allPrefixes) {
            if (!prefix.isEmpty() && path.startsWith(prefix)) {
                return path.substring(prefix.length());
            }
        }
        return path;
    }

    private static final Map<String, String> COMPAT_NAMESPACES = new HashMap<>() {{
        put("vna_", "minecraft");
        put("od_", "oceansdelight");
        put("pd_", "pineapple_delight");
        put("cd_", "corndelight");

        // No fabric port as of 1.21.1
        put("ed_", "expandeddelight");
        put("df_", "delightful");
        put("ad_", "alexdelight");
        put("ctd_", "culturaldelights");
        put("lm_", "largemeals");
        put("fd_", "festive_delight");
    }};

    public static String getNamespace(String prefix) {
        for (String key: COMPAT_NAMESPACES.keySet()) {
            if (COMPAT_NAMESPACES.get(key).equals(prefix)) {
                return key;
            }
        }
        return "";
    }

    public static String getLongNamespace(String prefix) {
        for (String key: COMPAT_NAMESPACES.keySet()) {
            if (prefix.startsWith(key)) {
                return COMPAT_NAMESPACES.get(key);
            }
        }

        return "farmersdelight";
    }

    public static String getPrefix(String id) {
        int firstUnderscore = id.indexOf("_");
        if (firstUnderscore == -1) return id;
        return id.substring(0, firstUnderscore + 1);
    }

    public static void init() {
        for (String compatNamespaces : COMPAT_NAMESPACES.keySet()){
            for (String typePrefix : typePrefixes) {
                allPrefixes.add(compatNamespaces + typePrefix);
            }
        }
    }
}