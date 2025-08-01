package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.level.BlockAndTintGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

public class BarnhousePlanksBlock extends Block {
	public BarnhousePlanksBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.WOOD).strength(2f, 3f));
	}

	@Override
	public boolean shouldDisplayFluidOverlay(BlockState state, BlockAndTintGetter world, BlockPos pos, FluidState fluidstate) {
		return true;
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 20;
	}
}