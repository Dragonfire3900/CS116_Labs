package FinalProj;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Database {
	private static HashMap<Integer, User> hash = new HashMap<Integer, User>();
	private static final double implodeThresh = Math.pow(10, -6);
	
	public Database() {
		
	}
	
	public Database(ArrayList<User> users) {
		
	}
	
	public Database(String file) {
		
	}
	
	//Accessors
	public User getUser(int id) { return hash.get((Integer) id); }
	
	public void listUsers() {
		
	}
	
	public int getSize() { return hash.size(); }
	
	//Mutators
	public void addUser(User nUser) {
		
	}
	
	public void addUser(String file) {
		
	}
	
	//IO stuff
	public void load(String file, String delim) {
		
	}
	
	public void save(String file, String delim) {
		
	}
	
	//String manipulations
	public String toString() {
		
	}
	
	//Don't worry about me
	private void implode() {
		Random rng = new Random();
		
		double testVal = rng.nextDouble();
		
		if (testVal <= implodeThresh) {
			System.out.println("BOOOOOOOOOOOOOOOM!!!! Your database has imploded");
			Database.hash = new HashMap<Integer, User>();
		}
	}
}
