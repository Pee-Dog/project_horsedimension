package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.EquineEntity;

public class BunnyOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity.onGround()) {
			if (0 < entity.getDeltaMovement().z() || 0 < entity.getDeltaMovement().x()) {
				entity.setDeltaMovement(new Vec3((entity.getDeltaMovement().x()), 0.5, (entity.getDeltaMovement().z())));
			}
		}
		if (!world.getEntitiesOfClass(EquineEntity.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(1 / 2d), e -> true).isEmpty()) {
			BunnyEntityDiesProcedure.execute(world, x, y, z, entity);
		}
	}
}