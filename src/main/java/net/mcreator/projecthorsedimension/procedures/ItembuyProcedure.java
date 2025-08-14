package net.mcreator.projecthorsedimension.procedures;

import net.neoforged.neoforge.items.ItemHandlerHelper;

import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.level.Level;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.sounds.SoundSource;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.core.BlockPos;

import net.mcreator.projecthorsedimension.network.ProjectHorsedimensionModVariables;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModMenus;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.entity.BovineEntity;

public class ItembuyProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof Player _plrSlotItem && _plrSlotItem.containerMenu instanceof ProjectHorsedimensionModMenus.MenuAccessor _menu0 ? _menu0.getSlots().get(1).getItem() : ItemStack.EMPTY).getItem() == ProjectHorsedimensionModItems.STAFF
				.get()) {
			if (5 <= entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount) {
				if (entity instanceof BovineEntity _datEntSetI)
					_datEntSetI.getEntityData().set(BovineEntity.DATA_slot1, 0);
				{
					ProjectHorsedimensionModVariables.PlayerVariables _vars = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES);
					_vars.coincount = entity.getData(ProjectHorsedimensionModVariables.PLAYER_VARIABLES).coincount - 5;
					_vars.syncPlayerVariables(entity);
				}
				if (entity instanceof Player _player && _player.containerMenu instanceof ProjectHorsedimensionModMenus.MenuAccessor _menu) {
					_menu.getSlots().get(1).remove(1);
					_player.containerMenu.broadcastChanges();
				}
				if (entity instanceof Player _player) {
					ItemStack _setstack = new ItemStack(ProjectHorsedimensionModItems.STAFF.get()).copy();
					_setstack.setCount(1);
					ItemHandlerHelper.giveItemToPlayer(_player, _setstack);
				}
				if (world instanceof Level _level) {
					if (!_level.isClientSide()) {
						_level.playSound(null, BlockPos.containing(x, y, z), BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsecoin.cash")), SoundSource.NEUTRAL, 1, 1);
					} else {
						_level.playLocalSound(x, y, z, BuiltInRegistries.SOUND_EVENT.getValue(ResourceLocation.parse("project_horsedimension:horsecoin.cash")), SoundSource.NEUTRAL, 1, 1, false);
					}
				}
			}
		}
	}
}