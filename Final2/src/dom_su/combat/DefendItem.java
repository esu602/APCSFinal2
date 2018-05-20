package dom_su.combat;

import dom_su.actor.Actor;
import processing.core.PImage;

public class DefendItem implements Item {

	private PImage defendSymbol;
	private int fixed, maxRand;
	private double ratio;
	
	public DefendItem(int maxRandomDamage, int fixedDamage, double ratioDamage) {
		maxRand = maxRandomDamage;
		fixed = fixedDamage;
		ratio = ratioDamage;
		defendSymbol = new PImage();
	}
	
	public void defend(int strikeDamage, Actor defender) {
		int damageStopped = (int) (fixed + (strikeDamage - fixed) * ratio + Math.random() * maxRand);
		defender.increaseHealth(damageStopped - strikeDamage);
	}
	
	public void setFixedDefendDamage(int damage) {
		fixed = damage;
	}
	
	public void setRatioDefendDamage(double ratioDamage) {
		ratio = ratioDamage;
	}
	
	public void setMaxRandomDamage(int maxRandomDamage) {
		maxRand = maxRandomDamage;
	}
	
	public int getFixedDamage() {
		return fixed;
	}
	
	public double getRatioDamage() {
		return ratio;
	}
	
	public int getMaxRandomDamage() {
		return maxRand;
	}
	
	@Override
	public void setSymbol(PImage itemSymbol) {
		defendSymbol = itemSymbol;
	}

	@Override
	public PImage getSymbol() {
		return defendSymbol;
	}

}
