package FinalProj;

public class User{
	protected int ID;
	protected String Username;
	protected Playlist playlist;
	
	public User(int id, String userName) {
		this.ID = id;
		this.Username = userName;
		this.playlist = new Playlist();
	}
	
	public User(int id, User oldUser) {
		this.ID = id;
		this.Username = oldUser.getUsername();
		this.playlist = new Playlist(oldUser.getPlaylist());
	}
	
	public int getID() {
		return this.ID;
	}
	
	public String getUsername() {
		return this.Username;
	}
	
	public Playlist getPlaylist() {
		return this.playlist;
	}
	
	public void setUsername(String u) {
		this.Username = u;
	}
	
	public void setPlaylistName(String nName) {
		this.playlist.setName(nName);
	}
	
	public String toString() {
		return String.format("%s - %d", this.Username, this.ID);
		
	}
}
