package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

public class BirdOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * 0.25), (entity.getDeltaMovement().y()), (entity.getLookAngle().z * 0.25)));
		if (world.getBlockState(BlockPos.containing(x, y - 5, z)).canOcclude()) {
			entity.push((entity.getDeltaMovement().x()), 0.2, (entity.getDeltaMovement().z()));
		}
		if (world.getBiome(BlockPos.containing(x, y, z)).is(ResourceLocation.parse("project_horsedimension:deep_blue"))) {
			if (!entity.level().isClientSide())
				entity.discard();
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ProjectHorsedimensionModEntities.FISH.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:bird.transform")), SoundSource.NEUTRAL, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:bird.transform")), SoundSource.NEUTRAL, 1, 1, false);
				}
			}
		}
	}
}