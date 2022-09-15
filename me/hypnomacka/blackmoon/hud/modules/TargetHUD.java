package me.hypnomacka.blackmoon.hud.modules;

import java.awt.Color;

import me.hypnomacka.blackmoon.hud.HudMod;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.inventory.GuiInventory;
import net.minecraft.entity.EntityLivingBase;
import net.minecraft.util.ResourceLocation;

public class TargetHUD extends HudMod {

	EntityLivingBase target;
	
	private Color healthColor;
	private int healthRect;

	//public BooleanSetting Test = new BooleanSetting("Test", false);
	
	
	public TargetHUD() {
		super("TargetHUD", 5, 5);
	}
	
	@Override
	public void draw() {
		renderTargetHud();
        
		
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,150).getRGB());
		fr.drawStringWithShadow(mc.thePlayer.getName(), getX() + 2, getY() + 2, -1);
		fr.drawStringWithShadow((int)mc.thePlayer.getHealth() + "\u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		GuiInventory.drawEntityOnScreen(getX() + 70, getY() + 30, 25, 50, 0, mc.thePlayer);
		
		super.renderDummy(mouseX, mouseY);
	}

	@Override
	public int getWidth() {
		return fr.getStringWidth(target.getName()) + 70;
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT + 20;
	}

	
	private void renderTargetHud() {
		target = (EntityLivingBase) mc.pointedEntity;
		try {
			if(target != null) {
				Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,150).getRGB());
		        fr.drawStringWithShadow(target.getName(), getX() + 2, getY() + 2, -1);
		        fr.drawStringWithShadow((int)target.getHealth() + "\u2764", getX() + 2, getY() + 2 + fr.FONT_HEIGHT, -1);
		        GuiInventory.drawEntityOnScreen(getX() + 70, getY() + 30, 25, 50, 0, target);
			}
		} catch(NullPointerException e) {
			e.printStackTrace();
		}	
		
	}
	
	
}
