package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public class ShortScrubBlock extends FlowerBlock {
	public ShortScrubBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.WITHER, 100, properties.mapColor(MapColor.PLANT).sound(SoundType.HANGING_ROOTS).instabreak().noCollission().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(pos);
		return box(0, 0, 0, 16, 8, 16).move(offset.x, offset.y, offset.z);
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(ProjectHorsedimensionModBlocks.ASTROTURF.get()) || groundState.is(ProjectHorsedimensionModBlocks.WHITE_BEAD_BLOCK.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}