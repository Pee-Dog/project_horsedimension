package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;

import net.mcreator.projecthorsedimension.entity.HorsecoincollectableEntity;

public class HorsecoinAdditionalParticleExpiryConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if (!world.getEntitiesOfClass(HorsecoincollectableEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(1 / 2d), e -> true).isEmpty()) {
			return false;
		}
		return true;
	}
}