package L2;

public class InvestCalc {

	static final public int shortTerm = 5;
	static final public int midTerm = 10;
	static final public int longTerm = 20;
	
	static final private String cashFormatString = "";
	static final private String percentFormatString = "";
	
	private double principal;
	private double interestRate;

	public InvestCalc() {
		
	}
	
	public InvestCalc(double interestRate, double principal) {
		
	}
	
	/*  --------------------------------
	 *  |      Accessor Methods        |
	 *  --------------------------------
	 */
	public double getRate() {
		return interestRate;
	}
	public double getPrincipal() {
		return principal;
	}
	/*  --------------------------------
	 *  |       Mutator Methods        |
	 *  --------------------------------
	 */
	
	public void setRate(double r) {
		interestRate = r;
	}
	public void setPrincipal(double p) {
		principal = p;
	}
	
	
	
	public String toString(InvestCalc a) {
		return "";
	}
	
	public double futureValue(int year) {
		return (principal * (Math.pow((1 + interestRate), year)));
	}
	
	public void displayTable() {
		
	}
}
