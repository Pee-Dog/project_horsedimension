package net.mcreator.projecthorsedimension.client.gui;

import net.neoforged.neoforge.network.PacketDistributor;

import net.minecraft.world.level.Level;
import net.minecraft.world.entity.player.Player;
import net.minecraft.world.entity.player.Inventory;
import net.minecraft.world.entity.LivingEntity;
import net.minecraft.util.Mth;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.network.chat.Component;
import net.minecraft.client.renderer.RenderType;
import net.minecraft.client.gui.screens.inventory.AbstractContainerScreen;
import net.minecraft.client.gui.components.PlainTextButton;
import net.minecraft.client.gui.components.Button;
import net.minecraft.client.gui.GuiGraphics;

import net.mcreator.projecthorsedimension.world.inventory.CowUIMenu;
import net.mcreator.projecthorsedimension.procedures.Item1buyProcedure;
import net.mcreator.projecthorsedimension.procedures.CowFarmerRightClickedOnEntityProcedure;
import net.mcreator.projecthorsedimension.network.CowUIButtonMessage;
import net.mcreator.projecthorsedimension.init.ProjectHorsedimensionModScreens;

import com.mojang.blaze3d.systems.RenderSystem;

public class CowUIScreen extends AbstractContainerScreen<CowUIMenu> implements ProjectHorsedimensionModScreens.ScreenAccessor {
	private final Level world;
	private final int x, y, z;
	private final Player entity;
	private boolean menuStateUpdateActive = false;
	Button button_empty;

	public CowUIScreen(CowUIMenu container, Inventory inventory, Component text) {
		super(container, inventory, text);
		this.world = container.world;
		this.x = container.x;
		this.y = container.y;
		this.z = container.z;
		this.entity = container.entity;
		this.imageWidth = 218;
		this.imageHeight = 178;
	}

	@Override
	public void updateMenuState(int elementType, String name, Object elementState) {
		menuStateUpdateActive = true;
		menuStateUpdateActive = false;
	}

	@Override
	public void render(GuiGraphics guiGraphics, int mouseX, int mouseY, float partialTicks) {
		super.render(guiGraphics, mouseX, mouseY, partialTicks);
		if (CowFarmerRightClickedOnEntityProcedure.execute(world) instanceof LivingEntity livingEntity) {
			ProjectHorsedimensionModScreens.renderEntityInInventoryFollowsAngle(guiGraphics, this.leftPos + 61, this.topPos + 48, 20, 0f + (float) Math.atan((this.leftPos + 61 - mouseX) / 40.0), (float) Math.atan((this.topPos + -1 - mouseY) / 40.0),
					livingEntity);
		}
		this.renderTooltip(guiGraphics, mouseX, mouseY);
	}

	@Override
	protected void renderBg(GuiGraphics guiGraphics, float partialTicks, int mouseX, int mouseY) {
		RenderSystem.setShaderColor(1, 1, 1, 1);
		RenderSystem.enableBlend();
		RenderSystem.defaultBlendFunc();
		guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("project_horsedimension:textures/screens/cowshop.png"), this.leftPos + -62, this.topPos + -77, 0, 0, 343, 259, 343, 259);
		guiGraphics.blit(RenderType::guiTextured, ResourceLocation.parse("project_horsedimension:textures/screens/cowlongitems.png"), this.leftPos + 59, this.topPos + 78, 0, Mth.clamp((int) Item1buyProcedure.execute(entity) * 64, 0, 64), 128, 64,
				128, 128);
		RenderSystem.disableBlend();
	}

	@Override
	public boolean keyPressed(int key, int b, int c) {
		if (key == 256) {
			this.minecraft.player.closeContainer();
			return true;
		}
		return super.keyPressed(key, b, c);
	}

	@Override
	protected void renderLabels(GuiGraphics guiGraphics, int mouseX, int mouseY) {
	}

	@Override
	public void init() {
		super.init();
		button_empty = new PlainTextButton(this.leftPos + 64, this.topPos + 117, 112, 20, Component.translatable("gui.project_horsedimension.cow_ui.button_empty"), e -> {
			int x = CowUIScreen.this.x;
			int y = CowUIScreen.this.y;
			if (true) {
				PacketDistributor.sendToServer(new CowUIButtonMessage(0, x, y, z));
				CowUIButtonMessage.handleButtonAction(entity, 0, x, y, z);
			}
		}, this.font);
		this.addRenderableWidget(button_empty);
	}
}