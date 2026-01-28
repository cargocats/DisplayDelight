package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.util.InteractionManager;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.item.ItemStack;

public class DisplayDelightEvents {
    public static void init() {
        UseBlockCallback.EVENT.register((playerEntity, world, hand, blockHitResult) -> {
            if (playerEntity.isSpectator() || world.isClientSide()) return InteractionResult.PASS;

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

            if (success) return InteractionResult.SUCCESS;

            return InteractionResult.PASS;
        });
    }
}
