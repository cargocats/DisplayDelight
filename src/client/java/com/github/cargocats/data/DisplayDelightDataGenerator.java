package com.github.cargocats.data;

import com.github.cargocats.data.provider.*;
import com.github.cargocats.data.provider.trade.DDVillagerTradesTagsProvider;
import com.github.cargocats.data.trading.DisplayDelightVillagerTrades;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;
import net.minecraft.core.RegistrySetBuilder;
import net.minecraft.core.registries.Registries;

public class DisplayDelightDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(DDItemTagsProvider::new);
        pack.addProvider(DDBlockTagsProvider::new);
        pack.addProvider(DDDynamicProvider::new);
        pack.addProvider(DDVillagerTradesTagsProvider::new);
        pack.addProvider(DDRecipeProvider::new);
        pack.addProvider(DDModelProvider::new);
    }

    @Override
    public void buildRegistry(RegistrySetBuilder registryBuilder) {
        registryBuilder.add(Registries.VILLAGER_TRADE, DisplayDelightVillagerTrades::bootstrapVillagerTrades);
        registryBuilder.add(Registries.TRADE_SET, DisplayDelightVillagerTrades::bootstrapTradeSet);
    }
}
