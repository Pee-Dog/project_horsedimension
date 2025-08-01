package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

public class HorseblockOnBoneMealSuccessProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.destroyBlock(BlockPos.containing(x, y, z), false);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ProjectHorsedimensionModEntities.EQUINE.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setXRot(Mth.nextInt(RandomSource.create(), 0, 360));
				entityToSpawn.setDeltaMovement(0, 0, 0);
			}
		}
	}
}