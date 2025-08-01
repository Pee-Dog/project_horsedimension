package net.mcreator.projecthorsedimension.item;

import net.minecraft.world.item.Item;
import net.minecraft.world.food.FoodProperties;

public class MealwormItem extends Item {
	public MealwormItem(Item.Properties properties) {
		super(properties.food((new FoodProperties.Builder()).nutrition(2).saturationModifier(0.3f).alwaysEdible().build()));
	}
}