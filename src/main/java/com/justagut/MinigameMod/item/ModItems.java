package com.justagut.MinigameMod.item;

import com.justagut.MinigameMod.item.custom.lasergun;
import com.justagut.MinigameMod.minigamemod;
import com.justagut.MinigameMod.item.custom.brickifier;
import net.minecraft.world.item.ArmorItem;
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
    public static final DeferredItem<Item> PLASTIC_PLATE = ITEMS.register
            ("plastic_plate", ()-> new Item(new Item.Properties()));
    public static final DeferredItem<Item> TENNIS_RACKET = ITEMS.register
            ("tennis_racket", ()-> new Item(new Item.Properties().stacksTo(1)));

    public static final DeferredItem<Item> LASERGUN = ITEMS.register
            ("lasergun", ()-> new lasergun(new Item.Properties().durability(64).stacksTo(1)));


    public static final DeferredItem<ArmorItem> LASERGAME_HELMET = ITEMS.register("lasergame_helmet",
            () -> new ArmorItem(ModArmorMaterials.LASERGAME_ARMOR_MATERIAL, ArmorItem.Type.HELMET,
                    new Item.Properties().durability(ArmorItem.Type.HELMET.getDurability(19))));
    public static final DeferredItem<ArmorItem> LASERGAME_CHESTPLATE = ITEMS.register("lasergame_chestplate",
            () -> new ArmorItem(ModArmorMaterials.LASERGAME_ARMOR_MATERIAL, ArmorItem.Type.CHESTPLATE,
                    new Item.Properties().durability(ArmorItem.Type.CHESTPLATE.getDurability(19))));
    public static final DeferredItem<ArmorItem> LASERGAME_LEGGINGS = ITEMS.register("lasergame_leggings",
            () -> new ArmorItem(ModArmorMaterials.LASERGAME_ARMOR_MATERIAL, ArmorItem.Type.LEGGINGS,
                    new Item.Properties().durability(ArmorItem.Type.LEGGINGS.getDurability(19))));
    public static final DeferredItem<ArmorItem> LASERGAME_BOOTS = ITEMS.register("lasergame_boots",
            () -> new ArmorItem(ModArmorMaterials.LASERGAME_ARMOR_MATERIAL, ArmorItem.Type.BOOTS,
                    new Item.Properties().durability(ArmorItem.Type.BOOTS.getDurability(19))));

    public static void register(IEventBus eventBus) {
        ITEMS.register(eventBus);
    }
}

