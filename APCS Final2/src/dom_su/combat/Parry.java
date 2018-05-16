package dom_su.combat;

import processing.core.PImage;

public class Parry extends DefendItem {

	public static final PImage SYMBOL = new PImage();	// TODO Set Symbol
	public static final int MAX_DAMAGE_DEFEND = 50;
	public static final int COST = 3;
	
	public Parry() {
		super(0, 0, MAX_DAMAGE_DEFEND);
		setSymbol(SYMBOL);
	}

}
