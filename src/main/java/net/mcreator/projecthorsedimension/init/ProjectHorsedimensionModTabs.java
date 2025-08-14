/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.event.BuildCreativeModeTabContentsEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;

import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.CreativeModeTabs;
import net.minecraft.world.item.CreativeModeTab;
import net.minecraft.network.chat.Component;
import net.minecraft.core.registries.Registries;

import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD)
public class ProjectHorsedimensionModTabs {
	public static final DeferredRegister<CreativeModeTab> REGISTRY = DeferredRegister.create(Registries.CREATIVE_MODE_TAB, ProjectHorsedimensionMod.MODID);
	public static final DeferredHolder<CreativeModeTab, CreativeModeTab> HORTH_DIMENSION_CREATIVE_TAB = REGISTRY.register("horth_dimension_creative_tab", () -> CreativeModeTab.builder()
			.title(Component.translatable("item_group.project_horsedimension.horth_dimension_creative_tab")).icon(() -> new ItemStack(ProjectHorsedimensionModItems.HORSEITEM.get())).displayItems((parameters, tabData) -> {
				tabData.accept(ProjectHorsedimensionModItems.HORSECOINCOLLECTABLE_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.EQUINE_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.HORSEKEY.get());
				tabData.accept(ProjectHorsedimensionModBlocks.ASTROTURF.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.RANUNCULUS.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.PEAJAK_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.PEA.get());
				tabData.accept(ProjectHorsedimensionModItems.BUNNY_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.GIBENTITY_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModBlocks.AGGREGATE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.CEMENT.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.YELLOW_CEMENT.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HEDGE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEPLANKS.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLESTAIRS.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLESLAB.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEFENCE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEFENCEGATE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEPRESSUREPLATE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEBUTTON.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEDOOR.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLETRAPDOOR.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_BLOCK.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_STAIRS.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_SLAB.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_STAIRS.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SLAB.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_WALL.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_WALL.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.BIRD_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.PEASHOOTER.get());
				tabData.accept(ProjectHorsedimensionModBlocks.PLANK_SLOPE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_RAISED_SLOPE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.RD_TREE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_LAYER.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.POPCORNCEILING.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.WHITE_DRYWALL.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.RAT_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModBlocks.LIGHTBULB.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.BARNHOUSE_PLANKS.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.BARNHOUSE_PLANK_SLOPE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.WHITE_BEAD_BLOCK.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.PALM_TREE.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.JUICE_BUCKET.get());
				tabData.accept(ProjectHorsedimensionModItems.GECKO_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModBlocks.SCRUB.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.SHORT_SCRUB.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.MEALWORMENTITY_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.CRICKETENTITY_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.CRICKETITEM.get());
				tabData.accept(ProjectHorsedimensionModItems.POOLGATOR_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModBlocks.BLOCKOFCOLORFULPEBBLES.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.LARGE_SEAWEED.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.BOULDER_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.BARNDOOR_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.BARNDOORITEM.get());
				tabData.accept(ProjectHorsedimensionModBlocks.FLOWRRING_ASTROTURF.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.TOADSTOOL.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.PLASTIC_YELLOW_FLOWER.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.SHRUB.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.CORNERSTONE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.PINETREE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.FARN.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.MULCH.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HDPORTALCENTER.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HDPORTALDIAMOND.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.PRISMRECEPTACLE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.NOISE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.HORSERECEPTACLE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.NOISEFLOOR.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.NOISEWALL.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.STATIC_RESIDUE.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.WALLBARRIER.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.FLOORBARRIER.get().asItem());
				tabData.accept(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get());
				tabData.accept(ProjectHorsedimensionModItems.BIRDWINGSOPEN_CHESTPLATE.get());
				tabData.accept(ProjectHorsedimensionModItems.CORRUPTEDWINGS_CHESTPLATE.get());
				tabData.accept(ProjectHorsedimensionModItems.DROMEDARY_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModItems.BOX_SPAWN_EGG.get());
				tabData.accept(ProjectHorsedimensionModBlocks.GASPUMP.get().asItem());
				tabData.accept(ProjectHorsedimensionModBlocks.TRASHCAN.get().asItem());
			}).build());

