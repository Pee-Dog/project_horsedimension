package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;
import net.mcreator.projecthorsedimension.entity.HorsecoincollectableEntity;

public class PlayerCollidesWithCoinProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof HorsecoincollectableEntity _datEntSetI)
			_datEntSetI.getEntityData().set(HorsecoincollectableEntity.DATA_coincollected, 1);
		if (!entity.level().isClientSide())
			entity.discard();
		if (world instanceof Level _level) {
			if (!_level.isClientSide()) {
				_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsecoin.collectph")), SoundSource.NEUTRAL, (float) 0.5, 1);
			} else {
				_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsecoin.collectph")), SoundSource.NEUTRAL, (float) 0.5, 1, false);
			}
		}
		{
			ProjectHorsedimensionModVariables.PlayerVariables _vars = sourceentity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
			_vars.coincount = sourceentity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount + 1;
			_vars.syncPlayerVariables(sourceentity);
		}
	}
}