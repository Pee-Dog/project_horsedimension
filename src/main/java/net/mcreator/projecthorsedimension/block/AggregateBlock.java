package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;

import com.mojang.serialization.MapCodec;

public class AggregateBlock extends FallingBlock {
	public static final MapCodec<AggregateBlock> CODEC = simpleCodec(AggregateBlock::new);

	public MapCodec<AggregateBlock> codec() {
		return CODEC;
	}

	public AggregateBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.GRAVEL).strength(0.6f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}
}