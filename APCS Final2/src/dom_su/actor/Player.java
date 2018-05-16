package dom_su.actor;

import dom_su.gui.Grid;

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
public class Player extends Actor {

	/**
	 * How much health the <code>Player</code> starts with.
	 */
	public static final int DEFAULT_HEALTH_START = 90;

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

	// CONSTRUCTORS

	/**
	 * Creates a <code>Player</code> on a {@link Grid}.
	 * 
	 * @param grid
	 *            The {@link Grid} which the <code>Player</code> is on.
	 */
	public Player(Grid grid, int xInitial, int yInitial) {
		super(grid, xInitial, yInitial, DEFAULT_HEALTH_START);
	}
}
