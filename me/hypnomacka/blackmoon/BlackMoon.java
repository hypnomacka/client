package me.hypnomacka.blackmoon;

import me.hypnomacka.blackmoon.event.EventManager;
import me.hypnomacka.blackmoon.event.EventTarget;
import me.hypnomacka.blackmoon.event.impl.ClientTick;
import me.hypnomacka.blackmoon.hud.HUDConfigScreen;
import me.hypnomacka.blackmoon.hud.HudManager;
import me.hypnomacka.blackmoon.ui.clickgui.ClickGUI;
import net.minecraft.client.Minecraft;

public class BlackMoon {
	
	public String NAME = "BlackMoon", VERSION = "1.0", AUTHOR = "hypnomacka";
	public static BlackMoon INSTANCE = new BlackMoon();
	public Minecraft mc = Minecraft.getMinecraft();
	
	public EventManager eventManager;
	public HudManager hudManager;
	
	public void startup() {
		eventManager = new EventManager();
		hudManager = new HudManager();
		System.out.println("Launching " + NAME + VERSION + " by " + AUTHOR);
		
		eventManager.register(this);
	}
	
	public void shutdown() {
		System.out.println("Shutting down " + NAME + "-" + VERSION + " by " + AUTHOR);
		
		eventManager.unregister(this);
	}
	
	@EventTarget 
	void onTick(ClientTick event) {
		if(mc.gameSettings.HUD_CONFIG.isPressed()) {
			mc.displayGuiScreen(new HUDConfigScreen());
		}
		if(mc.gameSettings.CLICKGUI.isPressed()) {
			mc.displayGuiScreen(new ClickGUI());
		}

	}

}
