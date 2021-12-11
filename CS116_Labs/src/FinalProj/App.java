package FinalProj;

import java.io.FileNotFoundException;
import java.util.InputMismatchException;
import java.util.NoSuchElementException;
import java.util.Scanner;

public class App {
	private static User currUsr = null;
	private static Database store = new Database();
	private static Scanner sc = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		//Building the initial menu
		Menu initMenu = new Menu("Initial Menu", "Welcome to the main database page!", App.sc);
		initMenu.setLoop(true);
		
		initMenu.addAct(() -> App.listUsrs(), "List users");
		initMenu.addAct(() -> App.addUsr(), "Add user");
		
		//Building the remove user submenu
		Menu rmUsr = new Menu("Remove user submenu", "Would you like to enter an ID or Username to remove someone?", App.sc);
		rmUsr.addAct(() -> App.remUsrID(), "Remove by ID");
		rmUsr.addAct(() -> App.remUsrUsr(), "Remove by Username");
		
		initMenu.addAct(() -> rmUsr.process(), "Remove user");
		
		//Building the streaming submenu
		Menu stream = new Menu("Main streaming submenu", "Welcome to the streaming menu!", App.sc);
		
		//Building the select user submenu
		Menu selUsr = new Menu("Selecting user", "How would you like to select a user?", App.sc);
		selUsr.addAct(() -> {App.selUsrID(); stream.process();}, "By ID");
		selUsr.addAct(() -> {App.selUsrUsr(); stream.process();}, "By username");
		
		initMenu.addAct(() -> selUsr.process(), "Select user and stream");
		
		initMenu.addAct(() -> {
			initMenu.setLoop(false);
		}, "Exit program");
		
		initMenu.process();
	}
	
	//Base Menu Functions
	public static void listUsrs() {
		App.store.listUsers();
	}
	
	public static void addUsr() {
		store.addUser(getStrInput(sc, "Please enter a username for the new user"));
	}
	
	//Remove user submenu functions
	public static void remUsrID() {
		store.remUser(getIntInput(sc, "Please enter an ID to remove"));
	}
	
	public static void remUsrUsr() {
		store.getUser(getStrInput(sc, "Please enter a username to remove"));
	}
	
	//Selecting user submenu
	public static void selUsrID() {
		while(true) {
			try {
				App.currUsr = store.getUser(getIntInput(sc, "Please enter an ID"));
				if (App.currUsr == null) { throw new NoSuchElementException(); }
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Please enter a valid user id");
			}
		}
	}
	
	public static void selUsrUsr() {
		while(true) {
			try {
				App.currUsr = store.getUser(getStrInput(sc, "Please enter a username"));
				break;
			} catch (NoSuchElementException e) {
				System.out.println("Please enter a valid username");
			}
		}
	}
	
	//Streaming submenu functions
	public static void addRecord() {
		
	}
	
	public static void setPlaylistName() {
		App.currUsr.getPlaylist().setName(getStrInput(App.sc, "Please enter a new playlist name"));
	}
	
	public static void showPlaylist() {
		System.out.println(App.currUsr.getPlaylist());
	}
	
	public static void loadPlaylist() {
		while (true) {
			try {
				App.currUsr.getPlaylist().load(getStrInput(App.sc, "Please enter a csv file path"), ",");
				break;
			} catch (FileNotFoundException e) {
				System.out.println("That file was not found please try again");
			}
		}
	}
	
	public static void loadPlaylistUsr() {
		App.currUsr.getPlaylist().cpyPlaylist(
			App.store.getUser(getIntInput(App.sc, "Please enter the id of the user you want to copy")).getPlaylist()
		);
	}
	
	public static void savePlaylist() {
		
	}
	
	public static void playAll() {
		App.currUsr.getPlaylist().play();
	}
	
	public static void shuffle() {
		App.currUsr.getPlaylist().shuffle();
	}
	
	public static void stats() {
		App.currUsr.getPlaylist().stats();
	}
	
	//Removing record functions
	public static void remRecordID() {
		System.out.println(App.currUsr.getPlaylist());
		App.currUsr.getPlaylist().remRecord(getIntInput(App.sc, "Please enter the index of the record you want to remove"));
	}
	
	public static void remRecordName() {
		System.out.println(App.currUsr.getPlaylist());
		App.currUsr.getPlaylist().remRecord(getIntInput(App.sc, "Please enter the name of the record you want to remove"));
	}
	
	//Playing record functions
	public static void playOneID() {
		App.currUsr.getPlaylist().play(getIntInput(App.sc, "Please enter the index of the record you want to play"));
	}
	
	public static void playOneName() {
		App.currUsr.getPlaylist().play(getStrInput(App.sc, "Please enter the name of the record you want to play"));
	}

	//Utilities
	public static String getStrInput(Scanner sc, String prompt) {
		while (true) {
			try {
				sc.nextLine();
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
				sc.nextLine();
				System.out.println(prompt);
				return sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid Int");
				System.out.println();
			}
		}
	}
}
