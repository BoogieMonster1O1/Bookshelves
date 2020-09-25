package io.github.boogiemonster1o1.bookshelves.init;

import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler.BookshelfScreenHandler;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class BookshelvesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, (handler, playerInventory, text) -> new BookshelfScreen(handler, playerInventory.player));
    }

    public static class BookshelfScreen extends CottonInventoryScreen<BookshelfScreenHandler> {
        public BookshelfScreen(BookshelfScreenHandler description, PlayerEntity player) {
            super(description, player, new TranslatableText("bookshelves.screenHandler.name"));
        }
    }
}
