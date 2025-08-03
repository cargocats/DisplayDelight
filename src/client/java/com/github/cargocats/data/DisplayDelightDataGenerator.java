package com.github.cargocats.data;

import com.github.cargocats.data.provider.DDItemTagsProvider;
import com.github.cargocats.data.provider.DDModelProvider;
import com.github.cargocats.data.provider.DDRecipeProvider;
import net.fabricmc.fabric.api.datagen.v1.DataGeneratorEntrypoint;
import net.fabricmc.fabric.api.datagen.v1.FabricDataGenerator;

public class DisplayDelightDataGenerator implements DataGeneratorEntrypoint {
    @Override
    public void onInitializeDataGenerator(FabricDataGenerator fabricDataGenerator) {
        FabricDataGenerator.Pack pack = fabricDataGenerator.createPack();

        pack.addProvider(DDItemTagsProvider::new);
        pack.addProvider(DDRecipeProvider::new);
        pack.addProvider(DDModelProvider::new);
    }
}
