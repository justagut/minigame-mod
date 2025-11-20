package com.justagut.TemplateMod.entity;


import com.justagut.TemplateMod.entity.custom.MagmaBossEntity;
import com.justagut.TemplateMod.templatemod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, templatemod.MODID);

    public static final Supplier<EntityType<MagmaBossEntity>> MAGMABOSS =
            ENTITY_TYPES.register("magmaboss", () -> EntityType.Builder.of(MagmaBossEntity::new,
                    MobCategory.MONSTER).sized(2, 5).build("magmaboss"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}