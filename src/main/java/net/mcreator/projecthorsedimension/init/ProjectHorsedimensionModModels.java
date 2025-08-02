/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.client.event.EntityRenderersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.projecthorsedimension.client.model.Modeltree_rubydung;
import net.mcreator.projecthorsedimension.client.model.Modelelytra;
import net.mcreator.projecthorsedimension.client.model.Modelbirdwings_open;
import net.mcreator.projecthorsedimension.client.model.Modelbirdwings;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ProjectHorsedimensionModModels {
	@SubscribeEvent
	public static void registerLayerDefinitions(EntityRenderersEvent.RegisterLayerDefinitions event) {
		event.registerLayerDefinition(Modelelytra.LAYER_LOCATION, Modelelytra::createBodyLayer);
		event.registerLayerDefinition(Modelbirdwings_open.LAYER_LOCATION, Modelbirdwings_open::createBodyLayer);
		event.registerLayerDefinition(Modelbirdwings.LAYER_LOCATION, Modelbirdwings::createBodyLayer);
		event.registerLayerDefinition(Modeltree_rubydung.LAYER_LOCATION, Modeltree_rubydung::createBodyLayer);
	}
}