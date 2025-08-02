package com.github.cargocats.data.provider;


import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public DDItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {

        /*
        TODO: Figure if this is actually needed in the futrue

        getTagBuilder(DisplayDelight.DISPLAYABLE)
                .addOptional(Identifier.ofVanilla("mushroom_stew"))
                .addOptional(Identifier.ofVanilla("rabbit_stew"))
                .addOptional(Identifier.ofVanilla("beetroot_soup"))

                .addOptional(Identifier.of("farmersdelight", "fruit_salad"))
                .addOptional(Identifier.of("farmersdelight", "glow_berry_custard"))
                .addOptional(Identifier.of("farmersdelight", "cooked_rice"))
                .addOptional(Identifier.of("farmersdelight", "mixed_salad"))
                .addOptional(Identifier.of("farmersdelight", "beef_stew"))
                .addOptional(Identifier.of("farmersdelight", "chicken_soup"))
                .addOptional(Identifier.of("farmersdelight", "vegetable_soup"))
                .addOptional(Identifier.of("farmersdelight", "fish_stew"))
                .addOptional(Identifier.of("farmersdelight", "fried_rice"))
                .addOptional(Identifier.of("farmersdelight", "pumpkin_soup"))
                .addOptional(Identifier.of("farmersdelight", "baked_cod_stew"))
                .addOptional(Identifier.of("farmersdelight", "noodle_soup"))
                .addOptional(Identifier.of("farmersdelight", "bone_broth"))
                .addOptional(Identifier.of("farmersdelight", "bacon_and_eggs"))
                .addOptional(Identifier.of("farmersdelight", "pasta_with_meatballs"))
                .addOptional(Identifier.of("farmersdelight", "pasta_with_mutton_chop"))
                .addOptional(Identifier.of("farmersdelight", "roasted_mutton_chops"))
                .addOptional(Identifier.of("farmersdelight", "steak_and_potatoes"))
                .addOptional(Identifier.of("farmersdelight", "vegetable_noodles"))
                .addOptional(Identifier.of("farmersdelight", "ratatouille"))
                .addOptional(Identifier.of("farmersdelight", "squid_ink_pasta"))
                .addOptional(Identifier.of("farmersdelight", "grilled_salmon"))
                .addOptional(Identifier.of("farmersdelight", "mushroom_rice"))
                .addOptional(Identifier.of("farmersdelight", "roast_chicken"))
                .addOptional(Identifier.of("farmersdelight", "stuffed_pumpkin"))
                .addOptional(Identifier.of("farmersdelight", "honey_glazed_ham"))
                .addOptional(Identifier.of("farmersdelight", "shepherds_pie"))
                .addOptional(Identifier.of("farmersdelight", "apple_cider"))
                .addOptional(Identifier.of("farmersdelight", "melon_juice"))
                .addOptional(Identifier.of("farmersdelight", "hot_cocoa"));*/
    }
}
