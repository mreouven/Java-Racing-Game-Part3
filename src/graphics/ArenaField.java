package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.racers.air.Airplane;
import game.racers.air.IAerialRacer;
import utilities.EnumContainer;
import utilities.EnumContainer.Arena;
import utilities.EnumContainer.Color;

public class ArenaField extends JPanel implements ActionListener {
	private Airplane test;
	private Airplane test3;
	private Airplane test2;
	/**
	 * Create the panel.
	 */
	public ArenaField(){
		setPreferredSize(new Dimension(5050, 500));
		test =new Airplane("reou", 2, 3, Color.BLACK, 4, this);
		test2 =new Airplane("reou", 2, 3, Color.YELLOW, 4, this);
		test3 =new Airplane("reou", 2, 3, Color.BLUE, 4, this);
		setBackgr(Arena.LAND);

		
	}

	
	private static final long serialVersionUID = 1L;

	
	
	
	private BufferedImage backroun;
	private boolean bgr;
	IAerialRacer tia;
	
	
	
	

	
	public void paintComponent(Graphics g){
		   	super.paintComponent(g);
		   	if(bgr && (backroun!=null))
	            g.drawImage(backroun, 0, 0, getWidth(), getHeight(), this);
		   		test.drawObject(g,0,100);
		   	repaint();
		   	
	   }
	   
	
	
	public void setBackgr(EnumContainer.Arena type) {
		   switch(type) {
		   case NAVAL:
			   try { backroun = ImageIO.read(new File(IDrawable.PICTURE_PATH+"NavalArena.jpg")); } 
				catch (IOException e) { System.out.println("Cannot load background"); }
			   bgr = true; 
			   break;
		   case AERA:
			   try { backroun = ImageIO.read(new File(IDrawable.PICTURE_PATH+"AerialArena.jpg")); } 
				catch (IOException e) { System.out.println("Cannot load background"); }
			   bgr = true; 
			   break;
		   case LAND:
			   try { backroun = ImageIO.read(new File(IDrawable.PICTURE_PATH+"LandArena.jpg")); } 
				catch (IOException e) { System.out.println("Cannot load background"); }
			   bgr = true; 
			   break;
		   default:
		
			   bgr = false;   
		   }
		   
		   repaint();
	
	}
	
	
	
	
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		//setBackgr(Arena.LAND);
		//repaint();
		
	}
	
	

}