	@SubscribeEvent
	public static void buildTabContentsVanilla(BuildCreativeModeTabContentsEvent tabData) {
		if (tabData.getTabKey() == CreativeModeTabs.SPAWN_EGGS) {
			tabData.accept(ProjectHorsedimensionModItems.HORSECOINCOLLECTABLE_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.EQUINE_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.PEAJAK_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.BUNNY_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.GIBENTITY_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.BIRD_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.RAT_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.GECKO_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.MEALWORMENTITY_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.CRICKETENTITY_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.POOLGATOR_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.FISH_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.GNOME_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.DROMEDARY_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.BOVINE_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.CANIS_LATRANS_SPAWN_EGG.get());
			tabData.accept(ProjectHorsedimensionModItems.PEERAMID_SPAWN_EGG.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.BUILDING_BLOCKS) {
			tabData.accept(ProjectHorsedimensionModBlocks.ASTROTURF.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.AGGREGATE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.CEMENT.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.YELLOW_CEMENT.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEPLANKS.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLESTAIRS.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLESLAB.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEFENCE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEFENCEGATE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEDOOR.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLETRAPDOOR.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_BLOCK.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_STAIRS.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_SLAB.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_STAIRS.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SLAB.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_WALL.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_WALL.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.PLANK_SLOPE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_RAISED_SLOPE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.ASPHALT_SHINGLE_LAYER.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.PLANKFENCE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.POPCORNCEILING.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.WHITE_DRYWALL.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEFENCEPOST.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEFENCESIDE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.BARNHOUSE_PLANKS.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.BARNHOUSE_PLANK_SLOPE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.WHITE_BEAD_BLOCK.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.BLOCKOFCOLORFULPEBBLES.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.FLOWRRING_ASTROTURF.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.MULCH.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.NATURAL_BLOCKS) {
			tabData.accept(ProjectHorsedimensionModBlocks.ASTROTURF.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.RANUNCULUS.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.AGGREGATE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HEDGE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.RD_TREE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.WHITE_BEAD_BLOCK.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.PALM_TREE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.SCRUB.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.SHORT_SCRUB.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.BLOCKOFCOLORFULPEBBLES.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.LARGE_SEAWEED.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.FLOWRRING_ASTROTURF.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.TOADSTOOL.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.PLASTIC_YELLOW_FLOWER.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.SHRUB.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.PINETREE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.FARN.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.MULCH.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.TOOLS_AND_UTILITIES) {
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEBLOCK.get().asItem());
			tabData.accept(ProjectHorsedimensionModItems.STAFF.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FOOD_AND_DRINKS) {
			tabData.accept(ProjectHorsedimensionModItems.PEA.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.COLORED_BLOCKS) {
			tabData.accept(ProjectHorsedimensionModBlocks.CEMENT.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.YELLOW_CEMENT.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.WHITE_DRYWALL.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.REDSTONE_BLOCKS) {
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEPRESSUREPLATE.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.HORSEAPPLEBUTTON.get().asItem());
			tabData.accept(ProjectHorsedimensionModBlocks.LIGHTBULB.get().asItem());
		} else if (tabData.getTabKey() == CreativeModeTabs.COMBAT) {
			tabData.accept(ProjectHorsedimensionModItems.PEASHOOTER.get());
			tabData.accept(ProjectHorsedimensionModItems.BIRDWINGS_CHESTPLATE.get());
			tabData.accept(ProjectHorsedimensionModItems.BIRDWINGSOPEN_CHESTPLATE.get());
			tabData.accept(ProjectHorsedimensionModItems.CORRUPTEDWINGS_CHESTPLATE.get());
		} else if (tabData.getTabKey() == CreativeModeTabs.FUNCTIONAL_BLOCKS) {
			tabData.accept(ProjectHorsedimensionModBlocks.LIGHTBULB.get().asItem());
		}
	}
}