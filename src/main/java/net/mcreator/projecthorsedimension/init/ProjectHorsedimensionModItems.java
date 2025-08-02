/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredItem;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.world.level.block.Block;
import net.minecraft.world.item.SpawnEggItem;
import net.minecraft.world.item.Rarity;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.DoubleHighBlockItem;
import net.minecraft.world.item.BlockItem;

import net.mcreator.projecthorsedimension.item.RatitemItem;
import net.mcreator.projecthorsedimension.item.PeashooterItem;
import net.mcreator.projecthorsedimension.item.PeajakitemItem;
import net.mcreator.projecthorsedimension.item.Peajakitem2Item;
import net.mcreator.projecthorsedimension.item.Peajakitem1Item;
import net.mcreator.projecthorsedimension.item.PeajakhanditemItem;
import net.mcreator.projecthorsedimension.item.PeaItem;
import net.mcreator.projecthorsedimension.item.MealwormheaditemItem;
import net.mcreator.projecthorsedimension.item.MealwormItem;
import net.mcreator.projecthorsedimension.item.JuiceItem;
import net.mcreator.projecthorsedimension.item.HorsekeyItem;
import net.mcreator.projecthorsedimension.item.HorseitemItem;
import net.mcreator.projecthorsedimension.item.HorsecoinitemItem;
import net.mcreator.projecthorsedimension.item.GnomeitemItem;
import net.mcreator.projecthorsedimension.item.GibItem;
import net.mcreator.projecthorsedimension.item.Gib3Item;
import net.mcreator.projecthorsedimension.item.Gib2Item;
import net.mcreator.projecthorsedimension.item.Gib1Item;
import net.mcreator.projecthorsedimension.item.GeckoLayingItem;
import net.mcreator.projecthorsedimension.item.GeckoItemItem;
import net.mcreator.projecthorsedimension.item.FishitemItem;
import net.mcreator.projecthorsedimension.item.CricketitemItem;
import net.mcreator.projecthorsedimension.item.CricketheaditemItem;
import net.mcreator.projecthorsedimension.item.CowfarmeritemItem;
import net.mcreator.projecthorsedimension.item.CorruptedwingsItem;
import net.mcreator.projecthorsedimension.item.BunnyitemItem;
import net.mcreator.projecthorsedimension.item.Bunnyitem3Item;
import net.mcreator.projecthorsedimension.item.Bunnyitem2Item;
import net.mcreator.projecthorsedimension.item.Bunnyitem1Item;
import net.mcreator.projecthorsedimension.item.BoulderitemItem;
import net.mcreator.projecthorsedimension.item.BottleofstaticItem;
import net.mcreator.projecthorsedimension.item.BirdwingsopenItem;
import net.mcreator.projecthorsedimension.item.BirdwingsItem;
import net.mcreator.projecthorsedimension.item.BirditemItem;
import net.mcreator.projecthorsedimension.item.BarndoorrightitemItem;
import net.mcreator.projecthorsedimension.item.BarndoorleftitemItem;
import net.mcreator.projecthorsedimension.item.BarndooritemItem;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

import java.util.function.Function;

