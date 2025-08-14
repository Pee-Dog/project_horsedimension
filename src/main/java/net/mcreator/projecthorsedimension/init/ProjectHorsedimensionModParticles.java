/*
 *    MCreator note: This file will be REGENERATED on each build.
 */
package net.mcreator.projecthorsedimension.init;

import net.neoforged.neoforge.client.event.RegisterParticleProvidersEvent;
import net.neoforged.fml.common.EventBusSubscriber;
import net.neoforged.bus.api.SubscribeEvent;
import net.neoforged.api.distmarker.Dist;

import net.mcreator.projecthorsedimension.client.particle.PeabitsParticle;
import net.mcreator.projecthorsedimension.client.particle.PackingpeanutParticle;
import net.mcreator.projecthorsedimension.client.particle.NoiseparticleParticle;
import net.mcreator.projecthorsedimension.client.particle.HorsecoinparticlesParticle;
import net.mcreator.projecthorsedimension.client.particle.HorsecoinParticle;
import net.mcreator.projecthorsedimension.client.particle.DeepbubbleParticle;
import net.mcreator.projecthorsedimension.client.particle.CoyoteParticle;
import net.mcreator.projecthorsedimension.client.particle.CardboardbitsParticle;
import net.mcreator.projecthorsedimension.client.particle.BloodtrailParticle;

@EventBusSubscriber(bus = EventBusSubscriber.Bus.MOD, value = Dist.CLIENT)
public class ProjectHorsedimensionModParticles {
	@SubscribeEvent
	public static void registerParticles(RegisterParticleProvidersEvent event) {
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.HORSECOIN.get(), HorsecoinParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.HORSECOINPARTICLES.get(), HorsecoinparticlesParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.BLOODTRAIL.get(), BloodtrailParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.PEABITS.get(), PeabitsParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.PACKINGPEANUT.get(), PackingpeanutParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.DEEPBUBBLE.get(), DeepbubbleParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.NOISEPARTICLE.get(), NoiseparticleParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.COYOTE.get(), CoyoteParticle::provider);
		event.registerSpriteSet(ProjectHorsedimensionModParticleTypes.CARDBOARDBITS.get(), CardboardbitsParticle::provider);
	}
}