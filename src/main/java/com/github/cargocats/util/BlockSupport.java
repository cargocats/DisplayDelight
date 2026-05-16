package com.github.cargocats.util;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.block.FoodBlock;
import net.minecraft.core.BlockPos;
import net.minecraft.core.Direction;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.block.SupportType;
import net.minecraft.world.level.block.TrapDoorBlock;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.properties.BlockStateProperties;

public class BlockSupport {
    public static boolean needSupport(LevelReader level, BlockPos current) {
        BlockState stateBelow = level.getBlockState(current.below());

        if (stateBelow.is(DisplayDelight.SUPPORT_EXCEPTIONS)) {
            return false;
        }

        if (stateBelow.getBlock() instanceof TrapDoorBlock && stateBelow.getValue(BlockStateProperties.OPEN))
            return false;
        if (stateBelow.getBlock() instanceof FoodBlock) return true;

        return !stateBelow.isFaceSturdy(level, current.below(), Direction.UP, SupportType.CENTER);
    }

    public static boolean needSupport(LevelReader level, BlockPos below, BlockState stateBelow) {
        if (stateBelow.is(DisplayDelight.SUPPORT_EXCEPTIONS)) {
            return false;
        }

        if (stateBelow.getBlock() instanceof TrapDoorBlock && stateBelow.getValue(BlockStateProperties.OPEN))
            return false;
        if (stateBelow.getBlock() instanceof FoodBlock) return true;

        return !stateBelow.isFaceSturdy(level, below, Direction.UP, SupportType.CENTER);
    }
}
