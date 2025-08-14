package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Mob;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;
import net.mcreator.projecthorsedimension.entity.BovineEntity;

public class CowFarmerSleepProcedure {
	public static boolean execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return false;
		if (!(world instanceof Level _lvl0 && _lvl0.isDay())) {
			if ((entity instanceof BovineEntity _datEntL1 && _datEntL1.getEntityData().get(BovineEntity.DATA_awake)) == true) {
				if (entity instanceof Mob _entity)
					_entity.getNavigation().moveTo((entity instanceof BovineEntity _datEntI ? _datEntI.getEntityData().get(BovineEntity.DATA_homex) : 0),
							(entity instanceof BovineEntity _datEntI ? _datEntI.getEntityData().get(BovineEntity.DATA_homey) : 0), (entity instanceof BovineEntity _datEntI ? _datEntI.getEntityData().get(BovineEntity.DATA_homez) : 0), 1);
				if ((world.getBlockState(BlockPos.containing(x, y, z))).getBlock() == ProjectHorsedimensionModBlocks.PILLOW.get()) {
					if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.COWFARMERITEM.get()) {
						{
							Entity _entity = entity;
							if (_entity instanceof Player _player) {
								_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.COWSLEEPITEM.get()));
								_player.getInventory().setChanged();
							} else if (_entity instanceof LivingEntity _living) {
								_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.COWSLEEPITEM.get()));
							}
						}
						if (entity instanceof BovineEntity _datEntSetL)
							_datEntSetL.getEntityData().set(BovineEntity.DATA_awake, false);
					}
				}
			}
		} else {
			if ((entity instanceof LivingEntity _entGetArmor ? _entGetArmor.getItemBySlot(EquipmentSlot.HEAD) : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.COWSLEEPITEM.get()) {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(3, new ItemStack(ProjectHorsedimensionModItems.COWFARMERITEM.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.HEAD, new ItemStack(ProjectHorsedimensionModItems.COWFARMERITEM.get()));
					}
				}
				if (entity instanceof BovineEntity _datEntSetL)
					_datEntSetL.getEntityData().set(BovineEntity.DATA_awake, true);
			}
		}
		return entity instanceof BovineEntity _datEntL16 && _datEntL16.getEntityData().get(BovineEntity.DATA_awake);
	}
}