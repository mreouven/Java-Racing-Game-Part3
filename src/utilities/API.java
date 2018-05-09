package utilities;

import java.util.ArrayList;

import factory.RaceBuilder;
import game.arenas.Arena;
import game.racers.Racer;

public class API {
	private static Arena myArena;
	private static ArrayList<Racer> myRacers;
	
	private static API instance;

	public static API getInstance() {
		if (instance == null) {
			instance = new API();
		}
		return instance;
	}
	
	
	private boolean addRacer(Racer to_add) {
		
		if myArena.
		myRacers.add(to_add);
		
		return false;
		
		
		
	}
	
	

}
