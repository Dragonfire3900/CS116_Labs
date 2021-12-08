package L10;

public class SquareRoot {

	public static void main(String[] args) {
		System.out.println(SR(9,0.15));
		System.out.println(SR(345,1));
	}
	
	public static double SR(double tar, double tol) {
		return SR(tar, tol, tar / 2);
	}

	public static double SR(double tar, double tol, double approx) {
		if (Math.abs(tar - Math.pow(approx, 2)) <= tol) {
			return approx;
		} else {
			approx = (0.5) * (approx + tar / approx);
			System.out.println(approx);
			return SR(tar, tol, approx);
		}
	}
}
