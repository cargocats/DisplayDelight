package com.github.cargocats;

import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.util.DisplayDelightAssociations;
import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.fabric.api.client.item.v1.ItemTooltipCallback;
import net.fabricmc.fabric.api.client.rendering.v1.BlockRenderLayerMap;
import net.minecraft.ChatFormatting;
import net.minecraft.client.renderer.chunk.ChunkSectionLayer;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.Identifier;
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

		BlockRenderLayerMap.putBlocks(ChunkSectionLayer.CUTOUT, cutoutBlocks.toArray(new Block[0]));

		ItemTooltipCallback.EVENT.register((itemStack, tooltipContext, tooltipType, textList) -> {
			Identifier id = BuiltInRegistries.ITEM.getKey(itemStack.getItem());

			if (itemStack.is(DisplayDelight.DISPLAYABLE)){
				textList.add(Component.translatable("item.displaydelight.tooltip.displayable").withStyle(ChatFormatting.GRAY));
			} else if (itemStack.is(DisplayDelight.SMALL_PLATE_DISPLAYABLE) && itemStack.is(DisplayDelight.PLATE_DISPLAYABLE)) {
				textList.add(Component.translatable("item.displaydelight.tooltip.placeable_any_food_plate").withStyle(ChatFormatting.GRAY));
			} else if (itemStack.is(DisplayDelight.SMALL_PLATE_DISPLAYABLE)) {
				textList.add(Component.translatable("item.displaydelight.tooltip.placeable_small_food_plate").withStyle(ChatFormatting.GRAY));
			} else if (itemStack.is(DisplayDelight.PLATE_DISPLAYABLE)) {
				textList.add(Component.translatable("item.displaydelight.tooltip.placeable_food_plate").withStyle(ChatFormatting.GRAY));
			}

			if (id.getNamespace().equals(DisplayDelight.MOD_ID)) {
				if (itemStack.getItem().equals(DisplayDelightItems.EMPTY_PLATE) || itemStack.getItem().equals(DisplayDelightItems.SMALL_EMPTY_PLATE)) return;
				textList.add(Component.translatable("item.displaydelight.tooltip.from_mod", DisplayDelightAssociations.getReadableName(DisplayDelightAssociations.getPrefix(id.getPath()))).withStyle(ChatFormatting.GOLD));
			}
		});
	}
}