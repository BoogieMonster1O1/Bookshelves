package io.github.boogiemonster1o1.bookshelves.client;

import io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler.BookshelfScreenHandler;
import io.github.cottonmc.cotton.gui.client.CottonInventoryScreen;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.text.TranslatableText;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

@Environment(EnvType.CLIENT)
public class BookshelfHandledScreen extends CottonInventoryScreen<BookshelfScreenHandler> {
    public BookshelfHandledScreen(BookshelfScreenHandler description, PlayerEntity player) {
        super(description, player, new TranslatableText("bookshelves.screenHandler.name"));
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }
}
