package L4;

import java.util.*;

public class LoanDecisionApp {
	
	private final static double SALARY_LIM = 60000.0f; //The limit on someones salary to be accepted
	private final static int YEAR_LIM = 3; //The number of years someone must work to qualify
	
	private final static String SUCCESS_STR = "Qualifies";
	private final static String FAILURE_STR = "Does not qualify";

	public static void main(String[] args) {
		double wSalary; //The salary of the person being asked
		int yearsWorking; //The number of years the person has been working at the company
		boolean qualify; //If they qualify for a loan
		
		Scanner globalInput = new Scanner(System.in);
		
		wSalary = askForSalary(globalInput);
		yearsWorking = askForYears(globalInput);
		
		qualify = decideLoan(wSalary, yearsWorking);
		
		if (qualify) System.out.println(LoanDecisionApp.SUCCESS_STR);
		else System.out.println(LoanDecisionApp.FAILURE_STR);
	}
	
	private static double askForSalary(Scanner input) {
		double wSalary;
		
		System.out.println("Please enter the salary of the worker (as a double): ");
		
		while(true) {
			try {
				wSalary = input.nextDouble();
				break;
			} catch (InputMismatchException ex) {
				System.out.print("\nPlease enter a double: ");
				input.nextLine();
			}
		}
		
		System.out.println();
		
		return wSalary;
	}
	
	private static int askForYears(Scanner input) {
		int yearsWorking;
		
		System.out.println("Please enter the number of years they've been working (as an int): ");
		
		while(true) {
			try {
				yearsWorking = input.nextInt();
				break;
			} catch (InputMismatchException ex) {
				System.out.print("\nPlease enter an int: ");
				input.nextLine();
			}
		}
		
		System.out.println();
		
		return yearsWorking;
	}

	private static boolean decideLoan(double salary, int yearsWorking) {
		if (salary > LoanDecisionApp.SALARY_LIM) {
			if (yearsWorking > LoanDecisionApp.YEAR_LIM) {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
}
