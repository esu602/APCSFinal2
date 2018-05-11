
import javafx.scene.media.*;

import java.awt.Point;
import java.awt.event.KeyEvent;
import java.awt.geom.Point2D;
import java.nio.file.Paths;

import processing.core.PApplet;

/**
 * 
 * This class draws the player, grid and other npcs onto a board, also handles the GUI, music and visual representation of the game
 * 
 * 
 * @author David Dominique ,Evan Su
 *@version 5/9/18
 */

public class DrawingSurface extends PApplet {

	private Grid board;
	
	private Player playerTest;
	
	private int X,Y;
	
	private int healthX, healthY;
	private int decreaseHealthX, decreaseHealthY;
	
	private AudioClip music;
	boolean isPlaying = false;
	
	
	
	
	public DrawingSurface() {
		board = new Grid();
		X=5;
		Y=5;
		
		healthX= width+1125;
		healthY=height-10;
		
		decreaseHealthX=width+1125;
		decreaseHealthY=height+200;
		
		
		playerTest = new Player(board);

		
		music = new AudioClip(Paths.get("music/menu.mp3").toUri().toString());

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
			
		if (!isPlaying) {
			music.play();
//			System.out.println("hi");
			isPlaying = true;
			
			music.setCycleCount(AudioClip.INDEFINITE); //menu music will infinite loop
		}

		
		background(255);   // Clear the screen with a white background
		fill(0);
		textAlign(LEFT);
		textSize(12);
		
		String message = "";	

		text(message, height+20, 30);
		
		String message2 = playerTest.healthToString();
		
		
		if (playerTest.getHealth()==100)
		{
			//Max Health warning
			text (playerTest.maxHealth(),height+40,50);
			//Health Indicator
			text(message2, height+40,10);

			
		}
		
		else
		{
			text(message2, height+40,50);

		}
		
		
		
		

		
		//where the board is drawn
		if (board != null) {
			board.draw(this, 0, 0, height, height);
			//Health Up Box
			rect (healthX,healthY,200,200,5);
			//Health Down Box
			
			rect (decreaseHealthX,decreaseHealthY,200,200,5);

			
			
		}
		
		
		
		//player start posistion
		
		board.setState(X, Y, 3);
		
		
	}
	
	public void keyPressed() {

		if (keyCode == KeyEvent.VK_W) 
		{
			
			if (playerTest.canMoveUp(X, Y)==true)
			{
				playerTest.moveUp(X, Y);
				
			 Y--;

			}
			
			
			
			
		}
		
		else if (keyCode==KeyEvent.VK_A)
		{
			if (playerTest.canMoveLeft(X, Y)==true)
			{
				playerTest.moveLeft(X, Y);
				
				X--;

			}
		}
		
		else if (keyCode==KeyEvent.VK_S)
		{
			if (playerTest.canMoveDown(X, Y)==true)
			{
				playerTest.moveDown(X, Y);
				Y++;

			}
		}
		
		else if (keyCode==KeyEvent.VK_D)
		{
			if (playerTest.canMoveRight(X, Y)==true)
			{
				playerTest.moveRight(X, Y);
				X++;

			}
		}

		}

	//cap health to 100, cant go above it
	public void mousePressed() {
		  if(mouseX>healthX && mouseX <healthX+200 && mouseY>healthY && mouseY <healthY+200){
			  
			  if (playerTest.getHealth()<100)
			  playerTest.setHealth(playerTest.getHealth()+1);
			  
		  }
		  
		  if(mouseX>decreaseHealthX && mouseX <decreaseHealthX+200 && mouseY>decreaseHealthY && mouseY <decreaseHealthY+200){
			  
			  playerTest.setHealth(playerTest.getHealth()-1);
			  
		  }
		  
		  
	}
	

	
}










