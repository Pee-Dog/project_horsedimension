package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class WeakCosmicNoiseBlock extends Block {
	public WeakCosmicNoiseBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.EMPTY).strength(10f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}