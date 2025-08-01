package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class HorsecoincountDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount >= 1) {
			return true;
		}
		return false;
	}
}