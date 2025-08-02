package net.mcreator.projecthorsedimension.entity;

import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.monster.RangedAttackMob;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.ai.goal.target.NearestAttackableTargetGoal;
import net.minecraft.world.entity.ai.goal.target.HurtByTargetGoal;
import net.minecraft.world.entity.ai.goal.RangedAttackGoal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.Pose;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntityDimensions;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.procedures.PeajakPlayerCollidesWithThisEntityProcedure;
import net.mcreator.projecthorsedimension.procedures.PeajakOnEntityTickUpdateProcedure;
import net.mcreator.projecthorsedimension.procedures.PeajakNaturalEntitySpawningConditionProcedure;
import net.mcreator.projecthorsedimension.procedures.PeajakEntityDiesProcedure;
import net.mcreator.projecthorsedimension.procedures.PeajakBoundingBoxScaleProcedure;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

public class PeajakEntity extends Monster implements RangedAttackMob {
	public static final EntityDataAccessor<Integer> DATA_stomped = SynchedEntityData.defineId(PeajakEntity.class, EntityDataSerializers.INT);

	public PeajakEntity(EntityType<PeajakEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.MAINHAND, new ItemStack(ProjectHorsedimensionModItems.PEAJAKHANDITEM.get()));
		this.setItemSlot(EquipmentSlot.OFFHAND, new ItemStack(ProjectHorsedimensionModItems.PEAJAKHANDITEM.get()));
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.PEAJAKITEM.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_stomped, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.goalSelector.addGoal(1, new RandomStrollGoal(this, 1));
		this.targetSelector.addGoal(2, new HurtByTargetGoal(this).setAlertOthers());
		this.goalSelector.addGoal(3, new RandomLookAroundGoal(this));
		this.goalSelector.addGoal(4, new FloatGoal(this));
		this.targetSelector.addGoal(5, new NearestAttackableTargetGoal(this, Player.class, true, false));
		this.goalSelector.addGoal(1, new RangedAttackGoal(this, 1.25, 60, 10f) {
			@Override
			public boolean canContinueToUse() {
				return this.canUse();
			}
		});
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	protected void dropCustomDeathLoot(ServerLevel serverLevel, DamageSource source, boolean recentlyHitIn) {
		super.dropCustomDeathLoot(serverLevel, source, recentlyHitIn);
		this.spawnAtLocation(serverLevel, new ItemStack(ProjectHorsedimensionModItems.PEA.get()));
	}

	@Override
	public void playStepSound(BlockPos pos, BlockState blockIn) {
		this.playSound(BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.step")), 0.15f, 1);
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.stomp1"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.death"));
	}

	@Override
	public void die(DamageSource source) {
		super.die(source);
		PeajakEntityDiesProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ());
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Datastomped", this.entityData.get(DATA_stomped));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datastomped"))
			this.entityData.set(DATA_stomped, compound.getInt("Datastomped"));
	}

	@Override
	public void baseTick() {
		super.baseTick();
		PeajakOnEntityTickUpdateProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
		this.refreshDimensions();
	}

	@Override
	public void playerTouch(Player sourceentity) {
		super.playerTouch(sourceentity);
		PeajakPlayerCollidesWithThisEntityProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this, sourceentity);
	}

	@Override
	public void performRangedAttack(LivingEntity target, float flval) {
		PeajectileEntity.shoot(this, target);
	}

	@Override
	public EntityDimensions getDefaultDimensions(Pose pose) {
		Entity entity = this;
		Level world = this.level();
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		return super.getDefaultDimensions(pose).scale((float) PeajakBoundingBoxScaleProcedure.execute());
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(ProjectHorsedimensionModEntities.PEAJAK.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES, (entityType, world, reason, pos, random) -> {
			int x = pos.getX();
			int y = pos.getY();
			int z = pos.getZ();
			return PeajakNaturalEntitySpawningConditionProcedure.execute(world, x, y, z);
		}, RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.27);
		builder = builder.add(Attributes.MAX_HEALTH, 5);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 32);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}