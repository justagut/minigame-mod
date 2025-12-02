package com.justagut.MinigameMod.event;


import com.justagut.MinigameMod.entity.ModEntities;
import com.justagut.MinigameMod.entity.custom.TennisBall;
import com.justagut.MinigameMod.minigamemod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = minigamemod.MODID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TENNISBALL.get(), TennisBall.createAttributes().build());
    }
}