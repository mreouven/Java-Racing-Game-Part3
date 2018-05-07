package game.racers.air;

import game.racers.Racer;
import graphics.ArenaPanel;
import utilities.EnumContainer.Color;


public class Helicopter extends Racer implements IAerialRacer {

	private static final String CLASS_NAME = "Helicopter";
	private static final int DEFAULT_WHEELS = 3;
	private static final double DEFAULT_MAX_SPEED = 400;
	private static final double DEFAULT_ACCELERATION = 50;
	private static final Color DEFAULT_color = Color.BLUE;

	public Helicopter(ArenaPanel panel) {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color,
				DEFAULT_WHEELS,panel);
	}

	/**
	 * @param name
	 * @param maxSpeed
	 * @param acceleration
	 * @param color
	 */
	public Helicopter(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color,
			int numOfWheels,ArenaPanel _pan) {
		super(name, maxSpeed, acceleration, color,_pan);
	}

	@Override
	public String className() {
		return CLASS_NAME;
	}

	@Override
	public String describeSpecific() {
		return "";
	}
}
