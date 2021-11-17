package L10;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(SR(16,.0000000003));

	}
	
	public static double SR(double a, double t) {
		if(a < t) {
			return 1;
		}
		else {
			return 0.5 * (SR(a/2 , t) + a/SR(a/2 , t));
		}
	}

}
