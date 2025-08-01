/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.registries.DeferredRegister;
import net.neoforged.neoforge.registries.DeferredHolder;

import net.minecraft.core.registries.Registries;
import net.minecraft.core.particles.SimpleParticleType;
import net.minecraft.core.particles.ParticleType;

import net.mcreator.projecthorsedimension.ProjectHorsedimensionMod;

public class ProjectHorsedimensionModParticleTypes {
	public static final DeferredRegister<ParticleType<?>> REGISTRY = DeferredRegister.create(Registries.PARTICLE_TYPE, ProjectHorsedimensionMod.MODID);
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HORSECOIN = REGISTRY.register("horsecoin", () -> new SimpleParticleType(true));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> HORSECOINPARTICLES = REGISTRY.register("horsecoinparticles", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> BLOODTRAIL = REGISTRY.register("bloodtrail", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PEABITS = REGISTRY.register("peabits", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> PACKINGPEANUT = REGISTRY.register("packingpeanut", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> DEEPBUBBLE = REGISTRY.register("deepbubble", () -> new SimpleParticleType(false));
	public static final DeferredHolder<ParticleType<?>, SimpleParticleType> NOISEPARTICLE = REGISTRY.register("noiseparticle", () -> new SimpleParticleType(false));
}