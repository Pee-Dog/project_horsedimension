package net.mcreator.projecthorsedimension.item;

import net.neoforged.neoforge.client.extensions.common.RegisterClientExtensionsEvent;
import net.neoforged.neoforge.client.extensions.common.IClientItemExtensions;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.OnlyIn;
import net.neoforged.api.distmarker.Dist;

import net.minecraft.world.level.Level;
import net.minecraft.world.item.equipment.EquipmentAssets;
import net.minecraft.world.item.equipment.ArmorType;
import net.minecraft.world.item.equipment.ArmorMaterial;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.ArmorItem;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.tags.TagKey;
import net.minecraft.sounds.SoundEvents;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;
import net.minecraft.core.registries.BuiltInRegistries;
import net.minecraft.client.resources.model.EquipmentClientInfo;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.Model;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.Minecraft;

import net.mcreator.projecthorsedimension.procedures.BirdwingsTickEventProcedure;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.client.model.Modelbirdwings_open;

import java.util.Map;
import java.util.Collections;

import com.google.common.collect.Iterables;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public abstract class BirdwingsopenItem extends ArmorItem {
	public static ArmorMaterial ARMOR_MATERIAL = new ArmorMaterial(15, Map.of(ArmorType.BOOTS, 2, ArmorType.LEGGINGS, 5, ArmorType.CHESTPLATE, 6, ArmorType.HELMET, 2, ArmorType.BODY, 6), 9,
			BuiltInRegistries.SOUND_EVENT.wrapAsHolder(SoundEvents.EMPTY), 0f, 0f, TagKey.create(Registries.ITEM, ResourceLocation.parse("project_horsedimension:birdwingsopen_repair_items")),
			ResourceKey.create(EquipmentAssets.ROOT_ID, ResourceLocation.parse("project_horsedimension:birdwingsopen")));

	@SubscribeEvent
	public static void registerItemExtensions(RegisterClientExtensionsEvent event) {
		event.registerItem(new IClientItemExtensions() {
			@Override
			@OnlyIn(Dist.CLIENT)
			public HumanoidModel getHumanoidArmorModel(ItemStack itemStack, EquipmentClientInfo.LayerType layerType, Model original) {
				return new HumanoidModel(new ModelPart(Collections.emptyList(),
						Map.of("body", new Modelbirdwings_open(Minecraft.getInstance().getEntityModels().bakeLayer(Modelbirdwings_open.LAYER_LOCATION)).wingus, "left_arm",
								new Modelbirdwings_open(Minecraft.getInstance().getEntityModels().bakeLayer(Modelbirdwings_open.LAYER_LOCATION)).empty, "right_arm",
								new Modelbirdwings_open(Minecraft.getInstance().getEntityModels().bakeLayer(Modelbirdwings_open.LAYER_LOCATION)).empty, "head",
								new ModelPart(Collections.emptyList(), Map.of("hat", new ModelPart(Collections.emptyList(), Collections.emptyMap()))), "right_leg", new ModelPart(Collections.emptyList(), Collections.emptyMap()), "left_leg",
								new ModelPart(Collections.emptyList(), Collections.emptyMap()))));
			}

			@Override
			public ResourceLocation getArmorTexture(ItemStack stack, EquipmentClientInfo.LayerType type, EquipmentClientInfo.Layer layer, ResourceLocation _default) {
				return ResourceLocation.parse("project_horsedimension:textures/models/armor/birdwings_layer_1.png");
			}
		}, ProjectHorsedimensionModItems.BIRDWINGSOPEN_CHESTPLATE.get());
	}

	private BirdwingsopenItem(ArmorType type, Item.Properties properties) {
		super(ARMOR_MATERIAL, type, properties);
	}

	public static class Chestplate extends BirdwingsopenItem {
		public Chestplate(Item.Properties properties) {
			super(ArmorType.CHESTPLATE, properties);
		}

		@Override
		public void inventoryTick(ItemStack itemstack, Level world, Entity entity, int slot, boolean selected) {
			super.inventoryTick(itemstack, world, entity, slot, selected);
			if (entity instanceof Player player && Iterables.contains(player.getArmorSlots(), itemstack)) {
				BirdwingsTickEventProcedure.execute(world, entity, itemstack);
			}
		}
	}
}