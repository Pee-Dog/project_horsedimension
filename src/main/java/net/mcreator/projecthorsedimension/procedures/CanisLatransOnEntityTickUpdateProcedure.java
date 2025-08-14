package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;

public class CanisLatransOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		world.addParticle((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.COYOTE.get()), x, (1 + y), z, 0, 0, 0);
	}
}