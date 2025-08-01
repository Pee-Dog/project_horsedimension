package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

import java.util.Comparator;

public class PrismreceptacleNeighbourBlockChangesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (!((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get() || (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.CAVE_AIR
				|| (world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == Blocks.AIR)) {
			{
				BlockPos _pos = BlockPos.containing(x, y + 1, z);
				Block.dropResources(world.getBlockState(_pos), world, BlockPos.containing(x, y + 1, z), null);
				world.destroyBlock(_pos, false);
			}
			{
				final Vec3 _center = new Vec3(x, y, z);
				for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(10 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
					if (entityiterator instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("The receptacle requires \u25B2 "), true);
				}
			}
		} else if ((world.getBlockState(BlockPos.containing(x, y + 1, z))).getBlock() == ProjectHorsedimensionModBlocks.CORNERSTONE.get()) {
			if (world instanceof Level _level) {
				if (!_level.isClientSide()) {
					_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1);
				} else {
					_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("block.end_portal_frame.fill")), SoundSource.BLOCKS, 1, 1, false);
				}
			}
		}
	}
}