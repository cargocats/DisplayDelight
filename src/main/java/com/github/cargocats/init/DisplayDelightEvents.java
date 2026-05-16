package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.FoodBlock;
import com.github.cargocats.util.InteractionManager;
import net.fabricmc.fabric.api.event.player.PlayerPickItemEvents;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;

public class DisplayDelightEvents {
    public static void init() {

        UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
            if (playerEntity.isSpectator()) return InteractionResult.PASS;
            if (world.isClientSide()) {
                // Handle desync
                if (InteractionManager.testInsertPlate(playerEntity, world, hand, blockHitResult)) {
                    return InteractionResult.SUCCESS;
                } else {
                    return InteractionResult.PASS;
                }
            }

            ItemStack itemStackInHand = playerEntity.getItemInHand(hand);
            boolean success = false;

            if (itemStackInHand.isEmpty() && hand == InteractionHand.MAIN_HAND) {
                success = InteractionManager.tryTakeItemWithHand(playerEntity, (ServerLevel) world, hand, blockHitResult);
            }

            if (!success && playerEntity.isShiftKeyDown() && itemStackInHand.is(DisplayDelight.DISPLAYABLE)) {
                success = InteractionManager.tryPlaceItem(playerEntity, (ServerLevel) world, hand, blockHitResult);
            } else {
                if (!success && itemStackInHand.is(DisplayDelight.SMALL_PLATE_DISPLAYABLE)) {
                    success = InteractionManager.tryPlaceItemOnSmallPlate(playerEntity, (ServerLevel) world, hand, blockHitResult);
                }

                if (!success && itemStackInHand.is(DisplayDelight.PLATE_DISPLAYABLE)) {
                    success = InteractionManager.tryPlaceItemOnPlate(playerEntity, (ServerLevel) world, hand, blockHitResult);
                }
            }

            if (!success && itemStackInHand.is(ItemTags.AXES)) {
                success = InteractionManager.tryTakePlateWithAxe(playerEntity, (ServerLevel) world, hand, blockHitResult);
            }

            if (!success && itemStackInHand.is(DisplayDelightItems.SMALL_EMPTY_PLATE) || itemStackInHand.is(DisplayDelightItems.EMPTY_PLATE)) {
                success = InteractionManager.tryInsertPlate(playerEntity, (ServerLevel) world, hand, blockHitResult);
            }

            if (success) return InteractionResult.SUCCESS;

            return InteractionResult.PASS;
        });

        PlayerPickItemEvents.BLOCK.register((player, pos, state, includeData) -> {
            if (!(state.getBlock() instanceof FoodBlock foodBlock)) return null;
            Item foodItem = foodBlock.getFoodItem();

            if (!foodItem.equals(Items.AIR) && !player.isShiftKeyDown()) {
                // Use normal pick block behavior
                return null;
            } else {
                // The item doesn't exist or player is sneaking, try to give the block itself instead.
                return new ItemStack(state.getBlock().asItem());
            }
        });
    }
}
