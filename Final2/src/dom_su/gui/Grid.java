package dom_su.gui;
import java.awt.Point;

import processing.core.PApplet;
import java.util.ArrayList;

/**
 * 
 * 
 * This class models the grid upon which everything exists on, each spot in the
 * grid corresponds to a certain state (player, enemy, vendor, empty state)
 * 
 * 
 * 
 * @author David Dominique, Evan Su
 * @version 5/9/18
 */
public class Grid {

	public static final int STATE_EMPTY 	= 0;
	public static final int STATE_ENEMY 	= 1;
	public static final int STATE_VENDOR 	= 2;
	public static final int STATE_PLAYER 	= 3;
	public static final int STATE_DOOR1 	= 4;
	public static final int STATE_DOOR2      =5;
	
	
	private int p1Grid[][]; // rename this once we're close to finishing
	private int dim;
	
	private boolean isActive;

	private ArrayList<int[][]> grids;

	// Constructs an empty grid
	public Grid(boolean isActive) {
		this.isActive = isActive;
		dim = 20;

		p1Grid = new int[dim][dim];
		for (int i = 0; i < p1Grid.length; i++) {
			for (int j = 0; j < p1Grid[0].length; j++) {
				p1Grid[i][j] = 0;
			}

		}

		grids = new ArrayList<int[][]>();
		grids.add(p1Grid);
	}

	/**
	 * Optionally, complete this method to draw the grid on a PApplet.
	 * 
	 * @param marker
	 *            The PApplet used for drawing.
	 * @param x
	 *            The x pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param y
	 *            The y pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param width
	 *            The pixel width of the grid drawing.
	 * @param height
	 *            The pixel height of the grid drawing.
	 */

	// Idea, each value of a cell contains a certain state, enemy is 1, vendor is 2,
	// player is 3 ect. Change color (for now) accordingly to movement
	// Empty space is 0, when creating map code this segment and return values of
	// each cell via for loops
	public void draw(DrawingSurface marker, float x, float y, float width, float height) {
		float cellX = x;
		float cellY = y;

		float cellWidth = width / p1Grid.length;
		float cellHeight = height / p1Grid[0].length;
		// marker.stroke(0);

		// RESET DRAWING PARAMETERS
		marker.stroke(0);
		marker.strokeWeight(1);
		marker.fill(0);

		for (int i = 0; i < p1Grid.length; i++) {
			for (int j = 0; j < p1Grid[i].length; j++) {

				cellX = x + i * cellWidth;
				cellY = y + j * cellHeight;
				marker.pushStyle();

				if (p1Grid[i][j] == STATE_EMPTY) {			// if it's empty, it'll be white
					marker.noFill();
				} else if (p1Grid[i][j] == STATE_ENEMY) {		// if it contains an enemy, it'll be cyan
					marker.fill(0, 255, 255);
				} else if (p1Grid[i][j] == STATE_VENDOR) {		// if it contains a vendor, it'll be red
					marker.fill(255, 0, 0);
				} else if (p1Grid[i][j] == STATE_PLAYER) {
					marker.noFill();
				}
				else if (p1Grid[i][j]==STATE_DOOR1)//Door From map 1 to 2
				{
					marker.fill(255,255,51);
				}
				
				else if (p1Grid[i][j]==STATE_DOOR2)//Door from map 2 to 1
				{
					marker.fill(51,51,255);
				}
				
				marker.rect(cellX, cellY, cellWidth, cellHeight);
				if (p1Grid[i][j] == STATE_PLAYER) {
					marker.image(marker.getPlayer().getImage(), cellX, cellY, cellWidth, cellHeight);
				} else if(p1Grid[i][j] == STATE_ENEMY) {
//					marker.image(marker.getEnemy(i, j).getImage(), cellX, cellY, cellWidth, cellHeight);
					marker.fill(0,255,255);
					
				}
				
			

				
				
				cellX += cellWidth;

				marker.popStyle();

			}

			cellX = x;
			cellY += cellHeight;

		}
	}

	/**
	 * Optionally, complete this method to determine which element of the grid
	 * matches with a particular pixel coordinate.
	 * 
	 * @param p
	 *            A Point object representing a graphical pixel coordinate.
	 * @param x
	 *            The x pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param y
	 *            The y pixel coordinate of the upper left corner of the grid
	 *            drawing.
	 * @param width
	 *            The pixel width of the grid drawing.
	 * @param height
	 *            The pixel height of the grid drawing.
	 * @return A Point object representing a coordinate within the game of life
	 *         grid.
	 */
	public Point clickToIndex(Point p, float x, float y, float width, float height) {
		float cellWidth = width / p1Grid.length;
		float cellHeight = height / p1Grid[0].length;

		int j = (int) ((p.x - x) / cellWidth);
		int i = (int) ((p.y - y) / cellHeight);

		if (j < 0 || j > (p1Grid.length - 1)) {
			return null;
		}
		if (i < 0 || i > (p1Grid[0].length - 1)) {
			return null;
		}

		Point answer = new Point(i, j);
		return answer;
	}

	public void toggleCell(int i, int j) {

	}

	// change to get state later
	public int getState(int x, int y) {
		return p1Grid[x][y];
	}

	public void setState(int x, int y, int state) {
		p1Grid[x][y] = state;
	}

	public int getDim() {
		return dim;
	}

	public int getGridWidth() {
		return p1Grid.length;
	}

	public int getGridHeight() {
		return p1Grid[0].length;
	}
	
	public boolean isActive() {
		return  isActive;
	}
	public void setActive(boolean active) {
		isActive= active;
	}

}