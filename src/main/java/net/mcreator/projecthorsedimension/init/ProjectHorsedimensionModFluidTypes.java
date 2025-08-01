/*
 * MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.NeoForgeRegistries;
import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;
import net.neoforged.neoforge.fluids.FluidType;

import net.mcreator.projecthorsedimension.fluid.types.JuiceFluidType;
import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class ProjectHorsedimensionModFluidTypes {
	public static final DeferredRegister<FluidType> REGISTRY = DeferredRegister.create(NeoForgeRegistries.FLUID_TYPES, ProjectHorsedimensionMod.MODID);
	public static final DeferredHolder<FluidType, FluidType> JUICE_TYPE = REGISTRY.register("juice", () -> new JuiceFluidType());
}