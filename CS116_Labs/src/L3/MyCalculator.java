package L3;

public class MyCalculator {
	private double a;
	private double b;
	private char opr;
	private boolean valid = true;
	
	public MyCalculator(String m) {
		String mProblem = m.replaceAll("\\s", "");
		if(Character.isDigit(mProblem.charAt(0)) && Character.isDigit(mProblem.charAt(2))) {
			a = Character.getNumericValue(mProblem.charAt(0));
			b = Character.getNumericValue(mProblem.charAt(2));
		}
		else valid = false;
		
		if(mProblem.charAt(1) == '+' || mProblem.charAt(1) == '-' || mProblem.charAt(1) == '*' || mProblem.charAt(1) == '/' || mProblem.charAt(1) == '^') {
			opr = mProblem.charAt(1);
		}
		else valid = false;
	}
	
	public String evaluateExpression() {
		double r = 0;
		
		if (!valid) return "ERROR: Impossible to evaluate this expression.";
		
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
		
		return String.valueOf(r);
		
	}

}
