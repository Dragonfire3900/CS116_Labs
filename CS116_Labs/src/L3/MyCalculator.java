package L3;

public class MyCalculator {
	private double a;
	private double b;
	private char opr;
	
	public MyCalculator(String m) {
		String mProblem = m.trim();
		a = Character.getNumericValue(mProblem.charAt(0));
		b = Character.getNumericValue(mProblem.charAt(2));
		opr = mProblem.charAt(1);
	}
	
	public String evaluateExpression() {
		double r = 0;
		switch (opr) {
			case '+': 	r = (a + b);
						break;
			case '-': 	r = (a - b);
						break; 	
			case '*': 	r = (a * b);
						break;  
			case '/': 	r = (a / b);
						break; 
			case '^': 	r = (Math.pow(a , b));
						break; 
		}
		if(r != Double.NaN) return String.valueOf(r);
		else return "ERROR: Impossible to evaluate this expression.";
	}

}
