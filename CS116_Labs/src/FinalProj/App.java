package FinalProj;

import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
	private static User currUsr = null;
	private static Database store = new Database();
	
	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		
		UserMenu(input);
	}
	
	public static void UserMenu(Scanner sc) {
	    for(;;) {
	    	System.out.println();
		    
		    System.out.println("Welcome to the main database page! Please select an option");
		    System.out.println("\t1) Select User to stream\n"
		    		+ "\t2) list users\n"
		    		+ "\t3) Add users\n"
		    		+ "\t4) Remove users\n"
		    		+ "\t5) exit program\n");
		    
		    String usrInput = null;
	    	switch(getIntInput(sc, "")) {
	    	case 1: //Selecting usr and then streaming from them
	    		try {
	    			switch(getIntInput(sc, "Do you want to enter a ID (1) or user name (2)?")) {
		    		case 1:
		    			App.currUsr = store.getUser(getIntInput(sc, "Please enter an ID"));
		    			if (App.currUsr == null) { throw new NoSuchElementException(); }
		    			break;
		    		case 2:
		    			App.currUsr = store.getUser(getStrInput(sc, "Please enter a username"));
		    			break;
		    		}
		    		StreamMenu(sc);
	    		} catch (NoSuchElementException e) {
	    			System.out.println("That user does not exists try again");
	    		}
	    		continue;
	    	case 2:
	    		store.listUsers();
	    		continue;
	    	case 3:
	    		store.addUser(getStrInput(sc, "Please enter a username for the new user"));
	    		continue;
	    	case 4:
	    		try {
	    			switch(getIntInput(sc, "Do you want to enter a ID (1) or user name (2)?")) {
		    		case 1:
		    			store.remUser(getIntInput(sc, "Please enter an ID to remove"));
		    			break;
		    		case 2:
		    			store.getUser(getStrInput(sc, "Please enter a username to remove"));
		    			break;
		    		}
		    		System.out.println("User deleted");
	    		} catch (NoSuchElementException e) {
	    			System.out.println("That user does not exists try again");
	    		}
	    		continue;
	    	case 5:
	    		break;
	    	default:
	    		System.out.println("Please enter a valid option");
	    		continue;
	    	}
	    break;
	    }
	}
	
	public static void StreamMenu(Scanner sc) {
		for(;;) {
			System.out.println("Welcome to the streaming page");
			System.out.println("You have user: " + App.currUsr + " selected");
			
			System.out.println("What would you like to do?"
					+ "1) Add recording to playlist"
					+ "2) Show playlist"
					+ "3) Load playlist from source"
					+ "4) Remove recording"
					+ "5) Play recordings!"
					+ "6) Save playlist"
					+ "7) Display playlist stats"
					+ "8) Go back");
			
			switch(getIntInput(sc, "Please enter an option")) {
			case 1:
			}
		}
	}

	public static String getStrInput(Scanner sc, String prompt) {
		while (true) {
			try {
				sc.next();
				System.out.println(prompt);
				return sc.next();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid string");
				System.out.println();
			}
		}
	}

	public static int getIntInput(Scanner sc, String prompt) {
		while (true) {
			try {
				sc.next();
				System.out.println(prompt);
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid Int");
				System.out.println();
			}
		}
	}
}
