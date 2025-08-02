package com.github.cargocats.data.provider;

import com.github.cargocats.init.DisplayDelightItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.server.recipe.RecipeExporter;
import net.minecraft.data.server.recipe.ShapedRecipeJsonBuilder;
import net.minecraft.item.Items;
import net.minecraft.recipe.book.RecipeCategory;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.registry.tag.ItemTags;

import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void generate(RecipeExporter recipeExporter) {
        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, DisplayDelightItems.EMPTY_PLATE, 2)
                .pattern("S S")
                .pattern(" S ")
                .input('S', ItemTags.WOODEN_SLABS)
                .criterion(hasItem(Items.OAK_SLAB), conditionsFromItem(Items.OAK_SLAB))
                .offerTo(recipeExporter);

        ShapedRecipeJsonBuilder.create(RecipeCategory.MISC, DisplayDelightItems.SMALL_EMPTY_PLATE, 2)
                .pattern("SS")
                .input('S', ItemTags.WOODEN_SLABS)
                .criterion(hasItem(Items.OAK_SLAB), conditionsFromItem(Items.OAK_SLAB))
                .offerTo(recipeExporter);
    }

    @Override
    public String getName() {
        return "Recipe Provider";
    }
}
