package L5;

import java.util.*;

public class ScoreCalc {

	public static void main(String[] args) {
		//Variables used for this program
		int numScore; //The number of scores for this calculation
		double scores[]; //The actual score values
		double totalScore; //The total of scores jut to make sure repeated calculation doesn't occur
		double avg = 0.0f; //The average score
		int aboveCount = 0; //The number of scores above the average
		
		Scanner input = new Scanner(System.in);
		
		
	}
	
	/**
	 * Gets a double from the user using a given scanner
	 * 
	 * @param input The scanner from which the double will be acquired
	 * @param initPrompt The initial prompt for the user's input
	 * @param repeatPrompt The prompt used when the user provides invalid input
	 * @return The double the user gives to the program
	 */
	private static double getDouble(Scanner input, String initPrompt, String repeatPrompt) {
		if (input == null) { return Double.NaN; } //User provided a null scanner
		
		double output;
		
		System.out.println(initPrompt + "\n");
		while (true) {
			try {
				output = input.nextDouble();
				return output;
			} catch (InputMismatchException ex) {
				System.out.println(repeatPrompt + "\n");
			} finally {
				input.nextLine();
			}
		}
	}
	
	/**
	 * Gets an int from the user using a given scanner and prompt
	 * 
	 * @param input The scanner from which the int will be acquired
	 * @param initPrompt The initial prompt for the user's input
	 * @param repeatPrompt The prompt used when the user provides invalid input
	 * @return The int the user gives to the program
	 */
	private static int getInt(Scanner input, String initPrompt, String repeatPrompt) {
		if (input == null) { return -1; } //User provided a null scanner
		
		int output;
		
		System.out.println(initPrompt + "\n");
		while (true) {
			try {
				output = input.nextInt();
				return output;
			} catch (InputMismatchException ex) {
				System.out.println(repeatPrompt + "\n");
			} finally {
				input.nextLine();
			}
		}
	}
}
