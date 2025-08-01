package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class DoorPushProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (Minecraft.getInstance().options.keyShift.isDown()) {
			entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().z / 10), (entity.getDeltaMovement().y()), (sourceentity.getLookAngle().x / 10)));
		} else {
			entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().z / (-10)), (entity.getDeltaMovement().y()), (sourceentity.getLookAngle().x / (-10))));
		}
	}
}