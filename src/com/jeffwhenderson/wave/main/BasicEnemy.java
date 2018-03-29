package com.jeffwhenderson.wave.main;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

public class BasicEnemy extends GameObject {
	private Handler handler;

	public BasicEnemy(int x, int y, ID id, Handler handler) {
		super(x, y, id);
		
		velX = 5;
		velY = 5;
		this.handler = handler;
	}
	
	@Override
	public Rectangle getBounds() {
		return new Rectangle(x, y, 16, 16);
	}

	@Override
	public void tick() {
		x += velX;
		y += velY;
		
		if(y <= 0 || y >= Game.HEIGHT - 16) velY *= -1;
		if(x <= 0 || x >= Game.WIDTH - 32) velX *= -1;

		handler.addObject(new Trail(x, y, ID.Trail, Color.blue, 16, 16, 0.01f, handler));
	}

	@Override
	public void render(Graphics g) {
		g.setColor(Color.red);
		g.fillRect(x, y, 16, 16);
	}
}
