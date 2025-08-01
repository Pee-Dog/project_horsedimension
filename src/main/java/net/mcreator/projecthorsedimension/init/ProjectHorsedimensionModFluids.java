/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.fml.event.lifecycle.FMLClientSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.material.FlowingFluid;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.renderer.ItemBlockRenderTypes;

import net.mcreator.projecthorsedimension.fluid.JuiceFluid;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class ProjectHorsedimensionModFluids {
	public static final DeferredRegister<Fluid> REGISTRY = DeferredRegister.create(BuiltInRegistries.FLUID, ProjectHorsedimensionMod.MODID);
	public static final DeferredHolder<Fluid, FlowingFluid> JUICE = REGISTRY.register("juice", () -> new JuiceFluid.Source());
	public static final DeferredHolder<Fluid, FlowingFluid> FLOWING_JUICE = REGISTRY.register("flowing_juice", () -> new JuiceFluid.Flowing());

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
	public static class FluidsClientSideHandler {
		@SubscribeEvent
		public static void clientSetup(FMLClientSetupEvent event) {
			ItemBlockRenderTypes.setRenderLayer(JUICE.get(), RenderType.translucent());
			ItemBlockRenderTypes.setRenderLayer(FLOWING_JUICE.get(), RenderType.translucent());
		}
	}
}