package com.justagut.MinigameMod.entity.custom;


import net.minecraft.core.BlockPos;
import net.minecraft.core.Position;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

import java.util.Objects;

public class BallBasics extends Monster {
    public Vec3 oldvelocity = new Vec3(0,0,0);
    public float drag = 0.95F;
    public float weight = 1f;
    public float bouncyness = 0.8f;
    public float gravitystrenght = 0.05f;
    public BlockPos oldpos = new BlockPos(0,1000,0);
    public BlockPos newpos = new BlockPos(0,0,0);
    public BlockPos diffpos = new BlockPos(0,0,0);
    Level level = this.level();
    public boolean xcol = false;
    public boolean zcol = false;

    public BallBasics(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 0;
        this.fireImmune();
    }
    @Override
    public boolean fireImmune() {
        return true;
    }
    public void weight(Float counterweight){weight = counterweight;}
    public void drag(Float counterdrag){
        drag = counterdrag;
    }
    public void bouncyness(Float Bouncestrength){
        bouncyness = Bouncestrength;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {

    }

    @Override
    protected void registerGoals() {this.goalSelector.addGoal(1, new FloatGoal(this));}
    @Override
    protected float getJumpPower() {
        return 0.4F; // default is around 0.42F for most mobs
    }


    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 120d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.KNOCKBACK_RESISTANCE, -20)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                ;

    }

    @Override
    public void tick() {
        if (this.verticalCollision){
            this.setDeltaMovement(oldvelocity.x,-oldvelocity.y*bouncyness - 0.01,oldvelocity.z);
        }
        if (this.horizontalCollision && oldpos!= new BlockPos(0, 1000, 0) && false) {
            newpos = this.blockPosition();
            oldpos = new BlockPos(oldpos.getX(),newpos.getY(),oldpos.getZ());
            diffpos = new BlockPos
                    (newpos.getX() - oldpos.getX(), 0, newpos.getZ() - oldpos.getZ());
            xcol = diffpos.getX() != 0 && level.getBlockState(new BlockPos(oldpos.getX(), newpos.getY(), newpos.getZ())).isSolid();
            zcol = diffpos.getZ() != 0 && level.getBlockState(new BlockPos(newpos.getX(), newpos.getY(), oldpos.getZ())).isSolid();
            if ((!xcol && !zcol) || (xcol && zcol)){
                this.setDeltaMovement(-oldvelocity.x*bouncyness,oldvelocity.y,-oldvelocity.z*bouncyness);
            }
            if (!xcol && zcol){
                this.setDeltaMovement(oldvelocity.x,-oldvelocity.y,-oldvelocity.z*bouncyness);
            }
            if (xcol && !zcol){
                this.setDeltaMovement(-oldvelocity.x*bouncyness,-oldvelocity.y,oldvelocity.z);
            }
            System.out.println("x"+ diffpos.getX() +  ",z" + diffpos.getZ());
        }
        oldvelocity = this.getDeltaMovement();
        super.tick();
        System.out.println(getDeltaMovement());
        this.setDeltaMovement(oldvelocity.multiply(drag,weight,drag));
        this.setDeltaMovement(getDeltaMovement().x,getDeltaMovement().y - gravitystrenght,getDeltaMovement().z);
        oldpos = this.blockPosition();
    }
}