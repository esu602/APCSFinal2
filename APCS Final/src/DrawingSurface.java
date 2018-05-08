
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

		
		music = new AudioClip("music" + System.getProperty("file.separator") + "menu");
		music.setCycleCount(AudioClip.INDEFINITE); //menu music will infinite loop
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

		text(message, height+20, 30);
		
		
		if (board != null) {
			board.draw(this, 0, 0, height, height);
		}
		
	}
	
	
	public void mousePressed() {

	}
	

	
}










