package L4;
import java.util.Arrays;

public class WhatIsInCommon {

	public static void main(String[] args) {
		int sE = 0;
		
		MyArrayGenerator a = new MyArrayGenerator();
		MyArrayGenerator b = new MyArrayGenerator();
		int[] arrA = a.getArr();
		int[] arrB = b.getArr();
		
		System.out.println("Array A: " + Arrays.toString(arrA));
		System.out.println("Array b: " + Arrays.toString(arrB));
		for(int i = 0; i < 11; i++) {
			if(a.getElem()[i] > 0 && b.getElem()[i] > 0) {
				System.out.println(i + "			" + a.getElem()[i] + "			" + b.getElem()[i]);
				sE++;
			}
		}
		System.out.println("Number of elements that are both A and B: " + sE);
		
	}

}
