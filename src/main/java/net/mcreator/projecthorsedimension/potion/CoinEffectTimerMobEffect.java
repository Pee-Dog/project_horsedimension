package net.mcreator.projecthorsedimension.potion;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientMobEffectExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.world.effect.MobEffectCategory;
import net.minecraft.world.effect.MobEffect;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.projecthorsedimension.procedures.CoinEffectTimerEffectStartedappliedProcedure;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMobEffects;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class CoinEffectTimerMobEffect extends MobEffect {
	public CoinEffectTimerMobEffect() {
		super(MobEffectCategory.NEUTRAL, -1);
	}

	@Override
	public void onEffectStarted(LivingEntity entity, int amplifier) {
		CoinEffectTimerEffectStartedappliedProcedure.execute(entity.level(), entity.getX(), entity.getY(), entity.getZ());
	}

	@SubscribeEvent
	public static void registerMobEffectExtensions(RegisterClientExtensionsEvent event) {
		event.registerMobEffect(new IClientMobEffectExtensions() {
			@Override
			public boolean isVisibleInInventory(MobEffectInstance effect) {
				return false;
			}

			@Override
			public boolean renderInventoryText(MobEffectInstance instance, AbstractContainerScreen<?> screen, GuiGraphics guiGraphics, int x, int y, int blitOffset) {
				return false;
			}

			@Override
			public boolean isVisibleInGui(MobEffectInstance effect) {
				return false;
			}
		}, ProjectHorsedimensionModMobEffects.COIN_EFFECT_TIMER.get());
	}
}