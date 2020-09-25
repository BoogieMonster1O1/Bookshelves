package io.github.boogiemonster1o1.bookshelves.block;

import io.github.boogiemonster1o1.bookshelves.mixin.BlocksAccessor;
import io.github.boogiemonster1o1.bookshelves.mixin.ItemsAccessor;
import com.mojang.serialization.Lifecycle;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;
import net.minecraft.item.BlockItem;
import net.minecraft.item.Item;
import net.minecraft.item.ItemGroup;
import net.minecraft.item.Items;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;
import net.minecraft.util.registry.RegistryKey;

import net.fabricmc.fabric.api.item.v1.FabricItemSettings;
import net.fabricmc.fabric.api.object.builder.v1.block.FabricBlockSettings;

/**
 * Overwrites the bookshelf block and item
 * @author BoogieMonster1O1
 */
public class ModBlocksNItems {
    public static final Block BOOKSHELF = new BookshelfBlock(FabricBlockSettings.copyOf(Blocks.BOOKSHELF));
    public static final RegistryKey<Block> BOOKSHELF_KEY = RegistryKey.of(Registry.BLOCK_KEY, new Identifier("minecraft", "bookshelf"));
    public static final Item BOOKSHELF_ITEM = new BlockItem(BOOKSHELF, new FabricItemSettings().group(ItemGroup.BUILDING_BLOCKS));
    public static final RegistryKey<Item> BOOKSHELF_ITEM_KEY = RegistryKey.of(Registry.ITEM_KEY, new Identifier("minecraft", "bookshelf"));

    public static void init() {
        Registry.BLOCK.set(Registry.BLOCK.getRawId(Blocks.BOOKSHELF), BOOKSHELF_KEY, BOOKSHELF, Lifecycle.stable());
        BlocksAccessor.setBookshelf(BOOKSHELF);
        Registry.ITEM.set(Registry.ITEM.getRawId(Items.BOOKSHELF), BOOKSHELF_ITEM_KEY, BOOKSHELF_ITEM, Lifecycle.stable());
        ItemsAccessor.setBookshelf(BOOKSHELF_ITEM);
    }
}
