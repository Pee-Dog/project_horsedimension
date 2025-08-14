/*
 *	MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import org.lwjgl.glfw.GLFW;

import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.client.event.RegisterKeyMappingsEvent;
import net.neoforged.neoforge.client.event.ClientTickEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.client.Minecraft;
import net.minecraft.client.KeyMapping;

import net.mcreator.projecthorsedimension.network.MoveforwardMessage;
import net.mcreator.projecthorsedimension.network.LookrightMessage;
import net.mcreator.projecthorsedimension.network.LookleftMessage;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = {Dist.CLIENT})
public class ProjectHorsedimensionModKeyMappings {
	public static final KeyMapping MOVEFORWARD = new KeyMapping("key.project_horsedimension.moveforward", GLFW.GLFW_KEY_W, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new MoveforwardMessage(0, 0));
				MoveforwardMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				MOVEFORWARD_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - MOVEFORWARD_LASTPRESS);
				PacketDistributor.sendToServer(new MoveforwardMessage(1, dt));
				MoveforwardMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping LOOKLEFT = new KeyMapping("key.project_horsedimension.lookleft", GLFW.GLFW_KEY_A, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new LookleftMessage(0, 0));
				LookleftMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				LOOKLEFT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - LOOKLEFT_LASTPRESS);
				PacketDistributor.sendToServer(new LookleftMessage(1, dt));
				LookleftMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	public static final KeyMapping LOOKRIGHT = new KeyMapping("key.project_horsedimension.lookright", GLFW.GLFW_KEY_D, "key.categories.gameplay") {
		private boolean isDownOld = false;

		@Override
		public void setDown(boolean isDown) {
			super.setDown(isDown);
			if (isDownOld != isDown && isDown) {
				PacketDistributor.sendToServer(new LookrightMessage(0, 0));
				LookrightMessage.pressAction(Minecraft.getInstance().player, 0, 0);
				LOOKRIGHT_LASTPRESS = System.currentTimeMillis();
			} else if (isDownOld != isDown && !isDown) {
				int dt = (int) (System.currentTimeMillis() - LOOKRIGHT_LASTPRESS);
				PacketDistributor.sendToServer(new LookrightMessage(1, dt));
				LookrightMessage.pressAction(Minecraft.getInstance().player, 1, dt);
			}
			isDownOld = isDown;
		}
	};
	private static long MOVEFORWARD_LASTPRESS = 0;
	private static long LOOKLEFT_LASTPRESS = 0;
	private static long LOOKRIGHT_LASTPRESS = 0;

	@SubscribeEvent
	public static void registerKeyMappings(RegisterKeyMappingsEvent event) {
		event.register(MOVEFORWARD);
		event.register(LOOKLEFT);
		event.register(LOOKRIGHT);
	}

	@EventBusSubscriber({Dist.CLIENT})
	public static class KeyEventListener {
		@SubscribeEvent
		public static void onClientTick(ClientTickEvent.Post event) {
			if (Minecraft.getInstance().screen == null) {
				MOVEFORWARD.consumeClick();
				LOOKLEFT.consumeClick();
				LOOKRIGHT.consumeClick();
			}
		}
	}
}