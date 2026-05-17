package com.github.cargocats.data.provider;

import com.github.cargocats.DisplayDelight;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.fabricmc.fabric.api.tag.convention.v2.ConventionalBlockTags;
import net.minecraft.core.HolderLookup;
import net.minecraft.resources.Identifier;
import net.minecraft.tags.BlockTags;
import net.minecraft.world.level.block.Blocks;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class DDBlockTagsProvider extends FabricTagsProvider.BlockTagsProvider {
    public DDBlockTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider wrapperLookup) {
        valueLookupBuilder(DisplayDelight.SUPPORT_EXCEPTIONS)
                .addOptionalTag(BlockTags.DOORS)
                .addOptionalTag(BlockTags.STAIRS)
                .add(Blocks.HONEY_BLOCK)
                .add(Blocks.COMPOSTER)
                .add(Blocks.DIRT_PATH)
                .add(Blocks.FARMLAND)
                .addOptionalTag(BlockTags.FENCE_GATES)
                .add(Blocks.POTTED_CACTUS)
                .add(Blocks.POTTED_BAMBOO)
                .add(Blocks.BAMBOO)
                .addOptionalTag(BlockTags.LEAVES)
                .add(Blocks.CAULDRON)
                .add(Blocks.WATER_CAULDRON)
                .add(Blocks.LAVA_CAULDRON)
                .add(Blocks.POWDER_SNOW_CAULDRON)
                .add(Blocks.BIG_DRIPLEAF)
                .add(Blocks.HOPPER)
                .add(Blocks.LECTERN)
                .addOptionalTag(ConventionalBlockTags.FENCE_GATES);

        getOrCreateRawBuilder(DisplayDelight.SUPPORT_EXCEPTIONS)
                .addOptionalElement(Identifier.fromNamespaceAndPath("farmersdelight", "basket"));
    }
}
