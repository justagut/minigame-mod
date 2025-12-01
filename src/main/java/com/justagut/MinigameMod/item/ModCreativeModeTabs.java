package com.justagut.MinigameMod.item;

import com.justagut.MinigameMod.block.ModBlocks;
import com.justagut.MinigameMod.minigamemod;
import net.minecraft.core.registries.Registries;
import net.minecraft.network.chat.Component;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.world.item.ItemStack;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModCreativeModeTabs {
    public static final DeferredRegister<CreativeModeTab> CREATIVE_MODE_TAB =
            DeferredRegister.create(Registries.CREATIVE_MODE_TAB, minigamemod.MODID);

    public static final Supplier<CreativeModeTab> BISMUTH_ITEMS_TAB =
            CREATIVE_MODE_TAB.register("general_items_tab", ()-> CreativeModeTab.builder()
                    .icon(()-> new ItemStack(ModItems.BISMUTH.get()))
                    .title(Component.translatable("creativetab.minigames.general_items"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModItems.BISMUTH);
                        output.accept(ModItems.BRICKIFIER);
                        output.accept(ModItems.TENNIS_RACKET);
                        output.accept(ModItems.PLASTIC_PLATE);
                    })
                    .build());

    public static final Supplier<CreativeModeTab> BISMUTH_BLOCKS_TAB =
            CREATIVE_MODE_TAB.register("bismuth_blocks_tab", ()-> CreativeModeTab.builder()
                    .withTabsBefore(ResourceLocation.fromNamespaceAndPath(minigamemod.MODID, "general_items_tab"))
                    .icon(()-> new ItemStack(ModBlocks.GOLD_BLACKSTONE_BRICKS.get()))
                    .title(Component.translatable("creativetab.minigames.bismuth_blocks"))
                    .displayItems((itemDisplayParameters, output) -> {
                        output.accept(ModBlocks.GOLD_BLACKSTONE_BRICKS);
                    })
                    .build());


    public static void register(IEventBus eventBus) {
        CREATIVE_MODE_TAB.register(eventBus);
    }
}
