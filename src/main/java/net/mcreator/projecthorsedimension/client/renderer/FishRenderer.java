package net.mcreator.projecthorsedimension.client.renderer;

import net.minecraft.world.level.Level;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;

import net.mcreator.projecthorsedimension.procedures.FishModelVisualScaleProcedure;
import net.mcreator.projecthorsedimension.entity.FishEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class FishRenderer extends HumanoidMobRenderer<FishEntity, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
	private FishEntity entity = null;

	public FishRenderer(EntityRendererProvider.Context context) {
		super(context, new HumanoidModel<HumanoidRenderState>(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
	}

	@Override
	public HumanoidRenderState createRenderState() {
		return new HumanoidRenderState();
	}

	@Override
	public void extractRenderState(FishEntity entity, HumanoidRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
	}

	@Override
	public ResourceLocation getTextureLocation(HumanoidRenderState state) {
		return ResourceLocation.parse("project_horsedimension:textures/entities/nothing.png");
	}

	@Override
	protected void scale(HumanoidRenderState state, PoseStack poseStack) {
		Level world = entity.level();
		double x = entity.getX();
		double y = entity.getY();
		double z = entity.getZ();
		float scale = (float) FishModelVisualScaleProcedure.execute(entity);
		poseStack.scale(scale, scale, scale);
		poseStack.scale(entity.getAgeScale(), entity.getAgeScale(), entity.getAgeScale());
	}
}