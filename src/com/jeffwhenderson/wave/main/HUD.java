package com.jeffwhenderson.wave.main;

import java.awt.Color;
import java.awt.Graphics;

public class HUD {
	public static int HEALTH = 100; // its not great to use statics but this will be the only instance of health
	
	public void tick() {
		HEALTH--;
		
		HEALTH = Game.clamp(HEALTH, 0, 100);
	}
	
	public void render(Graphics g) {
		g.setColor(Color.GRAY);
		g.fillRect(15, 15, 200, 32);
		g.setColor(Color.green);
		g.fillRect(15, 15, HEALTH * 2, 32);
		g.setColor(Color.white);
		g.drawRect(15, 15, 200, 32);
	}
}
