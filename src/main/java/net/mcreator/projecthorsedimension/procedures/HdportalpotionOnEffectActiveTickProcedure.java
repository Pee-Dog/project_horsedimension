package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class HdportalpotionOnEffectActiveTickProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		HdportalpotionOnEffectActiveTick2Procedure.execute(entity);
		if (entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).noiseframe == 0) {
			return false;
		}
		return true;
	}
}