package io.github.boogiemonster1o1.bookshelves.init;

import io.github.boogiemonster1o1.bookshelves.block.ModBlocksNItems;
import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.item.Item;
import net.minecraft.tag.Tag;
import net.minecraft.util.Identifier;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.tag.TagRegistry;

public class Bookshelves implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final Tag<Item> TAG = TagRegistry.item(new Identifier("bookshelves", "books"));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializating Bookshelves");
        ModBlocksNItems.init();
        ModBlockEntities.init();
    }
}
