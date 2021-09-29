package L5;
import java.util.*;
import java.io.*;

public class UnsortedDataApp {
	public static void main(String[] args) throws FileNotFoundException {
	    double [] fileNums = new double [100];
		double myNum;
		
		Scanner askFile = new Scanner(System.in);
	    System.out.println("What is the name of the input file?");
	    String fileN = askFile.nextLine();
	    askFile.close();
	    
	    File myFile = new File(fileN);
	    Scanner fileScanner = new Scanner(myFile);
	    
	    for (int i = 0; i < 100; i++) {
	    	myNum = fileScanner.nextDouble();
	    	fileNums[i] = myNum;
	    }
	    
	    fileScanner.close();
	    
	    System.out.println("Total Out of Order BEFORE Bubble = " + UnsortedData.countOutOfPosition(fileNums));
	    UnsortedData.bubble(fileNums);
	    System.out.println("Total Out of Order AFTER Bubble = " + UnsortedData.countOutOfPosition(fileNums));
	    
	  }
}
