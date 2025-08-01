package net.mcreator.projecthorsedimension.procedures;

import net.neoforged.neoforge.event.entity.item.ItemTossEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.bus.api.Event;

import javax.annotation.Nullable;

@EventBusSubscriber
public class DeleteItemProcedure {
	@SubscribeEvent
	public static void onGemDropped(ItemTossEvent event) {
		execute(event);
	}

	public static void execute() {
		execute(null);
	}

	private static void execute(@Nullable Event event) {
	}
}