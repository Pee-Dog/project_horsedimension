package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.BunnyEntity;

public class BunnyOnInitialEntitySpawnProcedure {
	public static void execute(Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof BunnyEntity _datEntI ? _datEntI.getEntityData().get(BunnyEntity.DATA_color) : 0) == 0) {
			if (entity instanceof BunnyEntity _datEntSetI)
				_datEntSetI.getEntityData().set(BunnyEntity.DATA_color, Mth.nextInt(RandomSource.create(), 1, 4));
		}
		if ((entity instanceof BunnyEntity _datEntI ? _datEntI.getEntityData().get(BunnyEntity.DATA_color) : 0) == 1) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM.get()));
				}
			}
		} else if ((entity instanceof BunnyEntity _datEntI ? _datEntI.getEntityData().get(BunnyEntity.DATA_color) : 0) == 2) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM_1.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM_1.get()));
				}
			}
		} else if ((entity instanceof BunnyEntity _datEntI ? _datEntI.getEntityData().get(BunnyEntity.DATA_color) : 0) == 3) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM_2.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM_2.get()));
				}
			}
		} else if ((entity instanceof BunnyEntity _datEntI ? _datEntI.getEntityData().get(BunnyEntity.DATA_color) : 0) == 4) {
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM_3.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.BUNNYITEM_3.get()));
				}
			}
		}
	}
}