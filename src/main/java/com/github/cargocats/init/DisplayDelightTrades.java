package com.github.cargocats.init;


import net.fabricmc.fabric.api.object.builder.v1.trade.TradeOfferHelper;
import net.minecraft.core.component.DataComponentPredicate;
import net.minecraft.util.RandomSource;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.npc.VillagerTrades;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.ItemCost;
import net.minecraft.world.item.trading.MerchantOffer;
import net.minecraft.world.level.block.Block;
import org.jetbrains.annotations.Nullable;

import java.util.Optional;

public class DisplayDelightTrades {
    public static abstract class DisplayFoodItemFactory implements VillagerTrades.ItemListing {
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
        public @Nullable MerchantOffer getOffer(Entity entity, RandomSource random) {
            ItemStack forSale = ForSaleItem(entity, random);
            ItemStack toBuy = new ItemStack(Items.EMERALD, this.price);
            ItemCost tradedItem = new ItemCost(toBuy.getItemHolder(), toBuy.getCount(), DataComponentPredicate.EMPTY);

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
        TradeOfferHelper.registerWanderingTraderOffers(1, (factories) -> {
            factories.add(new DisplayDelightTrades.FoodItemFactory(2, 4, 24, 0.05f));
            factories.add(new DisplayDelightTrades.FoodItemFactory(2, 4, 24, 0.05f));
            factories.add(new DisplayDelightTrades.PlatedFoodItemFactory(2, 4, 24, 0.05F));
            factories.add(new DisplayDelightTrades.PlatedFoodItemFactory(2, 4, 24, 0.05F));
            factories.add(new DisplayDelightTrades.SmallPlatedFoodItemFactory(1, 4, 12, 0.05F));
        });
    }
}
