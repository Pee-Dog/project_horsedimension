package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.pathfinder.PathType;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.entity.Mob;
import net.minecraft.core.BlockPos;

public class YellowCementBlock extends Block {
	public YellowCementBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.POLISHED_DEEPSLATE).strength(1.8f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public PathType getBlockPathType(BlockState state, BlockGetter world, BlockPos pos, Mob entity) {
		return PathType.WALKABLE;
	}
}