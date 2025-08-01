package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class NoiseoverlayfadeprocedureProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		new Object() {
			void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
				{
					ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
					_vars.noiseframe = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).noiseframe + 1;
					_vars.syncPlayerVariables(entity);
				}
				final int tick2 = ticks;
				ProjectHorsedimensionMod.queueServerWork(tick2, () -> {
					if (timedlooptotal > timedloopiterator + 1) {
						timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
					}
				});
			}
		}.timedLoop(0, 10, 5);
	}
}