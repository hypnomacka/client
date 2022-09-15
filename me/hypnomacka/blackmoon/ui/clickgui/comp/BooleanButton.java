package me.hypnomacka.blackmoon.ui.clickgui.comp;

import java.awt.Color;

import org.lwjgl.input.Mouse;

import me.hypnomacka.blackmoon.hud.HudMod;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.BooleanSetting;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.Gui;

public class BooleanButton {
	
	
	private HudMod mod;
	
	private Minecraft mc = Minecraft.getMinecraft();
	
	private boolean pressed;
	private static boolean hovered;
	private static boolean hovered2;
	
	public static int x;
	public static int y;
	private int width;
	private int height;
	
	private BooleanSetting bool;
	
	private int pressColor = new Color(0, 255, 0 ,255).getRGB();
	private int neutralColor = new Color(255, 0, 0, 100).getRGB();
	
	public BooleanButton(int mouseX, int mouseY, int x, int y, BooleanSetting bool, HudMod mod, int buttonId) {
		this.x = x;
		this.y = y;
		this.width = 100;
		this.height = 25;
		this.mod = mod;
		this.bool = bool;
		
		if(!mod.settings.isEmpty()) {	
			for(Setting setting : mod.settings) {
				if(setting instanceof BooleanSetting) {
					BooleanSetting boolsett = (BooleanSetting) setting;
					Gui.drawRect(this.x, this.y, this.x + this.width, this.y + this.height, boolsett.isEnabled() ? new Color(0, 255, 0, 55).getRGB() : new Color(255, 0, 0, 55).getRGB());
					//DrawUtil.drawBorderedRoundedRect(x, y, x + this.width, y + this.height, 10, 1, getWearingColor(bool), ColorMode.getModColor()); // 0, 0, 0, 255
					mc.fontRendererObj.drawString(boolsett.name, x + 13, y + 8, boolsett.isEnabled() ? new Color(0, 255, 0, 255).getRGB() : new Color(255, 0, 0, 255).getRGB());
					this.pressed = (Mouse.getEventButton() == 0) && (this.hovered2 == true) && (Mouse.getEventButtonState() == true);
				}
			}
		}
	}
	
	
	private int getWearingColor(BooleanSetting bool) {
		if(bool.isEnabled()) {
			return new Color(0, 255, 0, 255).getRGB();
		} else {
			 return new Color(255, 0, 0, 255).getRGB();
		}
	}

	public static boolean isHovered2() {
		return hovered2;
	}
	
	public static boolean isHovered(int mouseX, int mouseY) {
		if(mouseX >= x && mouseX <= x + 100 && mouseY >= y && mouseY <= y + 25) {
			return true;
		} else return false;
	}
}