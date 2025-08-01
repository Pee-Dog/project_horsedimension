package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMobEffects;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class OnCoinEntitySpawnProcedure {
	public static void execute(LevelAccessor world, Entity entity) {
		if (entity == null)
			return;
		ProjectHorsedimensionMod.queueServerWork(1, () -> {
			if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
				_entity.addEffect(new MobEffectInstance(ProjectHorsedimensionModMobEffects.COIN_EFFECT_TIMER, 16, 1, false, false));
		});
	}
}