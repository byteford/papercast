package com.byteford.papercast.GUI.Buttons;

import java.awt.Color;

import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.renderer.GlStateManager;

public class colouredButton extends GuiButton {
	Color colour = Color.BLACK;
	int colourId = 1;
	public colouredButton(int buttonId, int x, int y, int widthIn, int heightIn) {
		super(buttonId, x, y, widthIn, heightIn, "");
	}
	public colouredButton(int buttonId, int x, int y) {
		super(buttonId, y, x, "");
	}

	public void setColour(int red, int green, int blue) {
		colour = new Color(red, green, blue);		
	}
	
	public colouredButton setColour(Color col) {
		colour = col;
		return this;
	}
	public Color GetColour() {
		return colour;
	}
	public void setcolID(int id) {
		colourId = id;
	}
	public int getColID() {
		return colourId;
	}
	public char getColIDasChar() {
		if(colourId == 0)
			return ' ';
		return Integer.toString(colourId).charAt(0);
	}
	@Override
	public void drawButton(Minecraft mc, int mouseX, int mouseY, float partialTicks) {
		 if (this.visible)
	        {
	            mc.getTextureManager().bindTexture(BUTTON_TEXTURES);
	            GlStateManager.color(colour.getRed(),colour.getGreen(), colour.getBlue(), colour.getAlpha());
	            this.hovered = mouseX >= this.x && mouseY >= this.y && mouseX < this.x + this.width && mouseY < this.y + this.height;
	            int i = this.getHoverState(this.hovered);
	            GlStateManager.enableBlend();
	            GlStateManager.tryBlendFuncSeparate(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA, GlStateManager.SourceFactor.ONE, GlStateManager.DestFactor.ZERO);
	            GlStateManager.blendFunc(GlStateManager.SourceFactor.SRC_ALPHA, GlStateManager.DestFactor.ONE_MINUS_SRC_ALPHA);
	            this.drawTexturedModalRect(this.x, this.y, 0, 46 + i * 20, this.width / 2, this.height);
	            this.drawTexturedModalRect(this.x + this.width / 2, this.y, 200 - this.width / 2, 46 + i * 20, this.width / 2, this.height);
	            this.mouseDragged(mc, mouseX, mouseY);
	        }
	}
	@Override
	protected void drawGradientRect(int left, int top, int right, int bottom, int startColor, int endColor) {
		// TODO Auto-generated method stub
		super.drawGradientRect(left, top, right, bottom, 0, 0);
	}
}
