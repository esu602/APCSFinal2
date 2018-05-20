package dom_su.combat;

import processing.core.PImage;

public class Sword extends AttackItem {

	public static final PImage SYMBOL = new PImage();	// TODO Set Symbol
	public static final int FIXED_DAMAGE = 25;
	public static final int COST = 2;
	
	public Sword() {
		super(0, FIXED_DAMAGE, 0);
		
		setSymbol(SYMBOL);
	}

}
