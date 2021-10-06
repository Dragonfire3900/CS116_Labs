package L6;

public class Vector {
	protected double startPointX = 0;
	protected double startPointY = 0;
	protected double endPointX;
	protected double endPointY;
	
	Vector() {
		endPointX = 0;
		endPointY = 0;
	}
	Vector(double x2, double y2) {
		endPointX = x2;
		endPointY = y2;
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
