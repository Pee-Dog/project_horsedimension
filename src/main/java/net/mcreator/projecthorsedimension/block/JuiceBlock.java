package net.mcreator.projecthorsedimension.block;

import net.minecraft.world.level.material.PushReaction;
import net.minecraft.world.level.material.MapColor;
import net.minecraft.world.level.block.state.BlockBehaviour;
import net.minecraft.world.level.block.SoundType;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModFluids;

public class JuiceBlock extends LiquidBlock {
	public JuiceBlock(BlockBehaviour.Properties properties) {
		super(ProjectHorsedimensionModFluids.JUICE.get(), properties.mapColor(MapColor.WATER).strength(100f).noCollission().noLootTable().liquid().pushReaction(PushReaction.DESTROY).sound(SoundType.EMPTY).replaceable());
	}
}