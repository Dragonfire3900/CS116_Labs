package L4;

public class Square {
	//Static defaults
	private final static double DEFAULT_SIDE = 0.0f;
	private final static Point2D DEFAULT_LOWERLEFT = new Point2D(0.0f, 0.0f);
	
	/**
	 * The length of the side of the square
	 */
	private double side;
	
	/**
	 * The coordinates of the lower left side of the square
	 */
	private Point2D lowerleft;
	
	
	
	Square () {
		this.side = Square.DEFAULT_SIDE;
		this.lowerleft = Square.DEFAULT_LOWERLEFT;
	}
	
	Square(double initialSide, Point2D initialLowerLeft) {
		this.side = Square.DEFAULT_SIDE;
		this.lowerleft = Square.DEFAULT_LOWERLEFT;
		
		this.setSide(initialSide);
		
		if (initialLowerLeft != null) {
			this.lowerleft = initialLowerLeft;
		}
	}
	
	Square(Square otherSquare) {
		if (otherSquare != null) {
			this.side = otherSquare.getSide();
			this.lowerleft = new Point2D(otherSquare.getLowerLeft());
		} else {
			this.side = Square.DEFAULT_SIDE;
			this.lowerleft = Square.DEFAULT_LOWERLEFT; 
		}
	}
	
	double getSide() { return this.side; }
	
	boolean setSide(double newSide) {
		if (newSide < 0.0f) { return false; }
		
		this.side = newSide;
		return true;
	}
	
	Point2D getLowerLeft() { return this.lowerleft; }
	
	double getArea() { return Math.pow(this.side, 2); }
	
	double getCircumference() {return 4 * this.side; }
	
	boolean equals(Square otherSquare) {
		if (otherSquare == null) { return false; }
		
		if (this.side != otherSquare.getSide()) { return false; }
		
		if (!this.getLowerLeft().equals(otherSquare.getLowerLeft())) { return false; }
		
		return true;
	}
	
	public String toString() {
		return String.format("Square: lower left corner: %s | side: %f, area: %f, circumference %fs", this.getLowerLeft(), this.getSide(), this.getArea(), this.getCircumference());
	}
}
