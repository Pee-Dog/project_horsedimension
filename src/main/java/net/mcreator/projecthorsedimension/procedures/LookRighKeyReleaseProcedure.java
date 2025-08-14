package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class LookRighKeyReleaseProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
			_vars.lookright = false;
			_vars.syncPlayerVariables(entity);
		}
	}
}