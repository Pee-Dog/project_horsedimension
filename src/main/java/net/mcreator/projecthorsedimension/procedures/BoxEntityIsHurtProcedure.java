package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.entity.BoxEntity;

public class BoxEntityIsHurtProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof BoxEntity _datEntL0 && _datEntL0.getEntityData().get(BoxEntity.DATA_carried)) == true) {
			if (entity instanceof BoxEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BoxEntity.DATA_carried, false);
			entity.setDeltaMovement(new Vec3((sourceentity.getLookAngle().x * 0.5), (sourceentity.getLookAngle().y * 0.5), (sourceentity.getLookAngle().z * 0.5)));
			entity.setNoGravity(false);
		} else {
			if (world instanceof ServerLevel _level)
				_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.CARDBOARDBITS.get()), x, y, z, 3, 0.5, 0.5, 0.5, 1);
		}
	}
}