package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.entity.PeajakEntity;

public class PeajakOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof PeajakEntity) {
			if (Math.random() < 0.001) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.hop")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:peajak.hop")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), (entity.getDeltaMovement().y() + 0.4), (entity.getDeltaMovement().z())));
			}
		}
		if (world instanceof Level _lvl6 && _lvl6.isDay()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsedimension.despawn")), SoundSource.AMBIENT, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsedimension.despawn")), SoundSource.AMBIENT, 1, 1, false);
				}
			}
			if (!entity.level().isClientSide())
				entity.discard();
		}
	}
}