/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.renderer.entity.ThrownItemRenderer;

import net.mcreator.projecthorsedimension.client.renderer.RatRenderer;
import net.mcreator.projecthorsedimension.client.renderer.PoolgatorRenderer;
import net.mcreator.projecthorsedimension.client.renderer.PeeramidRenderer;
import net.mcreator.projecthorsedimension.client.renderer.PeajakRenderer;
import net.mcreator.projecthorsedimension.client.renderer.NoiseCloudRenderer;
import net.mcreator.projecthorsedimension.client.renderer.MealwormentityRenderer;
import net.mcreator.projecthorsedimension.client.renderer.HorsecoincollectableRenderer;
import net.mcreator.projecthorsedimension.client.renderer.GnomeRenderer;
import net.mcreator.projecthorsedimension.client.renderer.GibentityRenderer;
import net.mcreator.projecthorsedimension.client.renderer.GeckoRenderer;
import net.mcreator.projecthorsedimension.client.renderer.FishRenderer;
import net.mcreator.projecthorsedimension.client.renderer.EquineRenderer;
import net.mcreator.projecthorsedimension.client.renderer.DromedaryRenderer;
import net.mcreator.projecthorsedimension.client.renderer.CricketentityRenderer;
import net.mcreator.projecthorsedimension.client.renderer.CowHeadRenderer;
import net.mcreator.projecthorsedimension.client.renderer.CanisLatransRenderer;
import net.mcreator.projecthorsedimension.client.renderer.BunnyRenderer;
import net.mcreator.projecthorsedimension.client.renderer.BoxRenderer;
import net.mcreator.projecthorsedimension.client.renderer.BovineRenderer;
import net.mcreator.projecthorsedimension.client.renderer.BoulderRenderer;
import net.mcreator.projecthorsedimension.client.renderer.BirdRenderer;
import net.mcreator.projecthorsedimension.client.renderer.BarndoorRenderer;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ProjectHorsedimensionModEntityRenderers {
	@SubscribeEvent
	public static void registerEntityRenderers(EntityRenderersEvent.RegisterRenderers event) {
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.HORSECOINCOLLECTABLE.get(), HorsecoincollectableRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.EQUINE.get(), EquineRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.PEAJAK.get(), PeajakRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.BUNNY.get(), BunnyRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.GIBENTITY.get(), GibentityRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.BIRD.get(), BirdRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.PEAJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.RAT.get(), RatRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.GECKO.get(), GeckoRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.HORSECOINPROJECTILE.get(), ThrownItemRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.MEALWORMENTITY.get(), MealwormentityRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.CRICKETENTITY.get(), CricketentityRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.POOLGATOR.get(), PoolgatorRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.FISH.get(), FishRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.BOULDER.get(), BoulderRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.BARNDOOR.get(), BarndoorRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.GNOME.get(), GnomeRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.NOISE_CLOUD.get(), NoiseCloudRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.DROMEDARY.get(), DromedaryRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.BOX.get(), BoxRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.COW_HEAD.get(), CowHeadRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.BOVINE.get(), BovineRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.CANIS_LATRANS.get(), CanisLatransRenderer::new);
		event.registerEntityRenderer(ProjectHorsedimensionModEntities.PEERAMID.get(), PeeramidRenderer::new);
	}
}