package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.projecthorsedimension.entity.BoulderEntity;

public class BoulderOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof BoulderEntity _datEntSetI)
			_datEntSetI.getEntityData().set(BoulderEntity.DATA_rockscale, Mth.nextInt(RandomSource.create(), 25, 45));
	}
}