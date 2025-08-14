package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMenus;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.BovineEntity;

public class CowFarmerOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BovineEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BovineEntity.DATA_homex, (int) entity.getX());
		if (entity instanceof BovineEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BovineEntity.DATA_homey, (int) entity.getY());
		if (entity instanceof BovineEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BovineEntity.DATA_homez, (int) entity.getZ());
		if (entity instanceof Player _player && _player.containerMenu instanceof ProjectHorsedimensionModMenus.MenuAccessor _menu) {
			ItemStack _setstack = new ItemStack(ProjectHorsedimensionModItems.PEA.get()).copy();
			_setstack.setCount(1);
			_menu.getSlots().get(0).set(_setstack);
			_player.containerMenu.broadcastChanges();
		}
	}
}