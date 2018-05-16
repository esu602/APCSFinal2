package dom_su.gui;

import java.awt.Color;

import processing.core.PApplet;

public class Button {

	/**
	 * The x-coordinate that places the <code>Button</code> at the center of the
	 * window.
	 */
	public static final int DEFAULT_X = -1;

	/**
	 * The y-coordinate that places the <code>Button</code> at the center of the
	 * window.
	 */
	public static final int DEFAULT_Y = -1;

	public static final int ALIGN_X_LEFT = 0;
	public static final int ALIGN_X_CENTER = 1;
	public static final int ALIGN_X_RIGHT = 2;
	public static final int ALIGN_Y_TOP = 0;
	public static final int ALIGN_Y_CENTER = 1;
	public static final int ALIGN_Y_BOTTOM = 2;

	public static final Color COLOR_TEXT = Color.BLACK;
	public static final Color COLOR_FILL = Color.LIGHT_GRAY;
	public static final Color Color_BORDER = Color.BLACK;

	private boolean clicked;

	private String text;
	private Color textColor;
	private String textFont;

	private int alignX, alignY;
	private int x, y;
	private int w, h;
	private int rectRad;

	private Color fill, border;

	public Button(String buttonText, int x, int y, int width, int height) {
		text = buttonText;
		textColor = Color.BLACK;
		textFont = "Georgia";

		alignX = ALIGN_X_LEFT;
		alignY = ALIGN_Y_TOP;
		this.x = x;
		this.y = y;
		this.w = width;
		this.h = height;
		rectRad = 0;

		fill = Color.LIGHT_GRAY;
		border = Color.BLACK;
	}

	private boolean pointInside(int pointX, int pointY, int xCoord, int yCoord) {
		int absoluteX = xCoord - (w / 2) * alignX;
		int absoluteY = yCoord - (h / 2) * alignY;

		return pointX >= absoluteX && pointY >= absoluteY && pointX <= (absoluteX + w) && pointY <= (absoluteY + h);
	}

	/**
	 * 
	 * @return Whether the <code>Button</code> has been pressed.
	 */
	public boolean buttonPressed() {
		return clicked;
	}

	// SETTERS

	/**
	 * Sets the alignment for the position of the <code>Button</code>.
	 * 
	 * @param alignmentX
	 *            The x-alignment of the positioning of the <code>Button</code>.
	 * @param alignmentY
	 *            The y-alignment of the positioning of the <code>Button</code>.
	 */
	public void setAlignment(int alignmentX, int alignmentY) {
		alignX = alignmentX;
		alignY = alignmentY;
	}

	/**
	 * Sets the text that is displayed on the <code>Button</code>.
	 * 
	 * @param buttonText
	 *            The text that is displayed on the <code>Button</code>.
	 */
	public void setText(String buttonText) {
		text = buttonText;
	}

	/**
	 * Sets the {@link java.awt.Color Color} in which the text is displayed.
	 * 
	 * @param color
	 *            The {@link java.awt.Color Color} in which the text is displayed.
	 */
	public void setTextColor(Color color) {
		textColor = color;
	}

	/**
	 * Sets the type of font in which the text is displayed.
	 * 
	 * @param font
	 *            The <code>PFont</code> in which the text is displayed.
	 */
	public void setTextFont(String font) {
		textFont = font;
	}

	/**
	 * Sets the x-coordinate in respect to the set alignment of the
	 * <code>Button</code>.
	 * 
	 * @param x
	 *            The x-coordinate of the <code>Button</code> in respect to the
	 *            alignment.
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Sets the y-coordinate in respect to the set alignment of the
	 * <code>Button</code>.
	 * 
	 * @param y
	 *            The y-coordinate of the <code>Button</code> in respect to the
	 *            alignment.
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Sets the width of the <code>Button</code>.
	 * 
	 * @param width
	 *            The width of the <code>Button</code>.
	 */
	public void setWidth(int width) {
		w = width;
	}

	/**
	 * Sets the height of the <code>Button</code>.
	 * 
	 * @param height
	 *            The height of the <code>Button</code>.
	 */
	public void setHeight(int height) {
		h = height;
	}

	/**
	 * Sets the radius of the corners of the <code>Button</code>.
	 * 
	 * @param radius
	 *            The radius of the corners of the <code>Button</code>.
	 */
	public void setBorderRadius(int radius) {
		rectRad = radius;
	}

	/**
	 * Sets the {@link java.awt.Color Color} that fills the <code>Button</code>.
	 * 
	 * @param color
	 *            The {@link java.awt.Color Color} that fills the
	 *            <code>Button</code>.
	 */
	public void setFillColor(Color color) {
		fill = color;
	}

	/**
	 * Sets the {@link java.awt.Color Color} of the Button's borders.
	 * 
	 * @param color
	 *            The {@link java.awt.Color Color} of the Button's borders.
	 */
	public void setBorderColor(Color color) {
		border = color;
	}

	// GETTERS

