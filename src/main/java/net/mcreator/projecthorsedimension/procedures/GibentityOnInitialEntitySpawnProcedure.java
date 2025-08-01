package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.GibentityEntity;

public class GibentityOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof GibentityEntity _datEntI ? _datEntI.getEntityData().get(GibentityEntity.DATA_model) : 0) == 0) {
			if (entity instanceof GibentityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GibentityEntity.DATA_model, Mth.nextInt(RandomSource.create(), 1, 3));
		}
		if ((entity instanceof GibentityEntity _datEntI ? _datEntI.getEntityData().get(GibentityEntity.DATA_model) : 0) == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.GIB_1.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.GIB_1.get()));
				}
			}
		} else if ((entity instanceof GibentityEntity _datEntI ? _datEntI.getEntityData().get(GibentityEntity.DATA_model) : 0) == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.GIB_2.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.GIB_2.get()));
				}
			}
		} else if ((entity instanceof GibentityEntity _datEntI ? _datEntI.getEntityData().get(GibentityEntity.DATA_model) : 0) == 3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.GIB_3.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.GIB_3.get()));
				}
			}
		}
		entity.setDeltaMovement(new Vec3((entity.getLookAngle().x * Math.random()), 0.5, (entity.getLookAngle().z * Math.random())));
	}
}