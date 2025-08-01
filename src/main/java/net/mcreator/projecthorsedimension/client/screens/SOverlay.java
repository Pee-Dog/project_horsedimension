package net.mcreator.projecthorsedimension.client.screens;

import org.checkerframework.checker.units.qual.h;

import net.neoforged.neoforge.client.event.RenderGuiEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.EventPriority;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.Minecraft;

import net.mcreator.projecthorsedimension.procedures.HdportalpotionOnEffectActiveTickProcedure;
import net.mcreator.projecthorsedimension.procedures.HdportalpotionOnEffectActiveTick2Procedure;

@EventBusSubscriber({Dist.CLIENT})
public class SOverlay {
	@SubscribeEvent(priority = EventPriority.LOWEST)
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
		if (HdportalpotionOnEffectActiveTickProcedure.execute(entity)) {

			event.getGuiGraphics().blit(RenderType::guiTextured, ResourceLocation.parse("project_horsedimension:textures/screens/noisefadeanim.png"), w / 2 + -474, h / 2 + -273, 0,
					Mth.clamp((int) HdportalpotionOnEffectActiveTick2Procedure.execute(entity) * 540, 0, 4860), 960, 540, 960, 5400);

		}
	}
}