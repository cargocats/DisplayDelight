package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.util.BlockAssociations;
import com.github.cargocats.util.InteractionManager;
import net.fabricmc.fabric.api.event.lifecycle.v1.ServerWorldEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.block.Block;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;
import net.minecraft.util.math.BlockPos;

import java.util.List;

public class DisplayDelightEvents {
    public static void init() {
        UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
            if (playerEntity.isSpectator() || world.isClient) return ActionResult.PASS;

            ItemStack itemStackInHand = playerEntity.getStackInHand(hand);
            boolean success = false;

            if (itemStackInHand.isEmpty() && hand == Hand.MAIN_HAND) {
                success = InteractionManager.tryTakeItemWithHand(playerEntity, (ServerWorld) world, hand, blockHitResult);
            }

            if (!success && playerEntity.isSneaking() && itemStackInHand.isIn(DisplayDelight.DISPLAYABLE)) {
                success = InteractionManager.tryPlaceItem(playerEntity, (ServerWorld) world, hand, blockHitResult);
            } else {
                if (!success && itemStackInHand.isIn(DisplayDelight.SMALL_PLATE_DISPLAYABLE)) {
                    success = InteractionManager.tryPlaceItemOnSmallPlate(playerEntity, (ServerWorld) world, hand, blockHitResult);
                }

                if (!success && itemStackInHand.isIn(DisplayDelight.PLATE_DISPLAYABLE)) {
                    success = InteractionManager.tryPlaceItemOnPlate(playerEntity, (ServerWorld) world, hand, blockHitResult);
                }
            }

            if (success) return ActionResult.SUCCESS_SERVER;

            return ActionResult.PASS;
        });

        ServerWorldEvents.LOAD.register((server, world) -> {
            DisplayDelightBlocks.DISPLAYABLE_BLOCKS.forEach(block -> {
                List<ItemStack> drops = Block.getDroppedStacks(block.getDefaultState(), world, BlockPos.ofFloored(0, 256, 0), null);

                if (!drops.isEmpty()) {
                    BlockAssociations.BLOCK_ITEM_MAP.put(block, drops.getFirst().getItem());
                    BlockAssociations.ITEM_BLOCK_MAP.put(drops.getFirst().getItem(), block);
                } else {
                    DisplayDelight.LOG.warn("Missing displayable loot table for block {}", block);
                }
            });

            DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.forEach(block -> {
                List<ItemStack> drops = Block.getDroppedStacks(block.getDefaultState(), world, BlockPos.ofFloored(0, 256, 0), null);

                if (!drops.isEmpty()) {
                    BlockAssociations.SMALL_PLATE_BLOCK_ITEM_MAP.put(block, drops.getFirst().getItem());
                    BlockAssociations.SMALL_PLATE_ITEM_BLOCK_MAP.put(drops.getFirst().getItem(), block);
                } else {
                    DisplayDelight.LOG.warn("Missing small plate loot table for block {}", block);
                }
            });

            DisplayDelightBlocks.PLATEABLE_BLOCKS.forEach(block -> {
                List<ItemStack> drops = Block.getDroppedStacks(block.getDefaultState(), world, BlockPos.ofFloored(0, 256, 0), null);

                if (!drops.isEmpty()) {
                    BlockAssociations.PLATE_BLOCK_ITEM_MAP.put(block, drops.getFirst().getItem());
                    BlockAssociations.PLATE_ITEM_BLOCK_MAP.put(drops.getFirst().getItem(), block);
                } else {
                    DisplayDelight.LOG.warn("Missing plate loot table for block {}", block);
                }
            });
        });
    }
}
