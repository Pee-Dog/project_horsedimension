package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.world.entity.EquipmentSlot;
import net.minecraft.world.entity.Entity;
import net.minecraft.world.effect.MobEffects;
import net.minecraft.world.effect.MobEffectInstance;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.client.Minecraft;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class BirdwingsTickEventProcedure {
	public static void execute(LevelAccessor world, Entity entity, ItemStack itemstack) {
		if (entity == null)
			return;
		if (entity instanceof LivingEntity _entity && !_entity.level().isClientSide())
			_entity.addEffect(new MobEffectInstance(MobEffects.SLOW_FALLING, 1, 0, true, false));
		if (Minecraft.getInstance().options.keyJump.isDown()) {
			entity.setDeltaMovement(new Vec3((0.5 * entity.getLookAngle().x), 0.75, (0.5 * entity.getLookAngle().z)));
			{
				Entity _entity = entity;
				if (_entity instanceof Player _player) {
					_player.getInventory().armor.set(2, new ItemStack(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get()));
					_player.getInventory().setChanged();
				} else if (_entity instanceof LivingEntity _living) {
					_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get()));
				}
			}
			new ItemStack(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get()).applyComponents(itemstack.getComponents());
			if (world instanceof ServerLevel _level) {
				new ItemStack(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get()).hurtAndBreak(itemstack.getDamageValue(), _level, null, _stkprov -> {
				});
			}
			ProjectHorsedimensionMod.queueServerWork(10, () -> {
				{
					Entity _entity = entity;
					if (_entity instanceof Player _player) {
						_player.getInventory().armor.set(2, new ItemStack(ProjectHorsedimensionModItems.BIRDWINGSOPEN_CHESTPLATE.get()));
						_player.getInventory().setChanged();
					} else if (_entity instanceof LivingEntity _living) {
						_living.setItemSlot(EquipmentSlot.CHEST, new ItemStack(ProjectHorsedimensionModItems.BIRDWINGSOPEN_CHESTPLATE.get()));
					}
				}
				new ItemStack(ProjectHorsedimensionModItems.BIRDWINGSOPEN_CHESTPLATE.get()).applyComponents(itemstack.getComponents());
				if (world instanceof ServerLevel _level) {
					new ItemStack(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get()).hurtAndBreak(itemstack.getDamageValue(), _level, null, _stkprov -> {
					});
				}
			});
		}
	}
}