package net.mcreator.projecthorsedimension.procedures;

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
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class PeajakStompProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		ProjectHorsedimensionMod.queueServerWork(0, () -> {
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
					if (world instanceof ServerLevel _level)
						_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.PEABITS.get()), x, y, z, 5, 0.5, 0.5, 0.5, 1);
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = ProjectHorsedimensionModEntities.HORSECOINCOLLECTABLE.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setDeltaMovement(0, 0, 0);
						}
					}
				});
			});
		});
	}
}