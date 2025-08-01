package net.mcreator.projecthorsedimension.potion;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.projecthorsedimension.procedures.PeadOnEffectStartedappliedProcedure;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;

public class PeadOnMobEffect extends MobEffect {
	public PeadOnMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1, mobEffectInstance -> (SimpleParticleType) (ProjectHorsedimensionModParticleTypes.PEABITS.get()));
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		PeadOnEffectStartedappliedProcedure.execute(entity);
	}
}