package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class LookLeftKeyPressProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
			_vars.lookleft = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}