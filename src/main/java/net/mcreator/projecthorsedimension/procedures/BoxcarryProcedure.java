package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.BoxEntity;

public class BoxcarryProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof BoxEntity _datEntL0 && _datEntL0.getEntityData().get(BoxEntity.DATA_carried)) == false) {
			if (entity instanceof BoxEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BoxEntity.DATA_carried, true);
		} else if ((entity instanceof BoxEntity _datEntL2 && _datEntL2.getEntityData().get(BoxEntity.DATA_carried)) == true) {
			if (entity instanceof BoxEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BoxEntity.DATA_carried, false);
			entity.setNoGravity(false);
		}
	}
}