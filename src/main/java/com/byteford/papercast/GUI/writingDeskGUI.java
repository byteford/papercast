package com.byteford.papercast.GUI;

import java.awt.Color;
import java.io.IOException;

import com.byteford.papercast.paperCast;
import com.byteford.papercast.GUI.Buttons.colouredButton;
import com.byteford.papercast.block.BlockManager;
import com.byteford.papercast.block.TileEntity.WritingDeskTileEntity;
import com.byteford.papercast.block.container.WritingDeskContainer;

import net.minecraft.client.gui.GuiButton;
import net.minecraft.client.gui.inventory.GuiContainer;
import net.minecraft.client.renderer.GlStateManager;
import net.minecraft.client.resources.I18n;
import net.minecraft.entity.player.InventoryPlayer;
import net.minecraft.inventory.Container;
import net.minecraft.util.ResourceLocation;
import net.minecraft.world.World;

public class writingDeskGUI extends GuiContainer {

	private InventoryPlayer playerInv;
	WritingDeskContainer contioner;
	
	private static final ResourceLocation BG_TEXTURE = new ResourceLocation(paperCast.MODID, "textures/gui/infuser.png");
	int top, left;
	
	Color colourSelected;
	int colourNum;
	
	public writingDeskGUI(Container inventorySlotsIn, InventoryPlayer playerInv) {
		super(inventorySlotsIn);
		this.playerInv = playerInv;
		contioner = (WritingDeskContainer)inventorySlotsIn;
		
	}
	@Override
	public void initGui() {
		super.initGui();
		left = (width - xSize)/2;
		top = (height - ySize)/2;
		
		this.addButton(new GuiButton(0, left + xSize/2 -5, top + 60,20,20, "GO"));
		
		this.addButton(new colouredButton(1, left + (xSize/2), top + 25,10,10));
		this.addButton(new colouredButton(2, left + (xSize/2) + 10, top + 25,10,10));
		this.addButton(new colouredButton(3, left + (xSize/2) +20, top + 25,10,10));
		this.addButton(new colouredButton(4, left + (xSize/2), top + 35,10,10));
		this.addButton(new colouredButton(5, left + (xSize/2) +10, top + 35,10,10));
		
		this.addButton(new colouredButton(6, left + (xSize/2) + 40, top + 25, 10, 10).setColour(Color.BLACK));
		this.addButton(new colouredButton(7, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.BLUE));
		this.addButton(new colouredButton(8, left + (xSize/2) + 40, top + 35, 10, 10).setColour(Color.RED));
//		this.addButton(new colouredButton(9, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.WHITE));
//		this.addButton(new colouredButton(10, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.blue)); //light blue
//		this.addButton(new colouredButton(11, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.GREEN));
//		this.addButton(new colouredButton(12, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.green)); //dark green
//		this.addButton(new colouredButton(13, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.YELLOW));
//		this.addButton(new colouredButton(14, left + (xSize/2) + 50, top + 25, 10, 10).setColour(Color.)); //brown
	}
	
	@Override
	protected void actionPerformed(GuiButton button) throws IOException {
		switch (button.id) {
		case 0:
			String paperval = "";
			for(int i = 1; i < 6; i++) {
				paperval += ((colouredButton)this.buttonList.get(i)).getColIDasChar();
			}
			((WritingDeskTileEntity)mc.world.getTileEntity(contioner.writingDesk.getPos())).makePaper(paperval);
			//contioner.writingDesk.makePaper();
			break;
		case 1:
		case 2:
		case 3:
		case 4:
		case 5:
			if(colourSelected == null)
				break;
			((colouredButton)button).setColour(colourSelected);
			((colouredButton)button).setcolID(colourNum);
			break;
		case 6:
		case 7:
		case 8:
		case 9:
		case 10:
		case 11:
		case 12:
		case 13:
		case 14:
			colourSelected = ((colouredButton)button).GetColour();
			colourNum = button.id - 5;
			break;
		default:
			break;
		}
		super.actionPerformed(button);
	}
	@Override
	protected void drawGuiContainerBackgroundLayer(float partialTicks, int mouseX, int mouseY) {
		GlStateManager.color(1, 1, 1,1);
		mc.getTextureManager().bindTexture(BG_TEXTURE);
		left = (width - xSize)/2;
		top = (height - ySize)/2;
		drawTexturedModalRect(left, top,0,0,xSize,ySize);
		
	}
	protected void drawGuiContainerForegroundLayer(int mouseX, int mouseY) {
		String name = I18n.format(BlockManager.writingdesk.getUnlocalizedName() + ".name");
		fontRenderer.drawString(name,xSize /2 - fontRenderer.getStringWidth(name)/2,6, 0x404040);
		fontRenderer.drawString(playerInv.getDisplayName().getUnformattedText(), 8, ySize -94 , 0x404040);
	}
	
}
