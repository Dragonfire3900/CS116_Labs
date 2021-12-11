package FinalProj;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

public class Database {
	private static HashMap<Integer, User> hash = new HashMap<Integer, User>();
	private static final double implodeThresh = Math.pow(10, -6);
	private static int nextUserID = 0;
	
	public Database() {
		super();
	}
	
	public Database(ArrayList<User> users) {
		users.forEach(usr -> this.addUser(usr));
	}
	
	//Accessors
	public User getUser(int id) { return hash.get((Integer) id); }
	
	public User getUser(String usrName) {
//		System.out.println("\'" + usrName + "\'");
		return hash.entrySet().stream()
			.filter(map -> map.getValue().getUsername().equals(usrName))
			.findFirst().orElseThrow().getValue();
	}
	
	public void listUsers() {
		System.out.println(this.toString());
	}
	
	public int getSize() { return hash.size(); }
	
	//Mutators
	public void addUser(User nUser) {
		hash.put(Database.nextUserID, new User(nextUserID, nUser));
		Database.nextUserID += 1;
	}
	
	public void addUser(String usrName) {
		hash.put(Database.nextUserID, new User(nextUserID, usrName));
		Database.nextUserID += 1;
	}
	
	public void remUser(int id) {
		hash.remove((Integer) id);
	}
	
	public void remUser(String usrName) {
		hash.values().removeIf(usr -> usr.getUsername().equals(usrName));
	}
	
	//String manipulations
	public String toString() {
		StringBuilder output = new StringBuilder();
		
		output.append("Database\nUsrName  -  ID\n");
		Database.hash.forEach((key, usr) -> output.append(usr.toString() + "\n"));
		return output.toString();
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
