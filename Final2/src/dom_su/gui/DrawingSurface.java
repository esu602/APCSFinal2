package dom_su.gui;

import javafx.scene.media.*;

import java.awt.event.KeyEvent;
import java.nio.file.Paths;
import java.util.ArrayList;

import dom_su.actor.Enemy;
import dom_su.actor.Player;
import dom_su.combat.Combat;
import dom_su.combat.Item;
import dom_su.testers.Main;
import processing.core.PApplet;
import processing.core.PFont;
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
//Problems: Player Steps on top of enemy making the enemey invisible
public class DrawingSurface extends PApplet {

	public static final int STAGE_MENU = 0;
	public static final int STAGE_MAP = 1;
	public static final int STAGE_END = 2;
	public static final int STAGE_COMBAT = 3;
	
	

	private PImage menuScreen, battleScreen, endScreen, mapImg;
	private int stage;
	private Grid board1, board2;
	private Grid justSwitchedFrom;

	private Player playerTest;
	private ArrayList<Enemy> enemies1,enemies2;



	private int healthX, healthY;
	private int decreaseHealthX, decreaseHealthY;

	private AudioClip music;

	public DrawingSurface() {
		justSwitchedFrom = null;
		board1 = new Grid(true);
		board2 = new Grid(false);

		healthX = width + 1125;
		healthY = height - 10;

		decreaseHealthX = width + 1125;
		decreaseHealthY = height - 10;
		

		playerTest = new Player(board1, 5, 5);
		enemies1 = new ArrayList<Enemy>();
		enemies1.add(new Enemy(board1, 3, 4, 100));
		enemies1.add(new Enemy(board1, 5, 6, 100));
		
		enemies2 = new ArrayList<Enemy>();
		enemies2.add(new Enemy(board2, 19, 10, 100));
		enemies2.add(new Enemy(board2, 0, 10, 100));
		
		board1.setState(2, 2, Grid.STATE_DOOR1);
		board2.setState(18, 18, Grid.STATE_DOOR2);

		music = new AudioClip(Paths.get("music/menu.mp3").toUri().toString());
		music.play();

		stage = STAGE_MENU;
	}

	public Player getPlayer() {
		return playerTest;
	}

	public Enemy getEnemy(int x, int y) {
		if (board1.isActive()) {
			for (Enemy e : enemies1) {
				if (e.getX() == x && e.getY() == y) {
					return e;
				}
			}
		}
		
		else if (board2.isActive())
		{
			for (Enemy e : enemies2) {
				if (e.getX() == x && e.getY() == y) {
					return e;
				}
			}
		}
		

		return null;
	}

	// The statements in the setup() function
	// execute once when the program begins
	public void setup() {
		String backgroundPath = "images" + Main.FILE_SEPARATOR + "background" + Main.FILE_SEPARATOR;
		menuScreen = loadImage(backgroundPath + "scene_menu.png");
		endScreen = loadImage(backgroundPath + "scene_end.jpg");
		battleScreen = loadImage(backgroundPath + "scene_battle.png");
		mapImg = loadImage("images//background//background.jpg");

		String spritePath = "images" + Main.FILE_SEPARATOR + "sprites" + Main.FILE_SEPARATOR;
		playerTest.setImage(loadImage(spritePath + "sprite_player.png"));
		for (Enemy e : enemies1) {
			e.setImage(loadImage(spritePath + "sprite_enemy.png"));
		}
		for (Enemy e : enemies2) {
			e.setImage(loadImage(spritePath + "sprite_enemy.png"));
		}
	}

