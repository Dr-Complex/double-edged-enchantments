package net.dr_complex.double_edged_enchantments.screen;

import net.dr_complex.double_edged_enchantments.DEE_Main;
import net.dr_complex.double_edged_enchantments.block.DEE_Blocks;
import net.minecraft.advancement.criterion.Criteria;
import net.minecraft.enchantment.Enchantment;
import net.minecraft.enchantment.EnchantmentHelper;
import net.minecraft.entity.player.PlayerEntity;
import net.minecraft.entity.player.PlayerInventory;
import net.minecraft.inventory.Inventory;
import net.minecraft.inventory.SimpleInventory;
import net.minecraft.item.ItemStack;
import net.minecraft.item.Items;
import net.minecraft.registry.DynamicRegistryManager;
import net.minecraft.registry.RegistryKeys;
import net.minecraft.registry.entry.RegistryEntry;
import net.minecraft.registry.tag.EnchantmentTags;
import net.minecraft.registry.tag.ItemTags;
import net.minecraft.screen.Property;
import net.minecraft.screen.ScreenHandler;
import net.minecraft.screen.ScreenHandlerContext;
import net.minecraft.screen.slot.Slot;
import net.minecraft.server.network.ServerPlayerEntity;
import net.minecraft.sound.SoundCategory;
import net.minecraft.sound.SoundEvents;
import net.minecraft.stat.Stats;

import java.util.ArrayList;
import java.util.List;

public class HexingTableScreenHandler extends ScreenHandler {
    private final ScreenHandlerContext context;
    private final Slot MainSlot;
    private final Slot Material_UD_Slot;
    private final Slot Material_EC_Slot;
    private List<RegistryEntry<Enchantment>> enchants;
    private final DynamicRegistryManager registryManager;
    final Property selectedEnchantment = Property.create();
    Runnable inventoryChangeListener = () -> {
    };
    private final Inventory InputInventory = new SimpleInventory(3){
        @Override
        public void markDirty() {
            super.markDirty();
            HexingTableScreenHandler.this.onContentChanged(this);
        }
    };

    public HexingTableScreenHandler(int syncId,PlayerInventory playerInventory){
        this(syncId,playerInventory,ScreenHandlerContext.EMPTY);
    }

    public HexingTableScreenHandler(int syncId, PlayerInventory playerInventory, ScreenHandlerContext context){
        super(DEE_ScreenHandlers.HEXING_TABLE_SCREEN_HANDLER,syncId);
        this.context = context;

        this.MainSlot = this.addSlot(new Slot(this.InputInventory, 0, 26, 30) {
            @Override
            public int getMaxItemCount() {
                return 1;
            }

            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isIn(ItemTags.VANISHING_ENCHANTABLE);
            }}
        );

