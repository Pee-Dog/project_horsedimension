package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerPlayer;

import net.mcreator.projecthorsedimension.entity.BoxEntity;

import java.util.Comparator;

public class BoxOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		Entity carrysource = null;
		if (!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(6 / 2d), e -> true).isEmpty()) {
			carrysource = findEntityInWorldRange(world, Player.class, x, y, z, 6);
			if ((entity instanceof BoxEntity _datEntL2 && _datEntL2.getEntityData().get(BoxEntity.DATA_carried)) == true) {
				entity.setNoGravity(true);
				{
					Entity _ent = entity;
					_ent.teleportTo((carrysource.getX() + carrysource.getLookAngle().x * 2), (carrysource.getY() + carrysource.getLookAngle().y * 2 + 1), (carrysource.getZ() + carrysource.getLookAngle().z * 2));
					if (_ent instanceof ServerPlayer _serverPlayer)
						_serverPlayer.connection.teleport((carrysource.getX() + carrysource.getLookAngle().x * 2), (carrysource.getY() + carrysource.getLookAngle().y * 2 + 1), (carrysource.getZ() + carrysource.getLookAngle().z * 2), _ent.getYRot(),
								_ent.getXRot());
				}
			}
		}
	}

	private static Entity findEntityInWorldRange(LevelAccessor world, Class<? extends Entity> clazz, double x, double y, double z, double range) {
		return (Entity) world.getEntitiesOfClass(clazz, AABB.ofSize(new Vec3(x, y, z), range, range, range), e -> true).stream().sorted(Comparator.comparingDouble(e -> e.distanceToSqr(x, y, z))).findFirst().orElse(null);
	}
}