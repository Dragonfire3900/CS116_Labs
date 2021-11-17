package L10;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(SR(9,0.15));
		System.out.println(SR(345,1));
	}
	
	public static double SR(double a, double t) {
		if(Math.abs(a) < t) {
			return a/2;
		}
		else {
			return 0.5 * (SR(a/2 , t) + a/SR(a/2 , t));
		}
	}

}
