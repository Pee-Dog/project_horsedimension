package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;

public class CowFarmerRightClickedOnEntityProcedure {
	public static Entity execute(LevelAccessor world) {
		return world instanceof Level _level ? ProjectHorsedimensionModEntities.COW_HEAD.get().create(_level, EntitySpawnReason.EVENT) : null;
	}
}