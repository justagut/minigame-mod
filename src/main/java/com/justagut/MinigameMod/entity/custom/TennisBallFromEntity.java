package com.justagut.MinigameMod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.level.Level;

public class TennisBallFromEntity extends BallPhisicsEntity{
    public TennisBallFromEntity(EntityType<?> entityType, Level level) {
        super(entityType, level);
        this.airdrag = 0.98f;
        this.grounddrag = 0.9f;
        this.bouncyness = 0.7f;
        this.weight = -0.4f;
    }


}
