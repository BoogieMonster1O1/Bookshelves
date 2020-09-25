package io.github.boogiemonster1o1.bookshelves.client;

import io.github.boogiemonster1o1.bookshelves.init.Bookshelves;
import io.github.cottonmc.cotton.gui.client.CottonClientScreen;
import io.netty.buffer.Unpooled;

import net.minecraft.network.PacketByteBuf;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.math.BlockPos;

import net.fabricmc.fabric.api.network.ClientSidePacketRegistry;

public class BookshelfConfigurationToolScreen extends CottonClientScreen {
    private final BlockPos pos;

    public BookshelfConfigurationToolScreen(BlockPos pos) {
        super(new TranslatableText("item.bookshelves.bookshelf_configuration_tool"), new BookshelfConfigurationToolDescription());
        this.pos = pos;
    }

    @Override
    public boolean isPauseScreen() {
        return false;
    }

    @Override
    public void onClose() {
        PacketByteBuf buf = new PacketByteBuf(Unpooled.buffer());
        buf.writeBlockPos(this.pos);
        // Block entity toggle
        buf.writeBoolean(((BookshelfConfigurationToolDescription) this.getDescription()).blockEntityToggle.getToggle());
        ClientSidePacketRegistry.INSTANCE.sendToServer(Bookshelves.CONFIG_TOOL_C2S_PACKET_ID, buf);
    }
}
