package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;
import net.mcreator.projecthorsedimension.entity.PeajakEntity;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class PeajakPlayerCollidesWithThisEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof PeajakEntity _datEntI ? _datEntI.getEntityData().get(PeajakEntity.DATA_stomped) : 0) == 0) {
			if (!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, (y + 1), z)).inflate(1 / 2d), e -> true).isEmpty()) {
				if (!sourceentity.onGround()) {
					ProjectHorsedimensionMod.queueServerWork(1, () -> {
						if (entity instanceof PeajakEntity _datEntSetI)
							_datEntSetI.getEntityData().set(PeajakEntity.DATA_stomped, 1);
						entity.setDeltaMovement(new Vec3(0, (entity.getDeltaMovement().y()), 0));
						PeajakBoundingBoxScaleProcedure.execute(entity);
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.stomp1")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.stomp1")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.stomp2")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.stomp2")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.PEAJAKITEM_1.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.PEAJAKITEM_1.get()));
							}
						}
						ProjectHorsedimensionMod.queueServerWork(2, () -> {
							{
								Entity _entity = entity;
								if (_entity instanceof Player _player) {
									_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.PEAJAKITEM_2.get()));
									_player.getInventory().setChanged();
								} else if (_entity instanceof LivingEntity _living) {
									_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.PEAJAKITEM_2.get()));
								}
							}
							ProjectHorsedimensionMod.queueServerWork(10, () -> {
								if (world instanceof Level _level) {
									if (!_level.isClientSide()) {
										_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.death")), SoundSource.NEUTRAL, 1, 1);
									} else {
										_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.death")), SoundSource.NEUTRAL, 1, 1, false);
									}
								}
								if (!entity.level().isClientSide())
									entity.discard();
								if (world instanceof ServerLevel _level) {
									Entity entityToSpawn = ProjectHorsedimensionModEntities.HORSECOINCOLLECTABLE.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
									if (entityToSpawn != null) {
										entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
									}
								}
							});
						});
					});
				}
			}
		}
	}
}