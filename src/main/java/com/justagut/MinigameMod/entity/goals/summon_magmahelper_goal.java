package com.justagut.MinigameMod.entity.goals;

import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

public class summon_magmahelper_goal<T extends Mob> extends Goal {



    public summon_magmahelper_goal(T mob) {
    }

    public boolean canUse() {
        return true;
    }


    public boolean canContinueToUse() {
        return true;
    }
    public void start(){

    }
    public void stop(){

    }

    public void tick() {
    }
}
