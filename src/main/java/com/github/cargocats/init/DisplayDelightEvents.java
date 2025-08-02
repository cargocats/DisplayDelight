package com.github.cargocats.init;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.util.InteractionManager;
import net.fabricmc.fabric.api.event.player.UseBlockCallback;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.util.ActionResult;
import net.minecraft.util.Hand;

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

            if (success) return ActionResult.SUCCESS;

            return ActionResult.PASS;
        });
    }
}
