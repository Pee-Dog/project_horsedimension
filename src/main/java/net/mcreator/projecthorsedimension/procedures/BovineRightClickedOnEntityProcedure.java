package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMenus;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.BovineEntity;

public class BovineRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if ((entity instanceof BovineEntity _datEntL0 && _datEntL0.getEntityData().get(BovineEntity.DATA_table_loaded)) == false) {
			if (entity instanceof BovineEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BovineEntity.DATA_table_loaded, true);
			if (sourceentity instanceof Player _player && _player.containerMenu instanceof ProjectHorsedimensionModMenus.MenuAccessor _menu) {
				ItemStack _setstack = new ItemStack(ProjectHorsedimensionModItems.PEA.get()).copy();
				_setstack.setCount(1);
				_menu.getSlots().get(0).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
			if (sourceentity instanceof Player _player && _player.containerMenu instanceof ProjectHorsedimensionModMenus.MenuAccessor _menu) {
				ItemStack _setstack = new ItemStack(ProjectHorsedimensionModItems.STAFF.get()).copy();
				_setstack.setCount(1);
				_menu.getSlots().get(1).set(_setstack);
				_player.containerMenu.broadcastChanges();
			}
		}
	}
}