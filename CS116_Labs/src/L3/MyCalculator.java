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
		
		evaluateExpression(this);
	}
	
	public static void evaluateExpression(MyCalculator c) {
		if (!c.validV) System.out.println( "ERROR: Impossible to evaluate this expression." );
		
		if (!c.validO) System.out.println( "ERROR: Unknown operator." );
		
		if (!c.validL) System.out.println( "ERROR: This expression is either too long or too short.");
		
		else if (c.validO && c.validV && c.validL) {
			
			switch (c.opr) {
				case '+': 	System.out.println( c.a + c.opr + c.b + "=" + (c.a + c.b));
							break;
				case '-': 	System.out.println( c.a + c.opr + c.b + "=" + (c.a - c.b));
							break; 	
				case '*': 	System.out.println( c.a + c.opr + c.b + "=" + (c.a * c.b));
							break;  
				case '/': 	if(c.b != 0) System.out.println( c.a + c.opr + c.b + "=" + (c.a / c.b));
							else System.out.println("ERROR: Impossible to evaluate this expression.");	
							break; 
				case '^': 	System.out.println( c.a + c.opr + c.b + "=" + (Math.pow(c.a , c.b)));
							break; 
		}
		}
		
	}

}
