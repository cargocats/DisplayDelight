package com.github.cargocats.data.provider;

import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;

import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
/*
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
*/
import net.minecraft.util.random.WeightedList;
import net.minecraft.world.level.block.Block;
import org.jspecify.annotations.NonNull;

public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockStateModelGenerator) {
        for (net.minecraft.world.level.block.Block block : DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(block);
        }

        for (Block block : DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(block);
        }

        for (Block block : DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            if (!(block instanceof PlatedFoodBlock plated)) continue;

            var supplier = MultiVariantGenerator.dispatch(block);
            PropertyDispatch.C1<MultiVariant, Integer> variantMap = PropertyDispatch.C1.initial(PlatedFoodBlock.STACKS);
/*
            for (int i = 1; i <= 6; i++) {
                variantMap.select(1, new MultiVariant(WeightedList.<Variant>builder()
                        .add(new Variant())
                        .build()));
                variantMap.select(i, Variant..variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block).withSuffix("_" + Math.min(i, plated.getMaxStacks()))));
            }

            blockStateModelGenerator.blockStateOutput.accept(supplier.with(variantMap).with(BlockModelGenerators.()));
            blockStateModelGenerator.createFlatItemModel
            blockStateModelGenerator.delegateItemModel(block, ModelLocationUtils.getModelLocation(block).withSuffix("_" + plated.getMaxStacks())); */
        }

        blockStateModelGenerator.createNonTemplateHorizontalBlock(DisplayDelightBlocks.SMALL_EMPTY_PLATE);
        blockStateModelGenerator.createNonTemplateHorizontalBlock(DisplayDelightBlocks.EMPTY_PLATE);
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {

    }
}
