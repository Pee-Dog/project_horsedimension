package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMobEffects;

public class PeaOverlayDisplayOverlayIngameProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if (entity instanceof LivingEntity _livEnt0 && _livEnt0.hasEffect(ProjectHorsedimensionModMobEffects.PEAD_ON)) {
			return true;
		}
		return false;
	}
}