package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.BirdEntity;

public class BirdrestProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof BirdEntity _datEntL0 && _datEntL0.getEntityData().get(BirdEntity.DATA_flying)) == false) {
			return true;
		}
		return false;
	}
}