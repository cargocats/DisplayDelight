package com.github.cargocats.data.provider;

import com.github.cargocats.init.DisplayDelightItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.RecipeProvider;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jspecify.annotations.NonNull;

import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected @NonNull RecipeProvider createRecipeProvider(HolderLookup.@NonNull Provider provider, @NonNull RecipeOutput recipeOutput) {
        return new RecipeProvider(provider, recipeOutput) {
            @Override
            public void buildRecipes() {
                shaped(RecipeCategory.MISC, DisplayDelightItems.EMPTY_PLATE, 2)
                        .pattern("S S")
                        .pattern(" S ")
                        .define('S', ItemTags.WOODEN_SLABS)
                        .unlockedBy(getHasName(Items.OAK_SLAB), this.has(Items.OAK_SLAB))
                        .save(recipeOutput);

                shaped(RecipeCategory.MISC, DisplayDelightItems.SMALL_EMPTY_PLATE, 2)
                        .pattern("SS")
                        .define('S', ItemTags.WOODEN_SLABS)
                        .unlockedBy(getHasName(Items.OAK_SLAB), this.has(Items.OAK_SLAB))
                        .save(recipeOutput);
            }
        };
    }

    @Override
    public @NonNull String getName() {
        return "Recipe Provider";
    }
}
