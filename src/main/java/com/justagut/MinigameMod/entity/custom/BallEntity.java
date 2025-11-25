package com.justagut.MinigameMod.entity.custom;


import com.justagut.MinigameMod.entity.goals.summon_magmahelper_goal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;

public class BallEntity extends Monster {
    public Vec3 oldvelocity = new Vec3(0,0,0);

    public BallEntity(EntityType<? extends Monster> entityType, Level level) {
        super(entityType, level);
        this.xpReward = 0;
        this.fireImmune();
    }
    @Override
    public boolean fireImmune() {
        return true;
    }

    @Override
    protected void checkFallDamage(double y, boolean onGround, BlockState state, BlockPos pos) {

    }

    @Override
    protected float getJumpPower() {
        return 0.4F; // default is around 0.42F for most mobs
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 1d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 1D)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                ;

    }

    @Override
    public void tick() {
        if (this.verticalCollision){
            this.setDeltaMovement(oldvelocity.x,-oldvelocity.y,oldvelocity.z);
        } else if (this.horizontalCollision) {
            if (this.getDeltaMovement().x-oldvelocity.x>0.1){
                this.setDeltaMovement(-oldvelocity.x, oldvelocity.y, oldvelocity.z);
            } else{
                this.setDeltaMovement(oldvelocity.x, oldvelocity.y, -oldvelocity.z);
            }
        }
        oldvelocity = this.getDeltaMovement();
        super.tick();
    }
}
