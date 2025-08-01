package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

public class PeadOnEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		PeaOverlayDisplayOverlayIngameProcedure.execute(entity);
	}
}