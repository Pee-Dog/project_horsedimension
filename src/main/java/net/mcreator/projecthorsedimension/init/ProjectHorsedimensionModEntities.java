/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.entity.RegisterSpawnPlacementsEvent;
import net.neoforged.neoforge.event.entity.EntityAttributeCreationEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.entity.MobCategory;
import net.minecraft.world.entity.EntityType;
import net.minecraft.world.entity.Entity;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.resources.ResourceKey;
import net.minecraft.core.registries.Registries;

import net.mcreator.projecthorsedimension.entity.RatEntity;
import net.mcreator.projecthorsedimension.entity.PoolgatorEntity;
import net.mcreator.projecthorsedimension.entity.PeajectileEntity;
import net.mcreator.projecthorsedimension.entity.PeajakEntity;
import net.mcreator.projecthorsedimension.entity.NoiseCloudEntity;
import net.mcreator.projecthorsedimension.entity.MealwormentityEntity;
import net.mcreator.projecthorsedimension.entity.HorsecoinprojectileEntity;
import net.mcreator.projecthorsedimension.entity.HorsecoincollectableEntity;
import net.mcreator.projecthorsedimension.entity.GnomeEntity;
import net.mcreator.projecthorsedimension.entity.GibentityEntity;
import net.mcreator.projecthorsedimension.entity.GeckoEntity;
import net.mcreator.projecthorsedimension.entity.FishEntity;
import net.mcreator.projecthorsedimension.entity.EquineEntity;
import net.mcreator.projecthorsedimension.entity.CricketentityEntity;
import net.mcreator.projecthorsedimension.entity.CowFarmerEntity;
import net.mcreator.projecthorsedimension.entity.BunnyEntity;
import net.mcreator.projecthorsedimension.entity.BoulderEntity;
import net.mcreator.projecthorsedimension.entity.BirdEntity;
import net.mcreator.projecthorsedimension.entity.BarndoorEntity;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ProjectHorsedimensionModEntities {
	public static final DeferredRegister<EntityType<?>> REGISTRY = DeferredRegister.create(Registries.ENTITY_TYPE, ProjectHorsedimensionMod.MODID);
	public static final DeferredHolder<EntityType<?>, EntityType<HorsecoincollectableEntity>> HORSECOINCOLLECTABLE = register("horsecoincollectable",
			EntityType.Builder.<HorsecoincollectableEntity>of(HorsecoincollectableEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.2f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<EquineEntity>> EQUINE = register("equine",
			EntityType.Builder.<EquineEntity>of(EquineEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.8f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<PeajakEntity>> PEAJAK = register("peajak",
			EntityType.Builder.<PeajakEntity>of(PeajakEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BunnyEntity>> BUNNY = register("bunny",
			EntityType.Builder.<BunnyEntity>of(BunnyEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<GibentityEntity>> GIBENTITY = register("gibentity",
			EntityType.Builder.<GibentityEntity>of(GibentityEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<BirdEntity>> BIRD = register("bird",
			EntityType.Builder.<BirdEntity>of(BirdEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.7f, 0.7f));
	public static final DeferredHolder<EntityType<?>, EntityType<PeajectileEntity>> PEAJECTILE = register("peajectile",
			EntityType.Builder.<PeajectileEntity>of(PeajectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<RatEntity>> RAT = register("rat", EntityType.Builder.<RatEntity>of(RatEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

			.ridingOffset(-0.6f).sized(0.6f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<CowFarmerEntity>> COW_FARMER = register("cow_farmer",
			EntityType.Builder.<CowFarmerEntity>of(CowFarmerEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<GeckoEntity>> GECKO = register("gecko",
			EntityType.Builder.<GeckoEntity>of(GeckoEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<HorsecoinprojectileEntity>> HORSECOINPROJECTILE = register("horsecoinprojectile",
			EntityType.Builder.<HorsecoinprojectileEntity>of(HorsecoinprojectileEntity::new, MobCategory.MISC).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(1).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<MealwormentityEntity>> MEALWORMENTITY = register("mealwormentity",
			EntityType.Builder.<MealwormentityEntity>of(MealwormentityEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<CricketentityEntity>> CRICKETENTITY = register("cricketentity",
			EntityType.Builder.<CricketentityEntity>of(CricketentityEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.3f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<PoolgatorEntity>> POOLGATOR = register("poolgator",
			EntityType.Builder.<PoolgatorEntity>of(PoolgatorEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 0.3f));
	public static final DeferredHolder<EntityType<?>, EntityType<FishEntity>> FISH = register("fish",
			EntityType.Builder.<FishEntity>of(FishEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.6f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<BoulderEntity>> BOULDER = register("boulder",
			EntityType.Builder.<BoulderEntity>of(BoulderEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(2.5f, 1.8f));
	public static final DeferredHolder<EntityType<?>, EntityType<BarndoorEntity>> BARNDOOR = register("barndoor",
			EntityType.Builder.<BarndoorEntity>of(BarndoorEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(128).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.25f, 3f));
	public static final DeferredHolder<EntityType<?>, EntityType<GnomeEntity>> GNOME = register("gnome",
			EntityType.Builder.<GnomeEntity>of(GnomeEntity::new, MobCategory.CREATURE).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3)

					.ridingOffset(-0.6f).sized(0.5f, 0.5f));
	public static final DeferredHolder<EntityType<?>, EntityType<NoiseCloudEntity>> NOISE_CLOUD = register("noise_cloud",
			EntityType.Builder.<NoiseCloudEntity>of(NoiseCloudEntity::new, MobCategory.MONSTER).setShouldReceiveVelocityUpdates(true).setTrackingRange(64).setUpdateInterval(3).fireImmune().ridingOffset(-0.6f).sized(0.6f, 0.5f));

	// Start of user code block custom entities
	// End of user code block custom entities
	private static <T extends Entity> DeferredHolder<EntityType<?>, EntityType<T>> register(String registryname, EntityType.Builder<T> entityTypeBuilder) {
		return REGISTRY.register(registryname, () -> (EntityType<T>) entityTypeBuilder.build(ResourceKey.create(Registries.ENTITY_TYPE, ResourceLocation.fromNamespaceAndPath(ProjectHorsedimensionMod.MODID, registryname))));
	}

	@SubscribeEvent
	public static void init(RegisterSpawnPlacementsEvent event) {
		HorsecoincollectableEntity.init(event);
		EquineEntity.init(event);
		PeajakEntity.init(event);
		BunnyEntity.init(event);
		GibentityEntity.init(event);
		BirdEntity.init(event);
		RatEntity.init(event);
		CowFarmerEntity.init(event);
		GeckoEntity.init(event);
		MealwormentityEntity.init(event);
		CricketentityEntity.init(event);
		PoolgatorEntity.init(event);
		FishEntity.init(event);
		BoulderEntity.init(event);
		BarndoorEntity.init(event);
		GnomeEntity.init(event);
		NoiseCloudEntity.init(event);
	}

	@SubscribeEvent
	public static void registerAttributes(EntityAttributeCreationEvent event) {
		event.put(HORSECOINCOLLECTABLE.get(), HorsecoincollectableEntity.createAttributes().build());
		event.put(EQUINE.get(), EquineEntity.createAttributes().build());
		event.put(PEAJAK.get(), PeajakEntity.createAttributes().build());
		event.put(BUNNY.get(), BunnyEntity.createAttributes().build());
		event.put(GIBENTITY.get(), GibentityEntity.createAttributes().build());
		event.put(BIRD.get(), BirdEntity.createAttributes().build());
		event.put(RAT.get(), RatEntity.createAttributes().build());
		event.put(COW_FARMER.get(), CowFarmerEntity.createAttributes().build());
		event.put(GECKO.get(), GeckoEntity.createAttributes().build());
		event.put(MEALWORMENTITY.get(), MealwormentityEntity.createAttributes().build());
		event.put(CRICKETENTITY.get(), CricketentityEntity.createAttributes().build());
		event.put(POOLGATOR.get(), PoolgatorEntity.createAttributes().build());
		event.put(FISH.get(), FishEntity.createAttributes().build());
		event.put(BOULDER.get(), BoulderEntity.createAttributes().build());
		event.put(BARNDOOR.get(), BarndoorEntity.createAttributes().build());
		event.put(GNOME.get(), GnomeEntity.createAttributes().build());
		event.put(NOISE_CLOUD.get(), NoiseCloudEntity.createAttributes().build());
	}
}