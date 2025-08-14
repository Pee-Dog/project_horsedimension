package net.mcreator.projecthorsedimension.procedures;

import net.neoforged.neoforge.network.handling.IPayloadContext;
import net.neoforged.neoforge.network.PacketDistributor;
import net.neoforged.neoforge.event.entity.player.PlayerInteractEvent;
import net.neoforged.fml.event.lifecycle.FMLCommonSetupEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.InteractionHand;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.protocol.common.custom.CustomPacketPayload;
import net.minecraft.network.protocol.PacketFlow;
import net.minecraft.network.codec.StreamCodec;
import net.minecraft.network.chat.Component;
import net.minecraft.network.RegistryFriendlyByteBuf;

import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

import javax.annotation.Nullable;

@EventBusSubscriber(value = {Dist.CLIENT})
public class PlayerraytracetestProcedure {
	@SubscribeEvent
	public static void onRightClick(PlayerInteractEvent.RightClickEmpty event) {
		if (event.getHand() != InteractionHand.MAIN_HAND)
			return;
		PacketDistributor.sendToServer(new PlayerraytracetestMessage());
		execute();
	}

	@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
	public record PlayerraytracetestMessage() implements CustomPacketPayload {
		public static final Type<PlayerraytracetestMessage> TYPE = new Type<>(ResourceLocation.fromNamespaceAndPath(ProjectHorsedimensionMod.MODID, "procedure_playerraytracetest"));
		public static final StreamCodec<RegistryFriendlyByteBuf, PlayerraytracetestMessage> STREAM_CODEC = StreamCodec.of((RegistryFriendlyByteBuf buffer, PlayerraytracetestMessage message) -> {
		}, (RegistryFriendlyByteBuf buffer) -> new PlayerraytracetestMessage());

		@Override
		public Type<PlayerraytracetestMessage> type() {
			return TYPE;
		}

		public static void handleData(final PlayerraytracetestMessage message, final IPayloadContext context) {
			if (context.flow() == PacketFlow.SERVERBOUND) {
				context.enqueueWork(() -> {
					if (!context.player().level().hasChunkAt(context.player().blockPosition()))
						return;
					execute();
				}).exceptionally(e -> {
					context.connection().disconnect(Component.literal(e.getMessage()));
					return null;
				});
			}
		}

		@SubscribeEvent
		public static void registerMessage(FMLCommonSetupEvent event) {
			ProjectHorsedimensionMod.addNetworkMessage(PlayerraytracetestMessage.TYPE, PlayerraytracetestMessage.STREAM_CODEC, PlayerraytracetestMessage::handleData);
		}
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}