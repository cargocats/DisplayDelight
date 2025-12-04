package com.github.cargocats;

import com.github.cargocats.init.DisplayDelightBlocks;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.blockrenderlayer.v1.BlockRenderLayerMap;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.network.chat.Component;
import net.minecraft.world.level.block.Block;

import java.util.ArrayList;
import java.util.List;

public class DisplayDelightClient implements ClientModInitializer {
	@Override
	public void onInitializeClient() {
		List<Block> cutoutBlocks = new ArrayList<>();
		cutoutBlocks.addAll(DisplayDelightBlocks.DISPLAYABLE_BLOCKS);
		cutoutBlocks.addAll(DisplayDelightBlocks.PLATEABLE_BLOCKS);
		cutoutBlocks.addAll(DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS);

		BlockRenderLayerMap.INSTANCE.putBlocks(RenderType.cutout(), cutoutBlocks.toArray(new Block[0]));

		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, textList) -> {
			if (itemStack.is(DisplayDelight.DISPLAYABLE)){
				textList.add(Component.translatable("item.displaydelight.tooltip.displayable").withStyle(ChatFormatting.GRAY));
			} else if (itemStack.is(DisplayDelight.SMALL_PLATE_DISPLAYABLE) && itemStack.is(DisplayDelight.PLATE_DISPLAYABLE)) {
				textList.add(Component.translatable("item.displaydelight.tooltip.placeable_any_food_plate").withStyle(ChatFormatting.GRAY));
			} else if (itemStack.is(DisplayDelight.SMALL_PLATE_DISPLAYABLE)) {
				textList.add(Component.translatable("item.displaydelight.tooltip.placeable_small_food_plate").withStyle(ChatFormatting.GRAY));
			} else if (itemStack.is(DisplayDelight.PLATE_DISPLAYABLE)) {
				textList.add(Component.translatable("item.displaydelight.tooltip.placeable_food_plate").withStyle(ChatFormatting.GRAY));
			}
		});
	}
}