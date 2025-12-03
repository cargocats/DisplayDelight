package com.github.cargocats.init;


import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.block.Block;
import net.minecraft.entity.Entity;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.predicate.ComponentPredicate;
import net.minecraft.util.math.random.Random;
import net.minecraft.village.TradeOffer;
import net.minecraft.village.TradeOffers;
import net.minecraft.village.TradedItem;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DisplayDelightTrades {
    public static abstract class DisplayFoodItemFactory implements TradeOffers.Factory {
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

        public abstract ItemStack ForSaleItem(Entity entity, Random randomSource);

        @Override
        public @Nullable TradeOffer create(Entity entity, Random random) {
            ItemStack forSale = ForSaleItem(entity, random);
            ItemStack toBuy = new ItemStack(Items.EMERALD, this.price);
            TradedItem tradedItem = new TradedItem(toBuy.getRegistryEntry(), toBuy.getCount(), ComponentPredicate.EMPTY);

            return new TradeOffer(tradedItem, Optional.empty(), forSale, this.maxTrades, this.xp, this.priceMultiplier);
        }
    }

    public static class FoodItemFactory extends DisplayFoodItemFactory {
        public FoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            super(price, maxTrades, xp, priceMultiplier);
        }

        @Override
        public ItemStack ForSaleItem(Entity entity, Random random) {
            Block randomBlock = DisplayDelightBlocks.DISPLAYABLE_BLOCKS.get(random.nextInt(DisplayDelightBlocks.DISPLAYABLE_BLOCKS.size()));
            return new ItemStack(randomBlock.asItem());
        }
    }

    public static class SmallPlatedFoodItemFactory extends DisplayFoodItemFactory {
        public SmallPlatedFoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            super(price, maxTrades, xp, priceMultiplier);
        }

        @Override
        public ItemStack ForSaleItem(Entity entity, Random random) {
            Block randomBlock = DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.get(random.nextInt(DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.size()));
            return new ItemStack(randomBlock.asItem());
        }
    }

    public static class PlatedFoodItemFactory extends DisplayFoodItemFactory {
        public PlatedFoodItemFactory(int price, int maxTrades, int xp, float priceMultiplier) {
            super(price, maxTrades, xp, priceMultiplier);
        }

        @Override
        public ItemStack ForSaleItem(Entity entity, Random random) {
            Block randomBlock = DisplayDelightBlocks.PLATEABLE_BLOCKS.get(random.nextInt(DisplayDelightBlocks.PLATEABLE_BLOCKS.size()));
            return new ItemStack(randomBlock.asItem());
        }
    }

    public static void init() {
        TradeOfferHelper.registerWanderingTraderOffers(1, (factories) -> {
            factories.add(new DisplayDelightTrades.FoodItemFactory(2, 4, 24, 0.05f));
            factories.add(new DisplayDelightTrades.FoodItemFactory(2, 4, 24, 0.05f));
            factories.add(new DisplayDelightTrades.PlatedFoodItemFactory(2, 4, 24, 0.05F));
            factories.add(new DisplayDelightTrades.PlatedFoodItemFactory(2, 4, 24, 0.05F));
            factories.add(new DisplayDelightTrades.SmallPlatedFoodItemFactory(1, 4, 12, 0.05F));
        });
    }
}
