package net.mcreator.projecthorsedimension.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;

import net.mcreator.projecthorsedimension.procedures.HorsecoincounterProcedure;
import net.mcreator.projecthorsedimension.procedures.HorsecoincountDisplayOverlayIngameProcedure;

@EventBusSubscriber({Dist.CLIENT})
public class HorsecoincountOverlay {
	@SubscribeEvent(priority = EventPriority.NORMAL)
	public static void eventHandler(RenderGuiEvent.Pre event) {
		int w = event.getGuiGraphics().guiWidth();
		int h = event.getGuiGraphics().guiHeight();
		Level world = null;
		double x = 0;
		double y = 0;
		double z = 0;
		Player entity = Minecraft.getInstance().player;
		if (entity != null) {
			world = entity.level();
			x = entity.getX();
			y = entity.getY();
			z = entity.getZ();
		}
		if (HorsecoincountDisplayOverlayIngameProcedure.execute(entity)) {

			event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("project_horsedimension:textures/screens/horsecoin.png"), 1, 1, 0, 0, 32, 32, 32, 32);

			event.getGuiGraphics().drawString(Minecraft.getInstance().font,

					HorsecoincounterProcedure.execute(entity), 35, 11, -205, false);
		}
	}
}