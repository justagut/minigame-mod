package com.justagut.MinigameMod.entity;


import com.justagut.MinigameMod.minigamemod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, minigamemod.MODID);

    //public static final Supplier<EntityType<MagmaBossEntity>> MAGMABOSS =
     //       ENTITY_TYPES.register("magmaboss", () -> EntityType.Builder.of(MagmaBossEntity::new,
     //               MobCategory.MONSTER).sized((float)0.5, (float) 0.5).build("magmaboss"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}