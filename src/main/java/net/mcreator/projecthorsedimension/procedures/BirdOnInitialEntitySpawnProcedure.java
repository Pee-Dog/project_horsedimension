package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

public class BirdOnInitialEntitySpawnProcedure {
	public static void execute(double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		{
			Entity _ent = entity;
			_ent.teleportTo(x, (y + 20), z);
			if (_ent instanceof ServerPlayer _serverPlayer)
				_serverPlayer.connection.teleport(x, (y + 20), z, _ent.getYRot(), _ent.getXRot());
		}
	}
}