package dom_su.combat;

import processing.core.PImage;

public interface Item {

	public static final AttackItem[] ATTACK_ARSENAL = { new Sword(), new Knife(), new SpecialAttack() };

	public static final DefendItem[] DEFENSE_ARSENAL = { new Shield(), new Parry() };
	
	public void setSymbol(PImage itemSymbol);

	public PImage getSymbol();
}
