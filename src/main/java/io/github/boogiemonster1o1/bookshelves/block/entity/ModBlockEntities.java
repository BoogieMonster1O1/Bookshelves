package io.github.boogiemonster1o1.bookshelves.block.entity;

import io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler.BookshelfScreenHandler;

import net.minecraft.block.Blocks;
import net.minecraft.block.entity.BlockEntityType;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.ScreenHandlerType;
import net.minecraft.util.Identifier;
import net.minecraft.util.registry.Registry;

import net.fabricmc.fabric.api.screenhandler.v1.ScreenHandlerRegistry;

public final class ModBlockEntities {
    private ModBlockEntities() {
    }

    public static final BlockEntityType<BookshelfBlockEntity> BOOKSHELF_BLOCK_ENTITY = Registry.register(Registry.BLOCK_ENTITY_TYPE, new Identifier("bookshelves", "bookshelf"), BlockEntityType.Builder.create(BookshelfBlockEntity::new, Blocks.BOOKSHELF).build(null));
    public static final ScreenHandlerType<BookshelfScreenHandler> BOOKSHELF_SCREEN_HANDLER = ScreenHandlerRegistry.registerSimple(new Identifier("bookshelves", "bookshelf"), ((syncId, inventory) -> new BookshelfScreenHandler(syncId, inventory, ScreenHandlerContext.EMPTY)));

    public static void init() {
    }
}
