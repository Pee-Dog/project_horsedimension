package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.block.Blocks;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.EntitySpawnReason;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModEntities;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class BunnyEntityDiesProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _entity = entity;
			if (_entity instanceof Player _player) {
				_player.getInventory().armor.set(3, new ItemStack(Blocks.AIR));
				_player.getInventory().setChanged();
			} else if (_entity instanceof LivingEntity _living) {
				_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(Blocks.AIR));
			}
		}
		ProjectHorsedimensionMod.queueServerWork(1, () -> {
			if (!entity.level().isClientSide())
				entity.discard();
		});
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.BLOODTRAIL.get()), x, y, z, 20, 0.4, 0.4, 0.4, 0);
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ProjectHorsedimensionModEntities.HORSECOINCOLLECTABLE.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ProjectHorsedimensionModEntities.GIBENTITY.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ProjectHorsedimensionModEntities.GIBENTITY.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (world instanceof ServerLevel _level) {
			Entity entityToSpawn = ProjectHorsedimensionModEntities.GIBENTITY.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
			if (entityToSpawn != null) {
				entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
			}
		}
		if (!(entity instanceof LivingEntity _livEnt8 && _livEnt8.isBaby())) {
			if (world instanceof ServerLevel _level) {
				Entity entityToSpawn = ProjectHorsedimensionModEntities.GIBENTITY.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
				if (entityToSpawn != null) {
					entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
				}
			}
			if (Math.random() <= 0.5) {
				if (world instanceof ServerLevel _level) {
					Entity entityToSpawn = ProjectHorsedimensionModEntities.GIBENTITY.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
					if (entityToSpawn != null) {
						entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
					}
				}
				if (Math.random() <= 0.5) {
					if (world instanceof ServerLevel _level) {
						Entity entityToSpawn = ProjectHorsedimensionModEntities.GIBENTITY.get().spawn(_level, BlockPos.containing(x, y, z), EntitySpawnReason.MOB_SUMMONED);
						if (entityToSpawn != null) {
							entityToSpawn.setYRot(world.getRandom().nextFloat() * 360F);
						}
					}
				}
			}
		}
		KillOBJsProcedure.execute(world, x, y, z);
	}
}