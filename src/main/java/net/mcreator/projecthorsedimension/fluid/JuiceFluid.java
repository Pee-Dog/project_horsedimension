package net.mcreator.projecthorsedimension.fluid;

import net.neoforged.neoforge.fluids.BaseFlowingFluid;

import net.minecraft.world.level.material.FluidState;
import net.minecraft.world.level.material.Fluid;
import net.minecraft.world.level.block.state.StateDefinition;
import net.minecraft.world.level.block.LiquidBlock;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModItems;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModFluids;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModFluidTypes;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModBlocks;

public abstract class JuiceFluid extends BaseFlowingFluid {
	public static final BaseFlowingFluid.Properties PROPERTIES = new BaseFlowingFluid.Properties(() -> ProjectHorsedimensionModFluidTypes.JUICE_TYPE.get(), () -> ProjectHorsedimensionModFluids.JUICE.get(),
			() -> ProjectHorsedimensionModFluids.FLOWING_JUICE.get()).explosionResistance(100f).slopeFindDistance(16).bucket(() -> ProjectHorsedimensionModItems.JUICE_BUCKET.get())
			.block(() -> (LiquidBlock) ProjectHorsedimensionModBlocks.JUICE.get());

	private JuiceFluid() {
		super(PROPERTIES);
	}

	public static class Source extends JuiceFluid {
		public int getAmount(FluidState state) {
			return 8;
		}

		public boolean isSource(FluidState state) {
			return true;
		}
	}

	public static class Flowing extends JuiceFluid {
		protected void createFluidStateDefinition(StateDefinition.Builder<Fluid, FluidState> builder) {
			super.createFluidStateDefinition(builder);
			builder.add(LEVEL);
		}

		public int getAmount(FluidState state) {
			return state.getValue(LEVEL);
		}

		public boolean isSource(FluidState state) {
			return false;
		}
	}
}