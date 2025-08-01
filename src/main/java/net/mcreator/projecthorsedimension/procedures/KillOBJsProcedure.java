package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.item.ItemEntity;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;

import java.util.Comparator;

public class KillOBJsProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z) {
		if (((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.PEAJAKHANDITEM.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.PEAJAKHANDITEM.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.PEAJAKITEM_1.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.BIRDITEM.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.BUNNYITEM_3.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.BUNNYITEM_2.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.BUNNYITEM_1.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.BUNNYITEM.get()
				|| ((findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)) instanceof ItemEntity _itemEnt ? _itemEnt.getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.PEAJAKITEM.get()) {
			if (!(findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)).level().isClientSide())
				(findEntityInWorldRange(world, ItemEntity.class, x, y, z, 1)).discard();
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}