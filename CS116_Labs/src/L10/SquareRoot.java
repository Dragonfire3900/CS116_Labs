package L10;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(SR(9,2));

	}
	
	public static double SR(double a, double t) {
		if(Math.abs(a) < t) {
			return a;
		}
		else {
			return SR((0.5 * (a + a/9)),t);
		}
	}

}
