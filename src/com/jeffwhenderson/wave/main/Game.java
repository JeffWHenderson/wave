package com.jeffwhenderson.wave.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; 
	private Thread thread;
	private boolean running = false; // needs a getter and setter possibly
	
	public Game() {
		new Window(WIDTH, HEIGHT, "PLACEHOLDER!! in Game constructor", this);
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
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args) {
		new Game();
	}
}
