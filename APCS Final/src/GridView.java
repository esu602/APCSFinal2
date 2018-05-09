import java.awt.Point;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Paths;
import java.util.Scanner;

import java.util.ArrayList;

import processing.core.PApplet;
import processing.core.PImage;

/*
 * This class draws the good ol'fashioned grid display where the player can see where they are, what's around them, etc.
 * 
 * It holds an array of Grids that it can switch between.
 * The UI is also programmed into this class.
 */
public class GridView extends PApplet{
	
	private ArrayList<Grid> grids;
	
	private int p1Grid[][]; //not used
	
	public static final int GRIDSIZE = 10; //length/height of the grid
	
	public static final int EMPTY = 0; //value for an empty space
	public static final int PLAYER = 1; //value for a player
	
	private int currentGrid = 0;
	
	private PImage player;

	// Constructs an empty grid
	public GridView() {
		grids = new ArrayList<Grid>();
		grids.add(new Grid());
		

	}
	// Constructs the grid defined in the file specified
	/*public GridGame(String filename) {
		p1Grid = new boolean[20][20];
		readData(filename, p1Grid);
	}*/

	public void setup() {
		player = loadImage(sketchPath("sprites/bug.gif"));
		System.out.println(player);
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
		System.out.println("hi");
		float cellX = x;
		float cellY = y;
		
		float cellWidth = width / GRIDSIZE;
		float cellHeight = height / GRIDSIZE;
		marker.stroke(0);
	
			for (int i = 0; i < GRIDSIZE; i++) {
				for (int j = 0; j < GRIDSIZE; j++) {
					if (grids.get(currentGrid).getCell(i,  j) == 0) {//if it's empty, it'll be white
						marker.fill(255);
						marker.rect(cellX, cellY, cellWidth, cellHeight);
					}

					
					if (grids.get(currentGrid).getCell(i,  j) == 1){//if it contains a vendor?
					}
				
					
					if (grids.get(currentGrid).getCell(i,  j) == 2)//if it contains a player 
						{
						marker.fill(75, 0, 130); //purple
						marker.rect(cellX, cellY, cellWidth, cellHeight);
						image(player, cellX, cellY);
							}

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