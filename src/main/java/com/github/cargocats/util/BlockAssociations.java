package com.github.cargocats.util;

import net.minecraft.block.Block;
import net.minecraft.item.Item;

import java.util.HashMap;
import java.util.Map;

public class BlockAssociations {
    public static final Map<Block, Item> BLOCK_ITEM_MAP = new HashMap<>();
    public static final Map<Item, Block> ITEM_BLOCK_MAP = new HashMap<>();

    public static final Map<Item, Block> PLATE_ITEM_BLOCK_MAP = new HashMap<>();
    public static final Map<Block, Item> PLATE_BLOCK_ITEM_MAP = new HashMap<>();

    public static final Map<Item, Block> SMALL_PLATE_ITEM_BLOCK_MAP = new HashMap<>();
    public static final Map<Block, Item> SMALL_PLATE_BLOCK_ITEM_MAP = new HashMap<>();
}