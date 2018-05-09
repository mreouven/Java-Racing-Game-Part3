package game.racers.air;

import game.racers.Racer;
import game.racers.Wheeled;
import graphics.ArenaField;
import utilities.EnumContainer.Color;


public class Airplane extends Racer implements IAerialRacer {
	private static final String CLASS_NAME = "Airplane";
	private Wheeled wheeled;
	
	
	private static final int DEFAULT_WHEELS = 3;
	private static final double DEFAULT_MAX_SPEED = 885;
	private static final double DEFAULT_ACCELERATION = 100;
	private static final Color DEFAULT_color = Color.BLACK;
	

	public Airplane(ArenaField panel) {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color,
				DEFAULT_WHEELS,panel);
	}
	 
	/**
	 * @param name
	 * @param maxSpeed
	 * @param acceleration
	 * @param color
	 */
	public Airplane(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color,
			int numOfWheels,ArenaField _pan) {
		super(name, maxSpeed, acceleration, color,_pan);
		this.wheeled = new Wheeled(numOfWheels);
		loadImages("Airplane");
	}

	@Override
	public String className() {
		return CLASS_NAME;
	}

	@Override
	public String describeSpecific() {
		return this.wheeled.describeSpecific();
	}
}
