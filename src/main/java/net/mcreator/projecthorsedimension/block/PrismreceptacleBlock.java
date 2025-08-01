package net.mcreator.projecthorsedimension.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.level.redstone.Orientation;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.procedures.PrismreceptacleNeighbourBlockChangesProcedure;

import javax.annotation.Nullable;

public class PrismreceptacleBlock extends Block {
	public PrismreceptacleBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GLASS).strength(-1, 3600000).lightLevel(s -> 10).requiresCorrectToolForDrops());
	}

	@Override
	public boolean propagatesSkylightDown(BlockState state) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 0;
	}

	@Override
	public void neighborChanged(BlockState blockstate, Level world, BlockPos pos, Block neighborBlock, @Nullable Orientation orientation, boolean moving) {
		super.neighborChanged(blockstate, world, pos, neighborBlock, orientation, moving);
		PrismreceptacleNeighbourBlockChangesProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ());
	}
}