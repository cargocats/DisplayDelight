package com.github.cargocats.init.mixins;

import com.github.cargocats.data.trading.DisplayDelightVillagerTrades;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.npc.villager.AbstractVillager;
import net.minecraft.world.entity.npc.wanderingtrader.WanderingTrader;
import net.minecraft.world.item.trading.MerchantOffers;
import net.minecraft.world.level.Level;
import org.spongepowered.asm.mixin.Debug;
import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.injection.At;
import org.spongepowered.asm.mixin.injection.Inject;
import org.spongepowered.asm.mixin.injection.callback.CallbackInfo;

@Debug(export = true)
@Mixin(WanderingTrader.class)
public abstract class WanderingTraderMixin extends AbstractVillager {
    public WanderingTraderMixin(EntityType<? extends AbstractVillager> type, Level level) {
        super(type, level);
    }

    @Inject(method = "updateTrades", at = @At("TAIL"))
    private void updateTrades(final ServerLevel level, final CallbackInfo ci) {
        MerchantOffers offers = this.getOffers();
        this.addOffersFromTradeSet(level, offers, DisplayDelightVillagerTrades.WANDERING_TRADER_FOOD_TRADE_SET);
    }
}
