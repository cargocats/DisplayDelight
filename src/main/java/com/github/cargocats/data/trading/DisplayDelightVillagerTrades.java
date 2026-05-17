package com.github.cargocats.data.trading;

import com.github.cargocats.DisplayDelight;
import com.github.cargocats.data.loot.RandomItemFunction;
import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.init.DisplayDelightItems;
import net.minecraft.core.registries.Registries;
import net.minecraft.data.worldgen.BootstrapContext;
import net.minecraft.resources.ResourceKey;
import net.minecraft.tags.TagKey;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.item.Items;
import net.minecraft.world.item.trading.TradeCost;
import net.minecraft.world.item.trading.TradeSet;
import net.minecraft.world.item.trading.VillagerTrade;
import net.minecraft.world.level.storage.loot.providers.number.UniformGenerator;

import java.util.List;
import java.util.Optional;

public class DisplayDelightVillagerTrades {
    // Trade Sets
    public static final ResourceKey<TradeSet> WANDERING_TRADER_FOOD_TRADE_SET = ResourceKey.create(Registries.TRADE_SET, DisplayDelight.id("wandering_trader_food_trade_set"));
    public static final TagKey<VillagerTrade> WANDERING_TRADER_FOOD_TAG_KEY = TagKey.create(Registries.VILLAGER_TRADE, DisplayDelight.id("wandering_trader_food_trade_tag_key"));
    // Trades
    public static final ResourceKey<VillagerTrade> RANDOM_DISPLAYABLE_FOOD = ResourceKey.create(Registries.VILLAGER_TRADE, DisplayDelight.id("random_displayable_food"));
    public static final ResourceKey<VillagerTrade> RANDOM_STACKABLE_FOOD = ResourceKey.create(Registries.VILLAGER_TRADE, DisplayDelight.id("random_stackable_food"));
    public static final ResourceKey<VillagerTrade> RANDOM_SMALL_STACKABLE_FOOD = ResourceKey.create(Registries.VILLAGER_TRADE, DisplayDelight.id("random_small_stackable_food"));

    public static void bootstrapTradeSet(BootstrapContext<TradeSet> context) {
        context.register(DisplayDelightVillagerTrades.WANDERING_TRADER_FOOD_TRADE_SET, new TradeSet(
                context.lookup(Registries.VILLAGER_TRADE).getOrThrow(WANDERING_TRADER_FOOD_TAG_KEY),
                UniformGenerator.between(1.0f, 3.0f),
                false,
                Optional.empty()
        ));
    }

    public static void bootstrapVillagerTrades(BootstrapContext<VillagerTrade> context) {
        context.register(DisplayDelightVillagerTrades.RANDOM_DISPLAYABLE_FOOD, new VillagerTrade(
                new TradeCost(Items.EMERALD, UniformGenerator.between(4.0f, 8.0f)),
                new ItemStackTemplate(DisplayDelightItems.EMPTY_PLATE, 1),
                2,
                10,
                0.1f,
                Optional.empty(),
                List.of(new RandomItemFunction(List.of(), DisplayDelightBlocks.DISPLAYABLE_BLOCKS.stream().map(b -> new ItemStackTemplate(b.asItem())).toList()))
        ));

        context.register(DisplayDelightVillagerTrades.RANDOM_STACKABLE_FOOD, new VillagerTrade(
                new TradeCost(Items.EMERALD, UniformGenerator.between(2.0f, 4.0f)),
                new ItemStackTemplate(DisplayDelightItems.EMPTY_PLATE, 1),
                3,
                8,
                0.2f,
                Optional.empty(),
                List.of(new RandomItemFunction(List.of(), DisplayDelightBlocks.PLATEABLE_BLOCKS.stream().map(b -> new ItemStackTemplate(b.asItem())).toList()))
        ));

        context.register(DisplayDelightVillagerTrades.RANDOM_SMALL_STACKABLE_FOOD, new VillagerTrade(
                new TradeCost(Items.EMERALD, UniformGenerator.between(1.0f, 3.0f)),
                new ItemStackTemplate(DisplayDelightItems.SMALL_EMPTY_PLATE, 1),
                4,
                6,
                0.4f,
                Optional.empty(),
                List.of(new RandomItemFunction(List.of(), DisplayDelightBlocks.SMALL_PLATEABLE_BLOCKS.stream().map(b -> new ItemStackTemplate(b.asItem())).toList()))
        ));
    }
}
