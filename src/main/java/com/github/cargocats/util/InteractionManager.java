package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.block.SmallPlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.util.Hand;
import net.minecraft.util.hit.BlockHitResult;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;

import java.util.Set;

public class InteractionManager {
    public static boolean tryPlaceItem(PlayerEntity player, ServerWorld world, Hand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getStackInHand(hand);
        BlockPos clickedPos = blockHitResult.getBlockPos();
        Direction side = blockHitResult.getSide();

        Block block = DisplayDelightAssociations.getDisplayBlockForItem(itemStack.getItem());
        BlockPos placePos = clickedPos.offset(side);
        if (block == Blocks.AIR) {
            DisplayDelight.LOG.warn("Missing displayable block association for item {}", itemStack);
            return false;
        }
        if (!world.getBlockState(placePos).canReplace(new ItemPlacementContext(player, hand, itemStack, blockHitResult)))
            return false;
        if (!world.getBlockState(placePos).canPlaceAt(world, placePos)) return false;

        itemStack.decrementUnlessCreative(1, player);
        world.setBlockState(placePos, block.getDefaultState(), Block.NOTIFY_ALL);
        world.playSound(null, placePos, block.getDefaultState().getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
        player.swingHand(hand, true);

        return true;
    }

    public static boolean tryPlaceItemOnSmallPlate(PlayerEntity player, ServerWorld world, Hand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getStackInHand(hand);
        BlockPos clickedPos = blockHitResult.getBlockPos();

        Block block = DisplayDelightAssociations.getSmallPlateBlockForItem(itemStack.getItem());
        if (block == Blocks.AIR) {
            DisplayDelight.LOG.warn("Missing small plate block association for item {}", itemStack);
            return false;
        }

        if (!world.getBlockState(clickedPos).isOf(DisplayDelightBlocks.SMALL_EMPTY_PLATE)) return false;

        itemStack.decrementUnlessCreative(1, player);
        world.setBlockState(clickedPos, block.getDefaultState(), Block.NOTIFY_ALL);
        world.playSound(null, clickedPos, block.getDefaultState().getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
        player.swingHand(hand, true);

        return true;
    }

    public static boolean tryPlaceItemOnPlate(PlayerEntity player, ServerWorld world, Hand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getStackInHand(hand);
        BlockPos blockPos = blockHitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        if (!(blockState.getBlock() instanceof PlatedFoodBlock)) return false;
        Block platedBlock = DisplayDelightAssociations.getPlateBlockForItem(itemStack.getItem());

        if (platedBlock == Blocks.AIR) {
            DisplayDelight.LOG.warn("Missing plate block association for item {}", itemStack);
            return false;
        }

        // Convert to the actual plate block
        if (blockState.isOf(DisplayDelightBlocks.EMPTY_PLATE)) {
            world.setBlockState(blockPos, platedBlock.getDefaultState().with(PlatedFoodBlock.STACKS, 1), Block.NOTIFY_ALL);
        } else {
            // Fill up a plate
            PlatedFoodBlock platedFoodBlock = (PlatedFoodBlock) platedBlock;
            if (platedFoodBlock.getStacks(blockState) < platedFoodBlock.getMaxStacks()) {
                world.setBlockState(blockPos, platedFoodBlock.incrementStackState(blockState), Block.NOTIFY_ALL);
            } else {
                return false;
            }
        }

        itemStack.decrementUnlessCreative(1, player);
        world.playSound(null, blockPos, platedBlock.getDefaultState().getSoundGroup().getPlaceSound(), SoundCategory.BLOCKS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
        player.swingHand(hand, true);

        return true;
    }

    public static boolean tryTakeItemWithHand(PlayerEntity player, ServerWorld world, Hand hand, BlockHitResult blockHitResult) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if (block instanceof SmallPlatedFoodBlock smallPlatedFoodBlock && !blockState.isOf(DisplayDelightBlocks.SMALL_EMPTY_PLATE)) {
            Item plateItem = smallPlatedFoodBlock.getFoodItem();
            if (plateItem == null) {
                DisplayDelight.LOG.warn("Missing small plate block association for block {} when taking", block);
                return false;
            }

            world.setBlockState(blockPos, DisplayDelightBlocks.SMALL_EMPTY_PLATE.getDefaultState(), Block.NOTIFY_ALL);
            world.playSound(null, blockPos, SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.PLAYERS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
            player.swingHand(hand, true);

            if (player.getInventory().containsAny(Set.of(plateItem))) {
                player.getInventory().insertStack(new ItemStack(plateItem));
            } else {
                player.setStackInHand(hand, new ItemStack(plateItem));
            }

            return true;
        } else if (block instanceof PlatedFoodBlock platedFoodBlock && !blockState.isOf(DisplayDelightBlocks.EMPTY_PLATE)) {
            Item plateItem = platedFoodBlock.getFoodItem();
            if (plateItem == null) {
                DisplayDelight.LOG.warn("Missing plate block association for block {} when taking", block);
                return false;
            }

            int count = 1;
            if (player.isSneaking()) {
                count = platedFoodBlock.getStacks(blockState);
                world.setBlockState(blockPos, DisplayDelightBlocks.EMPTY_PLATE.getDefaultState(), Block.NOTIFY_ALL);
            } else {
                if (platedFoodBlock.getStacks(blockState) > 1) {
                    world.setBlockState(blockPos, platedFoodBlock.decrementStackState(blockState), Block.NOTIFY_ALL);
                } else {
                    world.setBlockState(blockPos, DisplayDelightBlocks.EMPTY_PLATE.getDefaultState(), Block.NOTIFY_ALL);
                }
            }

            world.playSound(null, blockPos, SoundEvents.ENTITY_CHICKEN_EGG, SoundCategory.PLAYERS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
            player.swingHand(hand, true);

            if (player.getInventory().containsAny(Set.of(plateItem))) {
                player.giveItemStack(new ItemStack(plateItem, count));
            } else {
                player.setStackInHand(hand, new ItemStack(plateItem, count));
            }
            return true;
        }

        return false;
    }
}