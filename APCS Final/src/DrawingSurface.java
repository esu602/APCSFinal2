
import javafx.scene.media.*;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.nio.file.Paths;

import processing.core.PApplet;



public class DrawingSurface extends PApplet {

	private GridView board;
	
	private AudioClip music;
	boolean isPlaying = false;
	
	
	public DrawingSurface() {
		board = new GridView();

		
		music = new AudioClip(Paths.get("music/menu.mp3").toUri().toString());

	}
	
	// The statements in the setup() function 
	// execute once when the program begins
	public void setup() {
		//size(0,0,PApplet.P3D);
		board.setup();
	}
	
	// The statements in draw() are executed until the 
	// program is stopped. Each statement is executed in 
	// sequence and after the last line is read, the first 
	// line is executed again.
	public void draw() { 
		
		if (!isPlaying) {

			music.play();
			isPlaying = true;
			

		}

		
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










