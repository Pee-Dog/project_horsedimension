package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

public class CricketOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		if (entity.onGround()) {
			if (0 < entity.getDeltaMovement().z() || 0 < entity.getDeltaMovement().x()) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.1, (entity.getDeltaMovement().z())));
			}
		}
		if (!(world instanceof Level _lvl6 && _lvl6.isDay())) {
			if (Math.random() < 0.001) {
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(entity.getX(), entity.getY(), entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:cricket.chirp")), SoundSource.NEUTRAL, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.7, 1.3));
					} else {
						_level.playLocalSound((entity.getX()), (entity.getY()), (entity.getZ()), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:cricket.chirp")), SoundSource.NEUTRAL, 1,
								(float) Mth.nextDouble(RandomSource.create(), 0.7, 1.3), false);
					}
				}
			}
		}
	}
}