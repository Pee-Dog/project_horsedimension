package net.mcreator.projecthorsedimension.procedures;

import net.neoforged.neoforge.event.entity.EntityTravelToDimensionEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

import javax.annotation.Nullable;

@EventBusSubscriber
public class NoiseoverlayfadeoutprocedureProcedure {
	@SubscribeEvent
	public static void onEntityTravelToDimension(EntityTravelToDimensionEvent event) {
		execute(event, event.getDimension(), event.getEntity());
	}

	public static void execute(ResourceKey<Level> dimension, Entity entity) {
		execute(null, dimension, entity);
	}

	private static void execute(@Nullable Event event, ResourceKey<Level> dimension, Entity entity) {
		if (dimension == null || entity == null)
			return;
		if (dimension == ResourceKey.create(Registries.DIMENSION, ResourceLocation.parse("project_horsedimension:horsedimension"))) {
			{
				ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
				_vars.noiseframe = 10;
				_vars.syncPlayerVariables(entity);
			}
			new Object() {
				void timedLoop(int timedloopiterator, int timedlooptotal, int ticks) {
					{
						ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
						_vars.noiseframe = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).noiseframe - 1;
						_vars.syncPlayerVariables(entity);
					}
					final int tick2 = ticks;
					ProjectHorsedimensionMod.queueServerWork(tick2, () -> {
						if (timedlooptotal > timedloopiterator + 1) {
							timedLoop(timedloopiterator + 1, timedlooptotal, tick2);
						}
					});
				}
			}.timedLoop(0, 10, 4);
		}
	}
}