package com.justagut.MinigameMod.entity.custom;


import com.justagut.MinigameMod.entity.goals.summon_magmahelper_goal;
import net.minecraft.core.BlockPos;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.entity.AnimationState;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.MobSpawnType;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.projectile.Fireball;
import net.minecraft.world.level.Level;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.phys.Vec3;
import org.jetbrains.annotations.Nullable;

import static java.lang.Math.abs;

public class MagmaBossEntity extends Monster {
    public final AnimationState idleAnimationState = new AnimationState();
    public final AnimationState walkAnimationState = new AnimationState();
    private int idleAnimationTimeout = 0;
    public boolean doinggoal = false;
    public int selectedgoal = 0;
    public Vec3 oldvelocity = new Vec3(0,0,0);

    public MagmaBossEntity(EntityType<? extends Monster> entityType, Level level) {
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
    public void doinggoal(boolean value) {
        doinggoal = value;
    }

    @Override
    protected void registerGoals() {
            this.goalSelector.addGoal(1, new summon_magmahelper_goal<>(this));
            this.goalSelector.addGoal(2, new MeleeAttackGoal(this, 1.0D, true));
            this.targetSelector.addGoal(2, new NearestAttackableTargetGoal<>(this, Player.class, false));
    }
    @Override
    protected float getJumpPower() {
        return 0.4F; // default is around 0.42F for most mobs
    }

    @Override
    public boolean hurt(DamageSource source, float amount) {
        // check if the damage is caused by a fireball (any Fireball subclass)
        if (source.getDirectEntity() instanceof Fireball) {
            return false; // cancel damage completely
        }

        // otherwise, handle damage normally
        return super.hurt(source, amount);
    }

    public static AttributeSupplier.Builder createAttributes() {
        return Animal.createLivingAttributes()
                .add(Attributes.MAX_HEALTH, 120d)
                .add(Attributes.MOVEMENT_SPEED, 0.25D)
                .add(Attributes.FOLLOW_RANGE, 24D)
                .add(Attributes.KNOCKBACK_RESISTANCE, 0.8D)
                .add(Attributes.ATTACK_DAMAGE, 5D)
                .add(Attributes.ATTACK_KNOCKBACK, 1D)
                ;

    }





    private void setupAnimationStates() {
        if(this.idleAnimationTimeout <= 0) {
            this.idleAnimationTimeout = 80;
            this.idleAnimationState.start(this.tickCount);
        } else {
            --this.idleAnimationTimeout;
        }
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
        if (doinggoal){
            selectedgoal = 0;
        }
        else {
            selectedgoal = (int)Math.floor(Math.random() * 4 +1);
        }

        if(this.level().isClientSide()) {
            this.setupAnimationStates();
        }
        if (getDeltaMovement().horizontalDistanceSqr() > 1.0E-6D) {
            // start animation if not already running
            if (walkAnimationState.isStarted()) {
                walkAnimationState.start(tickCount);
            }
        } else {
            // stop animation if the entity stops walking
            walkAnimationState.stop();
        }
    }

    @Override
    public @Nullable SpawnGroupData finalizeSpawn(ServerLevelAccessor level, DifficultyInstance difficulty, MobSpawnType spawnType, @Nullable SpawnGroupData spawnGroupData) {
        this.setDeltaMovement(1,1,1);
        return super.finalizeSpawn(level, difficulty, spawnType, spawnGroupData);
    }
}
