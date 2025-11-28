package com.justagut.MinigameMod.entity.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;

public class TennisBall extends BallBasics{
    public TennisBall(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
    public float gettinghit;
    public float tickcount;
    Player player = null;
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
    public void tick(){
        if (gettinghit == 2) {
            ++tickcount;
            if (tickcount == 40 || !player.swinging){
                gettinghit = 1;
            }
        }
        else if(gettinghit == 1){
            tickcount /= 40;
            this.setDeltaMovement(player.getLookAngle().multiply(tickcount,tickcount,tickcount));
            gettinghit = 0;
        }


    }
}
