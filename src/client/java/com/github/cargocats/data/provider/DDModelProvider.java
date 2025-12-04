package com.github.cargocats.data.provider;

import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;

import net.minecraft.data.models.BlockModelGenerators;
import net.minecraft.data.models.ItemModelGenerators;
import net.minecraft.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.data.models.blockstates.PropertyDispatch;
import net.minecraft.data.models.blockstates.Variant;
import net.minecraft.data.models.blockstates.VariantProperties;
import net.minecraft.data.models.model.ModelLocationUtils;
import net.minecraft.world.level.block.Block;

public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
        super(output);
    }


    @Override
    public void generateBlockStateModels(BlockModelGenerators blockStateModelGenerator) {
        for (net.minecraft.world.level.block.Block block : DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(block);
        }

        for (Block block : DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            blockStateModelGenerator.createNonTemplateHorizontalBlock(block);
        }

        for (Block block : DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            if (!(block instanceof PlatedFoodBlock plated)) continue;

            var supplier = MultiVariantGenerator.multiVariant(block);
            PropertyDispatch.C1<Integer> variantMap = PropertyDispatch.property(PlatedFoodBlock.STACKS);

            for (int i = 1; i <= 6; i++) {
                variantMap.select(i, Variant.variant().with(VariantProperties.MODEL, ModelLocationUtils.getModelLocation(block).withSuffix("_" + Math.min(i, plated.getMaxStacks()))));
            }

            blockStateModelGenerator.blockStateOutput.accept(supplier.with(variantMap).with(BlockModelGenerators.createHorizontalFacingDispatch()));
            blockStateModelGenerator.delegateItemModel(block, ModelLocationUtils.getModelLocation(block).withSuffix("_" + plated.getMaxStacks()));
        }

        blockStateModelGenerator.createNonTemplateHorizontalBlock(DisplayDelightBlocks.SMALL_EMPTY_PLATE);
        blockStateModelGenerator.createNonTemplateHorizontalBlock(DisplayDelightBlocks.EMPTY_PLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerators itemModelGenerators) {

    }
}
