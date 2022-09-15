package me.hypnomacka.blackmoon.hud.modules;

import java.awt.Color;

import me.hypnomacka.blackmoon.hud.HudMod;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.BooleanSetting;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.ModeSetting;
import net.minecraft.client.gui.Gui;

public class FPSMod extends HudMod {
	
	BooleanSetting test = new BooleanSetting("Test2", true);
	//ModeSetting testMode = new ModeSetting("Test Mode", "Mode1", "Mode1", "Mode2", "Mode3");
	
	public FPSMod() {
		super("FPS", 5, 5);
		this.addSettings(test);
	}
	
	@Override
	public void draw() {
		if(test.isEnabled()) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,150).getRGB());
		fr.drawString("FPS: " + mc.getDebugFPS(), getX(), getY(), -1);
		}
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,150).getRGB());
		fr.drawString("FPS: " + mc.getDebugFPS(), getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("FPS: " + mc.getDebugFPS());
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
