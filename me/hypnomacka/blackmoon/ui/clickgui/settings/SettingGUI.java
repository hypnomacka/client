package me.hypnomacka.blackmoon.ui.clickgui.settings;

import java.awt.Color;
import java.io.IOException;

import me.hypnomacka.blackmoon.BlackMoon;
import me.hypnomacka.blackmoon.hud.HudMod;
import me.hypnomacka.blackmoon.ui.clickgui.ClickGUI;
import me.hypnomacka.blackmoon.ui.clickgui.comp.BooleanButton;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.BooleanSetting;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.ModeSetting;
import me.hypnomacka.blackmoon.ui.clickgui.settings.impl.Setting;
import me.hypnomacka.blackmoon.util.render.RoundedUtils;
import net.minecraft.client.gui.Gui;
import net.minecraft.client.gui.GuiScreen;

public class SettingGUI extends GuiScreen {
	
	HudMod mod;
	GuiScreen parent;
	
	public SettingGUI(HudMod mod, GuiScreen parent) {
		this.mod = mod;
		this.parent = parent;

	}
	
	@Override	
	public void initGui() {		
		super.initGui();		       
        
	}
	
	@Override
	public void drawScreen(int mouseX, int mouseY, float partialTicks) {
		//RoundedUtils.drawSmoothRoundedRect((ClickGUI.width / 2 - 190), (ClickGUI.height / 2 - 110), (ClickGUI.width / 2 + 190), (ClickGUI.height / 2 + 115), 12.0F, new Color(26, 24, 25, 100).getRGB());
		/*int index = 0;
		for(Setting s : mod.settings) {
			Gui.drawRect(100, 100 + index, 100+60, 100+20, new Color(26, 24, 25, 100).getRGB());
			index +=24;
		}*/
		if(!mod.settings.isEmpty()) {	
			for(Setting setting : mod.settings) {
				int countb = 1;
				if(setting instanceof BooleanSetting) {
					new BooleanButton(mouseX, mouseY, 75, 75 * countb + 10, (BooleanSetting) setting, mod, 1);
					countb += 1;
				}
			}
			/*for(Setting setting : mod.settings) {
				int countm = 1;
				if(setting instanceof ModeSetting) {
					new ModeButton(mouseX, mouseY,  this.width / 2 - 140, this.height / 2 - 80 * countm + 10, (ModeSetting) setting, mod, 2);
					countm += 1;
				}
			}*/
		}
	}
	
	@Override
	protected void mouseClicked(int mouseX, int mouseY, int mouseButton) throws IOException {
		int index = 0;
		for(Setting s : mod.settings) {
			for(Setting setting : mod.settings) {
				if(setting instanceof BooleanSetting) {
					if(BooleanButton.isHovered(mouseX, mouseY)) {
						((BooleanSetting) setting).toggle();
					}
				}
			}
		}
		/*int index = 0;
		for(Setting s : mod.settings) {
			if(mouseX>= 100 && mouseX<= 100+60 && mouseY >= 100+index && mouseY <= 100+20+index) {
				((BooleanSetting)s).enabled = !((BooleanSetting)s).enabled;
				index += 24;
			}
		}*/
	}
	public void mouuseClicked(int x, int y, int button) {
		for(HudMod mod : BlackMoon.INSTANCE.hudManager.hudMods) {
			if(!mod.settings.isEmpty()) {	
				for(Setting setting : mod.settings) {
					if(setting instanceof BooleanSetting) {
						if(BooleanButton.isHovered(x, y)) {
							((BooleanSetting) setting).toggle();
						}
					}
				}
			}
		}
		
	}

}
