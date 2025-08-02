package com.github.cargocats.data.provider;


import com.github.cargocats.DisplayDelight;
import net.fabricmc.fabric.api.datagen.v1.FabricDataOutput;
import net.fabricmc.fabric.api.datagen.v1.provider.FabricTagProvider;
import net.minecraft.registry.RegistryWrapper;
import net.minecraft.util.Identifier;

import java.util.concurrent.CompletableFuture;

public class DDItemTagsProvider extends FabricTagProvider.ItemTagProvider {
    public DDItemTagsProvider(FabricDataOutput output, CompletableFuture<RegistryWrapper.WrapperLookup> registriesFuture) {
        super(output, registriesFuture);
    }

    @Override
    protected void configure(RegistryWrapper.WrapperLookup wrapperLookup) {
        getTagBuilder(DisplayDelight.DISPLAYABLE)
                .addOptional(farmersDelightPath("fruit_salad"))
                .addOptional(farmersDelightPath("glow_berry_custard"))
                .addOptional(farmersDelightPath("cooked_rice"))
                .addOptional(farmersDelightPath("mixed_salad"))
                .addOptional(farmersDelightPath("beef_stew"))
                .addOptional(farmersDelightPath("chicken_soup"))
                .addOptional(farmersDelightPath("vegetable_soup"))
                .addOptional(farmersDelightPath("fish_stew"))
                .addOptional(farmersDelightPath("fried_rice"))
                .addOptional(farmersDelightPath("pumpkin_soup"))
                .addOptional(farmersDelightPath("baked_cod_stew"))
                .addOptional(farmersDelightPath("noodle_soup"))
                .addOptional(farmersDelightPath("bone_broth"))
                .addOptional(farmersDelightPath("bacon_and_eggs"))
                .addOptional(farmersDelightPath("pasta_with_meatballs"))
                .addOptional(farmersDelightPath("pasta_with_mutton_chop"))
                .addOptional(farmersDelightPath("roasted_mutton_chops"))
                .addOptional(farmersDelightPath("steak_and_potatoes"))
                .addOptional(farmersDelightPath("vegetable_noodles"))
                .addOptional(farmersDelightPath("ratatouille"))
                .addOptional(farmersDelightPath("squid_ink_pasta"))
                .addOptional(farmersDelightPath("grilled_salmon"))
                .addOptional(farmersDelightPath("mushroom_rice"))
                .addOptional(farmersDelightPath("roast_chicken"))
                .addOptional(farmersDelightPath("stuffed_pumpkin"))
                .addOptional(farmersDelightPath("honey_glazed_ham"))
                .addOptional(farmersDelightPath("shepherds_pie"))
                .addOptional(farmersDelightPath("apple_cider"))
                .addOptional(farmersDelightPath("melon_juice"))
                .addOptional(farmersDelightPath("hot_cocoa"))
                .addOptional(Identifier.ofVanilla("mushroom_stew"))
                .addOptional(Identifier.ofVanilla("rabbit_stew"))
                .addOptional(Identifier.ofVanilla("beetroot_soup"))
                .addOptional(cornDelightPath("nachos_bowl"))
                .addOptional(cornDelightPath("corn_soup"))
                .addOptional(cornDelightPath("cornbread_stuffing"))
                .addOptional(cornDelightPath("creamed_corn"))
                .addOptional(cornDelightPath("creamy_corn_drink"))
                .addOptional(expandedDelightPath("asparagus_soup"))
                .addOptional(expandedDelightPath("asparagus_soup_creamy"))
                .addOptional(expandedDelightPath("asparagus_and_bacon_cheesy"))
                .addOptional(expandedDelightPath("sweet_potato_salad"))
                .addOptional(expandedDelightPath("peperonata"))
                .addOptional(expandedDelightPath("peanut_salad"))
                .addOptional(expandedDelightPath("peanut_honey_soup"))
                .addOptional(expandedDelightPath("mac_and_cheese"))
                .addOptional(expandedDelightPath("cinnamon_rice"))
                .addOptional(expandedDelightPath("cinnamon_apples"))
                .addOptional(expandedDelightPath("apple_juice"))
                .addOptional(expandedDelightPath("glow_berry_juice"))
                .addOptional(expandedDelightPath("sweet_berry_juice"))
                .addOptional(delightfulPath("matcha_ice_cream"))
                .addOptional(delightfulPath("matcha_milkshake"))
                .addOptional(delightfulPath("salmonberry_ice_cream"))
                .addOptional(delightfulPath("salmonberry_milkshake"))
                .addOptional(delightfulPath("matcha_latte"))
                .addOptional(delightfulPath("ender_nectar"))
                .addOptional(delightfulPath("berry_matcha_latte"))
                .addOptional(delightfulPath("cactus_chili"))
                .addOptional(delightfulPath("cactus_soup"))
                .addOptional(delightfulPath("field_salad"))
                .addOptional(delightfulPath("stuffed_cantaloupe"))
                .addOptional(delightfulPath("sinigang"))
                .addOptional(pineappleDelightPath("pineapple_fried_rice"))
                .addOptional(pineappleDelightPath("pineapple_ice_cream"))
                .addOptional(pineappleDelightPath("pineapple_milk_shake"))
                .addOptional(pineappleDelightPath("pineapple_juice"))
                .addOptional(oceansDelightPath("bowl_of_guardian_soup"))
                .addOptional(oceansDelightPath("braised_sea_pickle"))
                .addOptional(oceansDelightPath("seagrass_salad"))
                .addOptional(oceansDelightPath("squid_rings"))
                .addOptional(alexsDelightPath("maggot_salad"))
                .addOptional(alexsDelightPath("kangaroo_stew"))
                .addOptional(alexsDelightPath("acacia_blossom_soup"))
                .addOptional(alexsDelightPath("lobster_pasta"))
                .addOptional(alexsDelightPath("kangaroo_pasta"))
                .addOptional(culturalDelightPath("hearty_salad"))
                .addOptional(culturalDelightPath("creamed_corn"))
                .addOptional(culturalDelightPath("spicy_curry"))
                .addOptional(culturalDelightPath("fried_eggplant_pasta"))
                .addOptional(largeMealsPath("pufferfish_broth"))
                .addOptional(largeMealsPath("potato_soup"))
                .addOptional(largeMealsPath("red_soup"))
                .addOptional(largeMealsPath("tomato_egg_soup"))
                .addOptional(largeMealsPath("cod_deluxe"))
                .addOptional(largeMealsPath("hearty_lunch"))
                .addOptional(largeMealsPath("chicken_curry"))
                .addOptional(largeMealsPath("pasta_with_mushroom_sauce"))
                .addOptional(largeMealsPath("omurice"))
                .addOptional(largeMealsPath("mushroom_pot_pie"))
                .addOptional(largeMealsPath("roasted_mutton_rack"))
                .addOptional(largeMealsPath("sweet_berry_custard"))
                .addOptional(largeMealsPath("rice_pudding"))
                .addOptional(festiveDelightPath("festive_chiken"))
                .addOptional(festiveDelightPath("christmas_tea"))
                .addOptional(festiveDelightPath("salmon_verrines"))
                .addOptional(brewinAndChewinPath("fiery_fondue"))
                .addOptional(brewinAndChewinPath("scarlet_pierogi"))
                .addOptional(brewinAndChewinPath("horror_lasagna"))
                .addOptional(brewinAndChewinPath("cheesy_pasta"))
                .addOptional(brewinAndChewinPath("creamy_onion_soup"))
                .addOptional(brewinAndChewinPath("vegetable_omelet"))
                .addOptional(expandedDelightPath("cranberry_juice"))
                .addOptional(expandedDelightPath("cranberry_chicken"))
                .addOptional(expandedDelightPath("asparagus_mushroom_pasta"))
                .addOptional(expandedDelightPath("sweet_potato_casserole"))
                .addOptional(culturalDelightPath("poached_eggplants"))
                .addOptional(culturalDelightPath("eggplant_parmesan"))
                .addOptional(aquacultureDelightPath("poor_fisher_chowder"))
                .addOptional(aquacultureDelightPath("jellyfish_jelly"))
                .addOptional(aquacultureDelightPath("unusual_fish_soup"))
                .addOptional(aquacultureDelightPath("bass_stew"))
                .addOptional(aquacultureDelightPath("fish_chorba"))
                .addOptional(aquacultureDelightPath("fish_and_chips"))
                .addOptional(aquacultureDelightPath("halaszle"))
                .addOptional(aquacultureDelightPath("crispy_nori_kelp"))
                .addOptional(aquacultureDelightPath("baked_pollock_with_carrots"))
                .addOptional(aquacultureDelightPath("large_fish_with_vegetables"))
                .addOptional(aquacultureDelightPath("rollmops"))
                .addOptional(aquacultureDelightPath("tuna_spaghetti"))
                .addOptional(aquacultureDelightPath("halibut_with_tartar_sauce"))
                .addOptional(aquacultureDelightPath("buckling"))
                .addOptional(aquacultureDelightPath("turtle_meat_dish"))
                .addOptional(endersDelightPath("chorus_juice"))
                .addOptional(endersDelightPath("amberveil_stew"))
                .addOptional(endersDelightPath("amberveiled_curry"))
                .addOptional(endersDelightPath("chorus_stew"))
                .addOptional(endersDelightPath("twisted_cereal"))
                .addOptional(endersDelightPath("endermite_stew"))
                .addOptional(endersDelightPath("ender_paella"))
                .addOptional(endersDelightPath("chicken_curry"))
                .addOptional(endersDelightPath("steak_fries"))
                .addOptional(endersDelightPath("veil_of_flames_risotto"))
                .addOptional(endersDelightPath("pearl_pasta"))
                .addOptional(endersDelightPath("stuffed_shulker_bowl"))
                .addOptional(endsDelightPath("dragon_breath_and_chorus_soup"))
                .addOptional(endsDelightPath("shulker_soup"))
                .addOptional(endsDelightPath("ender_noodle"))
                .addOptional(endsDelightPath("enderman_gristle_stew"))
                .addOptional(endsDelightPath("stir_fried_shulker_meat"))
                .addOptional(endsDelightPath("roasted_dragon_steak"))
                .addOptional(endsDelightPath("end_mixed_salad"))
                .addOptional(endsDelightPath("assorted_salad"))
                .addOptional(endsDelightPath("ender_congee"))
                .addOptional(endsDelightPath("chorus_fruit_milk_tea"))
                .addOptional(endsDelightPath("chorus_fruit_wine"))
                .addOptional(endsDelightPath("bubble_tea"))
                .addOptional(endsDelightPath("dragon_breath_soda"))
                .addOptional(endsDelightPath("chorus_flower_tea"))
                .addOptional(endsDelightPath("grilled_shulker"))
                .addOptional(endsDelightPath("steamed_dragon_egg_block"))
                .addOptional(endsDelightPath("dragon_meat_stew"))
                .addOptional(endsDelightPath("steamed_dragon_egg"))
                .addOptional(endsDelightPath("dragon_leg_with_sauce"))
                .addOptional(myNethersDelightPath("sizzling_pudding"))
                .addOptional(myNethersDelightPath("rock_soup"))
                .addOptional(myNethersDelightPath("spicy_noodle_soup"))
                .addOptional(myNethersDelightPath("strider_stew"))
                .addOptional(myNethersDelightPath("ghast_salad"))
                .addOptional(myNethersDelightPath("dried_ghast_with_milk"))
                .addOptional(myNethersDelightPath("sausage_and_potatoes"))
                .addOptional(myNethersDelightPath("spicy_hoglin_stew"))
                .addOptional(myNethersDelightPath("egg_soup"))
                .addOptional(myNethersDelightPath("breakfast_sampler"))
                .addOptional(myNethersDelightPath("fried_hoglin_chop"))
                .addOptional(myNethersDelightPath("twisted_ghasta"))
                .addOptional(myNethersDelightPath("strider_with_grilled_fungus"))
                .addOptional(myNethersDelightPath("scotch_eggs"))
                .addOptional(myNethersDelightPath("giant_takoyaki"))
                .addOptional(myNethersDelightPath("blue_tenderloin_steak"))
                .addOptional(myNethersDelightPath("crimson_stroganoff"))
                .addOptional(myNethersDelightPath("spicy_curry"))
                .addOptional(myNethersDelightPath("bleeding_tartar"))
                .addOptional(myNethersDelightPath("hot_wings"))
                .addOptional(myNethersDelightPath("plate_of_ghasta_with_cream"))
                .addOptional(myNethersDelightPath("plate_of_stuffed_hoglin_snout"))
                .addOptional(myNethersDelightPath("plate_of_stuffed_hoglin_ham"))
                .addOptional(myNethersDelightPath("plate_of_stuffed_hoglin"))
                .addOptional(myNethersDelightPath("plate_of_cold_striderloaf"))
                .addOptional(myNethersDelightPath("plate_of_striderloaf"));

        getTagBuilder(DisplayDelight.PLATE_DISPLAYABLE)
                .addOptional(farmersDelightPath("melon_popsicle"))
                .addOptional(farmersDelightPath("barbecue_stick"))
                .addOptional(farmersDelightPath("egg_sandwich"))
                .addOptional(farmersDelightPath("chicken_sandwich"))
                .addOptional(farmersDelightPath("hamburger"))
                .addOptional(farmersDelightPath("dumplings"))
                .addOptional(farmersDelightPath("bacon_sandwich"))
                .addOptional(farmersDelightPath("mutton_wrap"))
                .addOptional(farmersDelightPath("stuffed_potato"))
                .addOptional(farmersDelightPath("cabbage_rolls"))
                .addOptional(farmersDelightPath("salmon_roll"))
                .addOptional(farmersDelightPath("cod_roll"))
                .addOptional(farmersDelightPath("kelp_roll"))
                .addOptional(farmersDelightPath("kelp_roll_slice"))
                .addOptional(farmersDelightPath("sweet_berry_cookie"))
                .addOptional(farmersDelightPath("honey_cookie"))
                .addOptional(Identifier.ofVanilla("pumpkin_pie"))
                .addOptional(Identifier.ofVanilla("cookie"))
                .addOptional(cornDelightPath("grilled_corn"))
                .addOptional(cornDelightPath("classic_corn_dog"))
                .addOptional(cornDelightPath("taco"))
                .addOptional(expandedDelightPath("cheese_sandwich"))
                .addOptional(expandedDelightPath("grilled_cheese"))
                .addOptional(expandedDelightPath("glow_berry_jelly_sandwich"))
                .addOptional(expandedDelightPath("sweet_berry_jelly_sandwich"))
                .addOptional(expandedDelightPath("peanut_butter_honey_sandwich"))
                .addOptional(expandedDelightPath("peanut_butter_sandwich"))
                .addOptional(expandedDelightPath("chocolate_cookie"))
                .addOptional(expandedDelightPath("sugar_cookie"))
                .addOptional(expandedDelightPath("snickerdoodle"))
                .addOptional(expandedDelightPath("glow_berry_sweet_roll"))
                .addOptional(expandedDelightPath("berry_sweet_roll"))
                .addOptional(expandedDelightPath("sweet_roll"))
                .addOptional(delightfulPath("cooked_marshmallow_stick"))
                .addOptional(delightfulPath("smore"))
                .addOptional(delightfulPath("cheeseburger"))
                .addOptional(delightfulPath("deluxe_cheeseburger"))
                .addOptional(delightfulPath("cantaloupe_popsicle"))
                .addOptional(delightfulPath("cantaloupe_bread"))
                .addOptional(delightfulPath("wrapped_cantaloupe"))
                .addOptional(delightfulPath("nut_butter_and_jelly_sandwich"))
                .addOptional(oceansDelightPath("baked_tentacle_on_a_stick"))
                .addOptional(oceansDelightPath("elder_guardian_roll"))
                .addOptional(oceansDelightPath("fugu_roll"))
                .addOptional(oceansDelightPath("honey_fried_kelp"))
                .addOptional(oceansDelightPath("cooked_stuffed_cod"))
                .addOptional(alexsDelightPath("gongylidia_bruschetta"))
                .addOptional(alexsDelightPath("bison_burger"))
                .addOptional(alexsDelightPath("bunfungus_sandwich"))
                .addOptional(culturalDelightPath("elote"))
                .addOptional(culturalDelightPath("empanada"))
                .addOptional(culturalDelightPath("beef_burrito"))
                .addOptional(culturalDelightPath("mutton_sandwich"))
                .addOptional(culturalDelightPath("eggplant_burger"))
                .addOptional(culturalDelightPath("avocado_toast"))
                .addOptional(culturalDelightPath("chicken_taco"))
                .addOptional(culturalDelightPath("pork_wrap"))
                .addOptional(culturalDelightPath("fish_taco"))
                .addOptional(culturalDelightPath("chicken_roll"))
                .addOptional(culturalDelightPath("midori_roll"))
                .addOptional(culturalDelightPath("chicken_roll_slice"))
                .addOptional(culturalDelightPath("midori_roll_slice"))
                .addOptional(culturalDelightPath("pufferfish_roll"))
                .addOptional(culturalDelightPath("tropical_roll"))
                .addOptional(culturalDelightPath("rice_ball"))
                .addOptional(culturalDelightPath("egg_roll"))
                .addOptional(culturalDelightPath("calamari_roll"))
                .addOptional(brewinAndChewinPath("ham_and_cheese_sandwich"))
                .addOptional(expandedDelightPath("cranberry_goat_cheese_toast"))
                .addOptional(aquacultureDelightPath("catfish_barbecue"))
                .addOptional(endersDelightPath("uncanny_cookies"))
                .addOptional(endersDelightPath("crispy_skewer"))
                .addOptional(endersDelightPath("strange_eclair"))
                .addOptional(endersDelightPath("crawling_sandwich"))
                .addOptional(endsDelightPath("stuffed_rice_cake"))
                .addOptional(endsDelightPath("chorus_flower_pie"))
                .addOptional(endsDelightPath("ender_bamboo_rice"))
                .addOptional(endsDelightPath("chorus_fruit_popsicle"))
                .addOptional(endsDelightPath("end_barbecue_stick"))
                .addOptional(myNethersDelightPath("stuffed_pepper"))
                .addOptional(myNethersDelightPath("hotdog_with_mixed_salad"))
                .addOptional(myNethersDelightPath("hotdog_with_nether_salad"))
                .addOptional(myNethersDelightPath("chilidog"))
                .addOptional(myNethersDelightPath("spicy_cotton"))
                .addOptional(myNethersDelightPath("fries_ghasta"))
                .addOptional(myNethersDelightPath("deviled_egg"))
                .addOptional(myNethersDelightPath("spicy_skewer"))
                .addOptional(myNethersDelightPath("red_loin_on_a_stick"))
                .addOptional(myNethersDelightPath("nether_burger"))
                .addOptional(myNethersDelightPath("burnt_roll"))
                .addOptional(myNethersDelightPath("hot_cream_cone"));

        getTagBuilder(DisplayDelight.SMALL_PLATE_DISPLAYABLE)
                .addOptional(farmersDelightPath("cake_slice"))
                .addOptional(farmersDelightPath("apple_pie_slice"))
                .addOptional(farmersDelightPath("sweet_berry_cheesecake_slice"))
                .addOptional(farmersDelightPath("chocolate_pie_slice"))
                .addOptional(farmersDelightPath("stuffed_potato"))
                .addOptional(farmersDelightPath("cabbage_rolls"))
                .addOptional(farmersDelightPath("salmon_roll"))
                .addOptional(farmersDelightPath("cod_roll"))
                .addOptional(farmersDelightPath("kelp_roll_slice"))
                .addOptional(expandedDelightPath("cheese_slice"))
                .addOptional(expandedDelightPath("glow_berry_sweet_roll"))
                .addOptional(expandedDelightPath("berry_sweet_roll"))
                .addOptional(expandedDelightPath("sweet_roll"))
                .addOptional(delightfulPath("salmonberry_pie_slice"))
                .addOptional(delightfulPath("pumpkin_pie_slice"))
                .addOptional(pineappleDelightPath("pineapple_pie_side"))
                .addOptional(oceansDelightPath("elder_guardian_roll"))
                .addOptional(oceansDelightPath("fugu_roll"))
                .addOptional(culturalDelightPath("chicken_roll_slice"))
                .addOptional(culturalDelightPath("midori_roll_slice"))
                .addOptional(culturalDelightPath("pufferfish_roll"))
                .addOptional(culturalDelightPath("tropical_roll"))
                .addOptional(culturalDelightPath("rice_ball"))
                .addOptional(culturalDelightPath("egg_roll"))
                .addOptional(culturalDelightPath("calamari_roll"))
                .addOptional(culturalDelightPath("cut_pickle"))
                .addOptional(brewinAndChewinPath("quiche_slice"))
                .addOptional(expandedDelightPath("cranberry_cobbler_slice"))
                .addOptional(expandedDelightPath("honeyed_goat_cheese_tart_slice"))
                .addOptional(aquacultureDelightPath("raw_fish_fillet_roll"))
                .addOptional(aquacultureDelightPath("fried_perch_roll"))
                .addOptional(endersDelightPath("chorus_pie_slice"))
                .addOptional(endsDelightPath("chorus_fruit_pie_slice"))
                .addOptional(myNethersDelightPath("magma_cake_slice"));
    }

