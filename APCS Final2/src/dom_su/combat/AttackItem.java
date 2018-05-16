package dom_su.combat;

import dom_su.actor.Actor;
import processing.core.PImage;

public class AttackItem implements Item {

	private PImage attackSymbol;
	private int fixedDam;
	private double ratioDam;
	private int maxRanDam;
	
	public AttackItem(int maxRandomDamage, int fixedDamage, double ratioDamage) {
		maxRanDam = maxRandomDamage;
		fixedDam = fixedDamage;
		ratioDam = ratioDamage;
		attackSymbol = new PImage();
	}
	
	public int getStrikeDamage(Actor defender) {
		int damage = (int) (fixedDam + defender.getHealth()*ratioDam + Math.random()*maxRanDam);
		return damage;
	}
	
	public void setFixedDamage(int attackDamage) {
		fixedDam = attackDamage;
	}
	
	public void setRatioDamage(double ratioDamage) {
		ratioDam = ratioDamage;
	}
	
	public void setMaxRandomDamage(int damage) {
		maxRanDam = damage;
	}
	
	public int getFixedDamage() {
		return fixedDam;
	}
	
	public double getRatioDamage() {
		return ratioDam;
	}
	
	public int getMaxRandomDamage() {
		return maxRanDam;
	}

	@Override
	public void setSymbol(PImage itemSymbol) {
		attackSymbol = itemSymbol;
	}

	@Override
	public PImage getSymbol() {
		return attackSymbol;
	}
}
