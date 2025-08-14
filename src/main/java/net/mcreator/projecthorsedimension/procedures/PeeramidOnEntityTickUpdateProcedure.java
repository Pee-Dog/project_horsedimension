package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.block.Block;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.ClipContext;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.damagesource.DamageTypes;
import net.minecraft.world.damagesource.DamageSource;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.entity.PeeramidEntity;

import java.util.Comparator;

public class PeeramidOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			final Vec3 _center = new Vec3(x, y, z);
			for (Entity entityiterator : world.getEntitiesOfClass(Entity.class, new AABB(_center, _center).inflate(20 / 2d), e -> true).stream().sorted(Comparator.comparingDouble(_entcnd -> _entcnd.distanceToSqr(_center))).toList()) {
				if (entityiterator instanceof Player) {
					if (!(!world
							.getEntitiesOfClass(PeeramidEntity.class,
									new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(
											(entityiterator.level()
													.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
															entityiterator))
													.getBlockPos().getX()),
											(entityiterator.level()
													.clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE, ClipContext.Fluid.NONE,
															entityiterator))
													.getBlockPos().getY()),
											(entityiterator.level().clip(new ClipContext(entityiterator.getEyePosition(1f), entityiterator.getEyePosition(1f).add(entityiterator.getViewVector(1f).scale(8)), ClipContext.Block.OUTLINE,
													ClipContext.Fluid.NONE, entityiterator)).getBlockPos().getZ())))
											.inflate(16 / 2d),
									e -> true)
							.isEmpty())) {
						if (entity instanceof LivingEntity _livingEntity5 && _livingEntity5.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity5.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.35);
					} else {
						if (entity instanceof LivingEntity _livingEntity6 && _livingEntity6.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
							_livingEntity6.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.2);
					}
				}
			}
		}
		if (!entity.onGround()) {
			if (entity.fallDistance > 2) {
				if (entity instanceof PeeramidEntity _datEntSetL)
					_datEntSetL.getEntityData().set(PeeramidEntity.DATA_fallcharge, true);
			}
		} else {
			if ((entity instanceof PeeramidEntity _datEntL11 && _datEntL11.getEntityData().get(PeeramidEntity.DATA_fallcharge)) == true) {
				world.levelEvent(2001, BlockPos.containing(x + 3, y, z), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x - 3, y, z), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x, y, z + 3), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x, y, z - 3), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + 2, y, z + 2), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x - 2, y, z - 2), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + 3, y, z), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x + 2, y, z - 2), Block.getId(Blocks.BRICKS.defaultBlockState()));
				world.levelEvent(2001, BlockPos.containing(x - 2, y, z + 2), Block.getId(Blocks.BRICKS.defaultBlockState()));
				if (entity instanceof PeeramidEntity _datEntSetL)
					_datEntSetL.getEntityData().set(PeeramidEntity.DATA_fallcharge, false);
				if (!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(8 / 2d), e -> true).isEmpty()) {
					(findEntityInWorldRange(world, Player.class, x, y, z, 8)).hurt(new DamageSource(world.holderOrThrow(DamageTypes.CRAMMING)), 6);
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}