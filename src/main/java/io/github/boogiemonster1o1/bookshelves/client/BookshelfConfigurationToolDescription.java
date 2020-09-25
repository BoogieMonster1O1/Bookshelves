package io.github.boogiemonster1o1.bookshelves.client;

import io.github.cottonmc.cotton.gui.client.LightweightGuiDescription;
import io.github.cottonmc.cotton.gui.widget.WGridPanel;
import io.github.cottonmc.cotton.gui.widget.WToggleButton;

public class BookshelfConfigurationToolDescription extends LightweightGuiDescription {
    public final WToggleButton blockEntityToggle = new WToggleButton();

    public BookshelfConfigurationToolDescription() {
        WGridPanel root = new WGridPanel();
        this.setRootPanel(root);
        root.add(this.blockEntityToggle, 1, 1);
        root.validate(this);
    }
}
