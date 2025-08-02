package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.Item;
import net.minecraft.item.Items;
import net.minecraft.registry.Registries;
import net.minecraft.util.Identifier;

import java.util.Optional;

public class DisplayDelightAssociations {
    public static Block getSmallPlateBlockForItem(Item item) {
        return getSuffixedBlockForItem(item, "small_plated_");
    }

    public static Block getPlateBlockForItem(Item item) {
        return getSuffixedBlockForItem(item, "plated_");
    }

    public static Block getDisplayBlockForItem(Item item) {
        return getSuffixedBlockForItem(item, "");
    }

    public static Block getSuffixedBlockForItem(Item item, String suffix) {
        Identifier itemId = Registries.ITEM.getId(item);
        Identifier translatedId = DisplayDelight.id(getExpandedSuffix(itemId.getNamespace()) + suffix + itemId.getPath());

        Optional<Block> optBlock = Registries.BLOCK.getOptionalValue(translatedId);
        Block block = optBlock.orElse(Blocks.AIR);

        if (block == Blocks.AIR) {
            DisplayDelight.LOG.warn("Could not find suffix {} block {} for item {}", suffix, translatedId, item);
        }

        return block;
    }

    public static Item getFoodItem(Identifier foodItemId) {
        Optional<Item> optItem = Registries.ITEM.getOptionalValue(foodItemId);
        Item foodItem = optItem.orElse(Items.AIR);

        if (foodItem.equals(Items.AIR)) {
            DisplayDelight.LOG.warn("Could not find item from registry with food item id: {}", foodItemId);
        }

        return foodItem;
    }

    public static String getExpandedSuffix(String suffix) {
        switch (suffix) {
            case "brewinandchewin" -> {
                return "bnc";
            }
        }

        // farmersdelight and minecraft
        return "";
    }

    public static Identifier farmersDelightPath(String path) {
        return Identifier.of("farmersdelight", path);
    }

    public static Identifier myNethersDelightPath(String path) {
        return Identifier.of("mynethersdelight", path);
    }

    public static Identifier endsDelightPath(String path) {
        return Identifier.of("ends_delight", path);
    }

    public static Identifier endersDelightPath(String path) {
        return Identifier.of("endersdelight", path);
    }

    public static Identifier aquacultureDelightPath(String path) {
        return Identifier.of("aquaculturedelight", path);
    }

    public static Identifier cornDelightPath(String path) {
        return Identifier.of("corn_delight", path);
    }

    public static Identifier expandedDelightPath(String path) {
        return Identifier.of("expandeddelight", path);
    }

    public static Identifier delightfulPath(String path) {
        return Identifier.of("delightful", path);
    }

    public static Identifier brewinAndChewinPath(String path) {
        return Identifier.of("brewinandchewin", path);
    }

    public static Identifier festiveDelightPath(String path) {
        return Identifier.of("festive_delight", path);
    }

    public static Identifier alexsDelightPath(String path) {
        return Identifier.of("alexsdelight", path);
    }

    public static Identifier culturalDelightPath(String path) {
        return Identifier.of("culturaldelights", path);
    }

    public static Identifier largeMealsPath(String path) {
        return Identifier.of("largemeals", path);
    }

    public static Identifier pineappleDelightPath(String path) {
        return Identifier.of("pineapple_delight", path);
    }

    public static Identifier oceansDelightPath(String path) {
        return Identifier.of("oceansdelight", path);
    }
}