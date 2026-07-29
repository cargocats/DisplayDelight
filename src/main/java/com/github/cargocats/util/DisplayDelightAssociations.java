package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;

import java.util.*;
import java.util.concurrent.ConcurrentHashMap;

public class DisplayDelightAssociations {
    public static final ConcurrentHashMap<Identifier, Block> BLOCK_CACHE = new ConcurrentHashMap<>();
    public static final ConcurrentHashMap<Identifier, Item> ITEM_CACHE = new ConcurrentHashMap<>();
    private static final ArrayList<String> allPrefixes = new ArrayList<>(List.of("small_plated_", "plated_"));
    private static final String[] typePrefixes = new String[]{
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
        Identifier itemId = BuiltInRegistries.ITEM.getKey(item);
        Identifier cacheKey = itemId.withPrefix(prefix);

        Block cached = BLOCK_CACHE.get(cacheKey);
        if (cached != null) return cached;

        Identifier translatedId = DisplayDelight.id(getNamespace(itemId.getNamespace()) + prefix + itemId.getPath());

        Optional<Block> optBlock = BuiltInRegistries.BLOCK.getOptional(translatedId);
        Block block = optBlock.orElse(Blocks.AIR);

        if (block.equals(Blocks.AIR) && !DisplayDelight.CONFIG.disableDebugLog) {
            DisplayDelight.LOG.warn("Could not find prefix {} block {} for item {}", prefix, translatedId, item);
        }

        BLOCK_CACHE.put(cacheKey, block);
        return block;
    }

    public static Item getFoodItem(Identifier foodItemId) {
        Item cached = ITEM_CACHE.get(foodItemId);
        if (cached != null) return cached;

        Identifier translatedId = Identifier.fromNamespaceAndPath(foodItemId.getNamespace(), removeFirstPrefix(foodItemId.getPath()));
        Optional<Item> optItem = BuiltInRegistries.ITEM.getOptional(translatedId);
        Item foodItem = optItem.orElse(Items.AIR);

        if (foodItem.equals(Items.AIR) && !DisplayDelight.CONFIG.disableDebugLog) {
            DisplayDelight.LOG.warn("Could not find item from registry with food item id: {}", foodItemId);
        }

        ITEM_CACHE.put(foodItemId, foodItem);
        return foodItem;
    }

    public static Identifier getId(String name) {
        return Identifier.fromNamespaceAndPath(getLongNamespace(getPrefix(name)), removeFirstPrefix(name));
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
        put("edd_", "ends_delight");
        put("mnd_", "mynethersdelight");
        put("nd_", "nethersdelight");

        // No fabric port as of 1.21.1
        put("ed_", "expandeddelight");
        put("df_", "delightful");
        put("ad_", "alexdelight");
        put("acd_", "aquaculturedelight");
        put("bnc_", "brewinandchewin");
        put("crd_", "crabbersdelight");
        put("erd_", "endersdelight");
        put("ctd_", "culturaldelights");
        put("lm_", "largemeals");
        put("fd_", "festive_delight");
    }};

    private static final Map<String, String> READABLE_NAMESPACES = new HashMap<>() {{
        put("ad_", "Alex's Delight");
        put("acd_", "Aquaculture Delight");
        put("bnc_", "Brewin' And Chewin'");
        put("cd_", "Corn Delight");
        put("crd_", "Crabber's Delight");
        put("ctd_", "Cultural Delights");
        put("df_", "Delightful");
        put("ed_", "Expanded Delight");
        put("edd_", "End's Delight");
        put("erd_", "Ender's Delight");
        put("fd_", "Festive Delight");
        put("lm_", "Large Meals");
        put("mnd_", "My Nether's Delight");
        put("nd_", "Nether's Delight");
        put("od_", "Ocean's Delight");
        put("pd_", "Pineapple Delight");
        put("vna_", "Minecraft");
    }};

    public static String getReadableName(String prefix) {
        return READABLE_NAMESPACES.getOrDefault(prefix, "Farmer's Delight");
    }

    public static String getNamespace(String prefix) {
        for (String key : COMPAT_NAMESPACES.keySet()) {
            if (COMPAT_NAMESPACES.get(key).equals(prefix)) {
                return key;
            }
        }
        return "";
    }

    public static String getLongNamespace(String prefix) {
        for (String key : COMPAT_NAMESPACES.keySet()) {
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
        for (String compatNamespaces : COMPAT_NAMESPACES.keySet()) {
            for (String typePrefix : typePrefixes) {
                allPrefixes.add(compatNamespaces + typePrefix);
            }
        }
    }
}