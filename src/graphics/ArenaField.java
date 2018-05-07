package graphics;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.JPanel;

import game.racers.Racer;
import game.racers.air.Airplane;
import game.racers.air.IAerialRacer;
import utilities.EnumContainer;
import utilities.EnumContainer.Arena;

public class ArenaField extends JPanel implements ActionListener {

	/**
	 * Create the panel.
	 */
	public ArenaField(){
		setPreferredSize(new Dimension(5050, 500));
		racers = new ArrayList<Racer>();
		setBackgr(Arena.NAVAL);

		
	}

	
	private static final long serialVersionUID = 1L;

	private ArrayList<Racer> racers;
	
	
	private BufferedImage backroun;
	private boolean bgr;
	private Thread controller;
	IAerialRacer tia;
	
	
	
	

	
	public void paintComponent(Graphics g){
		   	super.paintComponent(g);
		   	if(bgr && (backroun!=null))
	            g.drawImage(backroun, 0, 0, getWidth(), getHeight(), this);
		   	
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
		  
	
	}
	
	
	
	
	
	
	


	@Override
	public void actionPerformed(ActionEvent e) {
		//setBackgr(Arena.LAND);
		//repaint();
		
	}
	
	

}
