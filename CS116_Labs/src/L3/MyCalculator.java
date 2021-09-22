package L3;

public class MyCalculator {
	private double a;
	private double b;
	private char opr;
	private boolean validV = true;
	private boolean validO = true;
	private boolean validL = true;
	
	public MyCalculator(String m) {
		String mProblem = m.replaceAll("\\s", "");
		if(Character.isDigit(mProblem.charAt(0)) && Character.isDigit(mProblem.charAt(2))) {
			a = Character.getNumericValue(mProblem.charAt(0));
			b = Character.getNumericValue(mProblem.charAt(2));
		}
		else validV = false;
		
		if(mProblem.charAt(1) == '+' || mProblem.charAt(1) == '-' || mProblem.charAt(1) == '*' || mProblem.charAt(1) == '/' || mProblem.charAt(1) == '^') {
			opr = mProblem.charAt(1);
		}
		else validO = false;
		
		if(mProblem.length() > 3) validL = false;
		
	}
	
	public void evaluateExpression() {
		if (!validV) System.out.println( "ERROR: Impossible to evaluate this expression." );
		
		if (!validO) System.out.println( "ERROR: Unknown operator." );
		
		if (!validL) System.out.println( "ERROR: This expression is either too long or too short.");
		
		else if (validO && validV && validL) {
			
			switch (opr) {
				case '+': 	System.out.println( a + opr + b + "=" + (a + b));
							break;
				case '-': 	System.out.println( a + opr + b + "=" + (a - b));
							break; 	
				case '*': 	System.out.println( a + opr + b + "=" + (a * b));
							break;  
				case '/': 	if(b != 0) System.out.println( a + opr + b + "=" + (a / b));
							else System.out.println("ERROR: Impossible to evaluate this expression.");	
							break; 
				case '^': 	System.out.println( a + opr + b + "=" + (Math.pow(a , b)));
							break; 
		}
		}
		
	}

}