	/**
	 * Gets the x-alignment for the position of the <code>Button</code>.
	 * 
	 * @return The x-alignment of the positioning of the <code>Button</code>.
	 */
	public int getAlignmentX() {
		return alignX;
	}

	/**
	 * Gets the y-alignment for the position of the <code>Button</code>.
	 * 
	 * @return The y-alignment of the positioning of the <code>Button</code>.
	 */
	public int getAlignmentY() {
		return alignY;
	}

	/**
	 * Gets the text displayed on the <code>Button</code>.
	 * 
	 * @return The text displayed on the <code>Button</code>.
	 */
	public String getText() {
		return text;
	}

	/**
	 * Gets the {@link java.awt.Color Color} in which the text of the
	 * <code>Button</code> is displayed in.
	 * 
	 * @return The {@link java.awt.Color Color} in which the text of the
	 *         <code>Button</code> is displayed in.
	 */
	public Color getTextColor() {
		return textColor;
	}

	/**
	 * Gets the type of font in which the text of the button is displayed in.
	 * 
	 * @return The <code>PFont</code> in which the text of the button is displayed
	 *         in.
	 */
	public String getTextFont() {
		return textFont;
	}

	/**
	 * Gets the x-coordinate of the <code>Button</code> which is in respect to the
	 * x-alignment.
	 * 
	 * @return The x-coordinate of the <code>Button</code> which is in respect to
	 *         the x-alignment.
	 */
	public int getX() {
		return x;
	}

	/**
	 * Gets the y-coordinate of the <code>Button</code> which is in respect to the
	 * y-alignment.
	 * 
	 * @return The y-coordinate of the <code>Button</code> which is in respect to
	 *         the y-alignment.
	 */
	public int getY() {
		return y;
	}

	/**
	 * Gets the width of the <code>Button</code>.
	 * 
	 * @return The width of the <code>Button</code>.
	 */
	public int getWidth() {
		return w;
	}

	/**
	 * Gets the height of the <code>Button</code>.
	 * 
	 * @return The height of the <code>Button</code>.
	 */
	public int getHeight() {
		return h;
	}

	/**
	 * Gets the radius of the corner of the <code>Button</code>.
	 * 
	 * @return The radius of the corner of the <code>Button</code>.
	 */
	public int getBorderRadius() {
		return rectRad;
	}

	/**
	 * Gets the {@link java.awt.Color Color} that fills the <code>Button</code>.
	 * 
	 * @return The {@link java.awt.Color Color} that fills the <code>Button</code>.
	 */
	public Color getFillColor() {
		return fill;
	}

	/**
	 * Gets the {@link java.awt.Color Color} of the Button's border.
	 * 
	 * @return The {@link java.awt.Color Color} of the Button's border.
	 */
	public Color getBorderColor() {
		return border;
	}

	/**
	 * Draws the <code>Button</code> on the specified <code>PAppplet</code>.
	 * 
	 * @param marker
	 *            The <code>PApplet</code> that the <code>Button</code> is drawn on.
	 */
	public void draw(PApplet marker) {

		int screenW = marker.width;
		int screenH = marker.height;
		int xCoord = (x == DEFAULT_X) ? (screenW / 2) - (w / 2) : x; // xCoord is half window width if x=DEFAULT_X
		int yCoord = (y == DEFAULT_Y) ? (screenH / 2) - (h / 2) : y; // yCoord is half window width if x=DEFAULT_Y
		if (pointInside(marker.mouseX, marker.mouseY, xCoord, yCoord)) { // DRAW HOVER
			// DRAW RECT
			marker.stroke(0, 0, 255);
			marker.strokeWeight(2);
			marker.color(fill.getRed(), fill.getGreen(), fill.getBlue(), fill.getAlpha());
			marker.rect(xCoord - (w / 2) * alignX, yCoord - (h / 2) * alignY, w, h, rectRad);

			// DRAW TEXT
			marker.fill(0, 0, 255);
			marker.textFont(marker.createFont(textFont, 25));
			marker.textAlign(PApplet.CENTER);
			marker.text(text, xCoord - (w / 2) * (alignX - 1), yCoord - (h / 2) * (alignY - 1)); // Centers text on
																									// Button

			clicked = marker.mousePressed;
		} else { // DRAW NORMAL
			// DRAW RECT
			marker.stroke(border.getRed(), border.getGreen(), border.getBlue(), border.getAlpha());
			marker.strokeWeight(2);
			marker.color(fill.getRed(), fill.getGreen(), fill.getBlue(), fill.getAlpha());
			marker.rect(xCoord - (w / 2) * alignX, yCoord - (h / 2) * alignY, w, h, rectRad);

			// DRAW TEXT
			marker.fill(textColor.getRed(), textColor.getGreen(), textColor.getBlue(), textColor.getAlpha());
			marker.textFont(marker.createFont(textFont, 25));
			marker.textAlign(PApplet.CENTER);
			marker.text(text, xCoord - ((w / 2) * (alignX - 1)), yCoord - ((h / 2) * (alignY - 1))); // Centers text on
																									// Button

			clicked = false;
		}
	}
}
