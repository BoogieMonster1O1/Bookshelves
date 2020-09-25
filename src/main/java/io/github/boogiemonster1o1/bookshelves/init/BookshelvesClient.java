package io.github.boogiemonster1o1.bookshelves.init;

import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler.BookshelfScreenHandler;
import io.github.boogiemonster1o1.bookshelves.client.BookshelfHandledScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class BookshelvesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        //doesn't compile without explicit type arguments
        //bad bad bad bad bad
        //noinspection RedundantTypeArguments
        ScreenRegistry.<BookshelfScreenHandler, BookshelfHandledScreen>register(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, (handler, playerInventory, text) -> new BookshelfHandledScreen(handler, playerInventory.player));
    }

}
