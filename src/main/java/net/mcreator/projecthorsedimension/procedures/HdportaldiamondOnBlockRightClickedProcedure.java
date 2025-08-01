package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.block.state.properties.IntegerProperty;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public class HdportaldiamondOnBlockRightClickedProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		{
			int _value = Mth.nextInt(RandomSource.create(), 0, 3);
			BlockPos _pos = BlockPos.containing(x, y, z);
			BlockState _bs = world.getBlockState(_pos);
			if (_bs.getBlock().getStateDefinition().getProperty("blockstate") instanceof IntegerProperty _integerProp && _integerProp.getPossibleValues().contains(_value))
				world.setBlock(_pos, _bs.setValue(_integerProp, _value), 3);
		}
		if ((world.getBlockState(BlockPos.containing(x - 6, y - 5, z))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()
				&& (world.getBlockState(BlockPos.containing(x + 6, y - 5, z))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()
				&& (world.getBlockState(BlockPos.containing(x, y - 5, z + 6))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()
				&& (world.getBlockState(BlockPos.containing(x, y - 5, z - 6))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()) {
			world.setBlock(BlockPos.containing(x, y - 1, z), ProjectHorsedimensionModBlocks.HDPORTALCENTER.get().defaultBlockState(), 3);
		}
	}
}