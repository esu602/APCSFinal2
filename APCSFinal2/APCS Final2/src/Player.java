import processing.core.PApplet;
import processing.core.PImage;

/**
 * 
 * This class models the behavior of the player character from movement, to
 * their health. The core aspects of a player such as level and weapons they
 * have are stored in this class
 * 
 * @author David Dominique, Evan Su
 * @version 5/9/18
 *
 */
public class Player {

	/**
	 * The default positive health increase. When used in the method
	 * {@link #increaseHealth(int) increaseHealth(Player.DEFAULT_HEALTH_INCREASE)},
	 * this increases the health of the <code>Player</code> by 5.
	 */
	public static final int DEFAULT_HEALTH_INCREASE = 5;

	/**
	 * The default negative health decrease. When used in the method
	 * {@link #increaseHealth(int)
	 * increaseHealth(Player.DEFAULT_HEALTH_DECREASE)},this decreases the health of
	 * the <code>Player</code> by 5.
	 */
	public static final int DEFAULT_HEALTH_DECREASE = -5;

	private Grid playerGrid;
	private int x, y; // Location of the Player on the Grid

	private int health;

	private PImage playerImg;

	// CONSTRUCTORS

	/**
	 * Creates a <code>Player</code> on a {@link Grid}.
	 * 
	 * @param grid
	 *            The {@link Grid} which the <code>Player</code> is on.
	 */
	public Player(Grid grid, int xInitial, int yInitial) {
		playerImg = new PImage();
		playerGrid = grid;
		setX(xInitial);
		setY(yInitial);

		setHealth(90);
	}

	// METHODS

	/**
	 * Moves the <code>Player</code> by the specified amount.
	 * 
	 * @param xAmt
	 *            The amount to move the <code>Player</code> along the x-axis. Set
	 *            this to a negative value to move the <code>Player</code> along the
	 *            negative x-axis.
	 * @param yAmt
	 *            The amount to move the <code>Player</code> along the y-axis. Set
	 *            this to a negative value to move the <code>Player</code> along the
	 *            negative y-axis.
	 */
	public void moveBy(int xAmt, int yAmt) {
		playerGrid.setState(x, y, 0);
		playerGrid.setState(x + xAmt, y + yAmt, 3);
		x += xAmt;
		y += yAmt;
	}

	/**
	 * Moves the <code>Player</code> to the specified location.
	 * 
	 * @param xTo
	 *            The x-coordinate to set the <code>Player</code> to.
	 * @param yTo
	 *            The y-coordinate to set the <code>Player</code> to.
	 */
	public void moveTo(int xTo, int yTo) {
		playerGrid.setState(x, y, 0);
		playerGrid.setState(xTo, yTo, 3);
		x = xTo;
		y = yTo;
	}

	/**
	 * Determines whether the <code>Player</code> can move to the specified location
	 * based on the {@link Grid} it is in. To set the <code>Grid</code>, use the
	 * method {@link #setGrid(Grid)}.
	 * 
	 * @param xTo
	 *            The x-coordinate to check whether the <code>Player</code> can move
	 *            to.
	 * @param yTo
	 *            The y-coordinate to check whether the <code>Player</code> can move
	 *            to.
	 * @return Whether the the <code>Player</code> can move to the location
	 *         <code>(xTo, yTo)</code>.
	 */
	public boolean canMoveTo(int xTo, int yTo) {
		int gridW = playerGrid.getGridWidth();
		int gridH = playerGrid.getGridHeight();

		return xTo >= 0 && yTo >= 0 && xTo <= (gridW - 1) && yTo <= (gridH - 1) && playerGrid.getState(xTo, yTo) == 0;
	}

	/**
	 * Increases the health of the <code>Player</code> by the specified amount.
	 * 
	 * @param amount
	 *            The amount to increase the health by. To decrease health, set
	 *            <code>amount</code> to a negative.
	 */
	public void increaseHealth(int amount) {
		health += amount;
	}

	/**
	 * Determines whether the <code>Player</code> is alive - when health is lower
	 * than 0.
	 * 
	 * @return Whether the <code>Player</code> is alive.
	 */
	public boolean isAlive() {
		return health > 0;
	}

	// GETTERS
	/**
	 * Gets the x-coordinate of the <code>Player</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @return The x-coordinate of the Player's relative position on the
	 *         <code>Grid</code>.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y-coordinate of the <code>Player</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @return The y-coordinate of the Player's relative position on the
	 *         <code>Grid</code>.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets the health of the <code>Player</code>.
	 * 
	 * @return An integer value representing the Player's health.
	 */
	public int getHealth() {
		return health;
	}

	/**
	 * Gets the {@link Grid} which the <code>Player</code> is on and moves with
	 * respect to.
	 * 
	 * @return The <code>Grid</code> which the <code>Player</code> is on.
	 */
	public Grid getGrid() {
		return playerGrid;
	}

	/**
	 * Gets the <code>PImage</code> that represents the <code>Player</code>.
	 * 
	 * @return The <code>PImage</code> that represents the <code>Player</code>.
	 */
	public PImage getImage() {
		return playerImg;
	}

	// SETTERS

	/**
	 * Sets the x-coordinate of the <code>Player</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @param x
	 *            The x-coordinate to set the <code>Player</code> to.
	 */
	public void setX(int x) {
		playerGrid.setState(this.x, this.y, 0); // Sets current location to state=0
		playerGrid.setState(x, this.y, 3); // Sets location to move to, to state=3
		this.x = x;
	}

	/**
	 * Sets the y-coordinate of the <code>Player</code> in respect to the
	 * {@link Grid}.
	 * 
	 * @param y
	 *            The y-coordinate to set the <code>Player</code> to.
	 */
	public void setY(int y) {
		playerGrid.setState(this.x, this.y, 0); // Sets current location to state=0
		playerGrid.setState(this.x, y, 3); // Sets location to move to, to state=3
		this.y = y;
	}

	/**
	 * Sets the health of the <code>Player</code>.
	 * 
	 * @param health
	 *            An integer value representing the Player's health.
	 */
	public void setHealth(int health) {
		this.health = health;
	}

	/**
	 * Sets the {@link Grid} which the <code>Player</code> is on and moves with
	 * respect to.
	 * 
	 * @param g
	 *            The <code>Grid</code> which the <code>Player</code> is on.
	 */
	public void setGrid(Grid g) {
		this.playerGrid = g;
	}

	/**
	 * Sets the <code>PImage</code> that represents the <code>Player</code>.
	 * 
	 * @param img
	 *            The <code>PImage</code> that will represent the
	 *            <code>Player</code>.
	 */
	public void setImage(PImage img) {
		playerImg = img;
	}

	/**
	 * Sets the <code>PImage</code> that represents the <code>Player</code> based on
	 * the image's file name and the <code>PApplet</code> in which it is to be
	 * drawn.
	 * 
	 * @param filepath
	 *            The filepath location of the <code>PImage</code>.
	 * @param scope
	 *            The <code>PApplet</code> where the <code>Player</code> is drawn.
	 */
	public void setImage(String filepath, PApplet scope) {
		playerImg = scope.loadImage(filepath);
	}

}
