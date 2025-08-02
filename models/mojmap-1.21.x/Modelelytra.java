// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelelytra<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "elytra"), "main");
	private final ModelPart left_wing;
	private final ModelPart right_wing;

	public Modelelytra(ModelPart root) {
		this.left_wing = root.getChild("left_wing");
		this.right_wing = root.getChild("right_wing");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition left_wing = partdefinition.addOrReplaceChild("left_wing",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, -20.0F, -2.0F, 10.0F, 20.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		PartDefinition right_wing = partdefinition.addOrReplaceChild("right_wing",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-11.0F, -20.0F, -2.0F, 10.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 24.0F, 0.0F, -3.1416F, 0.0F, 3.1416F));

		return LayerDefinition.create(meshdefinition, 64, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		left_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		right_wing.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}