package L5;

import java.util.*;

public class ScoreCalc {

	public static void main(String[] args) {
		//Variables used for this program
		int numScore; //The number of scores for this calculation
		double scores[]; //The actual score values
		double totalScore = 0.0f; //The total of scores jut to make sure repeated calculation doesn't occur
		double avg = 0.0f; //The average score
		int aboveCount = 0; //The number of scores above the average
		
		Scanner input = new Scanner(System.in);
		
		numScore = getInt(input, "Please enter the number of scores: ", "Please enter a valid score on []", 1, Integer.MAX_VALUE);
		
		scores = new double[numScore];
		
		for (int i = 0; i < numScore; i++) {
			scores[i] = getDouble(input, String.format("Please enter score number %d:", i + 1), "Please enter a valid score", 0.0f, Double.MAX_VALUE);
			totalScore += scores[i];
		}
		
		avg = totalScore / numScore;
		
		for (int i = 0; i < numScore; i++) {
			if (scores[i] > avg) { aboveCount += 1; }
		}
		
		System.out.println(String.format("The average score is %f\n", avg));
		System.out.println(String.format("There are %d scores above the average\n", aboveCount));
		
		input.close();
	}
	
	/**
	 * Gets a double from the user using a given scanner
	 * 
	 * @param input The scanner from which the double will be acquired
	 * @param initPrompt The initial prompt for the user's input
	 * @param repeatPrompt The prompt used when the user provides invalid input
	 * @param lowerBound The lower bound (inclusive) of the double that is valid.
	 * @param upperBound The upper bound (inclusive) of the double that is valid.
	 * @return The double the user gives to the program
	 */
	private static double getDouble(Scanner input, String initPrompt, String repeatPrompt, double lowerBound, double upperBound) {
		if (input == null) { return Double.NaN; } //User provided a null scanner
		
		if (input.hasNext()) { input.nextLine(); }
		
		double output;
		
		System.out.println(initPrompt + "\n");
		while (true) {
			try {
				output = input.nextDouble();
				if (output >= lowerBound && output <= upperBound) { return output; }
				System.out.println(repeatPrompt + "\n");
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
	 * @param lowerBound The lower bound (inclusive) that is valid for the output
	 * @param upperBound The upper bound (inclusive) that is valid for the output
	 * @return The int the user gives to the program
	 */
	private static int getInt(Scanner input, String initPrompt, String repeatPrompt, int lowerBound, int upperBound) {
		if (input == null) { return -1; } //User provided a null scanner
		
		if (input.hasNext()) { input.nextLine(); }
		
		int output;
		
		System.out.println(initPrompt + "\n");
		while (true) {
			try {
				output = input.nextInt();
				if (output >= lowerBound && output <= upperBound) { return output; }
				System.out.println(repeatPrompt + "\n");
			} catch (InputMismatchException ex) {
				System.out.println(repeatPrompt + "\n");
			} finally {
				input.nextLine();
			}
		}
	}
}
