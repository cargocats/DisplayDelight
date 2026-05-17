package com.github.cargocats.data.provider.trade;

import com.github.cargocats.data.trading.DisplayDelightVillagerTrades;
import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagsProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import net.minecraft.world.item.trading.VillagerTrade;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class DDVillagerTradesTagsProvider extends FabricTagsProvider<VillagerTrade> {
    public DDVillagerTradesTagsProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registryLookupFuture) {
        super(output, Registries.VILLAGER_TRADE,  registryLookupFuture);
    }

    @Override
    protected void addTags(HolderLookup.@NonNull Provider registries) {
        this.builder(DisplayDelightVillagerTrades.WANDERING_TRADER_FOOD_TAG_KEY)
                .add(DisplayDelightVillagerTrades.RANDOM_DISPLAYABLE_FOOD)
                .add(DisplayDelightVillagerTrades.RANDOM_STACKABLE_FOOD)
                .add(DisplayDelightVillagerTrades.RANDOM_SMALL_STACKABLE_FOOD);
    }
}
