package com.github.cargocats.data.provider;

import net.fabricmc.fabric.api.datagen.v1.FabricPackOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricDynamicRegistryProvider;

import net.minecraft.core.HolderLookup;
import net.minecraft.core.registries.Registries;
import org.jspecify.annotations.NonNull;
import java.util.concurrent.CompletableFuture;

public class DDDynamicProvider extends FabricDynamicRegistryProvider {
    public DDDynamicProvider(FabricPackOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(HolderLookup.@NonNull Provider registries, @NonNull Entries entries) {
        entries.addAll(registries.lookupOrThrow(Registries.VILLAGER_TRADE));
        entries.addAll(registries.lookupOrThrow(Registries.TRADE_SET));
    }

    @Override
    public @NonNull String getName() {
        return "Display Delight Dynamic Registry Provider";
    }
}