	// The statements in draw() are executed until the
	// program is stopped. Each statement is executed in
	// sequence and after the last line is read, the first
	// line is executed again.
	public void draw() {



		// SET MUSIC
		if (!music.isPlaying()) {
			if ((board1.isActive() ? board1 : board2) != null) {
				// playMusic("random");
			}
		}

		// DETERMINE STAGE
		if (stage == STAGE_MENU) {
			Menu m = new Menu(menuScreen);
			m.draw(this);

			if (m.playGame()) {
				stage = STAGE_MAP;
			}
		} else if (stage == STAGE_MAP) {
			// SETUP MAP SCREEN
			background(255, 255, 255);
			fill(0);
			textAlign(LEFT);
			textSize(12);
			image(mapImg, 0, 0, width / 2 + 60, height);

			// MAX HEALTH WARNING
			if (playerTest.getHealth() == 100) {
				text("MAX HEALTH", 1125, 175);
			} else if (!playerTest.isAlive()) { // Player is dead
				stage = STAGE_END;
			}

			// Draw Board
			Grid board = null;
			if (board1.isActive()) {
				board = board1;
			} else if (board2.isActive()) {
				System.out.println("test");
				board = board2;
			}
			if (board != null) {
				board.draw(this, 0, 0, height, height);
			}

			// Health Square
			noFill();
			rect(healthX, healthY, 200, 100, 5);
			String message2 = "Player Health: " + playerTest.getHealth();
			text(message2, 1110, 150);
			text("Press button for health", 1255, 145);
			// // Attack Button
			// noFill();
			// rect(healthX, healthY + 150, 200, 100, 5);
			// text("Attack With Selected Weapon", 1240, 290);
			// // Cycle Weapon Buttons Left & Right
			// noFill();
			// text("Cycle Weapon", 1285, 390);
			// rect(healthX, healthY + 300, 50, 50, 5);
			// noFill();
			// rect(healthX + 150, healthY + 300, 50, 50);
			// // Defend Button
			// noFill();
			// text("Defend With Selected Item", 1250, 535);
			// rect(healthX, healthY + 390, 200, 100);
			// // Cycle Armor Buttons
			// noFill();
			// text("Cycle Armor", 1290, 625);
			// rect(healthX, healthY + 525, 50, 50, 5);
			// noFill();
			// rect(healthX + 150, healthY + 525, 50, 50);
		} else if (stage == STAGE_END) {
			image(endScreen, 0, 0, width, height);
		} else if (stage == STAGE_COMBAT) {
			image(battleScreen, 0, 0, width, height);
			image(playerTest.getImage(), width / 2 - 500, height / 2 - 100, 250, 250);
			image(enemies1.get(0).getImage(), width / 2 + 300, height / 2 - 310, 300, 300);

			textSize(28);
			text("PlayerHealth " + playerTest.getHealth(), 1000, 800);
			text("Action Point "+playerTest.getNumActionPoints(),1000,850);
			
			
		}

		if (keyPressed) {

		}

	}

