package com.github.cargocats;

import com.github.cargocats.init.DisplayDelightBlocks;
import com.github.cargocats.init.DisplayDelightEvents;
import com.github.cargocats.init.DisplayDelightItemGroup;
import com.github.cargocats.init.DisplayDelightItems;
import com.github.cargocats.init.compat.CornDelight;
import com.github.cargocats.init.compat.FarmersDelight;
import com.github.cargocats.init.compat.OceansDelight;
import com.github.cargocats.init.compat.PineappleDelight;
import net.fabricmc.api.ModInitializer;
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
		extraneousModBlocks();
		DisplayDelightBlocks.init();
		DisplayDelightItems.init();
		DisplayDelightEvents.init();
		DisplayDelightItemGroup.init();

		LOG.info("Initialized Display Delight");
	}

	private void extraneousModBlocks() {
		FarmersDelight.init();
		OceansDelight.init();
		PineappleDelight.init();
		CornDelight.init();
	}

	public static Identifier id(String path) {
		return Identifier.of(MOD_ID, path);
	}
}