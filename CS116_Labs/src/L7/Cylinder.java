package L7;

public class Cylinder extends CircleSolid {
	//Class variables
	protected static final double DEFAULT_HEIGHT = 0.0f;
	
	//New Class variables
	protected double height;
	
	//Constructors
	public Cylinder() {
		super();
		this.height = Cylinder.DEFAULT_HEIGHT;
	}
	
	public Cylinder(double nRadius, double nHeight) {
		super(nRadius);
		
		if (nHeight < 0.0f) {
			this.height = Cylinder.DEFAULT_HEIGHT;
		} else {
			this.height = nHeight;
		}
	}
	
	//Accessors
	public double getHeight() { return this.height; }
	
	//Mutators
	public boolean setHeight(double nHeight) {
		if (nHeight < 0.0f) {
			this.height = Cylinder.DEFAULT_HEIGHT;
			return false;
		} else {
			this.height = nHeight;
			return true;
		}
	}
	
	public double getArea() {
		return (this.getCircumference() * this.getHeight()) + (Math.PI * Math.pow(this.getRadius(), 2));
	}
	
	public double getVolume() {
		return (Math.PI * Math.pow(this.getRadius(), 2)) * this.getHeight();
	}
	
	public String toString() {		
		return String.format("%s\nCylinder: Height = %.3f, Volume = %.3f", super.toString(), this.getHeight(), this.getVolume());
	}
}
