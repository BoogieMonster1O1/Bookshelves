package io.github.boogiemonster1o1.bookshelves.item;

import java.util.List;

import org.jetbrains.annotations.Nullable;

import net.minecraft.client.gui.screen.Screen;
import net.minecraft.client.item.TooltipContext;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.Rarity;
import net.minecraft.world.World;

import net.fabricmc.api.EnvType;
import net.fabricmc.api.Environment;

public class BookshelfConfigurationToolItem extends Item {
    public BookshelfConfigurationToolItem(Settings settings) {
        super(settings);
    }

    @Override
    public boolean hasGlint(ItemStack stack) {
        return true;
    }

    @Environment(EnvType.CLIENT)
    @Override
    public void appendTooltip(ItemStack stack, @Nullable World world, List<Text> tooltip, TooltipContext context) {
        if (context.isAdvanced() || Screen.hasShiftDown()) {
            tooltip.add(new TranslatableText("item.bookshelves.bookshelf_configuration_tool.tooltip.title"));
            tooltip.add(new TranslatableText("item.bookshelves.bookshelf_configuration_tool.tooltip.blockEntity"));
        } else {
            tooltip.add(new TranslatableText("item.bookshelves.bookshelf_configuration_tool.tooltip.info"));
            tooltip.add(new TranslatableText("item.bookshelves.bookshelf_configuration_tool.tooltip.pressShift"));
        }
    }

    @Override
    public Rarity getRarity(ItemStack stack) {
        return Rarity.EPIC;
    }
}
