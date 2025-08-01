package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;
import net.minecraft.client.Minecraft;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMobEffects;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.EquineEntity;

public class EquineRightClickedOnEntityProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof TamableAnimal _tamEnt ? _tamEnt.isTame() : false) == false) {
			if (sourceentity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount >= 10) {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Thank you for your payment of [10] HorseCoin\u2122"), true);
				{
					ProjectHorsedimensionModVariables.PlayerVariables _vars = sourceentity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
					_vars.coincount = sourceentity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount - 10;
					_vars.syncPlayerVariables(sourceentity);
				}
				if (entity instanceof TamableAnimal _toTame && sourceentity instanceof Player _owner)
					_toTame.tame(_owner);
				if (world instanceof ServerLevel _level)
					_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.HORSECOINPARTICLES.get()), x, (y + 0.5), z, 10, 1, 1, 1, 1);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsecoin.cash")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsecoin.cash")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			} else {
				if (sourceentity instanceof Player _player && !_player.level().isClientSide())
					_player.displayClientMessage(Component.literal("Purchase for [10] HorseCoin\u2122"), true);
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:equine.snort")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:equine.snort")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
		if ((entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) == true) {
			if (!Minecraft.getInstance().options.keyShift.isDown()) {
				sourceentity.startRiding(entity);
			}
			if ((sourceentity instanceof LivingEntity _livEnt ? _livEnt.getMainHandItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.HORSEKEY.get()) {
				if (!(entity instanceof LivingEntity _livEnt12 && _livEnt12.hasEffect(ProjectHorsedimensionModMobEffects.PARKED))) {
					if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
						_entity.addEffect(new MobEffectInstance(ProjectHorsedimensionModMobEffects.PARKED, 1000000000, 1, false, false));
					if (sourceentity instanceof Player _player && !_player.level().isClientSide())
						_player.displayClientMessage(Component.literal("Car is turned off"), true);
					if (entity instanceof EquineEntity _datEntSetI)
						_datEntSetI.getEntityData().set(EquineEntity.DATA_parked, 1);
				} else {
					if (Math.random() <= 0.3) {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:equine.ignition")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:equine.ignition")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
						if (entity instanceof LivingEntity _entity)
							_entity.removeEffect(ProjectHorsedimensionModMobEffects.PARKED);
						if (sourceentity instanceof Player _player && !_player.level().isClientSide())
							_player.displayClientMessage(Component.literal("Car is turned on"), true);
						if (entity instanceof EquineEntity _datEntSetI)
							_datEntSetI.getEntityData().set(EquineEntity.DATA_parked, 0);
					} else {
						if (world instanceof Level _level) {
							if (!_level.isClientSide()) {
								_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:equine.ignitionfail")), SoundSource.NEUTRAL, 1, 1);
							} else {
								_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:equine.ignitionfail")), SoundSource.NEUTRAL, 1, 1, false);
							}
						}
					}
				}
			}
		}
	}
}