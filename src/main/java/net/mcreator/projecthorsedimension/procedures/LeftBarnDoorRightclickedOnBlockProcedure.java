package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

public class LeftBarnDoorRightclickedOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity.getDirection()) == Direction.NORTH) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ProjectHorsedimensionModEntities.BARNDOOR.get().spawn(_level, BlockPos.containing(x, y + 1, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(360);
					entityToSpawn.setYBodyRot(360);
					entityToSpawn.setYHeadRot(360);
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
		if ((entity.getDirection()) == Direction.SOUTH) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ProjectHorsedimensionModEntities.BARNDOOR.get().spawn(_level, BlockPos.containing(x, y + 1, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(180);
					entityToSpawn.setYBodyRot(180);
					entityToSpawn.setYHeadRot(180);
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
		if ((entity.getDirection()) == Direction.WEST) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ProjectHorsedimensionModEntities.BARNDOOR.get().spawn(_level, BlockPos.containing(x, y + 1, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(90);
					entityToSpawn.setYBodyRot(90);
					entityToSpawn.setYHeadRot(90);
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
		if ((entity.getDirection()) == Direction.EAST) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ProjectHorsedimensionModEntities.BARNDOOR.get().spawn(_level, BlockPos.containing(x, y + 1, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(270);
					entityToSpawn.setYBodyRot(270);
					entityToSpawn.setYHeadRot(270);
					entityToSpawn.setDeltaMovement(0, 0, 0);
				}
			}
		}
	}
}