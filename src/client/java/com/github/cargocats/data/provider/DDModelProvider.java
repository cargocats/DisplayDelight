package com.github.cargocats.data.provider;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.init.DisplayDelightProperties;
import net.fabricmc.fabric.api.client.datagen.v1.provider.FabricModelProvider;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.minecraft.client.data.models.BlockModelGenerators;
import net.minecraft.client.data.models.ItemModelGenerators;
import net.minecraft.client.data.models.MultiVariant;
import net.minecraft.client.data.models.blockstates.MultiPartGenerator;
import net.minecraft.client.data.models.model.ModelLocationUtils;
import net.minecraft.client.data.models.model.ModelTemplates;
import net.minecraft.core.Direction;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;
import org.jspecify.annotations.NonNull;

public class DDModelProvider extends FabricModelProvider {
    public DDModelProvider(FabricDataOutput output) {
        super(output);
    }
    public MultiVariant woodSupportModelVariant = BlockModelGenerators.plainVariant(DisplayDelight.id("block/wood_support"));

    @Override
    public void generateBlockStateModels(@NonNull BlockModelGenerators blockStateModelGenerator) {
        for (Block block : DisplayDelightBlocks.DISPLAYABLE_BLOCKS) {
            generateRotatableMultiPart(blockStateModelGenerator, block);
        }

        for (Block block : DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS) {
            generateRotatableMultiPart(blockStateModelGenerator, block);
        }

        for (Block block : DisplayDelightBlocks.PLATEABLE_BLOCKS) {
            if (!(block instanceof PlatedFoodBlock plated)) continue;
            var multiPart = MultiPartGenerator.multiPart(block);

            for (int stack = 1; stack <= plated.getMaxStacks(); stack++) {
                var stackVariant = BlockModelGenerators.plainVariant(
                        ModelLocationUtils.getModelLocation(block, "_" + stack)
                );

                multiPart
                        .with(BlockModelGenerators.condition().term(DisplayDelightProperties.SUPPORT, true), woodSupportModelVariant)
                        .with(
                                BlockModelGenerators.condition()
                                        .term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH)
                                        .term(PlatedFoodBlock.STACKS, stack),
                                stackVariant
                        )
                        .with(
                                BlockModelGenerators.condition()
                                        .term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH)
                                        .term(PlatedFoodBlock.STACKS, stack),
                                stackVariant.with(BlockModelGenerators.Y_ROT_180)
                        )
                        .with(
                                BlockModelGenerators.condition()
                                        .term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST)
                                        .term(PlatedFoodBlock.STACKS, stack),
                                stackVariant.with(BlockModelGenerators.Y_ROT_90)
                        )
                        .with(
                                BlockModelGenerators.condition()
                                        .term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST)
                                        .term(PlatedFoodBlock.STACKS, stack),
                                stackVariant.with(BlockModelGenerators.Y_ROT_270)
                        );
            }

            blockStateModelGenerator.blockStateOutput.accept(multiPart);
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

    private void generateRotatableMultiPart(BlockModelGenerators blockStateModelGenerator, Block block) {
        var baseVariant = BlockModelGenerators.plainVariant(ModelLocationUtils.getModelLocation(block));

        var multiPart = MultiPartGenerator.multiPart(block)
                .with(BlockModelGenerators.condition().term(DisplayDelightProperties.SUPPORT, true), woodSupportModelVariant)
                .with(BlockModelGenerators.condition().term(BlockStateProperties.HORIZONTAL_FACING, Direction.NORTH), baseVariant)
                .with(BlockModelGenerators.condition().term(BlockStateProperties.HORIZONTAL_FACING, Direction.EAST), baseVariant.with(BlockModelGenerators.Y_ROT_90))
                .with(BlockModelGenerators.condition().term(BlockStateProperties.HORIZONTAL_FACING, Direction.SOUTH), baseVariant.with(BlockModelGenerators.Y_ROT_180))
                .with(BlockModelGenerators.condition().term(BlockStateProperties.HORIZONTAL_FACING, Direction.WEST), baseVariant.with(BlockModelGenerators.Y_ROT_270));

        blockStateModelGenerator.blockStateOutput.accept(multiPart);
    }
}
