package com.jeffwhenderson.wave.main;

import java.awt.Canvas;
import java.awt.Dimension;

import javax.swing.JFrame;

public class Window extends Canvas{					
	private static final long serialVersionUID = 1L; // unique ID

	public Window(int width, int height, String title, Game game) {
		JFrame frame = new JFrame(title);

		frame.setPreferredSize(new Dimension(width, height));
		frame.setMinimumSize(new Dimension(width, height));
		frame.setMaximumSize(new Dimension(width, height));
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		frame.setLocationRelativeTo(null);
		frame.setVisible(true);
		frame.add(game);
		game.start();
	
	}
}

/*	NOTES on whats new to me i.e. READ THE DOCS ON THIS STUFF AND MAKE SURE YOU ARE USING IT RIGHT JEFFREY
 *  public synchronized void --- in Game -> synchronized is new to me. 
 *  cmd + shift + o // to import without hovering in eclipse
 *  extending Canvas...
 *  
 *  to make getters and setters try something like "alt shift s" (probably cmd??)
 *  
 */
