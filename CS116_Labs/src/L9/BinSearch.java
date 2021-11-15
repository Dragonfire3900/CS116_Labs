package L9;

import java.util.*;

public class BinSearch implements SearchInterface {
	public int findIndex(ArrayList<Integer> data, double target, int lowBound, int upperBound) {
		int midbound;
		
		while (lowBound != upperBound) {
			
			if (upperBound - lowBound <= 1) {
//				System.out.println("Started a binary comparison");
				if (data.get(lowBound) < target && data.get(upperBound) >= target) {
					return upperBound;
				}
				
				if (data.get(lowBound) >= target) { return lowBound; }
				
				if (data.get(upperBound) <= target) { return upperBound; }
			}
			
//			System.out.println("Started a new comparison");
			midbound = (lowBound + upperBound) / 2;
			if (data.get(midbound) <= target && data.get(midbound + 1) >= target) {
				return midbound;
			}
			
			if (data.get(midbound) > target) {
//				System.out.println("Moving lower bound");
//				System.out.println(String.format("low bound: %d, Upper bound: %d", lowBound, upperBound));
				lowBound = midbound;
			} else {
//				System.out.println("Moving the upper bound");
				upperBound = midbound;
			}
		}
		
//		System.out.println("Bin search broke");
		return -1;
	}
	
	public String toString() { return "BinSearch"; }
}
