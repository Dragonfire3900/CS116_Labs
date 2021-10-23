package L7;

public class Sphere extends CircleSolid {
	
	public Sphere() {
		super();
	}
	
	public Sphere(double r) {
		super(r);
	}
	
	public double getVolume() {
		return (4.0/3.0) * Math.PI * Math.pow(radius, 3);
	}

	@Override
	public double getArea() {
		// TODO Auto-generated method stub
		return (4.0) * Math.PI * Math.pow(radius, 2);
	}
	
	@Override
	public String toString() {
		return String.format("Sphere of radius %.3f", this.getRadius());
	}

}
