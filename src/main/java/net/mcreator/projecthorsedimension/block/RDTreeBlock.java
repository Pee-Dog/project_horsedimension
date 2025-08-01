package net.mcreator.projecthorsedimension.block;

import net.neoforged.neoforge.common.util.DeferredSoundType;

import net.minecraft.world.phys.shapes.VoxelShape;
import net.minecraft.world.phys.shapes.CollisionContext;
import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.FlowerBlock;
import net.minecraft.world.level.LevelReader;
import net.minecraft.world.level.BlockGetter;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public class RDTreeBlock extends FlowerBlock {
	public RDTreeBlock(BlockBehaviour.Properties properties) {
		super(MobEffects.MOVEMENT_SPEED, 100,
				properties.mapColor(MapColor.PLANT)
						.sound(new DeferredSoundType(1.0f, 1.0f, () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.grass.break")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.wood.step")),
								() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.wood.place")), () -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.wood.hit")),
								() -> BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.grass.fall"))))
						.strength(4f, 6f).noOcclusion().dynamicShape().offsetType(BlockBehaviour.OffsetType.XZ).pushReaction(PushReaction.DESTROY));
	}

	@Override
	public VoxelShape getShape(BlockState state, BlockGetter world, BlockPos pos, CollisionContext context) {
		Vec3 offset = state.getOffset(pos);
		return box(7, 0, 7, 10, 32, 10).move(offset.x, offset.y, offset.z);
	}

	@Override
	public int getFlammability(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 100;
	}

	@Override
	public int getFireSpreadSpeed(BlockState state, BlockGetter world, BlockPos pos, Direction face) {
		return 60;
	}

	@Override
	public boolean mayPlaceOn(BlockState groundState, BlockGetter worldIn, BlockPos pos) {
		return groundState.is(ProjectHorsedimensionModBlocks.ASTROTURF.get());
	}

	@Override
	public boolean canSurvive(BlockState blockstate, LevelReader worldIn, BlockPos pos) {
		BlockPos blockpos = pos.below();
		BlockState groundState = worldIn.getBlockState(blockpos);
		return this.mayPlaceOn(groundState, worldIn, blockpos);
	}
}