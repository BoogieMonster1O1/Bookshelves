package io.github.boogiemonster1o1.bookshelves.init;

import io.github.boogiemonster1o1.bookshelves.block.BookshelfBlock;
import io.github.boogiemonster1o1.bookshelves.block.ModBlocks;
import io.github.boogiemonster1o1.bookshelves.block.entity.ModBlockEntities;
import io.github.boogiemonster1o1.bookshelves.item.ModItems;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.item.Item;
import net.minecraft.server.MinecraftServer;
import net.minecraft.tag.Tag;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Identifier;
import net.minecraft.util.math.BlockPos;

import net.fabricmc.api.ModInitializer;
import net.fabricmc.fabric.api.network.ServerSidePacketRegistry;
import net.fabricmc.fabric.api.tag.TagRegistry;

public class Bookshelves implements ModInitializer {
    private static final Logger LOGGER = LogManager.getLogger();
    public static final Identifier CONFIG_TOOL_C2S_PACKET_ID = new Identifier("bookshelves", "bookshelf_configuration_tool_c2s");
    public static final Tag<Item> TAG = TagRegistry.item(new Identifier("bookshelves", "books"));

    @Override
    public void onInitialize() {
        LOGGER.info("Initializating Bookshelves");
        ModBlocks.init();
        ModItems.init();
        ModBlockEntities.init();
        ServerSidePacketRegistry.INSTANCE.register(CONFIG_TOOL_C2S_PACKET_ID, ((ctx, buf) -> {
            PlayerEntity player = ctx.getPlayer();
            BlockPos pos = buf.readBlockPos();
            boolean blockEntityToggle = buf.readBoolean();
            ctx.getTaskQueue().execute(() -> {
                if (((MinecraftServer) ctx.getTaskQueue()).getPlayerManager().isOperator(player.getGameProfile())) {
                    player.sendMessage(new TranslatableText("bookshelves.config.unauthorized"), false);
                } else if (player.getEntityWorld().getBlockState(pos).getBlock() instanceof BookshelfBlock) {
                    player.getEntityWorld().setBlockState(pos, player.getEntityWorld().getBlockState(pos).with(BookshelfBlock.BLOCK_ENTITY, blockEntityToggle));
                }
            });
        }));
    }
}
