package com.github.cargocats.data.provider;

import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.init.DisplayDelightItems;
import com.mojang.math.Quadrant;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.blockstates.MultiVariantGenerator;
import net.minecraft.client.data.models.blockstates.PropertyDispatch;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.client.renderer.block.model.Variant;
import net.minecraft.client.renderer.block.model.VariantMutator;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jspecify.annotations.NonNull;

public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
        super(output);
    }
    public static final PropertyDispatch<VariantMutator> ROTATION_HORIZONTAL_FACING = PropertyDispatch.modify(BlockStateProperties.HORIZONTAL_FACING)
            .select(Direction.EAST, VariantMutator.Y_ROT.withValue(Quadrant.R90))
            .select(Direction.SOUTH, VariantMutator.Y_ROT.withValue(Quadrant.R180))
            .select(Direction.WEST, VariantMutator.Y_ROT.withValue(Quadrant.R270))
            .select(Direction.NORTH, variant -> variant);

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
            var variantMap = PropertyDispatch.C1.initial(PlatedFoodBlock.STACKS);

            for (int i = 1; i <= 6; i++) {
                variantMap.select(i, BlockModelGenerators.variant(
                        new Variant(ModelLocationUtils.getModelLocation(block).withSuffix("_" + Math.min(i, plated.getMaxStacks())))
                ));
            }

            blockStateModelGenerator.blockStateOutput.accept(supplier.with(variantMap).with(ROTATION_HORIZONTAL_FACING));
            blockStateModelGenerator.registerSimpleItemModel(block, ModelLocationUtils.getModelLocation(block).withSuffix("_" + plated.getMaxStacks()));
        }

        blockStateModelGenerator.createNonTemplateHorizontalBlock(DisplayDelightBlocks.SMALL_EMPTY_PLATE);
        blockStateModelGenerator.createNonTemplateHorizontalBlock(DisplayDelightBlocks.EMPTY_PLATE);
    }

    @Override
    public void generateItemModels(@NonNull ItemModelGenerators itemModelGenerators) {
        itemModelGenerators.generateFlatItem(DisplayDelightItems.SMALL_EMPTY_PLATE, ModelTemplates.FLAT_ITEM);
        itemModelGenerators.generateFlatItem(DisplayDelightItems.EMPTY_PLATE, ModelTemplates.FLAT_ITEM);
    }
}
