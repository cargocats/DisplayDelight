package com.github.cargocats.init.compat;

import folk.sisby.kaleido.api.WrappedConfig;
import folk.sisby.kaleido.lib.quiltconfig.api.annotations.Comment;

public class DisplayDelightConfig extends WrappedConfig {
    @Comment("Whether if wandering traders should be able to trade Display Delight items")
    public boolean wanderingVillagerTrades = true;

    @Comment("Whether if creative tab items should be registered")
    public boolean creativeTabItems = true;

    @Comment("Whether if unnecessary logging be disabled")
    public boolean disableDebugLog = true;
}
