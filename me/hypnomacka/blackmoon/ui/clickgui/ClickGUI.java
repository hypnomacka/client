package me.hypnomacka.blackmoon.ui.clickgui;

import java.util.ArrayList;

import me.hypnomacka.blackmoon.BlackMoon;
import me.hypnomacka.blackmoon.hud.HudMod;
import me.hypnomacka.blackmoon.ui.clickgui.comp.ModButton;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;
import net.minecraft.client.gui.ScaledResolution;

import java.awt.*;
import java.io.IOException;

public class ClickGUI extends GuiScreen {
	
	ArrayList<ModButton> modButtons = new ArrayList<>();
	
	@Override	
	public void initGui() {		
		super.initGui();
		//this.modButtons.add(new ModButton(70, 220, 20, 10, DarkMoon.INSTANCE.hudManager.fps));
		
        //for(HudMod m  : DarkMoon.INSTANCE.hudManager.hudMods) {
        	
        		
        		this.modButtons.add(new ModButton(this.width/ 2 - 100,this.height / 2 - 100, 127, 35, BlackMoon.INSTANCE.hudManager.fps));
        		this.modButtons.add(new ModButton(this.width/ 2 - 150,this.height / 2 - 100, 127, 35, BlackMoon.INSTANCE.hudManager.t));
                //System.out.println(count);
                
        //}
        
        
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		ScaledResolution sr = new ScaledResolution(mc);
		super.drawScreen(mouseX, mouseY, partialTicks);
		
		//Gui.drawRect(200, 50, sr.getScaledWidth() - 200, sr.getScaledHeight() - 50, new Color(0,0,0,170).getRGB());
		
		for(ModButton m : modButtons) {
			m.draw();
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		super.mouseClicked(mouseX, mouseY, mouseButton);
		for(ModButton m : modButtons) {
			m.onClick(mouseX, mouseY, mouseButton);
		}
	}

}
