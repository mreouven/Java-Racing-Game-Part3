package game.arenas;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Observable;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
import graphics.ArenaField;
import utilities.API;
import utilities.EnumContainer;
import utilities.Point;

public abstract class Arena implements Observer{

	private final static int MIN_Y_GAP = 10;
	private ArrayList<Racer> activeRacers;
	private ArrayList<Racer> compleatedRacers;
	private ArrayList<Racer> brokenRacers;
	private ArrayList<Racer> disabledRacers;
	
	private double length;
	private final int MAX_RACERS;
	private final double FRICTION;

	/**
	 * 
	 * @param length
	 *            the x value for the finish line
	 * @param maxRacers
	 *            Maximum number of racers
	 * @param friction
	 *            Coefficient of friction
	 * 
	 */
	protected Arena(double length, int maxRacers, double friction) {
		this.length = length;
		this.MAX_RACERS = maxRacers;
		this.FRICTION = friction;
		this.activeRacers = new ArrayList<Racer>();
		this.compleatedRacers = new ArrayList<Racer>();
		this.brokenRacers = new ArrayList<Racer>();
		this.disabledRacers = new ArrayList<Racer>();
		
	}
	public synchronized void drawObject(Graphics g,ArenaField panel) {
		for (Racer racer : activeRacers) {
			racer.drawObject(g, panel);
		}
		for (Racer racer : brokenRacers) {
			racer.drawObject(g, panel);
		}
		for (Racer racer : compleatedRacers) {
			racer.drawObject(g, panel);
		}
		
	}
	public void setCompleatedRacers(ArrayList<Racer> compleatedRacers) {
		this.compleatedRacers = compleatedRacers;
	}
	public double getLength() {
		return length;
	}
	public void startRace() {
		ExecutorService pool=Executors.newFixedThreadPool(activeRacers.size());
		
		
		for (Racer racer : activeRacers)
			pool.execute(racer);
		
		pool.shutdown();
	}
	public void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException {
		if (this.activeRacers.size() == this.MAX_RACERS) {
			throw new RacerLimitException(this.MAX_RACERS, newRacer.getSerialNumber());
		}
		newRacer.addObserver(this);
		newRacer.initRace(FRICTION,new Point(0, 0), new Point(this.length, 0));
		this.activeRacers.add(newRacer);
		
	}

	public ArrayList<Racer> getActiveRacers() {
		return activeRacers;
	}

	public ArrayList<Racer> getCompleatedRacers() {
		return compleatedRacers;
	}



	public void initRace() {
		int y = 0;
		for (Racer racer : this.activeRacers) {
			Point s = new Point(0, y);
			Point f = new Point(this.length, y);
			racer.initRace(FRICTION, s, f);
			y += Arena.MIN_Y_GAP;
		}
	}

	

	public void showResults() {
		for (Racer r : this.compleatedRacers) {
			String s = "#" + this.compleatedRacers.indexOf(r) + " -> ";
			s += r.describeRacer();
			System.out.println(s);
		}
	}
	
	
	@Override
	public synchronized void update(Observable o, Object arg) {
		switch((EnumContainer.Event)arg)
		{
		case FINISHED:
			System.out.println("FINISHED ");
			((Racer)o).introduce();
			this.activeRacers.remove((Racer)o);
			this.compleatedRacers.add((Racer)o);
			
			break;
		case BROKENDOWN:
			System.out.println("BROKENDOWN ");
			((Racer)o).introduce();
			this.activeRacers.remove((Racer)o);
			this.brokenRacers.add((Racer)o);	
			
			break;
		case REPAIRED:
			System.out.println("REPAIRED ");
			((Racer)o).introduce();
			this.brokenRacers.remove((Racer)o);	
			this.activeRacers.add((Racer)o);
			
			break;
		case DISABLED:
			System.out.println("DISABLED ");
			((Racer)o).introduce();
			this.activeRacers.remove((Racer)o);
			this.disabledRacers.add((Racer)o);
			break;
		default:			
			break;
		}
		API.getInstance().resetGUI();
	} 	
	
}
