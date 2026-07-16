package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.init.DisplayDelightProperties;
import com.github.cargocats.util.BlockSupport;
import com.github.cargocats.util.DisplayDelightAssociations;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.Identifier;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemInstance;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.ScheduledTickAccess;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.jspecify.annotations.NonNull;

import java.util.List;
import java.util.Optional;

public class FoodBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<FoodBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Identifier.CODEC.fieldOf("food_item_id").forGetter(block -> block.foodItemId), propertiesCodec()).apply(instance, FoodBlock::new)
    );

    public static final BooleanProperty SUPPORT = DisplayDelightProperties.SUPPORT;
    private final Identifier foodItemId;

    public FoodBlock(Identifier foodItemId, Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH).setValue(SUPPORT, false));
        this.foodItemId = foodItemId;
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() {
        return CODEC;
    }

    @Override
    protected @NotNull List<ItemStack> getDrops(@NonNull BlockState state, LootParams.@NonNull Builder builder) {
        List<ItemStack> droppedStacks = super.getDrops(state, builder);

        ItemInstance tool = builder.getParameter(LootContextParams.TOOL);
        var enchantmentRegistry = builder.getLevel().registryAccess().lookupOrThrow(Registries.ENCHANTMENT);
        var silkTouchEntry = enchantmentRegistry.getOrThrow(Enchantments.SILK_TOUCH);
        boolean usedSilkTouch = silkTouchEntry.isBound() && EnchantmentHelper.getItemEnchantmentLevel(silkTouchEntry, tool) > 0;

        Block block = state.getBlock();
        Item foodItem = getFoodItem();
        boolean fallBack = false;

        if (foodItem.equals(Items.AIR) || (usedSilkTouch && !(block instanceof PlatedFoodBlock))) {
            Optional<Item> blockItem = BuiltInRegistries.ITEM.getOptional(BuiltInRegistries.BLOCK.getKey(block));
            foodItem = blockItem.orElse(Items.AIR);
            fallBack = true;

            DisplayDelightAssociations.ITEM_CACHE.put(BuiltInRegistries.BLOCK.getKey(block), foodItem);
        }

        if (block instanceof PlatedFoodBlock platedFoodBlock) {
            if (usedSilkTouch && platedFoodBlock.getStacks(state) >= platedFoodBlock.getMaxStacks()) {
                droppedStacks.add(new ItemStack(block));
            } else {
                droppedStacks.add(new ItemStack(foodItem, !fallBack ? platedFoodBlock.getStacks(state) : 1));
                if (!fallBack && platedFoodBlock.hasPlate(state)) droppedStacks.add(new ItemStack(DisplayDelightItems.EMPTY_PLATE));
            }
        } else if (block instanceof SmallPlatedFoodBlock smallPlatedFoodBlock) {
            droppedStacks.add(new ItemStack(foodItem));
            if (!fallBack && smallPlatedFoodBlock.hasPlate(state)) droppedStacks.add(new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE));
        } else {
            droppedStacks.add(new ItemStack(foodItem));
        }

        return droppedStacks;
    }

    public Item getFoodItem() {
        return DisplayDelightAssociations.getFoodItem(this.foodItemId);
    }

    @Override
    protected boolean canSurvive(@NonNull BlockState state, LevelReader world, BlockPos pos) {
        return !world.getBlockState(pos.below()).isAir();
    }

    @Override
    protected void tick(BlockState blockState, @NonNull ServerLevel serverLevel, @NonNull BlockPos blockPos, @NonNull RandomSource randomSource) {
        if (!blockState.canSurvive(serverLevel, blockPos)) {
            serverLevel.destroyBlock(blockPos, true);
        }
    }

    @Override
    protected @NonNull BlockState updateShape(BlockState blockState, @NonNull LevelReader levelReader, @NonNull ScheduledTickAccess scheduledTickAccess, @NonNull BlockPos blockPos, @NonNull Direction direction, @NonNull BlockPos blockPos2, @NonNull BlockState blockState2, @NonNull RandomSource randomSource) {
        if (!blockState.canSurvive(levelReader, blockPos)) {
            scheduledTickAccess.scheduleTick(blockPos, this, 1);
        }

        if (direction == Direction.DOWN && !blockState2.isAir()) {
            return blockState.setValue(SUPPORT, BlockSupport.needSupport(levelReader, blockPos2, blockState2));
        }

        return super.updateShape(blockState, levelReader, scheduledTickAccess, blockPos, direction, blockPos2, blockState2, randomSource);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        Level level = ctx.getLevel();
        BlockPos below = ctx.getClickedPos().below();
        BlockState stateBelow = level.getBlockState(below);

        return defaultBlockState()
                .setValue(FACING, ctx.getHorizontalDirection().getOpposite())
                .setValue(SUPPORT, BlockSupport.needSupport(level, below, stateBelow));
    }

    @Override
    protected @NonNull ItemStack getCloneItemStack(@NonNull LevelReader levelReader, @NonNull BlockPos blockPos, @NonNull BlockState blockState, boolean bl) {
        return new ItemStack(getFoodItem());
    }

    @Override
    protected @NotNull VoxelShape getShape(@NonNull BlockState state, @NonNull BlockGetter world, @NonNull BlockPos pos, @NonNull CollisionContext context) {
        return box(3, 0, 3, 13, 6, 13);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.@NonNull Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING, SUPPORT);
    }
}
