import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/*

	Represents a very simplified game of Battleship.

	Coded by: Evan Su
	Modified on: 1/19/18

*/

public class Grid {
	
	private int p1Grid[][];
	private int p1TargetGrid[][];
	private int p2Grid[][];
	private int p2TargetGrid[][];
	
	private int turnCount = 1;
	
	private int p1Score;
	private int p2Score;

	// Constructs an empty grid
	public Grid() {
		p1Grid = new int[10][10];
		p1TargetGrid = new int [10][10];
		p2Grid = new int [10][10];
		p2TargetGrid = new int [10][10];
		
		//For player grids: -1 is empty, 1 contains a ship, 2 contains a destroyed ship
		//For targeting grids: -1 is uncovered, 1 is a hit, 2 is a miss.
		
		for (int i = 0; i < 10; i++) {
			for (int j = 0; j < 10; j++) {
				p1Grid[i][j] = -1;
				p1TargetGrid[i][j] = -1;
				
				p2Grid[i][j] = -1;
				p2TargetGrid[i][j] = -1;
			}
		}
		
		for (int i = 0; i < 40; i++) {//randomly fills in 40 squares as containing ships for both player grids
				
				int x = (int) (Math.random() * 10);
				int y = (int) (Math.random() * 10);
				if (p1Grid[x][y] != 1) {
					p1Grid[x][y] = 1;
				}
				else i--;
			
		}
		
		for (int i = 0; i < 40; i++) {

					int x2 = (int) (Math.random() * 10);
					int y2 = (int) (Math.random() * 10);
					if (p2Grid[x2][y2] != 1) {
						p2Grid[x2][y2] = 1;
					}
					else i--;
		}
	}

	// Constructs the grid defined in the file specified
	/*public GridGame(String filename) {
		p1Grid = new boolean[20][20];
		readData(filename, p1Grid);
	}*/

