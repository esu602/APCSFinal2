package dom_su.combat;

import processing.core.PImage;

public class Knife extends AttackItem {

	public static final PImage SYMBOL = new PImage();	// TODO Set Symbol
	public static final int FIXED_DAMAGE = 10;
	public static final int COST = 1;
	
	public Knife() {
		super(0, FIXED_DAMAGE, 0);
		
		setSymbol(SYMBOL);
	}

}
