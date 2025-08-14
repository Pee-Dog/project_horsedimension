package net.mcreator.projecthorsedimension.entity;

import net.neoforged.neoforge.items.wrapper.EntityHandsInvWrapper;
import net.neoforged.neoforge.items.wrapper.EntityArmorInvWrapper;
import net.neoforged.neoforge.items.wrapper.CombinedInvWrapper;
import net.neoforged.neoforge.items.ItemStackHandler;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.levelgen.Heightmap;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.ServerLevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.enchantment.EnchantmentHelper;
import net.minecraft.world.item.enchantment.EnchantmentEffectComponents;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.inventory.AbstractContainerMenu;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.monster.Monster;
import net.minecraft.world.entity.animal.Animal;
import net.minecraft.world.entity.ai.goal.RandomStrollGoal;
import net.minecraft.world.entity.ai.goal.RandomLookAroundGoal;
import net.minecraft.world.entity.ai.goal.PanicGoal;
import net.minecraft.world.entity.ai.goal.OpenDoorGoal;
import net.minecraft.world.entity.ai.goal.MeleeAttackGoal;
import net.minecraft.world.entity.ai.goal.FollowParentGoal;
import net.minecraft.world.entity.ai.goal.FloatGoal;
import net.minecraft.world.entity.ai.goal.BreedGoal;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.ai.attributes.AttributeSupplier;
import net.minecraft.world.entity.SpawnPlacementTypes;
import net.minecraft.world.entity.SpawnGroupData;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.entity.AgeableMob;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.world.MenuProvider;
import net.minecraft.world.InteractionResult;
import net.minecraft.world.InteractionHand;
import net.minecraft.world.DifficultyInstance;
import net.minecraft.world.Difficulty;
import net.minecraft.sounds.SoundEvent;
import net.minecraft.server.level.ServerPlayer;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.syncher.SynchedEntityData;
import net.minecraft.network.syncher.EntityDataSerializers;
import net.minecraft.network.syncher.EntityDataAccessor;
import net.minecraft.network.chat.Component;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.nbt.CompoundTag;
import net.minecraft.core.registries.BuiltInRegistries;

import net.mcreator.projecthorsedimension.world.inventory.CowUIMenu;
import net.mcreator.projecthorsedimension.procedures.CowFarmerSleepProcedure;
import net.mcreator.projecthorsedimension.procedures.CowFarmerOnInitialEntitySpawnProcedure;
import net.mcreator.projecthorsedimension.procedures.BovineRightClickedOnEntityProcedure;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

import javax.annotation.Nullable;

import io.netty.buffer.Unpooled;

