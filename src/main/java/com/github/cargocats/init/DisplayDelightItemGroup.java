package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.core.Registry;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceKey;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;

public class DisplayDelightItemGroup {
    public static final ResourceKey<CreativeModeTab> ITEM_GROUP_KEY = ResourceKey.create(BuiltInRegistries.CREATIVE_MODE_TAB.key(), DisplayDelight.id("item_group"));
    public static final CreativeModeTab ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DisplayDelightItems.EMPTY_PLATE))
            .title(Component.translatable("itemGroup.displaydelight"))
            .build();

    public static void init() {
        Registry.register(BuiltInRegistries.CREATIVE_MODE_TAB, ITEM_GROUP_KEY, ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY).register(entries -> {
            entries.accept(DisplayDelightItems.SMALL_EMPTY_PLATE);
            entries.accept(DisplayDelightItems.EMPTY_PLATE);

            entries.acceptAll(DisplayDelightItems.BLOCK_ITEMS.stream().map(ItemStack::new).toList());
        });
    }
}
