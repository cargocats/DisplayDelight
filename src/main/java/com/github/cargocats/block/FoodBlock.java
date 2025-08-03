package com.github.cargocats.block;

import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.util.DisplayDelightAssociations;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.block.Block;
import net.minecraft.block.BlockState;
import net.minecraft.block.HorizontalFacingBlock;
import net.minecraft.block.ShapeContext;
import net.minecraft.block.SideShapeType;
import net.minecraft.item.Item;
import net.minecraft.item.ItemPlacementContext;
import net.minecraft.item.ItemStack;
import net.minecraft.loot.context.LootContextParameterSet;
import net.minecraft.server.world.ServerWorld;
import net.minecraft.state.StateManager;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;
import net.minecraft.util.math.Direction;
import net.minecraft.util.math.random.Random;
import net.minecraft.util.shape.VoxelShape;
import net.minecraft.world.BlockView;
import net.minecraft.world.WorldAccess;
import net.minecraft.world.WorldView;
import org.jetbrains.annotations.Nullable;

import java.util.List;

public class FoodBlock extends HorizontalFacingBlock {
    public static final MapCodec<FoodBlock> CODEC = RecordCodecBuilder.mapCodec(
            instance -> instance.group(
                    Identifier.CODEC.fieldOf("food_item_id").forGetter(block -> block.foodItemId), createSettingsCodec()).apply(instance, FoodBlock::new)
    );

    private final Identifier foodItemId;
    public FoodBlock(Identifier foodItemId, Settings settings) {
        super(settings);
        this.setDefaultState(this.getStateManager().getDefaultState().with(FACING, Direction.NORTH));
        this.foodItemId = foodItemId;
    }

    @Override
    protected MapCodec<? extends HorizontalFacingBlock> getCodec() { return CODEC; }

    @Override
    protected List<ItemStack> getDroppedStacks(BlockState state, LootContextParameterSet.Builder builder) {
        List<ItemStack> droppedStacks = super.getDroppedStacks(state, builder);
        Block block = state.getBlock();
        Item foodItem = getFoodItem();

        if (block instanceof PlatedFoodBlock platedFoodBlock) {
            droppedStacks.add(new ItemStack(foodItem, platedFoodBlock.getStacks(state)));
            droppedStacks.add(new ItemStack(DisplayDelightItems.EMPTY_PLATE));
        } else if (block instanceof SmallPlatedFoodBlock) {
            droppedStacks.add(new ItemStack(foodItem));
            droppedStacks.add(new ItemStack(DisplayDelightItems.SMALL_EMPTY_PLATE));
        } else {
            droppedStacks.add(new ItemStack(foodItem));
        }

        return droppedStacks;
    }

    public Item getFoodItem() {
        return DisplayDelightAssociations.getFoodItem(this.foodItemId);
    }

    @Override
    protected boolean canPlaceAt(BlockState state, WorldView world, BlockPos pos) {
        return world.getBlockState(pos.down()).isSideSolid(world, pos.down(), Direction.UP, SideShapeType.CENTER);
    }

    @Override
    protected void scheduledTick(BlockState state, ServerWorld world, BlockPos pos, Random random) {
        if (!state.canPlaceAt(world, pos)) {
            world.breakBlock(pos, true);
        }
    }

    @Override
    protected BlockState getStateForNeighborUpdate(
            BlockState state, Direction direction, BlockState neighborState, WorldAccess world, BlockPos pos, BlockPos neighborPos
    ) {
        if (!state.canPlaceAt(world, pos)) {
            world.scheduleBlockTick(pos, this, 1);
        }

        return super.getStateForNeighborUpdate(state, direction, neighborState, world, pos, neighborPos);
    }

    @Override
    public @Nullable BlockState getPlacementState(ItemPlacementContext ctx) {
        return getDefaultState().with(FACING, ctx.getHorizontalPlayerFacing().getOpposite());
    }

    @Override
    public ItemStack getPickStack(WorldView world, BlockPos pos, BlockState state) {
        return new ItemStack(getFoodItem());
    }

    @Override
    protected VoxelShape getOutlineShape(BlockState state, BlockView world, BlockPos pos, ShapeContext context) {
        return createCuboidShape(3, 0, 3, 13, 6, 13);
    }

    @Override
    protected void appendProperties(StateManager.Builder<Block, BlockState> builder) {
        super.appendProperties(builder);
        builder.add(FACING);
    }
}
