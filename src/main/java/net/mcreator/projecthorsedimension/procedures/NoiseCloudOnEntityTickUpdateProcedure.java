package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.item.FallingBlockEntity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public class NoiseCloudOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.NOISEPARTICLE.get()), x, y, z, 1, 3, 3, 3, 0);
		if (Math.random() < 0.001) {
			if (world instanceof ServerLevel _level)
				FallingBlockEntity.fall(_level, BlockPos.containing(x + Mth.nextDouble(RandomSource.create(), -3, 3), y + 2, z + Mth.nextDouble(RandomSource.create(), -3, 3)), ProjectHorsedimensionModBlocks.STATIC_RESIDUE.get().defaultBlockState());
		}
	}
}