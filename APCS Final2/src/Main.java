
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;

import processing.awt.PSurfaceAWT;
import processing.core.PApplet;
/**
 * 
 * This class is the Main class from which the program is launched
 * 
 * @author David Dominique,Evan Su
 *@version 5/9/18
 */
public class Main extends JFrame {
	
	private JPanel cardPanel;
	
	public Main (String title) {
		super(title);
		setBounds(100, 100, 800, 600);
	    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	    
	    cardPanel = new JPanel();
	    CardLayout cl = new CardLayout();
	    cardPanel.setLayout(cl);
	    
		//OptionPanel panel1 = new OptionPanel(this);    
	    //GamePanel panel2 = new GamePanel(this);
	
	   // cardPanel.add(panel1,"1"); // Card is named "1"
	   // cardPanel.add(panel2,"2"); // Card is named "2"
	    
	   // add(cardPanel);
	   // addKeyListener(panel2);
	
	    setVisible(true);
	}

	public static void main(String args[]) {

		DrawingSurface drawing = new DrawingSurface();
		PApplet.runSketch(new String[]{""}, drawing);
		PSurfaceAWT surf = (PSurfaceAWT) drawing.getSurface();
		PSurfaceAWT.SmoothCanvas canvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		JFrame window = (JFrame)canvas.getFrame();

		window.setSize(1000, 800);
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);

		window.setVisible(true);
		window.setTitle("New GridWorld");
		canvas.requestFocus();
		
	}

	
	/*
	 public class Main {

	private JFrame window;
	
	private ControlPanel panel1;
	
	private DrawingSurface panel2;  // These are PApplets - you use these to do regular processing stuff

	
	private PSurfaceAWT surf;  // These are the "portals" through which the PApplets draw on the canvas

	
	private PSurfaceAWT.SmoothCanvas processingCanvas;  // These are swing components (think of it as the canvas that the PApplet draws on to)

	
	public Main() {
		window = new JFrame();
		
		panel2 = new DrawingSurface();
		panel2.runMe();
		
		surf = (PSurfaceAWT) panel2.getSurface();
		processingCanvas = (PSurfaceAWT.SmoothCanvas) surf.getNative();
		
		window.setMinimumSize(new Dimension(100,100));
		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		window.setResizable(true);
		
		JPanel mainPanel = new JPanel();
	    
		mainPanel.addComponentListener(new ComponentAdapter() {

			@Override
			public void componentResized(ComponentEvent arg0) {
				Component x = (Component)arg0.getSource();
				fixProcessingPanelSizes(x);
			}

	    });

		panel1 = new ControlPanel(panel2);    
	    
		mainPanel.add(processingCanvas);
		
		window.setLayout(new BorderLayout());
		
	    window.add(mainPanel,BorderLayout.CENTER);
	    window.add(panel1,BorderLayout.EAST);
	    
	    
	    window.setVisible(true);
	    
	    window.setBounds(0, 0, 800, 600);
	    
	    processingCanvas.requestFocus();
	}
	
	public void fixProcessingPanelSizes(Component match) {
		surf.setSize(match.getWidth(),match.getHeight());
	}
	

	public static void main(String[] args)
	{
		Main m = new Main();
	}
	 */
}
