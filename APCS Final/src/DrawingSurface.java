
import javafx.scene.media.*;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private Grid board;
	
	private AudioClip music;
	
	
	
	public DrawingSurface() {
		board = new Grid();

		
		music = new AudioClip("music" + System.getProperty("file.separator") + "tibsun");
	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		
		background(255);   // Clear the screen with a white background
		fill(0);
		textAlign(LEFT);
		textSize(12);
		
		String message = "";
		
		int turnMod = board.getTurn() % 8;
		
		if (turnMod == 1) {//P1 viewing their own player grid
			message = "Here is the current state of your fleet, Player 1.\nCyan squares are living ships, red squares are destroyed ships."
					+ "\n\nClick on the grid to continue";
		}
		else if (turnMod == 2) {//P1 viewing their target grid.
			message = "Here is your targeting board, Player 1.\nWhite squares are uncovered, red squares are hits, and yellow squares are misses."
					+ "\n\nClick a square to fire on it.";
			
		}
		
		else if (turnMod == 3) {//P1 viewing their target grid.
			message = "Boom! Here is the result of your attack, Player 1.\nWhite squares are uncovered, red squares are hits, and yellow squares are misses."
					+ "\n\nClick on the grid to continue";
			
		}
		
		else if (turnMod == 4) {//Transition
			message = "GIVE CONTROL TO PLAYER 2. Unless you're playing against yourself, I don't judge. \n\nClick on the grid area to continue.";
		}
		
		else if (turnMod == 5) {//P2 viewing their own player grid
			message = "Here is the current state of your fleet, Player 2.\nCyan squares are living ships, red squares are destroyed ships."
					+ "\n\nClick on the grid to continue";
		}
		
		else if (turnMod == 6) {//P2 viewing their target grid.
			message = "Here is your targeting board, Player 2.\nWhite squares are uncovered, red squares are hits, and yellow squares are misses."
					+ "\n\nClick a square to fire on it.";
			
		}
		
		else if (turnMod == 7) {//P2 viewing their target grid.
			message = "Boom! Here is the result of your attack, Player 2.\nWhite squares are uncovered, red squares are hits, and yellow squares are misses."
					+ "\n\nClick on the grid to continue";
			
		}
		
		else if (turnMod == 0) {//Transition.
			message = "GIVE CONTROL TO PLAYER 1. Unless you're playing against yourself, I don't judge. \n\nClick on the grid area to continue.";
		}
		
		text(message, height+20, 30);
		
		
		if (board != null) {
			board.draw(this, 0, 0, height, height);
		}
		
	}
	
	
	public void mousePressed() {

	}
	

	
}










