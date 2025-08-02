package com.github.cargocats;

import com.github.cargocats.init.DisplayDelightBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.block.Block;
import net.minecraft.client.render.BlockRenderLayer;
import net.minecraft.text.Text;
import net.minecraft.util.Formatting;

import java.util.ArrayList;
import java.util.List;

public class DisplayDelightClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		List<Block> cutoutBlocks = new ArrayList<>();
		cutoutBlocks.addAll(DisplayDelightBlocks.DISPLAYABLE_BLOCKS);
		cutoutBlocks.addAll(DisplayDelightBlocks.PLATEABLE_BLOCKS);
		cutoutBlocks.addAll(DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS);

		BlockRenderLayerMap.putBlocks(BlockRenderLayer.CUTOUT, cutoutBlocks.toArray(new Block[0]));

		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, textList) -> {
			if (itemStack.isIn(DisplayDelight.DISPLAYABLE)){
				textList.add(Text.translatable("item.displaydelight.tooltip.displayable").formatted(Formatting.GRAY));
			} else if (itemStack.isIn(DisplayDelight.SMALL_PLATE_DISPLAYABLE) && itemStack.isIn(DisplayDelight.PLATE_DISPLAYABLE)) {
				textList.add(Text.translatable("item.displaydelight.tooltip.placeable_any_food_plate").formatted(Formatting.GRAY));
			} else if (itemStack.isIn(DisplayDelight.SMALL_PLATE_DISPLAYABLE)) {
				textList.add(Text.translatable("item.displaydelight.tooltip.placeable_small_food_plate").formatted(Formatting.GRAY));
			} else if (itemStack.isIn(DisplayDelight.PLATE_DISPLAYABLE)) {
				textList.add(Text.translatable("item.displaydelight.tooltip.placeable_food_plate").formatted(Formatting.GRAY));
			}
		});
	}
}