	public void setup() {
		
	}
	
	
	
	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker The PApplet used for drawing.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 */
	public void draw(PApplet marker, float x, float y, float width, float height) {
		float cellX = x;
		float cellY = y;
		
		float cellWidth = width / p1Grid.length;
		float cellHeight = height / p1Grid[0].length;
		marker.stroke(0);
		
		if (turnCount % 8 == 1) {//displaying P1's home grid
			for (int i = 0; i < p1Grid.length; i++) {
				for (int j = 0; j < p1Grid[i].length; j++) {
					if (p1Grid[i][j] == -1) {//if it's empty, it'll be white
						marker.fill(255);
					}
					else if (p1Grid[i][j] == 1){//if it contains a ship, it'll be cyan
						marker.fill(0, 255, 255);
					}
					else if (p1Grid[i][j] == 2)//if it contains a destroyed ship, it'll be red 
						{
						marker.fill(255, 0, 0);
							}
					marker.rect(cellX, cellY, cellWidth, cellHeight);
					cellX += cellWidth;
				}
				cellX = x;
				cellY += cellHeight;
			}
			
			
			
		}
		
		else if ((turnCount % 8 == 2) || (turnCount % 8 == 3)) {//displaying P1's targeting grid when firing and reviewing
			
			for (int i = 0; i < p1TargetGrid.length; i++) {
				for (int j = 0; j < p1TargetGrid[i].length; j++) {
					if (p1TargetGrid[i][j] == -1) {//if it's uncovered, the square will be white
						marker.fill(255);
					}
					else if (p1TargetGrid[i][j] == 1){//if it was a hit, the square will be red
						marker.fill(255, 0, 0);
					}
					else if (p1TargetGrid[i][j] == 2)//if it was a miss, the square will be yellow
						{
						marker.fill(255, 255, 0);
							}
					marker.rect(cellX, cellY, cellWidth, cellHeight);
					cellX += cellWidth;
				}
				cellX = x;
				cellY += cellHeight;
			}
			
			
		}
		
		else if ((turnCount % 8 == 4) || (turnCount % 8 == 0)) {//don't draw anything on the grid for privacy reasons during transition turns
			
			
		}
		
		else if (turnCount % 8 == 5) {//displaying P2's home grid
			for (int i = 0; i < p2Grid.length; i++) {
				for (int j = 0; j < p2Grid[i].length; j++) {
					if (p2Grid[i][j] == -1) {//if it's empty, it'll be white
						marker.fill(255);
					}
					else if (p2Grid[i][j] == 1){//if it contains a ship, it'll be cyan
						marker.fill(0, 255, 255);
					}
					else if (p2Grid[i][j] == 2)//if it contains a destroyed ship, it'll be red 
						{
						marker.fill(255, 0, 0);
							}
					marker.rect(cellX, cellY, cellWidth, cellHeight);
					cellX += cellWidth;
				}
				cellX = x;
				cellY += cellHeight;
			}
			
		}
		
		else if ((turnCount % 8 == 6) || (turnCount % 8 == 7)) {//displaying P2's target grid
			for (int i = 0; i < p2TargetGrid.length; i++) {
				for (int j = 0; j < p2TargetGrid[i].length; j++) {
					if (p2TargetGrid[i][j] == -1) {//if it's uncovered, the square will be white
						marker.fill(255);
					}
					else if (p2TargetGrid[i][j] == 1){//if it was a hit, the square will be red
						marker.fill(255, 0, 0);
					}
					else if (p2TargetGrid[i][j] == 2)//if it was a miss, the square will be yellow
						{
						marker.fill(255, 255, 0);
							}
					marker.rect(cellX, cellY, cellWidth, cellHeight);
					cellX += cellWidth;
				}
				cellX = x;
				cellY += cellHeight;
			}
			
		}
	
	}

	
	/**
	 * Optionally, complete this method to determine which element of the grid matches with a
	 * particular pixel coordinate.
	 * 
	 * @param p A Point object representing a graphical pixel coordinate.
	 * @param x The x pixel coordinate of the upper left corner of the grid drawing. 
	 * @param y The y pixel coordinate of the upper left corner of the grid drawing.
	 * @param width The pixel width of the grid drawing.
	 * @param height The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width / p1Grid.length;
		float cellHeight = height / p1Grid[0].length;
		
		int j = (int) ((p.x - x)/cellWidth);
		int i = (int) ((p.y - y)/cellHeight);
		
		if (j < 0 || j > (p1Grid.length -  1)) {
			return null;
		}
		if (i < 0 || i > (p1Grid[0].length -  1)) {
			return null;
		}
		
		Point answer = new Point (i, j);
		return answer;
	}
	
	public void toggleCell(int i, int j) {
		int turnMod = turnCount % 8;
		if ((turnMod == 1) || (turnMod == 3) || (turnMod == 4) || (turnMod == 5)|| (turnMod == 7) || (turnMod == 0)) {//
			turnCount++; //go to the next turn, they aren't supposed to do anything
		}
		else if (turnMod == 2) {//if player 1 is looking at their target grid
			if (p1TargetGrid[i][j] == -1) {//if they click an empty square
				if (p2Grid[i][j] == 1) { //if a ship exists in that spot
					p1TargetGrid[i][j] = 1; //it's a hit
					p2Grid[i][j] = 2; //p2's ship is destroyed
				}
				else if (p2Grid[i][j] == -1) {//if a ship doesn't exist in that spot
					p1TargetGrid[i][j] = 2; //it's a miss
				}
			}
			
			turnCount++;
		}

		else if (turnMod == 6) {//if player 2 is looking at their target grid
			if (p2TargetGrid[i][j] == -1) {//if they click an empty square
				if (p1Grid[i][j] == 1) { //if a ship exists in that spot
					p2TargetGrid[i][j] = 1; //it's a hit
					p1Grid[i][j] = 2; //p2's ship is destroyed
				}
				else if (p1Grid[i][j] == -1) {//if a ship doesn't exist in that spot
					p2TargetGrid[i][j] = 2; //it's a miss
				}
			}
			
			turnCount++;
		}
		

	}

	public int getTurn() {
		return turnCount;
	}
	
	
	
	
}