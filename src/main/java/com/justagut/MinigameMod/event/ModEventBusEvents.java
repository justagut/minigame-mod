package com.justagut.MinigameMod.event;


import com.justagut.MinigameMod.entity.ModEntities;
import com.justagut.MinigameMod.entity.client.TennisBallFromEntityModel;
import com.justagut.MinigameMod.entity.client.TennisBallModel;
import com.justagut.MinigameMod.entity.custom.TennisBall;
import com.justagut.MinigameMod.entity.custom.TennisBallFromEntity;
import com.justagut.MinigameMod.minigamemod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = minigamemod.MODID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
       event.registerLayerDefinition(TennisBallModel.LAYER_LOCATION, TennisBallModel::createBodyLayer);
       event.registerLayerDefinition(TennisBallFromEntityModel.LAYER_LOCATION, TennisBallFromEntityModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.TENNISBALL.get(), TennisBall.createAttributes().build());
    }
}