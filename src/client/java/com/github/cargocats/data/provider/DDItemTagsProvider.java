package com.github.cargocats.data.provider;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.util.DisplayDelightAssociations;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.TagBuilder;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends FabricTagsProvider.ItemTagsProvider {
    public DDItemTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider provider) {
        TagBuilder displayableTagBuilder = getOrCreateRawBuilder(DisplayDelight.DISPLAYABLE);
        TagBuilder plateDisplayableTagBuilder = getOrCreateRawBuilder(DisplayDelight.PLATE_DISPLAYABLE);
        TagBuilder smallPlateDisplayableTagBuilder = getOrCreateRawBuilder(DisplayDelight.SMALL_PLATE_DISPLAYABLE);

        for (Block block: DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            Identifier translatedId = DisplayDelightAssociations.getId(BuiltInRegistries.BLOCK.getKey(block).getPath());
            displayableTagBuilder.addOptionalElement(translatedId);
        }

        for (Block block: DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            Identifier translatedId = DisplayDelightAssociations.getId(BuiltInRegistries.BLOCK.getKey(block).getPath());
            plateDisplayableTagBuilder.addOptionalElement(translatedId);
        }

        for (Block block: DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            Identifier translatedId = DisplayDelightAssociations.getId(BuiltInRegistries.BLOCK.getKey(block).getPath());
            smallPlateDisplayableTagBuilder.addOptionalElement(translatedId);
        }
    }
}
