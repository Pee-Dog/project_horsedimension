package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.animal.horse.Horse;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public class HorseWalksOnBlockProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof Horse) {
			if ((world.getBlockState(BlockPos.containing(x - 6, y + 2, z))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()
					&& (world.getBlockState(BlockPos.containing(x + 6, y + 2, z))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()
					&& (world.getBlockState(BlockPos.containing(x, y + 2, z + 6))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()
					&& (world.getBlockState(BlockPos.containing(x, y + 2, z - 6))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()) {
				world.setBlock(BlockPos.containing(x, y + 6, z), ProjectHorsedimensionModBlocks.HDPORTALCENTER.get().defaultBlockState(), 3);
				world.setBlock(BlockPos.containing(x, y + 7, z), ProjectHorsedimensionModBlocks.HDPORTALDIAMOND.get().defaultBlockState(), 3);
				if (!entity.level().isClientSide())
					entity.discard();
			}
		}
	}
}