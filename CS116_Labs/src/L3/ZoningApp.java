package L3;

import java.util.*;

public class ZoningApp {
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("This is a small program to test the Zoning program for Lab #3. All units are in ft\n\n");
		
		Zoning t1 = new Zoning();
		System.out.print("The default case: ");
		System.out.print(t1.toString() + "\n\n");
		
		System.out.print("Please enter an integer width: ");
		int testWidth = input.nextInt();
		
		System.out.print("\nPlease enter an integer length: ");
		int testLength = input.nextInt();
		
		System.out.print("\nResulting zoning object: \n");
		Zoning t2 = new Zoning(testWidth, testLength);
		
		System.out.print(t2.toString());
		input.close();
	}
}
