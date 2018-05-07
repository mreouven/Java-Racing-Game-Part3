package game.racers;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import game.arenas.Arena;
import graphics.ArenaPanel;
import graphics.IDrawable;
import utilities.EnumContainer;
import utilities.Fate;
import utilities.Mishap;
import utilities.Point;

public abstract class Racer implements IDrawable,Runnable {
	protected static int lastSerialNumber = 1;

	private int serialNumber;
	private String name;
	private Point currentLocation;
	private Point finish;
	private Arena arena;
	private double maxSpeed;
	protected Thread thread;
	private double acceleration;
	private double currentSpeed;
	protected boolean threadSuspended;

	@SuppressWarnings("unused")
	private double failureProbability; 
	private EnumContainer.Color color; 
	
	protected ArenaPanel panel;
	protected BufferedImage img1;

	private Mishap mishap;

	/**
	 * @param name
	 * @param maxSpeed
	 * @param acceleration
	 * @param color
	 */
	public Racer(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color, ArenaPanel _pan) {
		this.serialNumber = Racer.lastSerialNumber++;
		this.name = name;
		this.maxSpeed = maxSpeed;
		this.acceleration = acceleration;
		this.color = color;
		this.panel=_pan;
	}

	public abstract String className();
	synchronized public void setSuspend() { threadSuspended = true; }
	synchronized public void setResume() { threadSuspended = false; notify(); }
	
	
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
		this.currentLocation = new Point(start);
		this.finish = new Point(finish);
	}

	public void introduce() {
		System.out.println("[" + this.className() + "] " + this.describeRacer());
	}

	public Point move(double friction) {
		double reductionFactor = 1;
		if (!(this.hasMishap()) && Fate.breakDown()) {
			this.mishap = Fate.generateMishap();
			System.out.println(this.name + " Has a new mishap! (" + this.mishap + ")");
		}

		if (this.hasMishap()) {
			reductionFactor = mishap.getReductionFactor();
			this.mishap.nextTurn();
		}
		if (this.currentSpeed < this.maxSpeed) {
			this.currentSpeed += this.acceleration * friction * reductionFactor;
		}
		if (this.currentSpeed > this.maxSpeed) {
			this.currentSpeed = this.maxSpeed;
		}
		double newX = (this.currentLocation.getX() + (this.currentSpeed));
		Point newLocation = new Point(newX, this.currentLocation.getY());
		this.currentLocation = newLocation;

		if (this.currentLocation.getX() >= this.finish.getX()) {
			this.arena.crossFinishLine(this);
		}
		return this.currentLocation;
	}
	
	
	
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
					 img1 = ImageIO.read(new File(PICTURE_PATH + nm + "Black.png"));
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

	
	  public void drawObject(Graphics g)
	    {
		  System.out.println("ici");
	 		g.drawImage(img1,(int) currentLocation.getX(),(int) currentLocation.getY(), panel);
	 		panel.repaint();
	 		
	    }
	
		@Override
		public void run() {
			while (true) 
		       {
		           try 
		           {
		               Thread.sleep(50);
		               
		               synchronized(this) {
		                   while (threadSuspended)
		   						wait();
		   				}  
		          }
		           catch (InterruptedException e) 
		           {
		           	System.out.println(this.name+ " dead...");
		           	return;
		           }
		       }
			
		}
	
}