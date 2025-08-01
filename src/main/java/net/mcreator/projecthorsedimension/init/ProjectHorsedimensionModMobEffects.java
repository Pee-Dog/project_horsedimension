/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.living.MobEffectEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.core.registries.Registries;

import net.mcreator.projecthorsedimension.procedures.PeadOnEffectStartedappliedProcedure;
import net.mcreator.projecthorsedimension.procedures.OnCoinEntitySpawnProcedure;
import net.mcreator.projecthorsedimension.potion.PeadOnMobEffect;
import net.mcreator.projecthorsedimension.potion.ParkedMobEffect;
import net.mcreator.projecthorsedimension.potion.CoinEffectTimerMobEffect;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

@EventBusSubscriber
public class ProjectHorsedimensionModMobEffects {
	public static final DeferredRegister<MobEffect> REGISTRY = DeferredRegister.create(Registries.MOB_EFFECT, ProjectHorsedimensionMod.MODID);
	public static final DeferredHolder<MobEffect, MobEffect> COIN_EFFECT_TIMER = REGISTRY.register("coin_effect_timer", () -> new CoinEffectTimerMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PARKED = REGISTRY.register("parked", () -> new ParkedMobEffect());
	public static final DeferredHolder<MobEffect, MobEffect> PEAD_ON = REGISTRY.register("pead_on", () -> new PeadOnMobEffect());

	@SubscribeEvent
	public static void onEffectRemoved(MobEffectEvent.Remove event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	@SubscribeEvent
	public static void onEffectExpired(MobEffectEvent.Expired event) {
		MobEffectInstance effectInstance = event.getEffectInstance();
		if (effectInstance != null) {
			expireEffects(event.getEntity(), effectInstance);
		}
	}

	private static void expireEffects(Entity entity, MobEffectInstance effectInstance) {
		if (effectInstance.getEffect().is(COIN_EFFECT_TIMER)) {
			OnCoinEntitySpawnProcedure.execute(entity.level(), entity);
		} else if (effectInstance.getEffect().is(PEAD_ON)) {
			PeadOnEffectStartedappliedProcedure.execute(entity);
		}
	}
}