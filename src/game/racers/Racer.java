package game.racers;


import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.Observable;
import java.util.Observer;

import javax.imageio.ImageIO;
import game.arenas.Arena;
import graphics.ArenaField;
import graphics.ArenaFrame;
import graphics.IDrawable;
import utilities.API;
import utilities.EnumContainer;
import utilities.EnumContainer.Event;
import utilities.Fate;
import utilities.Mishap;
import utilities.Point;

public abstract class Racer extends Observable implements IDrawable,Runnable {
	
	private Observer arena;
	protected static int lastSerialNumber = 1;
	private int serialNumber;
	private String name;
	private Point currentLocation;
	private Point finish;
	private double maxSpeed;
	protected boolean coordChanged;
	protected Thread thread;
	private double acceleration;
	private double currentSpeed;
	protected boolean threadSuspended;
	private double failureProbability=0; 
	private EnumContainer.Color color; 
	protected BufferedImage img1;
	private Mishap mishap;
	private static double counter=0;
	private static void counter() {
		counter+=250;
	}
	
	
	public String getName() {
		return name;
	}

	public Point getCurrentLocation() {
		return currentLocation;
	}

	public double getMaxSpeed() {
		return maxSpeed;
	}

	public double getCurrentSpeed() {
		return currentSpeed;
	}



	/**
	 * @param name
	 * @param maxSpeed
	 * @param acceleration
	 * @param color
	 */
	public Racer(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color) {
		this.serialNumber = Racer.lastSerialNumber++;
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.acceleration = acceleration;
		this.color = color;
	
	}

	public abstract String className();
	
	
	synchronized public void setSuspend() { threadSuspended = true; }
	synchronized public void setResume() { threadSuspended = false; notify(); }
	synchronized public void setChanges(boolean state){ coordChanged = state; }	 
	public void start() { thread.start(); }
	public void interrupt() { thread.interrupt(); }
	
	
	public String describeRacer() {
		String s = "";
		s += "name: " + this.name + ", ";
		s += "SerialNumber: " + this.serialNumber + ", ";
		s += "maxSpeed: " + this.maxSpeed + ", ";
		s += "acceleration: " + this.acceleration + ", ";
		s += "color: " + this.color + ", ";
		s = s.substring(0, s.length() - 2);
		s += this.describeSpecific();
		return s;
	}

	public Point move() {
		//VERIFIER PK PAS DE MISHUP??
		this.setChanged();
		if(mishap!=null && mishap.isFixable() && mishap.getTurnsToFix()==0) {
			mishap=null;
			this.notifyObservers(Event.REPAIRED);
		}
		
		if(mishap==null && Fate.breakDown(this.failureProbability)) {
			mishap=Fate.generateMishap();
			System.out.println(name + " Has a new mishap! " + mishap);
			if(mishap.isFixable()) {
				this.notifyObservers(Event.BROKENDOWN);
				
			}
			else
				{this.notifyObservers(Event.DISABLED);
				Thread.currentThread().interrupt();
				}
			
		}
		
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		if(mishap!=null && mishap.getTurnsToFix()>0) {
			this.setCurrentSpeed(this.currentSpeed + mishap.getReductionFactor() * this.acceleration);
			if(this.mishap.isFixable())
				mishap.nextTurn();			
		}
		else if (this.currentSpeed < this.maxSpeed) 
			this.setCurrentSpeed(this.currentSpeed + this.acceleration );

			
		
		if (this.currentSpeed > this.maxSpeed) 
			this.setCurrentSpeed(this.maxSpeed);
		
		Point newLocation = new Point((this.currentLocation.getX() + (1 * this.currentSpeed)),
				this.currentLocation.getY());
		this.setCurrentLocation(newLocation);
		
		if (this.currentLocation.getX() >= this.finish.getX())
			this.notifyObservers(Event.FINISHED);
		return this.currentLocation;
	}

	public abstract String describeSpecific();

	public int getSerialNumber() {
		return serialNumber;
	}

	private boolean hasMishap() {
		if (this.mishap != null && this.mishap.getTurnsToFix() == 0)
			this.mishap = null;
		return this.mishap != null;
	}

	public void initRace(Arena arena, Point start, Point finish) {
		this.arena = arena;
		this.currentLocation = new Point(start.getX(),counter);
		counter();
		this.finish = new Point(finish);
	}

	public void introduce() {
		System.out.println("[" + this.className() + "] " + this.describeRacer());
	}

	@Override
	public void run() {
		System.out.println("runing");
		while(move().getX()<=finish.getX() && !isDisabled() ) {
			
		};
		
	}
	
	private boolean isDisabled() {return (mishap!=null && !mishap.isFixable()); }
	
	
	
	public EnumContainer.Color getColor() {
		return color;
		
	}
	
	
	
	public void loadImages(String nm){
		 switch(getColor()){
			 case BLACK:
				 try { 
					 img1 = ImageIO.read(new File(PICTURE_PATH + nm + "Black.png"));
				 } 
				 catch (IOException e) { 
					 System.out.println("Cannot load picture");
					 }
				 break;
			 case RED:
				 try { 
					 img1 = ImageIO.read(new File(PICTURE_PATH + nm + "Red.png"));
				 } 
				 catch (IOException e) { 
					 System.out.println("Cannot load picture");
					 }
				 break;
			 case GREEN:
				 try { 
					 img1 = ImageIO.read(new File(PICTURE_PATH + nm + "Green.png"));
				 } 
				 catch (IOException e) { 
					 System.out.println("Cannot load picture");
					 }
				 break;
			 case BLUE:
				 try { 
					 img1 = ImageIO.read(new File(PICTURE_PATH + nm + "Blue.png"));
				 } 
				 catch (IOException e) { 
					 System.out.println("Cannot load picture");
					 }
				 break;
			 case YELLOW:
				 try { 
					 img1 = ImageIO.read(new File(PICTURE_PATH + nm + "Yellow.png"));
				 } 
				 catch (IOException e) { 
					 System.out.println("Cannot load picture");
					 }
				 break;
			 default:
				 try { img1 = ImageIO.read(new File(PICTURE_PATH + nm + "_n_1.png"));} 
				 catch (IOException e) { System.out.println("Cannot load picture"); }			 
		 }
	}

	
	public void drawObject(Graphics g,ArenaField panel)
	    {	//TODO PAS ENLEVER 150 MAIS POURCENTAGE
			if(currentLocation!=null) {
				if(((int)currentLocation.getX()*(int)API.getInstance().arenaFrame.panel.field.getWidth())/(int)API.getInstance().getArena().getLength()<(int)API.getInstance().arenaFrame.panel.field.getWidth()-150)
		 			g.drawImage(img1,(((int)currentLocation.getX()*(int)API.getInstance().arenaFrame.panel.field.getWidth())/(int)API.getInstance().getArena().getLength()),(int)currentLocation.getY(),150,150, panel);
				else
					g.drawImage(img1,(int)API.getInstance().arenaFrame.panel.field.getWidth()-150,(int)currentLocation.getY(),150,150, panel);
		 		panel.repaint();
			}
	 		
	    }
	

	
	
	@Override
	public void drawObject(Graphics g)
    {		
		
    }
	
	private void setCurrentLocation(Point newLocation) {
		this.currentLocation=newLocation;
		
	}

	private void setCurrentSpeed(double currectspeed) {
		this.currentSpeed=currectspeed;
		
	}
	
}
