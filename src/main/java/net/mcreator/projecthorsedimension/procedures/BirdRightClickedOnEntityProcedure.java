package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.entity.BirdEntity;

public class BirdRightClickedOnEntityProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof BirdEntity _datEntL0 && _datEntL0.getEntityData().get(BirdEntity.DATA_flying)) == true) {
			if (entity instanceof BirdEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BirdEntity.DATA_flying, false);
			BirdrestProcedure.execute(entity);
		}
		if ((entity instanceof BirdEntity _datEntL2 && _datEntL2.getEntityData().get(BirdEntity.DATA_flying)) == false) {
			if (entity instanceof BirdEntity _datEntSetL)
				_datEntSetL.getEntityData().set(BirdEntity.DATA_flying, true);
			BirdrestProcedure.execute(entity);
		}
	}
}