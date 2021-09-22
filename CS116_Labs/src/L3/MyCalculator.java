package L3;

import java.util.*;

public class MyCalculator {
	private double a;
	private double b;
	private char opr;
	private boolean validV = true;
	private boolean validO = true;
	private boolean validL = true;
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter an evaulation string: ");
		String stringInput = input.next();
		
		MyCalculator test = new MyCalculator(stringInput);
		
		System.out.print(String.format("Evaluated: %s, to be %f", stringInput, MyCalculator.evaluateExpression(test)));
		input.close();
	}
	
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
	
	public static Double evaluateExpression(MyCalculator c) {
		if (!c.validV) {
			System.out.println( "ERROR: Impossible to evaluate this expression." );
			return Double.NaN;
		};
		
		if (!c.validO) {
			System.out.println( "ERROR: Unknown operator." );
			return Double.NaN;
		}
		
		if (!c.validL) {
			System.out.println( "ERROR: This expression is either too long or too short.");
			return Double.NaN;
		}
		
		else if (c.validO && c.validV && c.validL) {
			
			switch (c.opr) {
				case '+': 	System.out.println("" + c.a + c.opr + c.b + "=" + (c.a + c.b));
							return c.a + c.b;
				case '-': 	System.out.println("" + c.a + c.opr + c.b + "=" + (c.a - c.b));
							return c.a - c.b; 	
				case '*': 	System.out.println("" + c.a + c.opr + c.b + "=" + (c.a * c.b));
							return c.a * c.b;  
				case '/': 	if(c.b != 0) { 
								System.out.println("" + c.a + c.opr + c.b + "=" + (c.a / c.b)); 
								return c.a / c.b;
							} else { return Double.NaN; }
				case '^': 	System.out.println("" + c.a + c.opr + c.b + "=" + (Math.pow(c.a , c.b)));
							return Math.pow(c.a, c.b); 
				default: System.out.print("ERROR: Unknown operator");
						 return Double.NaN;
		}
		}
		return Double.NaN;
	}
	
	public static Double evaluateExpression(String c) {
		MyCalculator test = new MyCalculator(c);
		
		return MyCalculator.evaluateExpression(test);
	}

}
