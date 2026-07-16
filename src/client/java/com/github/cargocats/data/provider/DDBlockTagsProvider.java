package com.github.cargocats.data.provider;

import com.github.cargocats.DisplayDelight;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.references.BlockIds;
import net.minecraft.references.BlockItemIds;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;

import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public DDBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        this.builder(DisplayDelight.SUPPORT_EXCEPTIONS)
                .addOptionalTag(BlockTags.DOORS)
                .addOptionalTag(BlockTags.STAIRS)
                .add(BlockItemIds.HONEY_BLOCK)
                .add(BlockItemIds.COMPOSTER)
                .add(BlockItemIds.DIRT_PATH)
                .add(BlockItemIds.FARMLAND)
                .addOptionalTag(BlockTags.FENCE_GATES)
                .add(BlockIds.POTTED_CACTUS)
                .add(BlockIds.POTTED_BAMBOO)
                .add(BlockItemIds.BAMBOO)
                .addOptionalTag(BlockTags.LEAVES)
                .add(BlockItemIds.CAULDRON)
                .add(BlockIds.WATER_CAULDRON)
                .add(BlockIds.LAVA_CAULDRON)
                .add(BlockIds.POWDER_SNOW_CAULDRON)
                .add(BlockItemIds.BIG_DRIPLEAF)
                .add(BlockItemIds.HOPPER)
                .add(BlockItemIds.LECTERN)
                .addOptionalTag(ConventionalBlockTags.FENCE_GATES);

        getOrCreateRawBuilder(DisplayDelight.SUPPORT_EXCEPTIONS)
                .addOptionalElement(Identifier.fromNamespaceAndPath("farmersdelight", "basket"));
    }
}
