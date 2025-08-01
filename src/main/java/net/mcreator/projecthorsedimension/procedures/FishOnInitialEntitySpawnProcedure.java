package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.projecthorsedimension.entity.FishEntity;

public class FishOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if (entity instanceof FishEntity _datEntSetI)
			_datEntSetI.getEntityData().set(FishEntity.DATA_fishscale, Mth.nextInt(RandomSource.create(), 2, 4));
	}
}