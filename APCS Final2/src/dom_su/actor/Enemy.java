package dom_su.actor;
import java.util.ArrayList;
import java.util.Collections;

import dom_su.combat.AttackItem;
import dom_su.combat.DefendItem;
import dom_su.combat.Knife;
import dom_su.combat.Parry;
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
	
	
	private int timer;
	
	/**
	 * Creates a <code>Enemy</code> on a {@link Grid}.
	 * 
	 * @param grid
	 *            The {@link Grid} which the <code>Enemy</code> is on.
	 */
	public Enemy(Grid grid, int xInitial, int yInitial, int startingHealth) {
		super(grid, xInitial, yInitial, startingHealth, Grid.STATE_ENEMY);
		
		timer = 0;
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
	
	/**
	 * The enemy must be able to afford one of the available defenses.
	 */
	public void setEnemyDefense() {
		int ap = getNumActionPoints();
		int health = getHealth();
		
		DefendItem item = new Shield();
		if (health > 50) {
			item = Math.random() > .5 ? new Shield() : new Parry();
		} else {
			item = Math.random() > .2 ? new Shield() : new Parry();
		}
		
		if(item instanceof Parry) {
			if (ap <  Parry.COST) {
				item = new Shield();
			}
		}
		
		setDefense(item);
	}
	
	public void act(Player p) {
		if (timer >= 1) {
			int pX = p.getX();
			int pY = p.getY();
			
			int eX = getX();
			int eY = getY();
			
			int dY = pY - eY;
			int dX = pX - eX;
			int absDY = Math.abs(dY);
			int absDX = Math.abs(dX);
			
			int moveByY = 0;
			if(absDY != 0) {
				moveByY = dY/absDY;
			}
			int moveToY = eY + moveByY;
			
			int moveByX = 0;
			if(absDX != 0) {
				moveByX = dX/absDX;
			}
			int moveToX = eX + moveByX;
			
			if(absDY > absDX) {
				//Better to move along Y
				if (canMoveTo(eX, moveToY)) {
					moveTo(eX, moveToY);
				} else if (canMoveTo(moveToX, eY)) {
					moveTo(moveToX, eY);
				}	// else DO NOT MOVE
			} else if(absDY < absDX) {
				//Better to move along X
				if (canMoveTo(moveToX, eY)) {
					moveTo(moveToX, eY);
				} else if (canMoveTo(eX, moveToY)) {
					moveTo(eX, moveToY);
				}	// else DO NOT MOVE
			} else {
				// absDY == absDX
				boolean moveAlongX = Math.random() > .5 ? true : false;
				
				if (moveAlongX) {
					if (canMoveTo(moveToX, eY)) {
						moveTo(moveToX, eY);
					} else if (canMoveTo(eX, moveToY)) {
						moveTo(eX, moveToY);
					}	// else DO NOT MOVE
				} else {
					if (canMoveTo(eX, moveToY)) {
						moveTo(eX, moveToY);
					} else if (canMoveTo(moveToX, eY)) {
						moveTo(moveToX, eY);
					}	// else DO NOT MOVE
				}
			}
			
			timer = 0;
		} else {
			timer++;
		}
		
		
	}
}
