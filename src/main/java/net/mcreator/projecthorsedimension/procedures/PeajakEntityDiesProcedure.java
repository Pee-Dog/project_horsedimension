package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

public class PeajakEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		KillOBJsProcedure.execute(world, x, y, z);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ProjectHorsedimensionModEntities.HORSECOINCOLLECTABLE.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
	}
}