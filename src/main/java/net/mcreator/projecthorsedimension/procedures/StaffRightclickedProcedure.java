package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.client.Minecraft;

public class StaffRightclickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (Minecraft.getInstance().options.keyUse.isDown()) {
			for (Entity entityiterator : world.getEntities(entity, new AABB((x - 2), (y - 2), (z - 2), (x + 2), (y + 2), (z + 2)))) {
				entityiterator.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getLookAngle().y), (entity.getLookAngle().z)));
			}
		}
	}
}