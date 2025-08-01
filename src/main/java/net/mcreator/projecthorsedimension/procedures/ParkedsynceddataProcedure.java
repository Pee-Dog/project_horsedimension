package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.Entity;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.commands.CommandSourceStack;
import net.minecraft.commands.CommandSource;
import net.minecraft.client.Minecraft;

import net.mcreator.projecthorsedimension.entity.EquineEntity;

public class ParkedsynceddataProcedure {
	public static boolean execute(Entity entity) {
		if (entity == null)
			return false;
		if ((entity instanceof EquineEntity _datEntI ? _datEntI.getEntityData().get(EquineEntity.DATA_parked) : 0) == 1) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoAI:1,Silent:1}");
				}
			}
		} else if ((entity instanceof EquineEntity _datEntI ? _datEntI.getEntityData().get(EquineEntity.DATA_parked) : 0) == 0) {
			{
				Entity _ent = entity;
				if (!_ent.level().isClientSide() && _ent.getServer() != null) {
					_ent.getServer().getCommands().performPrefixedCommand(new CommandSourceStack(CommandSource.NULL, _ent.position(), _ent.getRotationVector(), _ent.level() instanceof ServerLevel ? (ServerLevel) _ent.level() : null, 4,
							_ent.getName().getString(), _ent.getDisplayName(), _ent.level().getServer(), _ent), "data merge entity @s {NoAI:0,Silent:0}");
				}
			}
		}
		if (entity.isVehicle()) {
			if (Minecraft.getInstance().options.keyUp.isDown()) {
				entity.setDeltaMovement(new Vec3((entity.getLookAngle().x), (entity.getDeltaMovement().y()), (entity.getLookAngle().z)));
			}
			if (Minecraft.getInstance().options.keyLeft.isDown()) {
				{
					Entity _ent = entity;
					_ent.setYRot(entity.getYRot() - 2);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
			}
			if (Minecraft.getInstance().options.keyRight.isDown()) {
				{
					Entity _ent = entity;
					_ent.setYRot(entity.getYRot() + 2);
					_ent.setXRot(entity.getXRot());
					_ent.setYBodyRot(_ent.getYRot());
					_ent.setYHeadRot(_ent.getYRot());
					_ent.yRotO = _ent.getYRot();
					_ent.xRotO = _ent.getXRot();
					if (_ent instanceof LivingEntity _entity) {
						_entity.yBodyRotO = _entity.getYRot();
						_entity.yHeadRotO = _entity.getYRot();
					}
				}
			}
			return false;
		}
		return true;
	}
}