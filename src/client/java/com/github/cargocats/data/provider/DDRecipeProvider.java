package com.github.cargocats.data.provider;

import com.github.cargocats.init.DisplayDelightItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.core.HolderLookup;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.RecipeOutput;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.concurrent.CompletableFuture;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output, CompletableFuture<HolderLookup.Provider> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    public void buildRecipes(RecipeOutput recipeOutput) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DisplayDelightItems.EMPTY_PLATE, 2)
                .pattern("S S")
                .pattern(" S ")
                .define('S', ItemTags.WOODEN_SLABS)
                .unlockedBy(getHasName(Items.OAK_SLAB), has(Items.OAK_SLAB))
                .save(recipeOutput);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DisplayDelightItems.SMALL_EMPTY_PLATE, 2)
                .pattern("SS")
                .define('S', ItemTags.WOODEN_SLABS)
                .unlockedBy(getHasName(Items.OAK_SLAB), has(Items.OAK_SLAB))
                .save(recipeOutput);
    }

    @Override
    public @NotNull String getName() {
        return "Recipe Provider";
    }
}
