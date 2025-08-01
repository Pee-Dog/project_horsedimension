package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class WhiteDrywallBlock extends Block {
	public WhiteDrywallBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.BAMBOO_WOOD).strength(2f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}