    public static Identifier farmersDelightPath(String path) {
        return Identifier.of("farmersdelight", path);
    }
    
    public static Identifier myNethersDelightPath(String path) {
        return Identifier.of("mynethersdelight", path);
    }
    
    public static Identifier endsDelightPath(String path) {
        return Identifier.of("ends_delight", path);
    }

    public static Identifier endersDelightPath(String path) {
        return Identifier.of("endersdelight", path);
    }

    public static Identifier aquacultureDelightPath(String path) {
        return Identifier.of("aquaculturedelight", path);
    }
    
    public static Identifier cornDelightPath(String path) {
        return Identifier.of("corn_delight", path);
    }
    
    public static Identifier expandedDelightPath(String path) {
        return Identifier.of("expandeddelight", path);
    }

    public static Identifier delightfulPath(String path) {
        return Identifier.of("delightful", path);
    }

    public static Identifier brewinAndChewinPath(String path) {
        return Identifier.of("brewinandchewin", path);
    }

    public static Identifier festiveDelightPath(String path) {
        return Identifier.of("festive_delight", path);
    }

    public static Identifier alexsDelightPath(String path) {
        return Identifier.of("alexsdelight", path);
    }

    public static Identifier culturalDelightPath(String path) {
        return Identifier.of("culturaldelights", path);
    }

    public static Identifier largeMealsPath(String path) {
        return Identifier.of("largemeals", path);
    }

    public static Identifier pineappleDelightPath(String path) {
        return Identifier.of("pineapple_delight", path);
    }

    public static Identifier oceansDelightPath(String path) {
        return Identifier.of("oceansdelight", path);
    }
}
