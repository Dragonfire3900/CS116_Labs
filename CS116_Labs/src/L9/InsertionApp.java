package L9;

import java.util.ArrayList;
import java.util.Random;

public class InsertionApp {

	public static void main(String[] args) {
		Random rng = new Random();
		
		long initTime;
		
		Insertion insertObject = new Insertion();
		
		SearchInterface[] searchType = {new SequentialSearch(), new BinSearch()};
		int[] sortLengths = {1000, 2000, 4000, 8000, 16000};
		double[][] timings = new double[searchType.length][sortLengths.length];
		
		ArrayList<Integer> builtSortList;
		ArrayList<ArrayList<Integer>> actualSortList = new ArrayList<ArrayList<Integer>>(searchType.length);
		
		System.out.print("Search type | ");
		for( int i = 0; i < searchType.length; i++) {
			System.out.print(String.format("%s | ", searchType[i].toString()));
		}
		
		System.out.println();
		
		for (int lenIndex = 0; lenIndex < sortLengths.length; lenIndex++) {
			builtSortList = new ArrayList<Integer>(sortLengths[lenIndex]);
			
			for (int i = 0; i < sortLengths[lenIndex]; i++) {
				builtSortList.add(i, rng.nextInt(20001) - 10000);
			}
			
			actualSortList.clear();
			for (int i = 0; i < searchType.length; i++) {
				actualSortList.add(i, (ArrayList<Integer>) builtSortList.clone());
				
				initTime = System.nanoTime();
				
				insertObject.InsertionSort(actualSortList.get(i), searchType[i]);
				
				timings[i][lenIndex] = System.nanoTime() - initTime;
			}
			
			System.out.println(String.format("Length %d: %f | %f", sortLengths[lenIndex], timings[0][lenIndex] * Math.pow(10, -9), timings[1][lenIndex] * Math.pow(10,  -9)));
		}
	}
}
