package dom_su.actor;
import dom_su.gui.Grid;

//represents an enemy
public class Enemy extends Actor {

	/**
	 * How much health the <code>Player</code> starts with.
	 */
	public static final int DEFAULT_HEALTH_START = 200;

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
	
	
	/**
	 * Creates a <code>Enemy</code> on a {@link Grid}.
	 * 
	 * @param grid
	 *            The {@link Grid} which the <code>Enemy</code> is on.
	 */
	public Enemy(Grid grid, int xInitial, int yInitial, int startingHealth) {
		super(grid, xInitial, yInitial, startingHealth);
	}

	
}