	public void keyPressed() {

		if (stage == STAGE_MENU && keyCode == KeyEvent.VK_ENTER) {
			stage = STAGE_MAP;
		}

		/*// if(inCombat=true) {
		// HANDLE PLAYER MOVEMENT
		int toX = playerTest.getX();
		int toY = playerTest.getY();

		if (keyCode == KeyEvent.VK_W) {
			if (toY > 0)
				toY--;

			if (board.getState(toX, toY) == 1) {
				stage = STAGE_COMBAT;

			}

			else if (board.getState(toX, toY) == board.STATE_DOOR1) {
				mapStage = 1;
				toY++;

			}

			else if (board.getState(toX, toY) == board.STATE_DOOR2) {
				mapStage = 0;
				System.out.println("Door 2 to 1");
			}

			else if (board.getState(toX, toY) == 6) {
				playerTest.increaseHealth(-5);
			}
		} else if (keyCode == KeyEvent.VK_A) {
			if (toX > 0)
				toX--;

			if (board.getState(toX, toY) == 1) {
				stage = STAGE_COMBAT;
			} else if (board.getState(toX, toY) == board.STATE_DOOR1) {
				toX++;
				mapStage = 1;
			}

			else if (board.getState(toX, toY) == board.STATE_DOOR2) {
				toX++;
				mapStage = 0;
			} else if (board.getState(toX, toY) == 6) {
				playerTest.increaseHealth(-5);
			}

		} else if (keyCode == KeyEvent.VK_S) {

			if (toY < 19)
				toY++;

			if (board.getState(toX, toY) == 1) {
				stage = STAGE_COMBAT;
			} else if (board.getState(toX, toY) == 4) {
				mapStage = 1;
			}

			else if (board.getState(toX, toY) == 5) {
				mapStage = 0;
			} else if (board.getState(toX, toY) == 6) {
				playerTest.increaseHealth(-5);
			}

		} else if (keyCode == KeyEvent.VK_D) {
			if (toX < 19) {
				toX++;
			}

			if (board.getState(toX, toY) == 1) {
				stage = STAGE_COMBAT;
			} else if (board.getState(toX, toY) == 4) {
				mapStage = 1;
			}

			else if (board.getState(toX, toY) == 5) {
				mapStage = 0;
			} else if (board.getState(toX, toY) == 6) {
				playerTest.increaseHealth(-5);
			}

		}
		
*/
		else if (keyCode == KeyEvent.VK_N) {
			// inCombat=false;
			stage = STAGE_MAP;
		}
		
		// HANDLE PLAYER MOVEMENT
		int toX = playerTest.getX();
		int toY = playerTest.getY();
		boolean enemiesAct = false;
		if (keyCode == KeyEvent.VK_W) {
			enemiesAct = true;
			toY--;
		} else if (keyCode == KeyEvent.VK_A) {
			enemiesAct = true;
			toX--;
		} else if (keyCode == KeyEvent.VK_S) {
			enemiesAct = true;
			toY++;
		} else if (keyCode == KeyEvent.VK_D) {
			enemiesAct = true;
			toX++;
		}
		
		// Ensure nothing occurs when not on stage map
		if (stage == STAGE_MAP && enemiesAct) {
			
			// TODO set act method of enemies
			if (board1.isActive()) {
				for (Enemy e : enemies1) {
					e.act(playerTest);
				}
				
				// Must be called after enemies act
				if (board1.getState(playerTest.getX(), playerTest.getY()) == Grid.STATE_ENEMY) {
					stage = STAGE_COMBAT;
				} else {
					
				}
				
			} else if (board2.isActive()) {
				for (Enemy e : enemies2) {
					e.act(playerTest);
				}
				
				// Must be called after enemies act
				if (board2.getState(playerTest.getX(), playerTest.getY()) == Grid.STATE_ENEMY) {
					stage = STAGE_COMBAT;
				} else {
				}
			}
			int pX = playerTest.getX();
			int pY = playerTest.getY();
			if(playerTest.canMoveTo(toX, toY)) {
				int previousState = playerTest.moveTo(toX, toY);
				if(justSwitchedFrom == board1) {
					
					board1.setState(pX, pY, Grid.STATE_DOOR1);
					justSwitchedFrom = null;
				} else if (justSwitchedFrom == board2) {
					board1.setState(pX, pY, Grid.STATE_DOOR2);
					justSwitchedFrom = null;
				} 
				if (previousState == Grid.STATE_ENEMY) {
					stage = STAGE_COMBAT;
				} else if (previousState == Grid.STATE_DOOR1) {
					board1.setActive(false);
					board2.setActive(true);
					justSwitchedFrom = board1;
					playerTest.setGrid(board2);
				} else if (previousState == Grid.STATE_DOOR2) {
					board1.setActive(true);
					board2.setActive(false);
					playerTest.setGrid(board1);
					justSwitchedFrom = board2;
				}
			} // else NOTHING OCCURS
			
		}

	}

	public void mousePressed() {
		if (mouseX > healthX && mouseX < healthX + 200 && mouseY > healthY && mouseY < healthY + 200) {

			if (playerTest.getHealth() < 100) {
				playerTest.increaseHealth(2);
			}

			// Max health is set permanently , fix later
			else if (playerTest.getHealth() > 100) {
				playerTest.increaseHealth(playerTest.DEFAULT_HEALTH_DECREASE);
			}
		}
		else if(stage==STAGE_COMBAT)

		{
			//Buttons
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
//		music = new AudioClip(Paths.get("music/" + filename + ".mp3").toUri().toString());
//		music.play();
	}
}