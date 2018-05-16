package dom_su.actor;
import java.util.ArrayList;
import java.util.Collections;

import dom_su.combat.AttackItem;
import dom_su.combat.Knife;
import dom_su.combat.Shield;
import dom_su.combat.SpecialAttack;
import dom_su.combat.Sword;
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
		super(grid, xInitial, yInitial, startingHealth, Grid.STATE_ENEMY);
		
	}

	// Must have enough action points
	public void setEnemyWeapon(Player opponent) {
		int actionPoints = getNumActionPoints();
		int opHealth = opponent.getHealth();
		
		// Influence weapon selection
		// TODO set these values based on max health
		int barSpecial = 70;
		int barSword = 45;
		int barKnife = 20;
		
		double difSpecialSq 	= Math.pow( Math.abs(opHealth - barSpecial)	, 2)*Math.random();
		double difSwordSq 		= Math.pow( Math.abs(opHealth - barSword)	, 2)*Math.random();
		double difKnifeSq 		= Math.pow( Math.abs(opHealth - barKnife)	, 2)*Math.random();
		
		ArrayList<Double> difSqs = new ArrayList<Double>();
		difSqs.add(difSpecialSq);
		difSqs.add(difSwordSq);
		difSqs.add(difKnifeSq);
		Collections.sort(difSqs);
		
		AttackItem item = new Knife();
		for(int i = 0; i < difSqs.size(); i++) {
			double value = difSqs.get(i);
			
			// CHOOSE SPECIAL ATTACK
			if (Math.abs(value - difSpecialSq) < 0.000001) {
				if (actionPoints >= SpecialAttack.COST) {
					item = new SpecialAttack();
					break;
				} else {
					continue;
				}
			}
			
			// CHOOSE SWORD
			if (Math.abs(value - difSwordSq) < 0.000001) {
				if (actionPoints >= Sword.COST) {
					item = new Sword();
					break;
				} else {
					continue;
				}
			}
			
			// CHOOSE KNIFE
			if (Math.abs(value - difKnifeSq) < 0.000001) {
				item = new Knife();
				break;
			}
		}
		
		setWeapon(item);
	}
	
	public void setEnemyDefense() {
		
		// TODO create algorithm
		setDefense(new Shield());
	}
}
