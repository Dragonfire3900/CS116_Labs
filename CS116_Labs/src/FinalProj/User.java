package FinalProj;

public class User{
	protected int ID;
	protected String Username;
	
	public User(int i, String u) {
		this.ID = i;
		this.Username = u;
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getUsername() {
		return this.Username;
	}
	
	public void setUsername(String u) {
		this.Username = u;
	}
	
	public String toString() {
		return String.format("%s - %d", this.Username, this.ID);
		
	}
}
