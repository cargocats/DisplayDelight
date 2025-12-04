package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.util.DisplayDelightAssociations;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.registries.Registries;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.context.BlockPlaceContext;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.Enchantments;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.block.HorizontalDirectionalBlock;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.storage.loot.LootParams;
import net.minecraft.world.level.storage.loot.parameters.LootContextParams;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.shapes.VoxelShape;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;
import java.util.Optional;

public class FoodBlock extends HorizontalDirectionalBlock {
    public static final MapCodec<FoodBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    ResourceLocation.CODEC.fieldOf("food_item_id").forGetter(block -> block.foodItemId), propertiesCodec()).apply(instance, FoodBlock::new)
    );

    private final ResourceLocation foodItemId;
    public FoodBlock(ResourceLocation foodItemId, Properties settings) {
        super(settings);
        this.registerDefaultState(this.getStateDefinition().any().setValue(FACING, Direction.NORTH));
        this.foodItemId = foodItemId;
    }

    @Override
    protected @NotNull MapCodec<? extends HorizontalDirectionalBlock> codec() { return CODEC; }

    @Override
    protected @NotNull List<ItemStack> getDrops(BlockState state, LootParams.Builder builder) {
        List<ItemStack> droppedStacks = super.getDrops(state, builder);

        boolean usedSilktouch = false;

        ItemStack tool = builder.getParameter(LootContextParams.TOOL);
        var enchantmentRegistry = builder.getLevel().registryAccess().registryOrThrow(Registries.ENCHANTMENT);
        var silkTouchEntry = enchantmentRegistry.getHolder(Enchantments.SILK_TOUCH);

        if (silkTouchEntry.isPresent() && EnchantmentHelper.getItemEnchantmentLevel(silkTouchEntry.get(), tool) > 0) {
            usedSilktouch = true;
        }

        Block block = state.getBlock();
        Item foodItem = getFoodItem();
        boolean fallBack = false;

        if (foodItem.equals(Items.AIR) || (usedSilktouch && !(block instanceof PlatedFoodBlock))) {
            Optional<Item> blockItem = BuiltInRegistries.ITEM.getOptional(BuiltInRegistries.BLOCK.getKey(block));
            foodItem = blockItem.orElse(Items.AIR);
            fallBack = true;

            DisplayDelightAssociations.ITEM_CACHE.put(BuiltInRegistries.BLOCK.getKey(block), foodItem);
        }

        if (block instanceof PlatedFoodBlock platedFoodBlock) {
            if (usedSilktouch && platedFoodBlock.getStacks(state) >= platedFoodBlock.getMaxStacks()) {
                droppedStacks.add(new ItemStack(block));
            } else {
                droppedStacks.add(new ItemStack(foodItem, !fallBack ? platedFoodBlock.getStacks(state) : 1));
                if (!fallBack) droppedStacks.add(new ItemStack(DisplayDelightItems.EMPTY_PLATE));
            }
        } else if (block instanceof SmallPlatedFoodBlock) {
            droppedStacks.add(new ItemStack(foodItem));
            if (!fallBack) droppedStacks.add(new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE));
        } else {
            droppedStacks.add(new ItemStack(foodItem));
        }

        return droppedStacks;
    }

    public Item getFoodItem() {
        return DisplayDelightAssociations.getFoodItem(this.foodItemId);
    }

    @Override
    protected boolean canSurvive(BlockState state, LevelReader world, BlockPos pos) {
        return world.getBlockState(pos.below()).isFaceSturdy(world, pos.below(), Direction.UP, SupportType.CENTER);
    }

    @Override
    protected void tick(BlockState state, ServerLevel world, BlockPos pos, RandomSource random) {
        if (!state.canSurvive(world, pos)) {
            world.destroyBlock(pos, true);
        }
    }

    @Override
    protected @NotNull BlockState updateShape(
            BlockState state, Direction direction, BlockState neighborState, LevelAccessor world, BlockPos pos, BlockPos neighborPos
    ) {
        if (!state.canSurvive(world, pos)) {
            world.scheduleTick(pos, this, 1);
        }

        return super.updateShape(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public @Nullable BlockState getStateForPlacement(BlockPlaceContext ctx) {
        return defaultBlockState().setValue(FACING, ctx.getHorizontalDirection().getOpposite());
    }

    @Override
    public @NotNull ItemStack getCloneItemStack(LevelReader world, BlockPos pos, BlockState state) {
        return new ItemStack(getFoodItem());
    }

    @Override
    protected @NotNull VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
        return box(3, 0, 3, 13, 6, 13);
    }

    @Override
    protected void createBlockStateDefinition(StateDefinition.Builder<Block, BlockState> builder) {
        super.createBlockStateDefinition(builder);
        builder.add(FACING);
    }
}
