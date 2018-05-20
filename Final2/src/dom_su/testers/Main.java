package dom_su.testers;

import java.awt.Dimension;
import java.awt.Toolkit;

import javax.swing.JFrame;

import dom_su.gui.DrawingSurface;
import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
/**
 * 
 * This class is the Main class from which the program is launched
 * 
 * @author David Dominique,Evan Su
 * @version 5/9/18
 */
public class Main extends JFrame {
	
	public static final Dimension DEFAULT_DIMENSIONS = Toolkit.getDefaultToolkit().getScreenSize();


	private static final long serialVersionUID = 1L;
	
	public static final String FILE_SEPARATOR = System.getProperty("file.separator");

	public static void main(String args[]) {

		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		// Centers window on screen.
		window.setBounds((int) (Main.DEFAULT_DIMENSIONS.getWidth()/4),
				(int) (Main.DEFAULT_DIMENSIONS.getHeight()/4),
				(int) (Main.DEFAULT_DIMENSIONS.getWidth()/2),
				(int) (Main.DEFAULT_DIMENSIONS.getHeight()/2));
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		canvas.requestFocus();
		
	}
}
