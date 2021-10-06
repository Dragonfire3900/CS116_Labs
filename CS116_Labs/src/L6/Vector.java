package L6;

public class Vector {
	private double startPointX = 0;
	private double startPointY = 0;
	private final double endPointX;
	private final double endPointY;
	
	Vector() {
		endPointX = 0;
		endPointY = 0;
	}
	Vector(double a, double b) {
		endPointX = a;
		endPointY = b;
	}
	
	public double getStartPointX() {
		return startPointX;
	}
	public double getStartPointY() {
		return startPointY;
	}
	public double getEndPointX() {
		return endPointX;
	}
	public double getEndPointY() {
		return endPointY;
	}
	
	public double getLength() {
		return Math.sqrt((Math.pow(endPointX - startPointX, 2) + Math.pow(endPointY - startPointY, 2)));
	}
}
