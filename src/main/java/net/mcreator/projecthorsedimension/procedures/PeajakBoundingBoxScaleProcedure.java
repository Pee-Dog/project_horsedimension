package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.PeajakEntity;

public class PeajakBoundingBoxScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		if ((entity instanceof PeajakEntity _datEntI ? _datEntI.getEntityData().get(PeajakEntity.DATA_stomped) : 0) == 1) {
			return 0.1;
		}
		return 1;
	}
}