package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class HorsecoincounterProcedure {
	public static String execute(Entity entity) {
		if (entity == null)
			return "";
		if (entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount > 0) {
			return (("" + entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount).replaceAll("[.00]", "")).strip();
		}
		return "0";
	}
}