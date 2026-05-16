package com.github.cargocats.init;

import net.minecraft.world.level.block.state.properties.BooleanProperty;
import net.minecraft.world.level.block.state.properties.IntegerProperty;

public class DisplayDelightProperties {
    public static final BooleanProperty SUPPORT = BooleanProperty.create("support");
    public static final IntegerProperty STACKS = IntegerProperty.create("stacks", 1, 6);
    public static final BooleanProperty PLATE_HIDDEN = BooleanProperty.create("plate_hidden");
}
