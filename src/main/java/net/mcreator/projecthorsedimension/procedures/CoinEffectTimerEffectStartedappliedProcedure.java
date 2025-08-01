package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;

public class CoinEffectTimerEffectStartedappliedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.HORSECOIN.get()), x, (y + 0.5), z, 1, 0.001, 0.001, 0.001, 0);
	}
}