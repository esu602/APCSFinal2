import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;


public class Grid {
	
	private int p1Grid[][];

	// Constructs an empty grid
	public Grid() {
		p1Grid = new int[10][10];
		for (int i = 0; i < p1Grid.length; i++) {
			for (int j = 0; j < p1Grid[0].length; j++) {
				p1Grid[i][j] = -1;
			}
				
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
		

	}

	
	
	
	
}