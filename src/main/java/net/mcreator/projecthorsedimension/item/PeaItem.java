package net.mcreator.projecthorsedimension.item;

import net.minecraft.world.item.component.Consumables;
import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class PeaItem extends Item {
	public PeaItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(2.7f).alwaysEdible().build(), Consumables.defaultFood().consumeSeconds(0.8F).build()));
	}
}