package game.arenas;

import java.util.ArrayList;
import java.util.Observer;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import game.arenas.exceptions.RacerLimitException;
import game.arenas.exceptions.RacerTypeException;
import game.racers.Racer;
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
	public void startRace() {
		ExecutorService pool=Executors.newFixedThreadPool(MAX_RACERS);
		this.initRace();
		for (Racer racer : activeRacers)
			pool.execute(racer);
		
		pool.shutdown();
	}
	public void addRacer(Racer newRacer) throws RacerLimitException, RacerTypeException {
		if (this.activeRacers.size() == this.MAX_RACERS) {
			throw new RacerLimitException(this.MAX_RACERS, newRacer.getSerialNumber());
		}
		this.activeRacers.add(newRacer);
	}

	public void crossFinishLine(Racer racer) {
		this.compleatedRacers.add(racer);
	}

	public ArrayList<Racer> getActiveRacers() {
		return activeRacers;
	}

	public ArrayList<Racer> getCompleatedRacers() {
		return compleatedRacers;
	}

	public boolean hasActiveRacers() {
		return this.activeRacers.size() > 0;
	}

	public void initRace() {
		int y = 0;
		for (Racer racer : this.activeRacers) {
			Point s = new Point(0, y);
			Point f = new Point(this.length, y);
			racer.initRace(this, s, f);
			y += Arena.MIN_Y_GAP;
		}
	}

	public void playTurn() {
		for (Racer racer : this.activeRacers) {
			racer.move(this.FRICTION);
		}

		for (Racer r : this.compleatedRacers)
			this.activeRacers.remove(r);
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
	} 	
	
}
