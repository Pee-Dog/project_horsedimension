package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class HdportalpotionOnEffectActiveTick2Procedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).noiseframe;
	}
}