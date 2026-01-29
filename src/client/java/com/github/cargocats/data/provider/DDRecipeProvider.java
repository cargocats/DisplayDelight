package com.github.cargocats.data.provider;

import com.github.cargocats.init.DisplayDelightItems;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricRecipeProvider;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.data.recipes.RecipeCategory;
import net.minecraft.data.recipes.ShapedRecipeBuilder;
import net.minecraft.tags.ItemTags;
import net.minecraft.world.item.Items;
import org.jetbrains.annotations.NotNull;

import java.util.function.Consumer;

public class DDRecipeProvider extends FabricRecipeProvider {
    public DDRecipeProvider(FabricDataOutput output) {
        super(output);
    }

    @Override
    public void buildRecipes(Consumer<FinishedRecipe> consumer) {
        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DisplayDelightItems.EMPTY_PLATE, 2)
                .pattern("S S")
                .pattern(" S ")
                .define('S', ItemTags.WOODEN_SLABS)
                .unlockedBy(getHasName(Items.OAK_SLAB), has(Items.OAK_SLAB))
                .save(consumer);

        ShapedRecipeBuilder.shaped(RecipeCategory.MISC, DisplayDelightItems.SMALL_EMPTY_PLATE, 2)
                .pattern("SS")
                .define('S', ItemTags.WOODEN_SLABS)
                .unlockedBy(getHasName(Items.OAK_SLAB), has(Items.OAK_SLAB))
                .save(consumer);
    }

    @Override
    public @NotNull String getName() {
        return "Recipe Provider";
    }
}