public class BovineEntity extends Animal {
	public static final EntityDataAccessor<Integer> DATA_homex = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_homey = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_homez = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Boolean> DATA_awake = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Boolean> DATA_table_loaded = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.BOOLEAN);
	public static final EntityDataAccessor<Integer> DATA_slot0 = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_slot1 = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_slot2 = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);
	public static final EntityDataAccessor<Integer> DATA_slot3 = SynchedEntityData.defineId(BovineEntity.class, EntityDataSerializers.INT);

	public BovineEntity(EntityType<BovineEntity> type, Level world) {
		super(type, world);
		xpReward = 0;
		setNoAi(false);
		this.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.COWFARMERITEM.get()));
	}

	@Override
	protected void defineSynchedData(SynchedEntityData.Builder builder) {
		super.defineSynchedData(builder);
		builder.define(DATA_homex, 0);
		builder.define(DATA_homey, 0);
		builder.define(DATA_homez, 0);
		builder.define(DATA_awake, true);
		builder.define(DATA_table_loaded, false);
		builder.define(DATA_slot0, 0);
		builder.define(DATA_slot1, 1);
		builder.define(DATA_slot2, 0);
		builder.define(DATA_slot3, 0);
	}

	@Override
	protected void registerGoals() {
		super.registerGoals();
		this.getNavigation().getNodeEvaluator().setCanOpenDoors(true);
		this.goalSelector.addGoal(1, new MeleeAttackGoal(this, 1.2, false) {
			@Override
			protected boolean canPerformAttack(LivingEntity entity) {
				return this.isTimeToAttack() && this.mob.distanceToSqr(entity) < (this.mob.getBbWidth() * this.mob.getBbWidth() + entity.getBbWidth()) && this.mob.getSensing().hasLineOfSight(entity);
			}
		});
		this.goalSelector.addGoal(2, new RandomStrollGoal(this, 1) {
			@Override
			public boolean canUse() {
				double x = BovineEntity.this.getX();
				double y = BovineEntity.this.getY();
				double z = BovineEntity.this.getZ();
				Entity entity = BovineEntity.this;
				Level world = BovineEntity.this.level();
				return super.canUse() && CowFarmerSleepProcedure.execute(world, x, y, z, entity);
			}
		});
		this.goalSelector.addGoal(3, new PanicGoal(this, 1.2));
		this.goalSelector.addGoal(4, new RandomLookAroundGoal(this) {
			@Override
			public boolean canUse() {
				double x = BovineEntity.this.getX();
				double y = BovineEntity.this.getY();
				double z = BovineEntity.this.getZ();
				Entity entity = BovineEntity.this;
				Level world = BovineEntity.this.level();
				return super.canUse() && CowFarmerSleepProcedure.execute(world, x, y, z, entity);
			}
		});
		this.goalSelector.addGoal(5, new FloatGoal(this));
		this.goalSelector.addGoal(6, new BreedGoal(this, 1));
		this.goalSelector.addGoal(7, new FollowParentGoal(this, 0.8));
		this.goalSelector.addGoal(8, new OpenDoorGoal(this, true));
	}

	@Override
	public Vec3 getPassengerRidingPosition(Entity entity) {
		return super.getPassengerRidingPosition(entity).add(0, -0.35F, 0);
	}

	@Override
	public SoundEvent getAmbientSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.cow.ambient"));
	}

	@Override
	public SoundEvent getHurtSound(DamageSource ds) {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.hurt"));
	}

	@Override
	public SoundEvent getDeathSound() {
		return BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("entity.generic.death"));
	}

	@Override
	public SpawnGroupData finalizeSpawn(ServerLevelAccessor world, DifficultyInstance difficulty, EntitySpawnReason reason, @Nullable SpawnGroupData livingdata) {
		SpawnGroupData retval = super.finalizeSpawn(world, difficulty, reason, livingdata);
		CowFarmerOnInitialEntitySpawnProcedure.execute(this);
		return retval;
	}

	private final ItemStackHandler inventory = new ItemStackHandler(9);
	private final CombinedInvWrapper combined = new CombinedInvWrapper(inventory, new EntityHandsInvWrapper(this), new EntityArmorInvWrapper(this));

	public CombinedInvWrapper getCombinedInventory() {
		return combined;
	}

	@Override
	protected void dropEquipment(ServerLevel serverLevel) {
		super.dropEquipment(serverLevel);
		for (int i = 0; i < inventory.getSlots(); ++i) {
			ItemStack itemstack = inventory.getStackInSlot(i);
			if (!itemstack.isEmpty() && !EnchantmentHelper.has(itemstack, EnchantmentEffectComponents.PREVENT_EQUIPMENT_DROP)) {
				this.spawnAtLocation(serverLevel, itemstack);
			}
		}
	}

	@Override
	public void addAdditionalSaveData(CompoundTag compound) {
		super.addAdditionalSaveData(compound);
		compound.putInt("Datahomex", this.entityData.get(DATA_homex));
		compound.putInt("Datahomey", this.entityData.get(DATA_homey));
		compound.putInt("Datahomez", this.entityData.get(DATA_homez));
		compound.putBoolean("Dataawake", this.entityData.get(DATA_awake));
		compound.putBoolean("Datatable_loaded", this.entityData.get(DATA_table_loaded));
		compound.putInt("Dataslot0", this.entityData.get(DATA_slot0));
		compound.putInt("Dataslot1", this.entityData.get(DATA_slot1));
		compound.putInt("Dataslot2", this.entityData.get(DATA_slot2));
		compound.putInt("Dataslot3", this.entityData.get(DATA_slot3));
		compound.put("InventoryCustom", inventory.serializeNBT(this.registryAccess()));
	}

	@Override
	public void readAdditionalSaveData(CompoundTag compound) {
		super.readAdditionalSaveData(compound);
		if (compound.contains("Datahomex"))
			this.entityData.set(DATA_homex, compound.getInt("Datahomex"));
		if (compound.contains("Datahomey"))
			this.entityData.set(DATA_homey, compound.getInt("Datahomey"));
		if (compound.contains("Datahomez"))
			this.entityData.set(DATA_homez, compound.getInt("Datahomez"));
		if (compound.contains("Dataawake"))
			this.entityData.set(DATA_awake, compound.getBoolean("Dataawake"));
		if (compound.contains("Datatable_loaded"))
			this.entityData.set(DATA_table_loaded, compound.getBoolean("Datatable_loaded"));
		if (compound.contains("Dataslot0"))
			this.entityData.set(DATA_slot0, compound.getInt("Dataslot0"));
		if (compound.contains("Dataslot1"))
			this.entityData.set(DATA_slot1, compound.getInt("Dataslot1"));
		if (compound.contains("Dataslot2"))
			this.entityData.set(DATA_slot2, compound.getInt("Dataslot2"));
		if (compound.contains("Dataslot3"))
			this.entityData.set(DATA_slot3, compound.getInt("Dataslot3"));
		if (compound.get("InventoryCustom") instanceof CompoundTag inventoryTag)
			inventory.deserializeNBT(this.registryAccess(), inventoryTag);
	}

	@Override
	public InteractionResult mobInteract(Player sourceentity, InteractionHand hand) {
		ItemStack itemstack = sourceentity.getItemInHand(hand);
		InteractionResult retval = InteractionResult.SUCCESS;
		if (sourceentity instanceof ServerPlayer serverPlayer) {
			serverPlayer.openMenu(new MenuProvider() {
				@Override
				public Component getDisplayName() {
					return Component.literal("Bovine");
				}

				@Override
				public AbstractContainerMenu createMenu(int id, Inventory inventory, Player player) {
					FriendlyByteBuf packetBuffer = new FriendlyByteBuf(Unpooled.buffer());
					packetBuffer.writeBlockPos(sourceentity.blockPosition());
					packetBuffer.writeByte(0);
					packetBuffer.writeVarInt(BovineEntity.this.getId());
					return new CowUIMenu(id, inventory, packetBuffer);
				}
			}, buf -> {
				buf.writeBlockPos(sourceentity.blockPosition());
				buf.writeByte(0);
				buf.writeVarInt(this.getId());
			});
		}
		super.mobInteract(sourceentity, hand);
		double x = this.getX();
		double y = this.getY();
		double z = this.getZ();
		Entity entity = this;
		Level world = this.level();

		BovineRightClickedOnEntityProcedure.execute(entity, sourceentity);
		return retval;
	}

	@Override
	public void baseTick() {
		super.baseTick();
		CowFarmerSleepProcedure.execute(this.level(), this.getX(), this.getY(), this.getZ(), this);
	}

	@Override
	public AgeableMob getBreedOffspring(ServerLevel serverWorld, AgeableMob ageable) {
		BovineEntity retval = ProjectHorsedimensionModEntities.BOVINE.get().create(serverWorld, EntitySpawnReason.BREEDING);
		retval.finalizeSpawn(serverWorld, serverWorld.getCurrentDifficultyAt(retval.blockPosition()), EntitySpawnReason.BREEDING, null);
		return retval;
	}

	@Override
	public boolean isFood(ItemStack stack) {
		return Ingredient.of(Blocks.HAY_BLOCK.asItem()).test(stack);
	}

	public static void init(RegisterSpawnPlacementsEvent event) {
		event.register(ProjectHorsedimensionModEntities.BOVINE.get(), SpawnPlacementTypes.ON_GROUND, Heightmap.Types.MOTION_BLOCKING_NO_LEAVES,
				(entityType, world, reason, pos, random) -> (world.getDifficulty() != Difficulty.PEACEFUL && Monster.isDarkEnoughToSpawn(world, pos, random) && Mob.checkMobSpawnRules(entityType, world, reason, pos, random)),
				RegisterSpawnPlacementsEvent.Operation.REPLACE);
	}

	public static AttributeSupplier.Builder createAttributes() {
		AttributeSupplier.Builder builder = Mob.createMobAttributes();
		builder = builder.add(Attributes.MOVEMENT_SPEED, 0.18);
		builder = builder.add(Attributes.MAX_HEALTH, 15);
		builder = builder.add(Attributes.ARMOR, 0);
		builder = builder.add(Attributes.ATTACK_DAMAGE, 3);
		builder = builder.add(Attributes.FOLLOW_RANGE, 16);
		builder = builder.add(Attributes.STEP_HEIGHT, 0.6);
		return builder;
	}
}