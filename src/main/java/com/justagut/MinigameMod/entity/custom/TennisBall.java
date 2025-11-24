package com.justagut.MinigameMod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class TennisBall extends BallBasics{
    public TennisBall(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
}
