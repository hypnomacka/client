package me.hypnomacka.blackmoon.hud;

import me.hypnomacka.blackmoon.BlackMoon;
import net.minecraft.client.gui.GuiScreen;

public class HUDConfigScreen extends GuiScreen {
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		this.drawDefaultBackground();
		
		for(HudMod m : BlackMoon.INSTANCE.hudManager.hudMods) {
			if(m.isEnabled()) {
			   m.renderDummy(mouseX, mouseY);
			}
		}
			
		super.drawScreen(mouseX, mouseY, partialTicks);
	}

}