public class ProjectHorsedimensionModItems {
	public static final DeferredRegister.Items REGISTRY = DeferredRegister.createItems(ProjectHorsedimensionMod.MODID);
	public static final DeferredItem<Item> HORSECOINCOLLECTABLE_SPAWN_EGG = register("horsecoincollectable_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.HORSECOINCOLLECTABLE.get(), properties));
	public static final DeferredItem<Item> HORSEITEM = register("horseitem", HorseitemItem::new);
	public static final DeferredItem<Item> EQUINE_SPAWN_EGG = register("equine_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.EQUINE.get(), properties));
	public static final DeferredItem<Item> HORSEKEY = register("horsekey", HorsekeyItem::new);
	public static final DeferredItem<Item> ASTROTURF = block(ProjectHorsedimensionModBlocks.ASTROTURF);
	public static final DeferredItem<Item> ASPHALT = block(ProjectHorsedimensionModBlocks.ASPHALT);
	public static final DeferredItem<Item> HORSEBLOCK = block(ProjectHorsedimensionModBlocks.HORSEBLOCK, new Item.Properties().stacksTo(1).rarity(Rarity.EPIC));
	public static final DeferredItem<Item> RANUNCULUS = block(ProjectHorsedimensionModBlocks.RANUNCULUS);
	public static final DeferredItem<Item> BUNNYITEM = register("bunnyitem", BunnyitemItem::new);
	public static final DeferredItem<Item> PEAJAKITEM = register("peajakitem", PeajakitemItem::new);
	public static final DeferredItem<Item> PEAJAK_SPAWN_EGG = register("peajak_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.PEAJAK.get(), properties));
	public static final DeferredItem<Item> PEA = register("pea", PeaItem::new);
	public static final DeferredItem<Item> BUNNY_SPAWN_EGG = register("bunny_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.BUNNY.get(), properties));
	public static final DeferredItem<Item> BUNNYITEM_1 = register("bunnyitem_1", Bunnyitem1Item::new);
	public static final DeferredItem<Item> BUNNYITEM_2 = register("bunnyitem_2", Bunnyitem2Item::new);
	public static final DeferredItem<Item> BUNNYITEM_3 = register("bunnyitem_3", Bunnyitem3Item::new);
	public static final DeferredItem<Item> GIBENTITY_SPAWN_EGG = register("gibentity_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.GIBENTITY.get(), properties));
	public static final DeferredItem<Item> GIB_1 = register("gib_1", Gib1Item::new);
	public static final DeferredItem<Item> GIB_2 = register("gib_2", Gib2Item::new);
	public static final DeferredItem<Item> GIB_3 = register("gib_3", Gib3Item::new);
	public static final DeferredItem<Item> AGGREGATE = block(ProjectHorsedimensionModBlocks.AGGREGATE);
	public static final DeferredItem<Item> CEMENT = block(ProjectHorsedimensionModBlocks.CEMENT);
	public static final DeferredItem<Item> YELLOW_CEMENT = block(ProjectHorsedimensionModBlocks.YELLOW_CEMENT);
	public static final DeferredItem<Item> HEDGE = block(ProjectHorsedimensionModBlocks.HEDGE);
	public static final DeferredItem<Item> HORSEAPPLEPLANKS = block(ProjectHorsedimensionModBlocks.HORSEAPPLEPLANKS);
	public static final DeferredItem<Item> HORSEAPPLESTAIRS = block(ProjectHorsedimensionModBlocks.HORSEAPPLESTAIRS);
	public static final DeferredItem<Item> HORSEAPPLESLAB = block(ProjectHorsedimensionModBlocks.HORSEAPPLESLAB);
	public static final DeferredItem<Item> HORSEAPPLEFENCE = block(ProjectHorsedimensionModBlocks.HORSEAPPLEFENCE);
	public static final DeferredItem<Item> HORSEAPPLEFENCEGATE = block(ProjectHorsedimensionModBlocks.HORSEAPPLEFENCEGATE);
	public static final DeferredItem<Item> HORSEAPPLEPRESSUREPLATE = block(ProjectHorsedimensionModBlocks.HORSEAPPLEPRESSUREPLATE);
	public static final DeferredItem<Item> HORSEAPPLEBUTTON = block(ProjectHorsedimensionModBlocks.HORSEAPPLEBUTTON);
	public static final DeferredItem<Item> HORSEAPPLEDOOR = doubleBlock(ProjectHorsedimensionModBlocks.HORSEAPPLEDOOR);
	public static final DeferredItem<Item> HORSEAPPLETRAPDOOR = block(ProjectHorsedimensionModBlocks.HORSEAPPLETRAPDOOR);
	public static final DeferredItem<Item> ASPHALT_SHINGLE_BLOCK = block(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_BLOCK);
	public static final DeferredItem<Item> ASPHALT_SHINGLE_STAIRS = block(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_STAIRS);
	public static final DeferredItem<Item> ASPHALT_SHINGLE_SLAB = block(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_SLAB);
	public static final DeferredItem<Item> ASPHALT_STAIRS = block(ProjectHorsedimensionModBlocks.ASPHALT_STAIRS);
	public static final DeferredItem<Item> ASPHALT_SLAB = block(ProjectHorsedimensionModBlocks.ASPHALT_SLAB);
	public static final DeferredItem<Item> ASPHALT_WALL = block(ProjectHorsedimensionModBlocks.ASPHALT_WALL);
	public static final DeferredItem<Item> ASPHALT_SHINGLE_WALL = block(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_WALL);
	public static final DeferredItem<Item> BIRDITEM = register("birditem", BirditemItem::new);
	public static final DeferredItem<Item> BIRD_SPAWN_EGG = register("bird_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.BIRD.get(), properties));
	public static final DeferredItem<Item> PEAJAKITEM_1 = register("peajakitem_1", Peajakitem1Item::new);
	public static final DeferredItem<Item> PEAJAKITEM_2 = register("peajakitem_2", Peajakitem2Item::new);
	public static final DeferredItem<Item> PEASHOOTER = register("peashooter", PeashooterItem::new);
	public static final DeferredItem<Item> PEAJAKHANDITEM = register("peajakhanditem", PeajakhanditemItem::new);
	public static final DeferredItem<Item> PLANK_SLOPE = block(ProjectHorsedimensionModBlocks.PLANK_SLOPE);
	public static final DeferredItem<Item> ASPHALT_SHINGLE_RAISED_SLOPE = block(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_RAISED_SLOPE);
	public static final DeferredItem<Item> RD_TREE = block(ProjectHorsedimensionModBlocks.RD_TREE, new Item.Properties().stacksTo(1));
	public static final DeferredItem<Item> ASPHALT_SHINGLE_LAYER = block(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_LAYER);
	public static final DeferredItem<Item> PLANKFENCE = block(ProjectHorsedimensionModBlocks.PLANKFENCE);
	public static final DeferredItem<Item> POPCORNCEILING = block(ProjectHorsedimensionModBlocks.POPCORNCEILING);
	public static final DeferredItem<Item> WHITE_DRYWALL = block(ProjectHorsedimensionModBlocks.WHITE_DRYWALL);
	public static final DeferredItem<Item> HORSEFENCEPOST = block(ProjectHorsedimensionModBlocks.HORSEFENCEPOST);
	public static final DeferredItem<Item> HORSEFENCESIDE = block(ProjectHorsedimensionModBlocks.HORSEFENCESIDE);
	public static final DeferredItem<Item> RAT_SPAWN_EGG = register("rat_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.RAT.get(), properties));
	public static final DeferredItem<Item> RATITEM = register("ratitem", RatitemItem::new);
	public static final DeferredItem<Item> COWFARMERITEM = register("cowfarmeritem", CowfarmeritemItem::new);
	public static final DeferredItem<Item> COW_FARMER_SPAWN_EGG = register("cow_farmer_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.COW_FARMER.get(), properties));
	public static final DeferredItem<Item> LIGHTBULB = block(ProjectHorsedimensionModBlocks.LIGHTBULB);
	public static final DeferredItem<Item> GIB = register("gib", GibItem::new);
	public static final DeferredItem<Item> BARNHOUSE_PLANKS = block(ProjectHorsedimensionModBlocks.BARNHOUSE_PLANKS);
	public static final DeferredItem<Item> BARNHOUSE_PLANK_SLOPE = block(ProjectHorsedimensionModBlocks.BARNHOUSE_PLANK_SLOPE);
	public static final DeferredItem<Item> BLOOD = block(ProjectHorsedimensionModBlocks.BLOOD);
	public static final DeferredItem<Item> SCAR_TISSUE = block(ProjectHorsedimensionModBlocks.SCAR_TISSUE);
	public static final DeferredItem<Item> WIRE = block(ProjectHorsedimensionModBlocks.WIRE);
	public static final DeferredItem<Item> WHITE_BEAD_BLOCK = block(ProjectHorsedimensionModBlocks.WHITE_BEAD_BLOCK);
	public static final DeferredItem<Item> PALM_TREE = block(ProjectHorsedimensionModBlocks.PALM_TREE, new Item.Properties().stacksTo(1));
	public static final DeferredItem<Item> CARDBOARDBLOCK = block(ProjectHorsedimensionModBlocks.CARDBOARDBLOCK);
	public static final DeferredItem<Item> JUICE_BUCKET = register("juice_bucket", JuiceItem::new);
	public static final DeferredItem<Item> GECKO_SPAWN_EGG = register("gecko_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.GECKO.get(), properties));
	public static final DeferredItem<Item> GECKO_ITEM = register("gecko_item", GeckoItemItem::new);
	public static final DeferredItem<Item> MEALWORM = register("mealworm", MealwormItem::new);
	public static final DeferredItem<Item> SCRUB = block(ProjectHorsedimensionModBlocks.SCRUB);
	public static final DeferredItem<Item> SHORT_SCRUB = block(ProjectHorsedimensionModBlocks.SHORT_SCRUB);
	public static final DeferredItem<Item> HORSECOINITEM = register("horsecoinitem", HorsecoinitemItem::new);
	public static final DeferredItem<Item> MEALWORMENTITY_SPAWN_EGG = register("mealwormentity_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.MEALWORMENTITY.get(), properties));
	public static final DeferredItem<Item> MEALWORMHEADITEM = register("mealwormheaditem", MealwormheaditemItem::new);
	public static final DeferredItem<Item> CRICKETHEADITEM = register("cricketheaditem", CricketheaditemItem::new);
	public static final DeferredItem<Item> CRICKETENTITY_SPAWN_EGG = register("cricketentity_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.CRICKETENTITY.get(), properties));
	public static final DeferredItem<Item> CRICKETITEM = register("cricketitem", CricketitemItem::new);
	public static final DeferredItem<Item> GECKO_LAYING = register("gecko_laying", GeckoLayingItem::new);
	public static final DeferredItem<Item> POOLGATOR_SPAWN_EGG = register("poolgator_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.POOLGATOR.get(), properties));
	public static final DeferredItem<Item> BLOCKOFCOLORFULPEBBLES = block(ProjectHorsedimensionModBlocks.BLOCKOFCOLORFULPEBBLES);
	public static final DeferredItem<Item> FISH_SPAWN_EGG = register("fish_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.FISH.get(), properties));
	public static final DeferredItem<Item> FISHITEM = register("fishitem", FishitemItem::new);
	public static final DeferredItem<Item> LARGE_SEAWEED = block(ProjectHorsedimensionModBlocks.LARGE_SEAWEED);
	public static final DeferredItem<Item> BOULDERITEM = register("boulderitem", BoulderitemItem::new);
	public static final DeferredItem<Item> BOULDER_SPAWN_EGG = register("boulder_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.BOULDER.get(), properties));
	public static final DeferredItem<Item> BARNDOOR_SPAWN_EGG = register("barndoor_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.BARNDOOR.get(), properties));
	public static final DeferredItem<Item> BARNDOORLEFTITEM = register("barndoorleftitem", BarndoorleftitemItem::new);
	public static final DeferredItem<Item> BARNDOORRIGHTITEM = register("barndoorrightitem", BarndoorrightitemItem::new);
	public static final DeferredItem<Item> BARNDOORITEM = register("barndooritem", BarndooritemItem::new);
	public static final DeferredItem<Item> FLOWRRING_ASTROTURF = block(ProjectHorsedimensionModBlocks.FLOWRRING_ASTROTURF);
	public static final DeferredItem<Item> TOADSTOOL = block(ProjectHorsedimensionModBlocks.TOADSTOOL);
	public static final DeferredItem<Item> GNOMEITEM = register("gnomeitem", GnomeitemItem::new);
	public static final DeferredItem<Item> GNOME_SPAWN_EGG = register("gnome_spawn_egg", properties -> new SpawnEggItem(ProjectHorsedimensionModEntities.GNOME.get(), properties));
	public static final DeferredItem<Item> PLASTIC_YELLOW_FLOWER = block(ProjectHorsedimensionModBlocks.PLASTIC_YELLOW_FLOWER);
	public static final DeferredItem<Item> SHRUB = block(ProjectHorsedimensionModBlocks.SHRUB);
	public static final DeferredItem<Item> CORNERSTONE = block(ProjectHorsedimensionModBlocks.CORNERSTONE, new Item.Properties().rarity(Rarity.RARE));
	public static final DeferredItem<Item> PINETREE = block(ProjectHorsedimensionModBlocks.PINETREE, new Item.Properties().stacksTo(1));
	public static final DeferredItem<Item> FARN = block(ProjectHorsedimensionModBlocks.FARN);
	public static final DeferredItem<Item> MULCH = block(ProjectHorsedimensionModBlocks.MULCH);
	public static final DeferredItem<Item> HDPORTALCENTER = block(ProjectHorsedimensionModBlocks.HDPORTALCENTER, new Item.Properties().rarity(Rarity.RARE));
	public static final DeferredItem<Item> HDPORTALDIAMOND = block(ProjectHorsedimensionModBlocks.HDPORTALDIAMOND, new Item.Properties().rarity(Rarity.RARE));
	public static final DeferredItem<Item> PRISMRECEPTACLE = block(ProjectHorsedimensionModBlocks.PRISMRECEPTACLE, new Item.Properties().rarity(Rarity.RARE));
	public static final DeferredItem<Item> ENERGETIC_COSMIC_NOISE = block(ProjectHorsedimensionModBlocks.ENERGETIC_COSMIC_NOISE);
	public static final DeferredItem<Item> WEAK_COSMIC_NOISE = block(ProjectHorsedimensionModBlocks.WEAK_COSMIC_NOISE);
	public static final DeferredItem<Item> NOISE = block(ProjectHorsedimensionModBlocks.NOISE);
	public static final DeferredItem<Item> HORSERECEPTACLE = block(ProjectHorsedimensionModBlocks.HORSERECEPTACLE, new Item.Properties().rarity(Rarity.RARE));
	public static final DeferredItem<Item> NOISEFLOOR = block(ProjectHorsedimensionModBlocks.NOISEFLOOR);
	public static final DeferredItem<Item> NOISEWALL = block(ProjectHorsedimensionModBlocks.NOISEWALL);
	public static final DeferredItem<Item> BOTTLEOFSTATIC = register("bottleofstatic", BottleofstaticItem::new);
	public static final DeferredItem<Item> STATIC_RESIDUE = block(ProjectHorsedimensionModBlocks.STATIC_RESIDUE);
	public static final DeferredItem<Item> WALLBARRIER = block(ProjectHorsedimensionModBlocks.WALLBARRIER);
	public static final DeferredItem<Item> FLOORBARRIER = block(ProjectHorsedimensionModBlocks.FLOORBARRIER);
	public static final DeferredItem<Item> BIRDWINGS_CHESTPLATE = register("birdwings_chestplate", BirdwingsItem.Chestplate::new);
	public static final DeferredItem<Item> BIRDWINGSOPEN_CHESTPLATE = register("birdwingsopen_chestplate", BirdwingsopenItem.Chestplate::new);
	public static final DeferredItem<Item> CORRUPTEDWINGS_CHESTPLATE = register("corruptedwings_chestplate", CorruptedwingsItem.Chestplate::new);

	// Start of user code block custom items
	// End of user code block custom items
	private static <I extends Item> DeferredItem<I> register(String name, Function<Item.Properties, ? extends I> supplier) {
		return REGISTRY.registerItem(name, supplier, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block) {
		return block(block, new Item.Properties());
	}

	private static DeferredItem<Item> block(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new BlockItem(block.get(), prop), properties);
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block) {
		return doubleBlock(block, new Item.Properties());
	}

	private static DeferredItem<Item> doubleBlock(DeferredHolder<Block, Block> block, Item.Properties properties) {
		return REGISTRY.registerItem(block.getId().getPath(), prop -> new DoubleHighBlockItem(block.get(), prop), properties);
	}
}