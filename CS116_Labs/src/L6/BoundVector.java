package L6;

public class BoundVector extends Vector{
	BoundVector() {
		super();
	}
	BoundVector(double x2, double y2) {
		super(x2,y2);
	}
	BoundVector(double x1, double y1, double x2, double y2) {
		super(x2,y2);
		startPointX = x1;
		startPointY = y1;
	}
}
