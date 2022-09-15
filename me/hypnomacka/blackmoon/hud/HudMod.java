package me.hypnomacka.blackmoon.hud;

import java.awt.Color;
import java.util.ArrayList;
import java.util.Arrays;

import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.Setting;
import net.minecraft.client.Minecraft;
import net.minecraft.client.gui.FontRenderer;

public class HudMod {
	
	public Minecraft mc = Minecraft.getMinecraft();
	public FontRenderer fr = mc.fontRendererObj;
	
	public ArrayList<Setting> settings;
	
	public String name;
	public boolean enabled;
	public DraggableComponent drag;
	
	public int x, y;
	
	public HudMod(String name, int x, int y) {
		this.name = name;
		this.x = x;
	    this.y = y;
	    
	    settings = new ArrayList<Setting>();
	    
	    drag = new DraggableComponent(x, y, x + getWidth(), y + getHeight(), new Color(0, 0, 0, 0).getRGB());
	}
	
	
	
	public int getWidth() {
		return 50;
		
	}
	
	public int getHeight() {
		return 50;
		
	}
	
	public void draw() {
		
		
	}
	
	public void renderDummy(int mouseX, int mouseY) {
		drag.draw(mouseX, mouseY);
		
	}
	
	public int getX() {
		return drag.getxPosition();
		
	}
	
	public int getY() {
		return drag.getyPosition();
		
	}
	
	public void setEnabled(boolean enabled) {
		this.enabled = enabled;
		
	}
	
	public void toggle() {
		this.setEnabled(!enabled);
	}
	
	public void addSettings(Setting... settings) {
		this.settings.addAll(Arrays.asList(settings));
	}
	
	public boolean isEnabled() {
		return enabled;
	}

}
