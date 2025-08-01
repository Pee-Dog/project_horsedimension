package net.mcreator.projecthorsedimension.block;

import net.neoforged.neoforge.common.util.TriState;

import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FallingBlock;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import com.mojang.serialization.MapCodec;

public class BlockofcolorfulpebblesBlock extends FallingBlock {
	public static final MapCodec<BlockofcolorfulpebblesBlock> CODEC = simpleCodec(BlockofcolorfulpebblesBlock::new);

	public MapCodec<BlockofcolorfulpebblesBlock> codec() {
		return CODEC;
	}

	public BlockofcolorfulpebblesBlock(BlockBehaviour.Properties properties) {
		super(properties.sound(SoundType.TUFF).strength(0.6f));
	}

	@Override
	public int getLightBlock(BlockState state) {
		return 15;
	}

	@Override
	public TriState canSustainPlant(BlockState state, BlockGetter world, BlockPos pos, Direction direction, BlockState plant) {
		return TriState.TRUE;
	}
}