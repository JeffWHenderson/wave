package com.jeffwhenderson.wave.main;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferStrategy;
import java.util.Random;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; 
	private Thread thread;
	private boolean running = false; // needs a getter and setter possibly
	private Random r;
	private HUD hud;
	
	private Handler handler;
	
	public Game() {
		handler = new Handler();
		this.addKeyListener(new KeyInput(handler));
		
		new Window(WIDTH, HEIGHT, "PLACEHOLDER!! in Game constructor", this);
		
		hud = new HUD();
		
		r = new Random();
		
		handler.addObject(new Player(WIDTH/2, HEIGHT/2, ID.Player, handler));
		//for(int i = 0; i < 10; i++) // adds 10 enemies 
			handler.addObject(new BasicEnemy(r.nextInt(WIDTH), r.nextInt(HEIGHT), ID.BasicEnemy));
	}

	public synchronized void start() {
		thread = new Thread(this);
		thread.start();
		running = true;
	}
	
	public synchronized void stop() {
		try 
		{
			thread.join();
			running = false;
		} 
		catch(Exception e) 
		{
			e.printStackTrace();
		}

	}
	
	@Override
	public void run() {
		/*
		 * this is a popular pattern for Game Loops. 
		 */
		this.requestFocus();
		long lastTime = System.nanoTime();
		double amountOfTicks = 60.0;
		double ns = 1000000000 / amountOfTicks; //
		double delta = 0;
		long timer = System.currentTimeMillis();
		int frames = 0;
		
		while(running) {
			long now = System.nanoTime();
			delta += (now - lastTime) / ns;
			lastTime = now;
			
			while(delta >=1) {
				tick();
				delta--;
			}
			if(running)
				render();
			frames++;
			
			if(System.currentTimeMillis() - timer > 1000) {
				timer += 1000;
				//System.out.print("FPS: " + frames); // prints frame rate
				frames = 0;
			}
		}
		stop();
	}
	
	private void tick() {
		handler.tick();
		hud.tick();
	}
	
	private void render() {
		BufferStrategy bs = this.getBufferStrategy();
		if(bs == null) {
			this.createBufferStrategy(3);
			return;
		}
		
		Graphics g = bs.getDrawGraphics();
		
		g.setColor(Color.black);
		g.fillRect(0, 0, WIDTH, HEIGHT);
		
		handler.render(g);
		
		hud.render(g);
		
		g.dispose();
		bs.show();
	}
	
	public static void main (String[] args) {
		new Game();
	}

	public static int clamp(int var, int min, int max) {
		if(var >= max)
			return var = max;
		else if(var <= min)
			return var = min;
		else 
			return var;
	}
}
