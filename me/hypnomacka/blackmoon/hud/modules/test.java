package me.hypnomacka.blackmoon.hud.modules;

import java.awt.Color;

import me.hypnomacka.blackmoon.hud.HudMod;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.BooleanSetting;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.ModeSetting;
import net.minecraft.client.gui.Gui;

public class test extends HudMod {
	
	BooleanSetting test1 = new BooleanSetting("Test1", true);
	//ModeSetting testMode = new ModeSetting("Test Mode", "Mode1", "Mode1", "Mode2", "Mode3");
	
	public test() {
		super("test", 5, 5);
		this.addSettings(test1);
	}
	
	@Override
	public void draw() {
		if(test1.isEnabled()) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,150).getRGB());
		fr.drawString("test", getX(), getY(), -1);
		}
		super.draw();
	}
	
	@Override
	public void renderDummy(int mouseX, int mouseY) {
		Gui.drawRect(getX() - 2, getY() - 2, getX() + getWidth(), getY() + getHeight(), new Color(0,0,0,150).getRGB());
		fr.drawString("test", getX(), getY(), -1);
		super.renderDummy(mouseX, mouseY);
	}
	
	@Override
	public int getWidth() {
		return fr.getStringWidth("test");
	}
	
	@Override
	public int getHeight() {
		return fr.FONT_HEIGHT;
	}

}
