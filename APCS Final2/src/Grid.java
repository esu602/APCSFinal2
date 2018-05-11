import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import processing.core.PApplet;

/**
 * 
 * 
 * This class models the grid upon which everything exists on, each spot in the grid corresponds to a certain state (player, enemy, vendor, empty state)
 * 
 * 
 * 
 * @author David Dominique, Evan Su
 *@version 5/9/18
 */
public class Grid {
	
	private int p1Grid[][];
	private int dim;

	// Constructs an empty grid
	public Grid() {
		dim =20;
		
		p1Grid = new int[dim][dim];
		for (int i = 0; i < p1Grid.length; i++) {
			for (int j = 0; j < p1Grid[0].length; j++) {
				p1Grid[i][j] = 0;
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
	
	
	//Idea, each value of a cell contains a certain state, enemy is 1, vendor is 2, player is 3 ect. Change color (for now) accordingly to movement
	//Empty space is 0, when creating map code this segment and return values of each cell via for loops 
	public void draw(PApplet marker, float x, float y, float width, float height) {
		float cellX = x;
		float cellY = y;
		
		float cellWidth = width / p1Grid.length;
		float cellHeight = height / p1Grid[0].length;
		marker.stroke(0);
		
	
//		marker.fill(255,255,255);
		
			for (int i = 0; i < p1Grid.length; i++) {
				for (int j = 0; j < p1Grid[i].length; j++) {
//					System.out.println(p1Grid[i][j]);
//					System.out.println("Hhh" + p1Grid[1][2]);
					
					cellX = x + i*cellWidth;
					cellY = y + j*cellHeight;
					
					if (p1Grid[i][j] == 0) {//if it's empty, it'll be white
						
						marker.fill(255,255,255);
						
					}
					else if (p1Grid[i][j] == 1){//if it contains an enemy, it'll be cyan
						marker.fill(0, 255, 255);
					}
					else if (p1Grid[i][j] == 2)//if it contains a  vendor, it'll be red 
					{
						System.exit(0);
						marker.fill(255, 0, 0);
					}
					//player
					else if (p1Grid[i][j]==3)
					{
						marker.fill(169,5,250);
					}
					
					marker.rect(cellX, cellY, cellWidth, cellHeight);
					cellX += cellWidth;
					
				}
				
				
				cellX = x;
				cellY += cellHeight;
				
				
			}
			
			
//			
//			
//			for(int i = 0; i < p1Grid.length; i++)
//			{
//				for(int j = 0; j < p1Grid[0].length; j++)
//				{
//					System.out.print(p1Grid[i][j]);
//				}
//				System.out.println();
//			}
//	
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
		

	
	
	//change to get state later
	public int getCords(int x, int y)
	{		
//		System.out.println(p1Grid[x][y]);

		return p1Grid[x][y];
	}
	
	public void setState(int x, int y, int state)
	{
		p1Grid[x][y]= state;
//		System.out.println(x + "," + y + "," + state);
	}
	
	public int getDim()
	{
		return dim;
	}
	

	
	
	
	
	
}