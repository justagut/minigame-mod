package com.justagut.MinigameMod.entity.custom;

import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;

public class TennisBall extends BallBasics{
    public TennisBall(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
    @Override
    public void weight(Float counterweight) {
        super.weight(1.01f);
        //if you make this to much its gonna flyyyy up, so dont make it higher than ~1.02,
        // i didnt test this one as much
    }
    @Override
    public void drag(Float counterdrag) {
        super.drag(1.09f);
        //if you make this to much its gonna speed up, so dont make it higher than ~1.1
    }

    @Override
    public void bouncyness(Float Bouncestrength) {
        super.bouncyness(0.9f);
    }
}
