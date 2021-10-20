package L7;

public abstract class CircleSolid {
	//Class Variables
	protected static final double DEFAULT_RADIUS = 0.0f;
	
	//Instance variables
	protected double radius;
	
	//Constructors
	protected CircleSolid() {
		this.radius = CircleSolid.DEFAULT_RADIUS;
	}
	
	protected CircleSolid(double nRadius) {
		if (nRadius < 0.0f) { //A negative radius doesn't make sense
			this.radius = CircleSolid.DEFAULT_RADIUS;
		} else {
			this.radius = nRadius;
		}
	}
	
	//Mutators
	public boolean setRadius(double nRadius) {
		if (nRadius < 0.0f) { //A negative radius doesn't make sense
			this.radius = CircleSolid.DEFAULT_RADIUS;
			return false;
		} else {
			this.radius = nRadius;
			return true;
		}
	}
	
	//Accessors
	public double getRadius() { return this.radius; }
	
	public double getCircumference() { return 2 * Math.PI * this.radius; }
	
	abstract public double getArea();
	abstract public double getVolume();
	
	public String toString() {
		return String.format("CircleSolid: Radius = %.3f", this.getRadius());
	}
}
