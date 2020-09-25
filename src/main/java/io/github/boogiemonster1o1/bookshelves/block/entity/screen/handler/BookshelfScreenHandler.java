package io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler;

import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import io.github.boogiemonster1o1.bookshelves.init.Bookshelves;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.screen.GenericContainerScreenHandler;
import net.minecraft.screen.slot.Slot;

public class BookshelfScreenHandler extends GenericContainerScreenHandler {
    public BookshelfScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, syncId, playerInventory, new SimpleInventory(18), 2);
    }

    public BookshelfScreenHandler(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        super(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, syncId, playerInventory, inventory, 2);
    }

    @Override
    public boolean canInsertIntoSlot(ItemStack stack, Slot slot) {
        return stack.getItem().isIn(Bookshelves.TAG);
    }

    public static BookshelfScreenHandler create(int syncId, PlayerInventory playerInventory) {
        return new BookshelfScreenHandler(syncId, playerInventory);
    }

    public static BookshelfScreenHandler create(int syncId, PlayerInventory playerInventory, Inventory inventory) {
        return new BookshelfScreenHandler(syncId, playerInventory, inventory);
    }
}
