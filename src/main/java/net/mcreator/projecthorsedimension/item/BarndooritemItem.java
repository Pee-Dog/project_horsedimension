package net.mcreator.projecthorsedimension.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.projecthorsedimension.procedures.LeftBarnDoorRightclickedOnBlockProcedure;

public class BarndooritemItem extends Item {
	public BarndooritemItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		LeftBarnDoorRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}