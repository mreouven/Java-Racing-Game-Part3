package game.racers.land;

import game.racers.Racer;
import game.racers.Wheeled;
import graphics.ArenaPanel;
import utilities.EnumContainer.Color;
import utilities.EnumContainer.Engine;

public class Car extends Racer implements ILandRacer {

	private static final String CLASS_NAME = "Car";

	private static final int DEFAULT_WHEELS = 4;
	private static final double DEFAULT_MAX_SPEED = 400;
	private static final double DEFAULT_ACCELERATION = 20;
	private static final Color DEFAULT_color = Color.RED;

	private Engine engine;
	private Wheeled wheeled;

	public Car(ArenaPanel panel) {
		this(CLASS_NAME + " #" + lastSerialNumber, DEFAULT_MAX_SPEED, DEFAULT_ACCELERATION, DEFAULT_color,
				DEFAULT_WHEELS,panel);
	}

	public Car(String name, double maxSpeed, double acceleration, utilities.EnumContainer.Color color,
			int numOfWheels,ArenaPanel _pan) {
		super(name, maxSpeed, acceleration, color,_pan);
		this.wheeled = new Wheeled(numOfWheels);
		this.engine = Engine.FOURSTROKE;
	}

	@Override
	public String className() {
		return CLASS_NAME;
	}

	@Override
	public String describeSpecific() {
		String s = "";
		s += this.wheeled.describeSpecific();
		s += ", Engine Type: " + this.engine;

		return s;
	}
}
