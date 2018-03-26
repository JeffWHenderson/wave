package com.jeffwhenderson.wave.main;

import java.awt.Canvas;

public class Game extends Canvas implements Runnable {
	private static final long serialVersionUID = 1L;
	
	public static final int WIDTH = 640, HEIGHT = WIDTH / 12 * 9; 
	
	public Game() {
		new Window(WIDTH, HEIGHT, "PLACEHOLDER!! in Game constructor", this);
	}

	public synchronized void start() {
		
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}
	
	public static void main (String[] args) {
		new Game();
	}
}
