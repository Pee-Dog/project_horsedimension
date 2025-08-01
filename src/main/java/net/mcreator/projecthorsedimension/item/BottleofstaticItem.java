package net.mcreator.projecthorsedimension.item;

import net.minecraft.world.item.context.UseOnContext;
import net.minecraft.world.item.Item;
import net.minecraft.world.InteractionResult;

import net.mcreator.projecthorsedimension.procedures.BottleofstaticRightclickedOnBlockProcedure;

public class BottleofstaticItem extends Item {
	public BottleofstaticItem(Item.Properties properties) {
		super(properties);
	}

	@Override
	public InteractionResult useOn(UseOnContext context) {
		super.useOn(context);
		BottleofstaticRightclickedOnBlockProcedure.execute(context.getLevel(), context.getClickedPos().getX(), context.getClickedPos().getY(), context.getClickedPos().getZ(), context.getPlayer());
		return InteractionResult.SUCCESS;
	}
}