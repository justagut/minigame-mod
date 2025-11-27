package com.justagut.MinigameMod.entity.custom;


import net.minecraft.core.BlockPos;
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
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

public class BallBasics extends Monster {
    public Vec3 oldvelocity = new Vec3(0,0,0);
    public float drag = 1.09F;
    public float weight = 1.01f;
    public float bouncyness = 0.9f;

    public BallBasics(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 0;
        this.fireImmune();
    }
    @Override
    public boolean fireImmune() {
        return true;
    }
    public void weight(Float counterweight){
        weight = counterweight;
    }
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
    protected void registerGoals() {
            this.goalSelector.addGoal(1, new FloatGoal(this));
            }
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
            this.setDeltaMovement(oldvelocity.x,-oldvelocity.y*bouncyness,oldvelocity.z);
        } else if (this.horizontalCollision) {
            if (this.getDeltaMovement().x-oldvelocity.x>0.1){
                this.setDeltaMovement(-oldvelocity.x*bouncyness, oldvelocity.y, oldvelocity.z);
            } else{
                this.setDeltaMovement(oldvelocity.x, oldvelocity.y, -oldvelocity.z*bouncyness);
            }
        }
        oldvelocity = this.getDeltaMovement();
        super.tick();
        this.setDeltaMovement(getDeltaMovement().multiply(drag,weight,drag));



    }


}
