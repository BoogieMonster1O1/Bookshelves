package io.github.boogiemonster1o1.bookshelves.item;

import io.github.boogiemonster1o1.bookshelves.block.ModBlocks;
import io.github.boogiemonster1o1.bookshelves.mixin.ItemsAccessor;
import com.mojang.serialization.Lifecycle;

import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;

public class ModItems {
    public static final Item BOOKSHELF_ITEM = new BlockItem(ModBlocks.BOOKSHELF, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final RegistryKey<Item> BOOKSHELF_ITEM_KEY = RegistryKey.of(Registry.ITEM_KEY, new Identifier("minecraft", "bookshelf"));
    public static final Item BOOKSHELF_CONFIGURATION_TOOL = Registry.register(Registry.ITEM, new Identifier("bookshelves", "bookshelf_configuration_tool"), new BookshelfConfigurationToolItem(new FabricItemSettings().maxCount(1)));

    public static void init() {
        Registry.ITEM.set(Registry.ITEM.getRawId(Items.BOOKSHELF), BOOKSHELF_ITEM_KEY, BOOKSHELF_ITEM, Lifecycle.stable());
        ItemsAccessor.setBookshelf(BOOKSHELF_ITEM);
    }
}
