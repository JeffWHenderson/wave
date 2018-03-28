package com.jeffwhenderson.wave.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;

public class Player extends GameObject {

	public Player(int x, int y, ID id) {
		super(x, y, id);
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 32, 32);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
	}

	@Override
	public void render(Graphics g) {

		g.setColor(Color.white);
		g.fillRect(x, y, 32, 32);
		
	}

}
