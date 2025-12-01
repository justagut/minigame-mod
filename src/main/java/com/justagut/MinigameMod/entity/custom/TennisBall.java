package com.justagut.MinigameMod.entity.custom;

import net.minecraft.network.chat.Component;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.level.Level;
import net.minecraft.world.phys.Vec3;

public class TennisBall extends BallBasics{
    public TennisBall(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
    }
    public float gettinghit = 0;
    public static float tickcount;
    public Vec3 oldpos = this.position();
    public Player player = null;
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
            this.setPos(oldpos);
            ++tickcount;
            if (tickcount == 25 || !player.swinging){
                gettinghit = 1;
            }
            oldpos = this.position();
            player.sendSystemMessage(Component.literal((String.valueOf(tickcount))));
        }
        else if(gettinghit == 1){
            tickcount /= (float) 25;
            tickcount = (float)1.1-tickcount;
            this.setDeltaMovement(player.getLookAngle().multiply(tickcount,tickcount,tickcount));
            gettinghit = 0;
        }
        super.tick();
    }
}
