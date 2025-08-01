package net.mcreator.projecthorsedimension.procedures;

import net.minecraft.world.phys.Vec3;
import net.minecraft.world.phys.AABB;
import net.minecraft.world.level.LevelAccessor;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.Entity;
import net.minecraft.util.RandomSource;
import net.minecraft.util.Mth;
import net.minecraft.server.level.ServerLevel;
import net.minecraft.core.particles.SimpleParticleType;

import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModParticleTypes;
import net.mcreator.projecthorsedimension.entity.GibentityEntity;

public class GibentityOnEntityTickUpdateProcedure {
	public static void execute(LevelAccessor world, double x, double y, double z, Entity entity) {
		if (entity == null)
			return;
		if ((entity instanceof GibentityEntity _datEntI ? _datEntI.getEntityData().get(GibentityEntity.DATA_model) : 0) == 0) {
			if (entity instanceof GibentityEntity _datEntSetI)
				_datEntSetI.getEntityData().set(GibentityEntity.DATA_model, Mth.nextInt(RandomSource.create(), 1, 3));
		}
		if (!(!world.getEntitiesOfClass(Player.class, new AABB(Vec3.ZERO, Vec3.ZERO).move(new Vec3(x, y, z)).inflate(20 / 2d), e -> true).isEmpty())) {
			if (!entity.level().isClientSide())
				entity.discard();
		}
		if (world instanceof ServerLevel _level)
			_level.sendParticles((SimpleParticleType) (ProjectHorsedimensionModParticleTypes.BLOODTRAIL.get()), x, y, z, 1, 0.1, 0.1, 0.1, 0);
	}
}