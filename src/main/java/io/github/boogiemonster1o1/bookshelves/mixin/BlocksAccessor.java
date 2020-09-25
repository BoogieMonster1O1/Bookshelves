package io.github.boogiemonster1o1.bookshelves.mixin;

import org.spongepowered.asm.mixin.Mixin;
import org.spongepowered.asm.mixin.gen.Accessor;

import net.minecraft.block.Block;
import net.minecraft.block.Blocks;

@Mixin(Blocks.class)
public interface BlocksAccessor {
    @Accessor("BOOKSHELF")
    static void setBookshelf(Block b) {
        throw new AssertionError();
    }
}
