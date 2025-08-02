// Made with Blockbench 4.12.5
// Exported for Minecraft version 1.17 or later with Mojang mappings
// Paste this class into your mod and generate all required imports

public class Modelbirdwings_open<T extends Entity> extends EntityModel<T> {
	// This layer location should be baked with EntityRendererProvider.Context in
	// the entity renderer and passed into this model's constructor
	public static final ModelLayerLocation LAYER_LOCATION = new ModelLayerLocation(
			new ResourceLocation("modid", "birdwings_open"), "main");
	private final ModelPart wingus;
	private final ModelPart left_wing;
	private final ModelPart right_wing;
	private final ModelPart empty;

	public Modelbirdwings_open(ModelPart root) {
		this.wingus = root.getChild("wingus");
		this.left_wing = this.wingus.getChild("left_wing");
		this.right_wing = this.wingus.getChild("right_wing");
		this.empty = root.getChild("empty");
	}

	public static LayerDefinition createBodyLayer() {
		MeshDefinition meshdefinition = new MeshDefinition();
		PartDefinition partdefinition = meshdefinition.getRoot();

		PartDefinition wingus = partdefinition.addOrReplaceChild("wingus", CubeListBuilder.create(),
				PartPose.offset(0.0F, 4.0F, 0.0F));

		PartDefinition left_wing = wingus.addOrReplaceChild("left_wing",
				CubeListBuilder.create().texOffs(0, 0).addBox(1.0F, 0.0F, -2.0F, 10.0F, 20.0F, 4.0F,
						new CubeDeformation(0.0F)),
				PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, 1.309F, 0.2618F, 3.1416F));

		PartDefinition right_wing = wingus.addOrReplaceChild("right_wing",
				CubeListBuilder.create().texOffs(0, 0).mirror()
						.addBox(-11.0F, 0.0F, -2.0F, 10.0F, 20.0F, 4.0F, new CubeDeformation(0.0F)).mirror(false),
				PartPose.offsetAndRotation(0.0F, 2.0F, 2.0F, 1.309F, -0.2618F, 3.1416F));

		PartDefinition empty = partdefinition.addOrReplaceChild("empty", CubeListBuilder.create(),
				PartPose.offset(0.0F, 24.0F, 0.0F));

		return LayerDefinition.create(meshdefinition, 32, 32);
	}

	@Override
	public void renderToBuffer(PoseStack poseStack, VertexConsumer vertexConsumer, int packedLight, int packedOverlay,
			float red, float green, float blue, float alpha) {
		wingus.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
		empty.render(poseStack, vertexConsumer, packedLight, packedOverlay, red, green, blue, alpha);
	}

	public void setupAnim(T entity, float limbSwing, float limbSwingAmount, float ageInTicks, float netHeadYaw,
			float headPitch) {
	}
}