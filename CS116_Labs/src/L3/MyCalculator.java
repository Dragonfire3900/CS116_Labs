package L3;

import java.util.*;

public class MyCalculator {
	private double a;
	private double b;
	private char opr;
	private boolean validV = true;
	private boolean validO = true;
	private boolean validL = true;
	
	public void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Please enter an evaulation string: ");
		String stringInput = input.next();
		
		MyCalculator test = new MyCalculator(stringInput);
		
		System.out.print(String.format("Evaluated: %s, to be %f", stringInput, test.evaluateExpression()));
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
	
	public Double evaluateExpression() {
		if (!this.validV) {
			System.out.println( "ERROR: Impossible to evaluate this expression." );
			return Double.NaN;
		};
		
		if (!this.validO) {
			System.out.println( "ERROR: Unknown operator." );
			return Double.NaN;
		}
		
		if (!this.validL) {
			System.out.println( "ERROR: This expression is either too long or too short.");
			return Double.NaN;
		}
		
		else if (this.validO && this.validV && this.validL) {
			
			switch (this.opr) {
				case '+': 	System.out.println( this.a + this.opr + this.b + "=" + (this.a + this.b));
							return this.a + this.b;
				case '-': 	System.out.println( this.a + this.opr + this.b + "=" + (this.a - this.b));
							return this.a - this.b; 	
				case '*': 	System.out.println( this.a + this.opr + this.b + "=" + (this.a * this.b));
							return this.a * this.b;  
				case '/': 	if(this.b != 0) { 
								System.out.println( this.a + this.opr + this.b + "=" + (this.a / this.b)); 
								return this.a / this.b;
							} else { return Double.NaN; }
				case '^': 	System.out.println( this.a + this.opr + this.b + "=" + (Math.pow(this.a , this.b)));
							return Math.pow(this.a, this.b); 
				default: System.out.print("ERROR: Unknown operator");
						 return Double.NaN;
		}
		}
		return Double.NaN;
	}

}
