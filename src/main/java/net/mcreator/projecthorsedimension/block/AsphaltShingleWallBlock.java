package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.WallBlock;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

public class AsphaltShingleWallBlock extends WallBlock {
	public AsphaltShingleWallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.POLISHED_TUFF).strength(1.8f).dynamicShape().forceSolidOn());
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.WALKABLE;
	}
}