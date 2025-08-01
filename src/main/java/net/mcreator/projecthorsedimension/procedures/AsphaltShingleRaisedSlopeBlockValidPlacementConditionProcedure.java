package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.tags.BlockTags;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.BlockPos;

public class AsphaltShingleRaisedSlopeBlockValidPlacementConditionProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z) {
		if ((world.getBlockState(BlockPos.containing(x, y - 1, z))).is(BlockTags.create(ResourceLocation.parse("minecraft:stairs"))) || (world.getBlockState(BlockPos.containing(x, y - 1, z))).getBlock() == Blocks.AIR) {
			return true;
		}
		return false;
	}
}