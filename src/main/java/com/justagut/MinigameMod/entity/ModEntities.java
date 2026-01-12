package com.justagut.MinigameMod.entity;


import com.justagut.MinigameMod.entity.custom.TennisBall;
import com.justagut.MinigameMod.entity.custom.TennisBallFromEntity;
import com.justagut.MinigameMod.minigamemod;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobCategory;
import net.neoforged.bus.api.IEventBus;
import net.neoforged.neoforge.registries.DeferredRegister;

import java.util.function.Supplier;

public class ModEntities {
    public static final DeferredRegister<EntityType<?>> ENTITY_TYPES =
            DeferredRegister.create(BuiltInRegistries.ENTITY_TYPE, minigamemod.MODID);

    public static final Supplier<EntityType<TennisBall>> TENNISBALL =
           ENTITY_TYPES.register("tennisball", () -> EntityType.Builder.of(TennisBall::new,
                    MobCategory.MONSTER).sized((float)0.5, (float) 0.5).build("tennisball"));
    public static final Supplier<EntityType<TennisBallFromEntity>> TENNISBALLFROMENTITY =
            ENTITY_TYPES.register("tennisballfromentity", () -> EntityType.Builder.of(TennisBallFromEntity::new,
                    MobCategory.MISC).sized((float)0.5, (float) 0.5).build("tennisballfromentity"));


    public static void register(IEventBus eventBus) {
        ENTITY_TYPES.register(eventBus);
    }
}