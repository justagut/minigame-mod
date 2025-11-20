package com.justagut.MinigameMod.item;

import com.justagut.MinigameMod.minigamemod;
import com.justagut.MinigameMod.item.custom.brickifier;
import net.minecraft.world.item.Item;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModItems {
    public static final DeferredRegister.Items ITEMS = DeferredRegister.createItems(minigamemod.MODID);

    public static final DeferredItem<Item> BISMUTH = ITEMS.register
            ("bismuth", ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> BRICKIFIER = ITEMS.register
            ("brickifier", ()-> new brickifier(new Item.Properties().durability(32)));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

