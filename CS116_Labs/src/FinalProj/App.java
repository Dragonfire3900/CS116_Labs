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
		
		//Building the recording build menu
		Menu buildMen = new Menu("Menu for record building", "What kind of recording would you like to build?", App.sc);
		buildMen.addAct(() -> App.buildVideo(), "Video");
		buildMen.addAct(() -> App.buildAudio(), "Audio");
		
		//Building the recording play menu
		Menu playMen = new Menu("Menu for playing individual recordings", "How would you like to select one song to play?", App.sc);
		playMen.addAct(() -> App.playOneID(), "By Index");
		playMen.addAct(() -> App.playOneName(), "By Song Name");
		
		//Building the recording remove menu
		Menu remMen = new Menu("Menu for removing individual recordings", "How would you like to select one song to remove?", App.sc);
		remMen.addAct(() -> App.remRecordID(), "By Index");
		remMen.addAct(() -> App.remRecordName(), "By Song Name");
		
		//Building the streaming submenu
		Menu stream = new Menu("Main streaming submenu", "Welcome to the streaming menu!", App.sc);
		stream.addAct(() -> buildMen.process(), "Add a recording");
		stream.addAct(() -> App.setPlaylistName(), "Change playlist name");
		stream.addAct(() -> App.loadPlaylist(), "Load playlist from file");
		stream.addAct(() -> App.savePlaylist(), "Save current playlist");
		stream.addAct(() -> App.loadPlaylistUsr(), "Add playlist from another user");
		stream.addAct(() -> App.showPlaylist(), "Show playlist");
		stream.addAct(() -> remMen.process(), "Remove individual recording");
		stream.addAct(() -> playMen.process(), "Play single recording");
		stream.addAct(() -> App.playAll(), "Play entire playlist");
		stream.addAct(() -> App.shuffle(), "Shuffle playlist");
		stream.addAct(() -> App.stats(), "Show playlist stats");
		
		stream.addAct(() -> stream.setLoop(false), "Exit streaming");
		
		//Building the select user submenu
		Menu selUsr = new Menu("Selecting user", "How would you like to select a user?", App.sc);
		selUsr.addAct(() -> {
			App.selUsrID(); 
			stream.setLoop(true);
			stream.process();
			}, "By ID");
		
		selUsr.addAct(() -> {
			App.selUsrUsr();
			stream.setLoop(true);
			stream.process();
			}, "By username");
		
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
				e.printStackTrace();
			}
		}
	}
	
	//Streaming submenu functions
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
		App.currUsr.getPlaylist().save(getStrInput(App.sc, "Please enter the path and name of where you want to save the playlist"), ",");
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
		App.currUsr.getPlaylist().remRecord(getStrInput(App.sc, "Please enter the name of the record you want to remove"));
	}
	
	//Playing record functions
	public static void playOneID() {
		System.out.println(App.currUsr.getPlaylist());
		App.currUsr.getPlaylist().play(getIntInput(App.sc, "Please enter the index of the record you want to play"));
	}
	
	public static void playOneName() {
		System.out.println(App.currUsr.getPlaylist());
		App.currUsr.getPlaylist().play(getStrInput(App.sc, "Please enter the name of the record you want to play"));
	}
	
	//Building record functions
	public static void buildVideo() {
		String artist = getStrInput(App.sc, "Please enter the artist name");
		String name = getStrInput(App.sc, "Please enter the video name");
		int duration = getIntInput(App.sc, "Please enter the duration rounded to the nearest second");
		double fr = getDoubleInput(App.sc, "Please enter the frame rate of the video");
		
		App.currUsr.getPlaylist().addRecord(new VideoRecording(artist, name, duration, fr));
	}
	
	public static void buildAudio() {
		String artist = getStrInput(App.sc, "Please enter the artist name");
		String name = getStrInput(App.sc, "Please enter the song name");
		int duration = getIntInput(App.sc, "Please enter the duration rounded to the nearest second");
		double fr = getDoubleInput(App.sc, "Please enter the bit rate of the audio");
		
		App.currUsr.getPlaylist().addRecord(new AudioRecording(artist, name, duration, fr));
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
			}
		}
	}
	
	public static double getDoubleInput(Scanner sc, String prompt) {
		while (true) {
			try {
				sc.nextLine();
				System.out.println(prompt);
				return sc.nextDouble();
			} catch (InputMismatchException e) {
				System.out.println("Please enter a valid Int");
			}
		}
	}
}
