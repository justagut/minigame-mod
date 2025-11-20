package com.justagut.TemplateMod.event;


import com.justagut.TemplateMod.entity.ModEntities;
import com.justagut.TemplateMod.entity.client.MagmaBossModel;
import com.justagut.TemplateMod.entity.custom.MagmaBossEntity;
import com.justagut.TemplateMod.templatemod;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;

@EventBusSubscriber(modid = templatemod.MODID)
public class ModEventBusEvents {
    @SubscribeEvent
    public static void registerLayers(EntityRenderersEvent.RegisterLayerDefinitions event) {
        event.registerLayerDefinition(MagmaBossModel.LAYER_LOCATION, MagmaBossModel::createBodyLayer);
    }

    @SubscribeEvent
    public static void registerAttributes(EntityAttributeCreationEvent event) {
        event.put(ModEntities.MAGMABOSS.get(), MagmaBossEntity.createAttributes().build());
    }
}