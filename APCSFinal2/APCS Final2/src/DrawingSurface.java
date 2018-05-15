
import javafx.scene.media.*;

import java.awt.event.KeyEvent;
import java.nio.file.Paths;

import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * This class draws the player, grid and other npcs onto a board, also handles
 * the GUI, music and visual representation of the game
 * 
 * 
 * @author David Dominique ,Evan Su
 * @version 5/9/18
 */

public class DrawingSurface extends PApplet {

	public static final int STAGE_MENU 		= 0;
	public static final int STAGE_BATTLE 	= 1;
	public static final int STAGE_END		= 2;
	
	private PImage menuScreen, battleScreen, endScreen;
	private int stage;
	
	private Grid board;

	private Player playerTest;
	private Enemy enemy;


	// This should be kept in Player
	// private int X,Y;

	private int healthX, healthY;
	private int decreaseHealthX, decreaseHealthY;

	private AudioClip music;

	public DrawingSurface() {
		board = new Grid();

		healthX = width + 1125;
		healthY = height - 10;

		decreaseHealthX = width + 1125;
		decreaseHealthY = height - 10;

		playerTest = new Player(board, 5, 5);
		//enemy = new Enemy(board);

		music = new AudioClip(Paths.get("music/menu.mp3").toUri().toString());
		music.play();
		
		
		stage = STAGE_MENU;
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		String backgroundPath = "images" + Main.FILE_SEPARATOR + "background" + Main.FILE_SEPARATOR;
		menuScreen 		= loadImage(backgroundPath + "scene_menu.png");
		endScreen 		= loadImage(backgroundPath + "scene_end.jpg");
		battleScreen 	= loadImage(backgroundPath + "scene_battle.png");
		
		String spritePath = "images" + Main.FILE_SEPARATOR + "sprites" + Main.FILE_SEPARATOR;
		playerTest.setImage(loadImage(spritePath + "sprite_player.png"));
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {

		// SET MUSIC
		if (!music.isPlaying()) {
			if (board != null) {
				playMusic("random");
			}
		}
		
		
		// DETERMINE STAGE
		if (stage == STAGE_MENU) {
			image(menuScreen, 0, 0, width, height);
			
			// SETUP MENU CONTENTS
			textSize(56);
			textAlign(CENTER);
			text("Press Enter To Start", width / 2 - 25, height / 3 - 20);

			textAlign(CENTER);
			text("Instructions" + "\n" + "W-Move Player Up" + "\n" + "A-Move Player Left" + "\n" + "S-Move Player Down"
					+ "\n" + "D-Move Player Right", width / 2, height / 2);
		} else if (stage == STAGE_BATTLE) {
			//SETUP BATTLE SCREEN
			background(255); // Clear the screen with a white background
			fill(0);
			textAlign(LEFT);
			textSize(12);
			
			// MAX HEALTH WARNING
			if (playerTest.getHealth() == 100) {
				text("MAX HEALTH", 1125, 175);
			} else if (!playerTest.isAlive()) {		// Player is dead
				stage = STAGE_END;
			}
			
			// Draw Board
			if (board != null) {
				board.draw(this, 0, 0, height, height);
			}
			
			// Health Square
			noFill();
			rect(healthX, healthY, 200, 100, 5);
			String message2 = "Player Health: " + playerTest.getHealth();
			text(message2, 1110, 150);
			text("Press button for health", 1255, 145);
			// Attack Button
			noFill();
			rect(healthX, healthY + 150, 200, 100, 5);
			text("Attack With Selected Weapon", 1240, 290);
			// Cycle Weapon Buttons Left & Right
			noFill();
			text("Cycle Weapon", 1285, 390);
			rect(healthX, healthY + 300, 50, 50, 5);
			noFill();
			rect(healthX + 150, healthY + 300, 50, 50);
			// Defend Button
			noFill();
			text("Defend With Selected Item", 1250, 535);
			rect(healthX, healthY + 390, 200, 100);
			// Cycle Armor Buttons
			noFill();
			text("Cycle Armor", 1290, 625);
			rect(healthX, healthY + 525, 50, 50, 5);
			noFill();
			rect(healthX + 150, healthY + 525, 50, 50);
		} else if (stage == STAGE_END) {
			image(endScreen, 0, 0, width, height);
		}

	}

	public void keyPressed() {

		// MENU CONTROL
		if(stage == STAGE_MENU && keyCode == KeyEvent.VK_ENTER) {
			stage = STAGE_BATTLE;
		}
		
		// HANDLE PLAYER MOVEMENT
		int toX = playerTest.getX();
		int toY = playerTest.getY();
		if (keyCode == KeyEvent.VK_W) {
			toY--;
		} else if (keyCode == KeyEvent.VK_A) {
			toX--;
		} else if (keyCode == KeyEvent.VK_S) {
			toY++;
		} else if (keyCode == KeyEvent.VK_D) {
			toX++;
		}
		
		if(playerTest.canMoveTo(toX, toY)) {
			playerTest.moveTo(toX, toY);
		}

	}

	// cap health to 100, cant go above it
	public void mousePressed() {
		if (mouseX > healthX && mouseX < healthX + 200 && mouseY > healthY && mouseY < healthY + 200) {

			if (playerTest.getHealth() < 100)
				playerTest.setHealth(playerTest.getHealth() + 1);

		}

		if (mouseX > decreaseHealthX && mouseX < decreaseHealthX + 200 && mouseY > decreaseHealthY
				&& mouseY < decreaseHealthY + 200) {

			playerTest.setHealth(playerTest.getHealth() - 1);

		}

	}

	public void playMusic(String filename) {
		if (filename.equals("random")) {
			double d = Math.random();
			System.out.println(d);
			if (d < 0.3) {
				filename = "halo3";
			} else if (d < 0.6) {
				filename = "tibdawn";
			} else {
				filename = "menu";
			}
		}
		music = new AudioClip(Paths.get("music/" + filename + ".mp3").toUri().toString());
		music.play();
	}
}
