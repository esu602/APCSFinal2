package dom_su.combat;

import processing.core.PImage;

public class SpecialAttack extends AttackItem {

	public static final PImage SYMBOL = new PImage();	// TODO Set Symbol
	public static final int FIXED_DAMAGE = 20;
	public static final int MAX_RANDOM_DAMAGE = 75;
	public static final int COST = 3;
	
	public SpecialAttack() {
		super(MAX_RANDOM_DAMAGE, FIXED_DAMAGE, 0);
		setSymbol(SYMBOL);
	}

}
