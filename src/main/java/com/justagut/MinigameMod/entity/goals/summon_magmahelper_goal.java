package com.justagut.MinigameMod.entity.goals;

import com.justagut.MinigameMod.entity.custom.MagmaBossEntity;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.ai.goal.Goal;

import java.util.EnumSet;

public class summon_magmahelper_goal<T extends Mob> extends Goal {
    private final T mob;
    private int tickcount;



    public summon_magmahelper_goal(T mob) {
        this.mob = mob;
        this.setFlags(EnumSet.of(Flag.MOVE, Flag.LOOK));

    }

    public boolean canUse() {
        if (this.mob instanceof MagmaBossEntity magmaboss){
            return !magmaboss.doinggoal && magmaboss.selectedgoal == 3;
        }else{
            return  false;
        }
    }


    public boolean canContinueToUse() {
        return tickcount< 100;
    }
    public void start(){
        if(this.mob instanceof MagmaBossEntity magmaboss){
            magmaboss.doinggoal(true);
            System.out.println(magmaboss.doinggoal);
        }
        tickcount = 0;
    }
    public void stop(){
        if(this.mob instanceof MagmaBossEntity magmaboss){
            magmaboss.doinggoal(false);
        }
    }




    public void tick() {
        ++tickcount;
        if (tickcount== 50){
            summonhelpers();
        }
    }
    public void summonhelpers(){
        for(int i = 0; i < 3;i++){

    }
    }
}
