package io.github.boogiemonster1o1.bookshelves.block.entity;

import java.util.Objects;

import io.github.boogiemonster1o1.bookshelves.block.BookshelfBlock;
import io.github.boogiemonster1o1.bookshelves.block.entity.screen.handler.BookshelfScreenHandler;

import net.minecraft.block.BlockState;
import net.minecraft.block.Blocks;
import net.minecraft.block.entity.ChestBlockEntity;
import net.minecraft.block.entity.LootableContainerBlockEntity;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventories;
import net.minecraft.item.ItemStack;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.text.Text;
import net.minecraft.text.TranslatableText;
import net.minecraft.util.collection.DefaultedList;

import net.fabricmc.fabric.api.block.entity.BlockEntityClientSerializable;

public class BookshelfBlockEntity extends LootableContainerBlockEntity {
    private DefaultedList<ItemStack> inventory;
    protected int viewerCount;

    public BookshelfBlockEntity() {
        super(ModBlockEntities.BOOKSHELF_BLOCK_ENTITY);
        this.inventory = DefaultedList.ofSize(18, ItemStack.EMPTY);
    }

    @Override
    public void fromTag(BlockState state, CompoundTag tag) {
        super.fromTag(state, tag);
        this.inventory = DefaultedList.ofSize(this.size(), ItemStack.EMPTY);
        if (!this.deserializeLootTable(tag)) {
            Inventories.fromTag(tag, this.inventory);
        }
    }

    public CompoundTag toTag(CompoundTag tag) {
        super.toTag(tag);
        if (!this.serializeLootTable(tag)) {
            Inventories.toTag(tag, this.inventory);
        }
        return tag;
    }

    @Override
    protected DefaultedList<ItemStack> getInvStackList() {
        return this.inventory;
    }

    @Override
    protected void setInvStackList(DefaultedList<ItemStack> itemStacks) {
        this.inventory = itemStacks;
    }

    @Override
    protected Text getContainerName() {
        return new TranslatableText("bookshelves.screenHandler.name");
    }

    @Override
    protected ScreenHandler createScreenHandler(int syncId, PlayerInventory playerInventory) {
        return BookshelfScreenHandler.create(syncId, playerInventory, this);
    }

    @Override
    public int size() {
        return 18;
    }

    @Override
    public void onOpen(PlayerEntity player) {
        if (!player.isSpectator()) {
            if (this.viewerCount < 0) {
                this.viewerCount = 0;
            }
            ++this.viewerCount;
            BlockState state = this.getCachedState();
            if (!state.get(BookshelfBlock.OPEN)) {
                this.setOpen(state, true);
            }
            this.scheduleUpdate();
        }
    }

    @Override
    public void onClose(PlayerEntity player) {
        if (!player.isSpectator()) {
            --this.viewerCount;
        }
    }

    public void tick() {
        int i = this.pos.getX();
        int j = this.pos.getY();
        int k = this.pos.getZ();
        this.viewerCount = ChestBlockEntity.countViewers(Objects.requireNonNull(this.world), this, i, j, k);
        if (this.viewerCount > 0) {
            this.scheduleUpdate();
        } else {
            BlockState state = this.getCachedState();
            if (!state.isOf(Blocks.BOOKSHELF)) {
                this.markRemoved();
                return;
            }
            if (state.get(BookshelfBlock.OPEN)) {
                this.setOpen(state, false);
            }
        }
    }

    private void scheduleUpdate() {
        if (this.world != null) {
            this.world.getBlockTickScheduler().schedule(this.getPos(), this.getCachedState().getBlock(), 5);
        } else {
            throw new UnsupportedOperationException("Can't update in a null world!");
        }
    }

    private void setOpen(BlockState state, boolean open) {
        Objects.requireNonNull(this.world).setBlockState(this.getPos(), state.with(BookshelfBlock.OPEN, open), 3);
    }
}
