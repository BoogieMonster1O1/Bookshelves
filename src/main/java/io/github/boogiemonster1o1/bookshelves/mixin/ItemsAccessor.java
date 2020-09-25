package io.github.boogiemonster1o1.bookshelves.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.item.Item;
import net.minecraft.item.Items;

@Mixin(Items.class)
public interface ItemsAccessor {
    @Accessor("BOOKSHELF")
    static void setBookshelf(Item item) {
        throw new AssertionError(item);
    }
}
