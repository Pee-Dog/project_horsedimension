package net.mcreator.projecthorsedimension.item;

import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;

public class HorseitemItem extends Item {
	public HorseitemItem(Item.Properties properties) {
		super(properties.rarity(Rarity.EPIC).stacksTo(1));
	}
}