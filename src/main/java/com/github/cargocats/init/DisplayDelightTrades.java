package com.github.cargocats.init;


import com.github.cargocats.DisplayDelight;
import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.core.component.DataComponentExactPredicate;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.entity.npc.villager.VillagerTrades.ItemListing;
import org.jspecify.annotations.NonNull;
import org.jspecify.annotations.Nullable;

import java.util.Optional;

public class DisplayDelightTrades {
    public static abstract class DisplayFoodItemFactory implements ItemListing {
        protected final int price;
        protected final int maxTrades;
        protected final int xp;
        protected final float priceMultiplier;

        protected DisplayFoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            this.price = price;
            this.maxTrades = maxTrades;
            this.xp = xp;
            this.priceMultiplier = priceMultiplier;
        }

        public abstract ItemStack ForSaleItem(Entity entity, RandomSource randomSource);

        @Override
        public @Nullable MerchantOffer getOffer(@NonNull ServerLevel serverLevel, @NonNull Entity entity, @NonNull RandomSource randomSource) {
            ItemStack forSale = ForSaleItem(entity, randomSource);
            ItemStack toBuy = new ItemStack(Items.EMERALD, this.price);
            ItemCost tradedItem = new ItemCost(toBuy.getItemHolder(), toBuy.getCount(), DataComponentExactPredicate.EMPTY);

            return new MerchantOffer(tradedItem, Optional.empty(), forSale, this.maxTrades, this.xp, this.priceMultiplier);
        }
    }

    public static class FoodItemFactory extends DisplayFoodItemFactory {
        public FoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            super(price, maxTrades, xp, priceMultiplier);
        }

        @Override
        public ItemStack ForSaleItem(Entity entity, RandomSource random) {
            Block randomBlock = DisplayDelightBlocks.DISPLAYABLE_BLOCKS.get(random.nextInt(DisplayDelightBlocks.DISPLAYABLE_BLOCKS.size()));
            return new ItemStack(randomBlock.asItem());
        }
    }

    public static class SmallPlatedFoodItemFactory extends DisplayFoodItemFactory {
        public SmallPlatedFoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            super(price, maxTrades, xp, priceMultiplier);
        }

        @Override
        public ItemStack ForSaleItem(Entity entity, RandomSource random) {
            Block randomBlock = DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.get(random.nextInt(DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.size()));
            return new ItemStack(randomBlock.asItem());
        }
    }

    public static class PlatedFoodItemFactory extends DisplayFoodItemFactory {
        public PlatedFoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            super(price, maxTrades, xp, priceMultiplier);
        }

        @Override
        public ItemStack ForSaleItem(Entity entity, RandomSource random) {
            Block randomBlock = DisplayDelightBlocks.PLATEABLE_BLOCKS.get(random.nextInt(DisplayDelightBlocks.PLATEABLE_BLOCKS.size()));
            return new ItemStack(randomBlock.asItem());
        }
    }

    public static void init() {
        TradeOfferHelper.registerWanderingTraderOffers(factory -> factory.addAll(
                DisplayDelight.id("display_delight"),
                new DisplayDelightTrades.FoodItemFactory(2, 4, 24, 0.05f),
                new DisplayDelightTrades.FoodItemFactory(2, 4, 24, 0.05f),
                new DisplayDelightTrades.PlatedFoodItemFactory(2, 4, 24, 0.05F),
                new DisplayDelightTrades.PlatedFoodItemFactory(2, 4, 24, 0.05F),
                new DisplayDelightTrades.SmallPlatedFoodItemFactory(2, 4, 24, 0.05F)
        ));
    }
}
