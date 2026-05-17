package com.github.cargocats.data.loot;

import com.mojang.serialization.Codec;
import com.mojang.serialization.MapCodec;
import com.mojang.serialization.codecs.RecordCodecBuilder;
import net.minecraft.util.RandomSource;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.ItemStackTemplate;
import net.minecraft.world.level.storage.loot.LootContext;
import net.minecraft.world.level.storage.loot.functions.LootItemConditionalFunction;
import net.minecraft.world.level.storage.loot.predicates.LootItemCondition;
import org.jspecify.annotations.NonNull;

import java.util.List;

public class RandomItemFunction extends LootItemConditionalFunction {
    public static final MapCodec<RandomItemFunction> MAP_CODEC = RecordCodecBuilder.mapCodec(
            i -> commonFields(i).and(
                    Codec.list(ItemStackTemplate.CODEC).fieldOf("item_candidate_list").forGetter(f -> f.itemCandidateList)
            ).apply(i, RandomItemFunction::new)
    );

    public final List<ItemStackTemplate> itemCandidateList;
    public RandomItemFunction(List<LootItemCondition> predicates, List<ItemStackTemplate> itemCandidateList) {
        super(predicates);
        this.itemCandidateList = itemCandidateList;
    }

    @Override
    public @NonNull MapCodec<? extends LootItemConditionalFunction> codec() {
        return MAP_CODEC;
    }

    @Override
    protected @NonNull ItemStack run(ItemStack itemStack, LootContext context) {
        RandomSource random = context.getRandom();
        ItemStackTemplate itemStackTemplate = itemCandidateList.get(random.nextInt(itemCandidateList.size()));

        return itemStack.transmuteCopy(itemStackTemplate.item().value());
    }
}
