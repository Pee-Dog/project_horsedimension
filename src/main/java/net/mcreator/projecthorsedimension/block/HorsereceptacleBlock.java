package net.mcreator.projecthorsedimension.block;

import org.checkerframework.checker.units.qual.s;

import net.minecraft.world.phys.BlockHitResult;
import net.minecraft.world.level.block.state.BlockState;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.InteractionResult;
import net.minecraft.core.Direction;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.procedures.HorseWalksOnBlockProcedure;
import net.mcreator.projecthorsedimension.procedures.HorseReceptacleOnBlockRightClickedProcedure;

public class HorsereceptacleBlock extends Block {
	public HorsereceptacleBlock(BlockBehaviour.Properties properties) {
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
	public void stepOn(Level world, BlockPos pos, BlockState blockstate, Entity entity) {
		super.stepOn(world, pos, blockstate, entity);
		HorseWalksOnBlockProcedure.execute(world, pos.getX(), pos.getY(), pos.getZ(), entity);
	}

	@Override
	public InteractionResult useWithoutItem(BlockState blockstate, Level world, BlockPos pos, Player entity, BlockHitResult hit) {
		super.useWithoutItem(blockstate, world, pos, entity, hit);
		int x = pos.getX();
		int y = pos.getY();
		int z = pos.getZ();
		double hitX = hit.getLocation().x;
		double hitY = hit.getLocation().y;
		double hitZ = hit.getLocation().z;
		Direction direction = hit.getDirection();
		HorseReceptacleOnBlockRightClickedProcedure.execute(world, x, y, z, entity);
		return InteractionResult.SUCCESS;
	}
}