        this.Material_EC_Slot = this.addSlot(new Slot(this.InputInventory, 1, 17, 12) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.LAPIS_LAZULI) || stack.isOf(Items.COAL) || stack.isOf(Items.CHARCOAL);
            }}
        );

        this.Material_UD_Slot = this.addSlot(new Slot(this.InputInventory, 2, 35, 12) {
            @Override
            public boolean canInsert(ItemStack stack) {
                return stack.isOf(Items.IRON_INGOT) || stack.isOf(Items.COPPER_INGOT);
            }}
        );

        this.addPlayerSlots(playerInventory, 8, 84);
        this.registryManager = playerInventory.player.getRegistryManager();

        this.setEnchants(List.of());
    }

    @Override
    public ItemStack quickMove(PlayerEntity player, int slot) {
        ItemStack itemStack = ItemStack.EMPTY;
        Slot slot2 = this.slots.get(slot);
        if (slot2.hasStack()) {
            ItemStack itemStack2 = slot2.getStack();
            itemStack = itemStack2.copy();
            if (slot == 0) {
                if (!this.insertItem(itemStack2, 3, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot == 1) {
                if (!this.insertItem(itemStack2, 3, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (slot == 2) {
                if (!this.insertItem(itemStack2, 3, 38, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemStack2.isOf(Items.LAPIS_LAZULI) || itemStack2.isOf(Items.COAL) || itemStack2.isOf(Items.CHARCOAL)) {
                if (!this.insertItem(itemStack2, 0, 3, true)) {
                    return ItemStack.EMPTY;
                }
            } else if (itemStack2.isOf(Items.IRON_INGOT) || itemStack2.isOf(Items.COPPER_INGOT)) {
                if (!this.insertItem(itemStack2, 0, 3, true)) {
                    return ItemStack.EMPTY;
                }
            } else {
                if (this.slots.getFirst().hasStack() || !this.slots.getFirst().canInsert(itemStack2)) {
                    return ItemStack.EMPTY;
                }

                ItemStack itemStack3 = itemStack2.copyWithCount(1);
                itemStack2.decrement(1);
                this.slots.getFirst().setStack(itemStack3);
            }

            if (itemStack2.isEmpty()) {
                slot2.setStack(ItemStack.EMPTY);
            } else {
                slot2.markDirty();
            }

            if (itemStack2.getCount() == itemStack.getCount()) {
                return ItemStack.EMPTY;
            }

            slot2.onTakeItem(player, itemStack2);
        }

        return itemStack;
    }

    @Override
    public boolean canUse(PlayerEntity player) {
        return canUse(this.context, player, DEE_Blocks.HEXING_TABLE);
    }

    @Override
    public void onClosed(PlayerEntity player) {
        super.onClosed(player);
        this.context.run((world, pos) -> {
            this.dropInventory(player, this.InputInventory);
            this.enchants = List.of();
        });
    }

    @Override
    public void onContentChanged(Inventory inventory) {
        if (inventory == this.InputInventory) {
            ItemStack MAIN_INPUT = this.MainSlot.getStack();
            ItemStack EC_INPUT = this.Material_EC_Slot.getStack();

            if(!MAIN_INPUT.isEmpty() && !EC_INPUT.isEmpty()){
                List<RegistryEntry<Enchantment>> List = new ArrayList<>(java.util.List.of());

                if(!EC_INPUT.isOf(Items.LAPIS_LAZULI)){
                    this.registryManager.getOptional(RegistryKeys.ENCHANTMENT).ifPresent(enchantments -> enchantments.streamEntries()
                            .filter(tag -> tag.isIn(EnchantmentTags.CURSE))
                            .filter(reference -> reference.value().isAcceptableItem(MAIN_INPUT))
                            .map(map -> RegistryEntry.of(map.value()))
                            .forEach(List::add));
                } else {
                    this.registryManager.getOptional(RegistryKeys.ENCHANTMENT).ifPresent(enchantments -> enchantments.streamEntries()
                            .filter(tag -> !tag.isIn(EnchantmentTags.CURSE))
                            .filter(reference -> reference.value().isAcceptableItem(MAIN_INPUT))
                            .map(map -> RegistryEntry.of(map.value()))
                            .forEach(List::add));
                }

                this.setEnchants(List);

                this.sendContentUpdates();
            }
        }
    }

    public Slot getMaterial_UD_Slot(){
        return this.Material_UD_Slot;
    }

    public Slot getMaterial_EC_Slot(){
        return this.Material_EC_Slot;
    }

    public void setEnchants(List<RegistryEntry<Enchantment>> enchants) {
        this.enchants = enchants;
    }

    public List<RegistryEntry<Enchantment>> getEnchants(){
        return this.enchants;
    }

    @Override
    public boolean onButtonClick(PlayerEntity player, int id) {
        if (id >= 0 && id < this.enchants.size()) {
            this.selectedEnchantment.set(id);
            return this.Update(this.enchants.get(this.selectedEnchantment.get()),player);
        } else {
            DEE_Main.LOGGER.error("{} is out of range of {}",id, this.enchants.size());
            return false;
        }
    }

    public Slot getMainSlot() {
        return null;
    }

    public void setInventoryChangeListener(Runnable inventoryChangeListener) {
        this.inventoryChangeListener = inventoryChangeListener;
    }

    private boolean Update(RegistryEntry<Enchantment> entry, PlayerEntity player) {
        ItemStack InputItem = this.MainSlot.getStack();
        ItemStack UDItem = this.Material_UD_Slot.getStack();
        ItemStack ECItem = this.Material_EC_Slot.getStack();

        if ((player.experienceLevel < 5) && !player.getAbilities().creativeMode) {
            DEE_Main.LOGGER.info("no exp | creative");
            return false;
        } else if (InputItem.getEnchantments().getLevel(entry) <= 0 && !UDItem.isOf(Items.IRON_INGOT)) {
            DEE_Main.LOGGER.info("decrease below 0");
            return false;
        } else if (InputItem.getEnchantments().getLevel(entry) >= 10 && UDItem.isOf(Items.IRON_INGOT)) {
            DEE_Main.LOGGER.info("increase above 10");
            return false;
        } else {
            this.context.run((world, blockPos) -> {
                int UDLevel;

                if (UDItem.isOf(Items.IRON_INGOT)) {
                    UDLevel = InputItem.getEnchantments().getLevel(entry) + 1;
                } else if (UDItem.isOf(Items.COPPER_INGOT)) {
                    UDLevel = InputItem.getEnchantments().getLevel(entry) - 1;
                } else {
                    UDLevel = InputItem.getEnchantments().getLevel(entry);
                }

                EnchantmentHelper.apply(InputItem, builder -> builder.add(entry, UDLevel));

                ECItem.decrementUnlessCreative(1, player);
                if (ECItem.isEmpty()) {
                    this.InputInventory.setStack(1, ItemStack.EMPTY);
                }

                UDItem.decrementUnlessCreative(1, player);
                if (UDItem.isEmpty()) {
                    this.InputInventory.setStack(2, ItemStack.EMPTY);
                }

                if (ECItem.isOf(Items.LAPIS_LAZULI)) {
                    player.incrementStat(Stats.ENCHANT_ITEM);
                } else {
                    player.incrementStat(DEE_Main.CURSED_STAT);
                }

                if (player instanceof ServerPlayerEntity serverPlayer) {
                    Criteria.ENCHANTED_ITEM.trigger(serverPlayer, InputItem, 1);
                }

                this.InputInventory.markDirty();
                this.onContentChanged(this.InputInventory);
                player.getWorld().playSound(null, player.getBlockPos(), SoundEvents.BLOCK_ENCHANTMENT_TABLE_USE, SoundCategory.BLOCKS, 1.1f, 0.1f);
            });
        }
        return true;
    }
}
