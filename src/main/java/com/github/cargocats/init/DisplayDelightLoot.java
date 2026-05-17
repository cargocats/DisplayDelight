package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.data.loot.RandomItemFunction;
import com.mojang.serialization.MapCodec;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.level.storage.loot.functions.LootItemFunction;

public class DisplayDelightLoot {
    public static final ResourceKey<MapCodec<? extends LootItemFunction>> RANDOM_ITEM_FUNCTION_KEY = ResourceKey.create(Registries.LOOT_FUNCTION_TYPE, DisplayDelight.id("random_item_function"));

    public static void init() {
        Registry.register(BuiltInRegistries.LOOT_FUNCTION_TYPE, RANDOM_ITEM_FUNCTION_KEY, RandomItemFunction.MAP_CODEC);
    }
}
