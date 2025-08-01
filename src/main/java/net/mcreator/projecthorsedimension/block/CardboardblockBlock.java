package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;

public class CardboardblockBlock extends Block {
	public CardboardblockBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.SCAFFOLDING).strength(1f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}