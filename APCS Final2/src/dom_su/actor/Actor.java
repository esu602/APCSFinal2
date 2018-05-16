package dom_su.actor;

import dom_su.gui.Grid;
import processing.core.PApplet;
import processing.core.PImage;

public class Actor {

	private Grid g;
	private int x, y; // Location of the Actor on the Grid

	private int health;

	private PImage actorImg;

	public Actor(Grid grid, int xInitial, int yInitial, int startingHealth) {
		g = grid; // This must be set before any setX() or setY() can be called

		x = xInitial;
		y = yInitial;
		setX(x);
		setY(y);

		health = startingHealth;

		actorImg = new PImage();
	}

	// METHODS

	/**
	 * Moves the <code>Actor</code> by the specified amount.
	 * 
	 * @param xAmt
	 *            The amount to move the <code>Actor</code> along the x-axis. Set
	 *            this to a negative value to move the <code>Actor</code> along the
	 *            negative x-axis.
	 * @param yAmt
	 *            The amount to move the <code>Actor</code> along the y-axis. Set
	 *            this to a negative value to move the <code>Actor</code> along the
	 *            negative y-axis.
	 */
	public void moveBy(int xAmt, int yAmt) {
		g.setState(x, y, 0);
		g.setState(x + xAmt, y + yAmt, 3);
		x += xAmt;
		y += yAmt;
	}

	/**
	 * Moves the <code>Actor</code> to the specified location.
	 * 
	 * @param xTo
	 *            The x-coordinate to set the <code>Actor</code> to.
	 * @param yTo
	 *            The y-coordinate to set the <code>Actor</code> to.
	 */
	public void moveTo(int xTo, int yTo) {
		g.setState(x, y, 0);
		g.setState(xTo, yTo, 3);
		x = xTo;
		y = yTo;
	}

	/**
	 * Determines whether the <code>Actor</code> can move to the specified location
	 * based on the {@link Grid} it is in. To set the <code>Grid</code>, use the
	 * method {@link #setGrid(Grid)}.
	 * 
	 * @param xTo
	 *            The x-coordinate to check whether the <code>Actor</code> can move
	 *            to.
	 * @param yTo
	 *            The y-coordinate to check whether the <code>Actor</code> can move
	 *            to.
	 * @return Whether the the <code>Actor</code> can move to the location
	 *         <code>(xTo, yTo)</code>.
	 */
	public boolean canMoveTo(int xTo, int yTo) {
		int gridW = g.getGridWidth();
		int gridH = g.getGridHeight();

		return xTo >= 0 && yTo >= 0 && xTo <= (gridW - 1) && yTo <= (gridH - 1) && g.getState(xTo, yTo) == 0;
	}

	/**
	 * Increases the health of the <code>Actor</code> by the specified amount.
	 * 
	 * @param amount
	 *            The amount to increase the health by. To decrease health, set
	 *            <code>amount</code> to a negative.
	 */
	public void increaseHealth(int amount) {
		health += amount;
	}

	/**
	 * Determines whether the <code>Actor</code> is alive - when health is lower
	 * than 0.
	 * 
	 * @return Whether the <code>Actor</code> is alive.
	 */
	public boolean isAlive() {
		return health > 0;
	}

	// GETTERS
	/**
	 * Gets the x-coordinate of the <code>Actor</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @return The x-coordinate of the Actor's relative position on the
	 *         <code>Grid</code>.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y-coordinate of the <code>Actor</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @return The y-coordinate of the Actor's relative position on the
	 *         <code>Grid</code>.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets the health of the <code>Actor</code>.
	 * 
	 * @return An integer value representing the Actor's health.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Gets the {@link Grid} which the <code>Actor</code> is on and moves with
	 * respect to.
	 * 
	 * @return The <code>Grid</code> which the <code>Actor</code> is on.
	 */
	public Grid getGrid() {
		return g;
	}

	/**
	 * Gets the <code>PImage</code> that represents the <code>Actor</code>.
	 * 
	 * @return The <code>PImage</code> that represents the <code>Actor</code>.
	 */
	public PImage getImage() {
		return actorImg;
	}

	// SETTERS

	/**
	 * Sets the x-coordinate of the <code>Actor</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @param x
	 *            The x-coordinate to set the <code>Actor</code> to.
	 */
	public void setX(int x) {
		g.setState(this.x, this.y, 0); // Sets current location to state=0
		g.setState(x, this.y, 3); // Sets location to move to, to state=3
		this.x = x;
	}

	/**
	 * Sets the y-coordinate of the <code>Actor</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @param y
	 *            The y-coordinate to set the <code>Actor</code> to.
	 */
	public void setY(int y) {
		g.setState(this.x, this.y, 0); // Sets current location to state=0
		g.setState(this.x, y, 3); // Sets location to move to, to state=3
		this.y = y;
	}

	/**
	 * Sets the health of the <code>Actor</code>.
	 * 
	 * @param health
	 *            An integer value representing the Actor's health.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Sets the {@link Grid} which the <code>Actor</code> is on and moves with
	 * respect to.
	 * 
	 * @param g
	 *            The <code>Grid</code> which the <code>Actor</code> is on.
	 */
	public void setGrid(Grid g) {
		this.g = g;
	}

	/**
	 * Sets the <code>PImage</code> that represents the <code>Actor</code>.
	 * 
	 * @param img
	 *            The <code>PImage</code> that will represent the
	 *            <code>Actor</code>.
	 */
	public void setImage(PImage img) {
		actorImg = img;
	}

	/**
	 * Sets the <code>PImage</code> that represents the <code>Actor</code> based on
	 * the image's file name and the <code>PApplet</code> in which it is to be
	 * drawn.
	 * 
	 * @param filepath
	 *            The filepath location of the <code>PImage</code>.
	 * @param scope
	 *            The <code>PApplet</code> where the <code>Actor</code> is drawn.
	 */
	public void setImage(String filepath, PApplet scope) {
		actorImg = scope.loadImage(filepath);
	}
}
