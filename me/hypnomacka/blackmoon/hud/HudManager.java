package me.hypnomacka.blackmoon.hud;

import java.util.ArrayList;

import me.hypnomacka.blackmoon.hud.modules.FPSMod;
import me.hypnomacka.blackmoon.hud.modules.TargetHUD;
import me.hypnomacka.blackmoon.hud.modules.test;

public class HudManager {
	
	public ArrayList<HudMod> hudMods = new ArrayList<>();
	
	public FPSMod fps;
	
	//public TargetHUD thud;
	
	public test t;
	
	public HudManager() {
		try {
		hudMods.add(fps = new FPSMod());
		
		//hudMods.add(thud = new TargetHUD());
		
		hudMods.add(t = new test());
		} catch (NullPointerException e) {
			e.printStackTrace();
		}
		
	}
	
	public void renderMods() {
		for(HudMod m : hudMods) {
			if(m.isEnabled()) {
			   m.draw();
			}
		}
	}

}
