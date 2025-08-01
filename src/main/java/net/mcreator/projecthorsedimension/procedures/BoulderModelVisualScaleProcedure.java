package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.BoulderEntity;

public class BoulderModelVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return (entity instanceof BoulderEntity _datEntI ? _datEntI.getEntityData().get(BoulderEntity.DATA_rockscale) : 0) * 0.1;
	}
}