package io.github.boogiemonster1o1.bookshelves.init;

import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;

import net.minecraft.client.gui.screen.ingame.GenericContainerScreen;

import net.fabricmc.api.ClientModInitializer;
import net.fabricmc.api.Environment;
import net.fabricmc.api.EnvType;
import net.fabricmc.fabric.api.client.screenhandler.v1.ScreenRegistry;

@Environment(EnvType.CLIENT)
public class BookshelvesClient implements ClientModInitializer {
    @Override
    public void onInitializeClient() {
        ScreenRegistry.register(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, GenericContainerScreen::new);
    }
}
