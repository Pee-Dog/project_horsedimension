package net.mcreator.projecthorsedimension.client.renderer;

import net.minecraft.resources.ResourceLocation;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.entity.layers.HumanoidArmorLayer;
import net.minecraft.client.renderer.entity.HumanoidMobRenderer;
import net.minecraft.client.renderer.entity.EntityRendererProvider;
import net.minecraft.client.model.geom.ModelPart;
import net.minecraft.client.model.geom.ModelLayers;
import net.minecraft.client.model.HumanoidModel;
import net.minecraft.client.animation.definitions.ArmadilloAnimation;

import net.mcreator.projecthorsedimension.entity.MealwormentityEntity;

import com.mojang.blaze3d.vertex.PoseStack;

public class MealwormentityRenderer extends HumanoidMobRenderer<MealwormentityEntity, HumanoidRenderState, HumanoidModel<HumanoidRenderState>> {
	private MealwormentityEntity entity = null;

	public MealwormentityRenderer(EntityRendererProvider.Context context) {
		super(context, new AnimatedModel(context.bakeLayer(ModelLayers.PLAYER)), 0f);
		this.addLayer(new HumanoidArmorLayer(this, new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_INNER_ARMOR)), new HumanoidModel(context.bakeLayer(ModelLayers.PLAYER_OUTER_ARMOR)), context.getEquipmentRenderer()));
	}

	@Override
	public HumanoidRenderState createRenderState() {
		return new HumanoidRenderState();
	}

	@Override
	public void extractRenderState(MealwormentityEntity entity, HumanoidRenderState state, float partialTicks) {
		super.extractRenderState(entity, state, partialTicks);
		this.entity = entity;
		if (this.model instanceof AnimatedModel) {
			((AnimatedModel) this.model).setEntity(entity);
		}
	}

	@Override
	public ResourceLocation getTextureLocation(HumanoidRenderState state) {
		return ResourceLocation.parse("project_horsedimension:textures/entities/nothing.png");
	}

	@Override
	protected void scale(HumanoidRenderState state, PoseStack poseStack) {
		poseStack.scale(0.1f, 0.1f, 0.1f);
	}

	private static final class AnimatedModel extends HumanoidModel<HumanoidRenderState> {
		private MealwormentityEntity entity = null;

		public AnimatedModel(ModelPart root) {
			super(root);
		}

		public void setEntity(MealwormentityEntity entity) {
			this.entity = entity;
		}

		@Override
		public void setupAnim(HumanoidRenderState state) {
			super.setupAnim(state);
			this.animateWalk(ArmadilloAnimation.ARMADILLO_WALK, state.walkAnimationPos, state.walkAnimationSpeed, 1f, 1f);
		}
	}
}