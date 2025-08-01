package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public class PeajakNaturalEntitySpawningConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ProjectHorsedimensionModBlocks.ASTROTURF.get()
				|| (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == ProjectHorsedimensionModBlocks.FLOWRRING_ASTROTURF.get()) {
			return true;
		}
		return false;
	}
}