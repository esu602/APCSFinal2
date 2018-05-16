package dom_su.combat;

import processing.core.PImage;

public class Shield extends DefendItem{

	public static final PImage SYMBOL = new PImage();	// TODO Set Symbol
	public static final double RATIO_SHIELD = 0.8;
	public static final int COST = 2;
	
	public Shield() {
		super(0, 0, RATIO_SHIELD);
		setSymbol(SYMBOL);
	}

}
