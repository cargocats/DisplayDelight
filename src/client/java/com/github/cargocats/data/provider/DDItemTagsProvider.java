package com.github.cargocats.data.provider;


import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.util.DisplayDelightAssociations;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.tags.TagBuilder;
import net.minecraft.world.level.block.Block;

import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public DDItemTagsProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> completableFuture) {
        super(output, completableFuture);
    }

    @Override
    protected void addTags(HolderLookup.Provider provider) {
        TagBuilder displayableTagBuilder = getOrCreateRawBuilder(DisplayDelight.DISPLAYABLE);
        TagBuilder plateDisplayableTagBuilder = getOrCreateRawBuilder(DisplayDelight.PLATE_DISPLAYABLE);
        TagBuilder smallPlateDisplayableTagBuilder = getOrCreateRawBuilder(DisplayDelight.SMALL_PLATE_DISPLAYABLE);

        for (Block block: DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            ResourceLocation translatedId = DisplayDelightAssociations.getId(BuiltInRegistries.BLOCK.getKey(block).getPath());
            displayableTagBuilder.addOptionalTag(translatedId);
        }

        for (Block block: DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            ResourceLocation translatedId = DisplayDelightAssociations.getId(BuiltInRegistries.BLOCK.getKey(block).getPath());
            plateDisplayableTagBuilder.addOptionalTag(translatedId);
        }

        for (Block block: DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            ResourceLocation translatedId = DisplayDelightAssociations.getId(BuiltInRegistries.BLOCK.getKey(block).getPath());
            smallPlateDisplayableTagBuilder.addOptionalTag(translatedId);
        }
    }
}
