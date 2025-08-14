package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;

public class LookRighKeyPressProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		{
			ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
			_vars.lookright = true;
			_vars.syncPlayerVariables(entity);
		}
	}
}