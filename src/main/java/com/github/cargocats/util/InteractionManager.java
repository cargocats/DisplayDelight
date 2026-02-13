package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.FoodBlock;
import com.github.cargocats.block.PlatedFoodBlock;
import com.github.cargocats.block.SmallPlatedFoodBlock;
import com.github.cargocats.init.DisplayDelightBlocks;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.sounds.SoundSource;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.phys.shapes.CollisionContext;

import java.util.Set;

public class InteractionManager {
    public static boolean tryPlaceItem(Player player, ServerLevel world, InteractionHand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockPos clickedPos = blockHitResult.getBlockPos();
        Direction side = blockHitResult.getDirection();

        Block block = DisplayDelightAssociations.getDisplayBlockForItem(itemStack.getItem());
        BlockPos placePos = clickedPos.relative(side);
        BlockState blockState = block.defaultBlockState();

        if (block.equals(Blocks.AIR)) {
            DisplayDelight.LOG.warn("Missing displayable block association for item {}", itemStack);
            return false;
        }

        if (!world.getBlockState(placePos).isAir()) return false;
        if (!blockState.canSurvive(world, placePos)) return false;
        if (!world.isUnobstructed(blockState, placePos, CollisionContext.of(player))) return false;

        itemStack.consume(1, player);
        world.setBlock(placePos, block.defaultBlockState(), Block.UPDATE_ALL);
        world.playSound(null, placePos, block.defaultBlockState().getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
        player.swing(hand, true);

        return true;
    }

    public static boolean tryPlaceItemOnSmallPlate(Player player, ServerLevel world, InteractionHand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockPos blockPos = blockHitResult.getBlockPos();

        if (!(world.getBlockState(blockPos).getBlock() instanceof SmallPlatedFoodBlock)) return false;

        Block block = DisplayDelightAssociations.getSmallPlateBlockForItem(itemStack.getItem());
        BlockState blockState = world.getBlockState(blockPos);
        SmallPlatedFoodBlock smallPlatedFoodBlock = (SmallPlatedFoodBlock) blockState.getBlock();

        if (block.equals(Blocks.AIR) && !blockState.is(DisplayDelightBlocks.SMALL_EMPTY_PLATE)) {
            DisplayDelight.LOG.warn("Missing small plate block association for item {}", itemStack);
            return false;
        }

        // Early return for same food and plate
        if (!blockState.is(DisplayDelightBlocks.SMALL_EMPTY_PLATE) && smallPlatedFoodBlock.getFoodItem().equals(itemStack.getItem())) {
            return false;
        }

        // Handle item swapping for non-empty plates
        if (!blockState.is(DisplayDelightBlocks.SMALL_EMPTY_PLATE)) {
            Item previousPlateItem = smallPlatedFoodBlock.getFoodItem();

            if (!player.getInventory().hasAnyOf(Set.of(previousPlateItem))) {
                player.setItemInHand(hand, new ItemStack(previousPlateItem));
            } else {
                player.getInventory().add(new ItemStack(previousPlateItem));
            }
        }

        itemStack.consume(1, player);
        world.setBlock(blockPos, block.defaultBlockState().setValue(FoodBlock.FACING, blockState.getValue(FoodBlock.FACING)), Block.UPDATE_ALL);

        SoundEvent sound = blockState.is(DisplayDelightBlocks.SMALL_EMPTY_PLATE) ? block.defaultBlockState().getSoundType().getPlaceSound() : SoundEvents.CHICKEN_EGG;
        world.playSound(null, blockPos, sound, blockState.is(DisplayDelightBlocks.SMALL_EMPTY_PLATE) ? SoundSource.BLOCKS : SoundSource.PLAYERS, 1.0F, 0.8F + (float) Math.random() * 0.2F);
        player.swing(hand, true);

        return true;
    }

    public static boolean tryPlaceItemOnPlate(Player player, ServerLevel world, InteractionHand hand, BlockHitResult blockHitResult) {
        ItemStack itemStack = player.getItemInHand(hand);
        BlockPos blockPos = blockHitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);

        if (!(blockState.getBlock() instanceof PlatedFoodBlock)) return false;
        Block platedBlock = DisplayDelightAssociations.getPlateBlockForItem(itemStack.getItem());

        if (platedBlock.equals(Blocks.AIR) && !blockState.is(DisplayDelightBlocks.EMPTY_PLATE)) {
            DisplayDelight.LOG.warn("Missing plate block association for item {}", itemStack);
            return false;
        }

        int count = 1;
        // Convert to the actual plate block
        if (blockState.is(DisplayDelightBlocks.EMPTY_PLATE)) {
            world.setBlock(blockPos, platedBlock.defaultBlockState().setValue(PlatedFoodBlock.STACKS, 1).setValue(FoodBlock.FACING, blockState.getValue(FoodBlock.FACING)), Block.UPDATE_ALL);
        } else {
            if (!platedBlock.equals(blockState.getBlock())) return false;

            // Fill up a plate
            PlatedFoodBlock platedFoodBlock = (PlatedFoodBlock) platedBlock;
            if (platedFoodBlock.getStacks(blockState) < platedFoodBlock.getMaxStacks()) {
                if (player.isShiftKeyDown()) {
                    int stacksLeft = platedFoodBlock.getMaxStacks() - platedFoodBlock.getStacks(blockState);
                    count = player.isCreative() ? stacksLeft : Math.min(stacksLeft, itemStack.getCount());
                    world.setBlock(blockPos, platedFoodBlock.incrementStackState(blockState, count), Block.UPDATE_ALL);
                } else {
                    world.setBlock(blockPos, platedFoodBlock.incrementStackState(blockState), Block.UPDATE_ALL);
                }
            } else {
                return false;
            }
        }

        itemStack.consume(count, player);
        world.playSound(null, blockPos, platedBlock.defaultBlockState().getSoundType().getPlaceSound(), SoundSource.BLOCKS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
        player.swing(hand, true);

        return true;
    }

    public static boolean tryTakeItemWithHand(Player player, ServerLevel world, InteractionHand hand, BlockHitResult blockHitResult) {
        BlockPos blockPos = blockHitResult.getBlockPos();
        BlockState blockState = world.getBlockState(blockPos);
        Block block = blockState.getBlock();

        if (block instanceof SmallPlatedFoodBlock smallPlatedFoodBlock && !blockState.is(DisplayDelightBlocks.SMALL_EMPTY_PLATE)) {
            Item plateItem = smallPlatedFoodBlock.getFoodItem();
            if (plateItem.equals(Items.AIR)) {
                return false;
            }

            world.setBlock(blockPos, DisplayDelightBlocks.SMALL_EMPTY_PLATE.defaultBlockState(), Block.UPDATE_ALL);
            world.playSound(null, blockPos, SoundEvents.CHICKEN_EGG, SoundSource.PLAYERS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
            player.swing(hand, true);

            if (player.getInventory().hasAnyOf(Set.of(plateItem))) {
                player.getInventory().add(new ItemStack(plateItem));
            } else {
                player.setItemInHand(hand, new ItemStack(plateItem));
            }

            return true;
        } else if (block instanceof PlatedFoodBlock platedFoodBlock && !blockState.is(DisplayDelightBlocks.EMPTY_PLATE)) {
            Item plateItem = platedFoodBlock.getFoodItem();
            if (plateItem.equals(Items.AIR)) {
                return false;
            }

            int count = 1;
            if (player.isShiftKeyDown()) {
                count = platedFoodBlock.getStacks(blockState);
                world.setBlock(blockPos, DisplayDelightBlocks.EMPTY_PLATE.defaultBlockState().setValue(FoodBlock.FACING, blockState.getValue(FoodBlock.FACING)), Block.UPDATE_ALL);
            } else {
                if (platedFoodBlock.getStacks(blockState) > 1) {
                    world.setBlock(blockPos, platedFoodBlock.decrementStackState(blockState), Block.UPDATE_ALL);
                } else {
                    world.setBlock(blockPos, DisplayDelightBlocks.EMPTY_PLATE.defaultBlockState().setValue(FoodBlock.FACING, blockState.getValue(FoodBlock.FACING)), Block.UPDATE_ALL);
                }
            }

            world.playSound(null, blockPos, SoundEvents.CHICKEN_EGG, SoundSource.PLAYERS, 1.0F, (float) (0.8F + (Math.random() * 0.2)));
            player.swing(hand, true);

            if (player.getInventory().hasAnyOf(Set.of(plateItem))) {
                player.addItem(new ItemStack(plateItem, count));
            } else {
                player.setItemInHand(hand, new ItemStack(plateItem, count));
            }
            return true;
        }

        return false;
    }
}