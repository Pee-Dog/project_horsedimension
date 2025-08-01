package net.mcreator.projecthorsedimension.item;

import net.minecraft.world.item.Items;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.BucketItem;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModFluids;

public class JuiceItem extends BucketItem {
	public JuiceItem(Item.Properties properties) {
		super(ProjectHorsedimensionModFluids.JUICE.get(), properties.craftRemainder(Items.BUCKET).stacksTo(1)

		);
	}
}