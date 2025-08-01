package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;

public class BoulderPushProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().x / 10), (entity.getDeltaMovement().y()), (sourceentity.getLookAngle().z / 10)));
	}
}