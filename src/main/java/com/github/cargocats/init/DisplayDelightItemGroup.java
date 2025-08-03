package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import net.fabricmc.fabric.api.itemgroup.v1.FabricItemGroup;
import net.fabricmc.fabric.api.itemgroup.v1.ItemGroupEvents;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.ItemStack;
import net.minecraft.registry.Registries;
import net.minecraft.registry.Registry;
import net.minecraft.registry.RegistryKey;
import net.minecraft.text.Text;

public class DisplayDelightItemGroup {
    public static final RegistryKey<ItemGroup> ITEM_GROUP_KEY = RegistryKey.of(Registries.ITEM_GROUP.getKey(), DisplayDelight.id("item_group"));
    public static final ItemGroup ITEM_GROUP = FabricItemGroup.builder()
            .icon(() -> new ItemStack(DisplayDelightItems.EMPTY_PLATE))
            .displayName(Text.translatable("itemGroup.displayDelight"))
            .build();

    public static void init() {
        Registry.register(Registries.ITEM_GROUP, ITEM_GROUP_KEY, ITEM_GROUP);

        ItemGroupEvents.modifyEntriesEvent(ITEM_GROUP_KEY).register(entries -> {
            entries.add(DisplayDelightItems.SMALL_EMPTY_PLATE);
            entries.add(DisplayDelightItems.EMPTY_PLATE);

            entries.addAll(DisplayDelightItems.BLOCK_ITEMS);
        });
    }
}
