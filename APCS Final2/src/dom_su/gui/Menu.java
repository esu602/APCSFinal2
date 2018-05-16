package dom_su.gui;

import processing.core.PApplet;
import processing.core.PFont;
import processing.core.PImage;

public class Menu {

	private boolean playGame;
	
	private PImage menuScreen;
	
	private String header;
	private String fontName;
	
	private Button play;
	
	public Menu(PImage background) {
		menuScreen = background;
		fontName = "Georgia";
		
		header = "Dominique and Su";
		play = new Button("Play", Button.DEFAULT_X, Button.DEFAULT_Y, 400, 100);
		
		playGame = false;
	}
	
	public void draw(PApplet marker) {
		int width = marker.width;
		int height = marker.height;
		
		marker.background(255);
		marker.image(menuScreen, 0, 0, width, height);
		
		PFont fontHeader = marker.createFont(fontName + " Bold", 16, true);
		marker.fill(255);
		marker.textAlign(PApplet.CENTER);
		marker.textFont(fontHeader, 56);
		marker.text(header, width/2, height/4);
		
		play.draw(marker);
		if(play.buttonPressed()) {
			playGame = true;
		}
	}
	
	public boolean playGame() {
		return playGame;
	}
}
