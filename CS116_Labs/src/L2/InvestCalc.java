package L2;

//Imports
import java.text.NumberFormat;
import java.util.Locale;
import java.text.DecimalFormat;

public class InvestCalc {

	/**
	 * The typical years of interest. Short = 5, Medium = 10, Long = 20
	 */
	static final private int[] Lengthterms = {5, 10, 20};
	
	/**
	 * How the class formats percentages
	 */
	static final private String PERCENT_FORMAT_STRING = "##0.00%";
	
	static DecimalFormat PERCENT_FORMATTER = new DecimalFormat(InvestCalc.PERCENT_FORMAT_STRING);
	static NumberFormat CASH_FORMATTER = NumberFormat.getCurrencyInstance();
	
	private double principal;
	private double interestRate;

	public InvestCalc() {
		this.setPrincipal(0);
		this.setInterestRate(0);
	}
	
	public InvestCalc(double interestRate, double principal) {
		this.setInterestRate(interestRate);
		this.setPrincipal(principal);
	}
	
	/*  --------------------------------
	 *  |      Accessor Methods        |
	 *  --------------------------------
	 */
	
	/**
	 * @return The initial investment amount for this calculator object
	 */
	public double getPrincipal() {
		return this.principal;
	}
	
	/**
	 * @return A string formatted version of the principal investment
	 */
	public String getFormattedPrincipal() {
		return InvestCalc.CASH_FORMATTER.format(this.principal);
	}
	
	/**
	 * @return The interest rate for this calculator object
	 */
	public double getInterestRate() {
		return this.interestRate;
	}
	
	/**
	 * @return A string formatted version of the interest rate
	 */
	public String getFormattedInterestRate() {
		return InvestCalc.PERCENT_FORMATTER.format(this.interestRate);
	}
	
	/**
	 * @return The typical years of interest for the calculator
	 */
	public int[] getTerms() {
		return InvestCalc.Lengthterms;
	}
	

	/*  --------------------------------
	 *  |       Mutator Methods        |
	 *  --------------------------------
	 */

	/**
	 * Sets the principal amount for the calculator
	 * @param nP The new principal amount for the investment
	 * @return If setting the principal was successful
	 */
	public boolean setPrincipal(double nP) {
		//Validating
		if (nP < 0) { return false; }
		
		this.principal = nP;
		return true;
}
	
	/**
	 * Sets the interest rate of this calculator
	 * @param nIR The new interest rate
	 * @return If setting the interest rate was successful
	 */
	public boolean setInterestRate(double nIR) {
		//Validating
		if (nIR < 0) { return false; }
		
		this.interestRate = nIR;
		return true;
	}
	
	/**
	 * Added a dummy function to make it easier for the TAs to grade
	 * @param nIR the new interest rate
	 * @return If setting the interest rate was successful
	 */
	public boolean setRate(double nIR) {
		return this.setInterestRate(nIR);
	}
	
	
	@Override
	public String toString() {
		return "InvestCalc [principal= " + this.getFormattedPrincipal() + ", interestRate= " + this.getFormattedInterestRate() + "]";
	}

	/**
	 * Calculates the future value of an investment given the year
	 * @param year How many years the investment has been growing
	 * @return The future value of the investment
	 */
	public double futureValue(int year) {
		return this.principal * Math.pow(1 + this.interestRate, year);
	}
		
	public void displayTable() {
		System.out.print("YEAR\tINTEREST RATE\tPRINCIPAL\tFUTURE VALUE\n");
		
		for (int year : InvestCalc.Lengthterms) {
			System.out.print(year + "\t" + this.getFormattedInterestRate() + "\t" + this.getFormattedPrincipal() + "\t" + InvestCalc.CASH_FORMATTER.format(this.futureValue(year)) + "\n");
		}
	}
}
