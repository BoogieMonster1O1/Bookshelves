package io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler;

import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.screen.ScreenHandlerContext;

public class BookshelfScreenHandler extends SyncedGuiDescription {
    private static final int SIZE = 18;

    public BookshelfScreenHandler(int syncId, PlayerInventory inventory, ScreenHandlerContext ctx) {
        super(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, syncId, inventory, getBlockInventory(ctx, SIZE), getBlockPropertyDelegate(ctx));
        WGridPanel root = new WGridPanel();
        this.setRootPanel(root);
        int count = 1;
        int h = 1;
        for (int i = 0; i < SIZE - 1; i++) {
            count++;
            if (count > 9) {
                count = 1;
                h++;
            }
            WItemSlot slot = WItemSlot.of(this.blockInventory, i);
            root.add(slot, count, h);
        }
        root.add(this.createPlayerInventoryPanel(), 0, 6);
        root.validate(this);
    }
}
