package com.github.cargocats.data.provider;

import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricModelProvider;
import net.minecraft.block.Block;
import net.minecraft.data.client.BlockStateModelGenerator;
import net.minecraft.data.client.BlockStateVariant;
import net.minecraft.data.client.BlockStateVariantMap;
import net.minecraft.data.client.ItemModelGenerator;
import net.minecraft.data.client.ModelIds;
import net.minecraft.data.client.VariantSettings;
import net.minecraft.data.client.VariantsBlockStateSupplier;

public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void generateBlockStateModels(BlockStateModelGenerator blockStateModelGenerator) {
        for (Block block : DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            blockStateModelGenerator.registerNorthDefaultHorizontalRotation(block);
        }

        for (Block block : DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            blockStateModelGenerator.registerNorthDefaultHorizontalRotation(block);
        }

        for (Block block : DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            if (!(block instanceof PlatedFoodBlock plated)) continue;

            var supplier = VariantsBlockStateSupplier.create(block);
            BlockStateVariantMap.SingleProperty<Integer> variantMap = BlockStateVariantMap.create(PlatedFoodBlock.STACKS);

            for (int i = 1; i <= 6; i++) {
                variantMap.register(i, BlockStateVariant.create().put(VariantSettings.MODEL, ModelIds.getBlockModelId(block).withSuffixedPath("_" + Math.min(i, plated.getMaxStacks()))));
            }

            blockStateModelGenerator.blockStateCollector.accept(supplier.coordinate(variantMap).coordinate(BlockStateModelGenerator.createNorthDefaultHorizontalRotationStates()));
            blockStateModelGenerator.registerParentedItemModel(block, ModelIds.getBlockModelId(block).withSuffixedPath("_" + plated.getMaxStacks()));
        }

        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(DisplayDelightBlocks.SMALL_EMPTY_PLATE);
        blockStateModelGenerator.registerNorthDefaultHorizontalRotation(DisplayDelightBlocks.EMPTY_PLATE);
    }

    @Override
    public void generateItemModels(ItemModelGenerator itemModelGenerator) {

    }
}
