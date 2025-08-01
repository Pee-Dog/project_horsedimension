package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

public class HdportalpotionEffectStartedappliedProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		NoiseoverlayfadeprocedureProcedure.execute(entity);
	}
}