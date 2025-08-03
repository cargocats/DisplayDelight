package com.github.cargocats.data.provider;


import com.github.cargocats.DisplayDelight;
import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.util.DisplayDelightAssociations;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.block.Block;
import net.minecraft.registry.Registries;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.TagBuilder;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public DDItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        TagBuilder displayableTagBuilder = getTagBuilder(DisplayDelight.DISPLAYABLE);
        TagBuilder plateDisplayableTagBuilder = getTagBuilder(DisplayDelight.PLATE_DISPLAYABLE);
        TagBuilder smallPlateDisplayableTagBuilder = getTagBuilder(DisplayDelight.SMALL_PLATE_DISPLAYABLE);

        for (Block block: DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            Identifier translatedId = DisplayDelightAssociations.getId(Registries.BLOCK.getId(block).getPath());
            displayableTagBuilder.addOptional(translatedId);
        }

        for (Block block: DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            Identifier translatedId = DisplayDelightAssociations.getId(Registries.BLOCK.getId(block).getPath());
            plateDisplayableTagBuilder.addOptional(translatedId);
        }

        for (Block block: DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            Identifier translatedId = DisplayDelightAssociations.getId(Registries.BLOCK.getId(block).getPath());
            smallPlateDisplayableTagBuilder.addOptional(translatedId);
        }
    }
}
