package com.github.cargocats;

import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.init.DisplayDelightEvents;
import com.github.cargocats.init.DisplayDelightItemGroup;
import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.init.compat.FarmersDelight;
import net.fabricmc.api.ModInitializer;
import net.fabricmc.loader.api.FabricLoader;
import net.minecraft.item.Item;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.tag.TagKey;
import net.minecraft.util.Identifier;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DisplayDelight implements ModInitializer {
	public static final String MOD_ID = "displaydelight";
	public static final Logger LOG = LoggerFactory.getLogger(MOD_ID);

	public static final TagKey<Item> DISPLAYABLE = TagKey.of(RegistryKeys.ITEM, DisplayDelight.id("displayable"));
	public static final TagKey<Item> PLATE_DISPLAYABLE = TagKey.of(RegistryKeys.ITEM, DisplayDelight.id("plate_displayable"));
	public static final TagKey<Item> SMALL_PLATE_DISPLAYABLE = TagKey.of(RegistryKeys.ITEM, DisplayDelight.id("small_plate_displayable"));

	@Override
	public void onInitialize() {
		if (isModLoadedOrDev("farmersdelight")) {
			FarmersDelight.init();
		}

		DisplayDelightBlocks.init();
		DisplayDelightItems.init();
		DisplayDelightEvents.init();
		DisplayDelightItemGroup.init();

		LOG.info("Initialized Display Delight");
	}

	private boolean isModLoadedOrDev(String name) {
		FabricLoader fabricLoader = FabricLoader.getInstance();
		return fabricLoader.isModLoaded(name) || fabricLoader.isDevelopmentEnvironment();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}