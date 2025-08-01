package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.FishEntity;

public class FishModelVisualScaleProcedure {
	public static double execute(Entity entity) {
		if (entity == null)
			return 0;
		return (entity instanceof FishEntity _datEntI ? _datEntI.getEntityData().get(FishEntity.DATA_fishscale) : 0) * 0.1;
	}
}