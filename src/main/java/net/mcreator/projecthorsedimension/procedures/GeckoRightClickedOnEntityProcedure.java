package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.ai.attributes.Attributes;
import net.minecraft.world.entity.TamableAnimal;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.GeckoEntity;

public class GeckoRightClickedOnEntityProcedure {
	public static void execute(Entity entity, Entity sourceentity) {
		if (entity == null || sourceentity == null)
			return;
		if (entity instanceof TamableAnimal _tamIsTamedBy && sourceentity instanceof LivingEntity _livEnt ? _tamIsTamedBy.isOwnedBy(_livEnt) : false) {
			if ((entity instanceof GeckoEntity _datEntI ? _datEntI.getEntityData().get(GeckoEntity.DATA_laying) : 0) == 0) {
				if (entity instanceof GeckoEntity _datEntSetI)
					_datEntSetI.getEntityData().set(GeckoEntity.DATA_laying, 1);
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.GECKO_LAYING.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.GECKO_LAYING.get()));
					}
				}
				if (entity instanceof LivingEntity _livingEntity4 && _livingEntity4.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity4.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0);
			} else {
				if (entity instanceof GeckoEntity _datEntSetI)
					_datEntSetI.getEntityData().set(GeckoEntity.DATA_laying, 0);
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.GECKO_ITEM.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.GECKO_ITEM.get()));
					}
				}
				if (entity instanceof LivingEntity _livingEntity7 && _livingEntity7.getAttributes().hasAttribute(Attributes.MOVEMENT_SPEED))
					_livingEntity7.getAttribute(Attributes.MOVEMENT_SPEED).setBaseValue(0.27);
			}
		}
	}
}