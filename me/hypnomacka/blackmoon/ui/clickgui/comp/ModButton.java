package me.hypnomacka.blackmoon.ui.clickgui.comp;

import java.awt.Color;

import org.lwjgl.opengl.GL11;

import me.hypnomacka.blackmoon.hud.HudMod;
import me.hypnomacka.blackmoon.ui.clickgui.ClickGUI;
import me.hypnomacka.blackmoon.ui.clickgui.settings.SettingGUI;
import me.hypnomacka.blackmoon.util.render.RoundedUtils;
import net.minecraft.client.Minecraft;
import net.minecraft.client.renderer.Tessellator;
import net.minecraft.client.renderer.WorldRenderer;
import net.minecraft.client.renderer.vertex.DefaultVertexFormats;

public class ModButton {
	
	public int x, y, w, h;
	public HudMod m;
	
	public Minecraft mc = Minecraft.getMinecraft();
	
	public ModButton(int y, int x, int w, int h, HudMod m) {
		this.x = x;
		this.y = y;
		this.w = w;
		this.h = h;
		this.m = m;
	}
	
	public void draw() {
		RoundedUtils.drawSmoothRoundedRect(x, y, x + w, y + h, 12.0F, new Color(26, 26, 26, 255).getRGB());
		RoundedUtils.drawSmoothRoundedRect(x + 105, y + 18, x + w -6, y + h - 18, 4.0F, new Color(40, 40, 40, 255).getRGB());
		if(m.isEnabled()) {
			
			this.drawCircle(x + 109, y + 16, 8, 8, new Color(0, 255, 255));
				
				
		}else {
			this.drawCircle(x + 100, y + 16, 8, 8, new Color(100,100,100));
			
		}
		Minecraft.getMinecraft().fontRendererObj.drawString(m.name, x + 35, y + 12, getColor());
		//Minecraft.getMinecraft().fontRendererObj.drawString("Description", x + 35, y + 23, new Color(70, 70, 75, 255).getRGB());
		//Gui.drawRect(y + 390, x - 150, h + 120, w - 70, new Color(0,0,0,170).getRGB());
        //Minecraft.getMinecraft().fontRendererObj.drawString(m.name, x + 2, y + 2, getColor());
	}
	
	private int getColor() {
		if(m.isEnabled()) {
			return new Color(0,255,0,255).getRGB();
		} else {
			return new Color(255,0,0,255).getRGB(); 
		}
	}
	public void onClick(int mouseX, int mouseY, int button) {
		if(mouseX >= x && mouseX <= x + w && mouseY >= y && mouseY<= y + h) {
			if(button == 0) {
			   m.toggle();
			   System.out.println("toggled " + m.name);
			}
			if(button == 1) {
				//if(m.settings.size()>1)
				mc.displayGuiScreen(new SettingGUI(m, new ClickGUI()));
			}
		}

	}
	
	private void drawArc(final int x, final int y, final int radius, final int startAngle, final int endAngle, final Color color) {
	      GL11.glPushMatrix();
	      GL11.glEnable(3042);
	      GL11.glDisable(3553);
	      GL11.glBlendFunc(770, 771);
	      GL11.glColor4f(color.getRed() / 255.0f, color.getGreen() / 255.0f, color.getBlue() / 255.0f, color.getAlpha() / 255.0f);
	      final WorldRenderer worldRenderer = Tessellator.getInstance().getWorldRenderer();
	      worldRenderer.begin(6, DefaultVertexFormats.POSITION);
	      worldRenderer.pos(x, y, 0.0).endVertex();
	      for (int i = (int)(startAngle / 360.0 * 100.0); i <= (int)(endAngle / 360.0 * 100.0); ++i) {
	          final double angle = 6.283185307179586 * i / 100.0 + Math.toRadians(180.0);
	          worldRenderer.pos(x + Math.sin(angle) * radius, y + Math.cos(angle) * radius, 0.0).endVertex();
	      }
	      Tessellator.getInstance().draw();
	      GL11.glEnable(3553);
	      GL11.glDisable(3042);
	      GL11.glPopMatrix();
	  }
		
		private void drawCircle(final int x, final int y, final int width, final int height, final Color color) {
	      this.drawArc(x + width, y + height / 2, width / 2, 0, 360, color);
	  }

}
