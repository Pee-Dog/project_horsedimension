package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.sounds.SoundSource;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMobEffects;

public class PeajectileProjectileHitsPlayerProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.PEABITS.get()), x, y, z, 5, 0.5, 0.5, 0.5, 1);
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:pea.splat")), SoundSource.NEUTRAL, 1,
						Mth.nextInt(RandomSource.create(), (int) 0.5, (int) 1.5));
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:pea.splat")), SoundSource.NEUTRAL, 1, Mth.nextInt(RandomSource.create(), (int) 0.5, (int) 1.5), false);
			}
		}
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(ProjectHorsedimensionModMobEffects.PEAD_ON, 200, 0, false, true));
	}
}