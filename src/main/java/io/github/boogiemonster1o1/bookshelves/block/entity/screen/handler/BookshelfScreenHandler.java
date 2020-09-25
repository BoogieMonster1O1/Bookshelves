package io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler;

import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import io.github.cottonmc.cotton.gui.SyncedGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WItemSlot;

import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;

public class BookshelfScreenHandler extends SyncedGuiDescription {
    private boolean setup = false;

    public BookshelfScreenHandler(int syncId, PlayerInventory playerInventory) {
        super(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, syncId, playerInventory);
        this.setup();
    }

    public BookshelfScreenHandler(int syncId, PlayerInventory playerInventory, Inventory blockInventory) {
        super(ModBlockEntities.BOOKSHELF_SCREEN_HANDLER, syncId, playerInventory, blockInventory, null);
        this.setup();
    }

    private void setup() {
        if (this.setup) {
            throw new UnsupportedOperationException();
        }
        this.setup = true;
        WGridPanel root = new WGridPanel();
        this.setRootPanel(root);
        int count = 1;
        int h = 1;
        for (int i = 0; i < this.blockInventory.size(); i++) {
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
