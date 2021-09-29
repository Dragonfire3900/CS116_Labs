package L5;

public class PlaylistDemo {
	public static void main(String [] args){
		// Instantiate new playlist
		Playlist myPlaylist = new Playlist("CS 116 Playlist", 10);
		
		// Add some songs to it
		Recording newRecording = new Recording("Billie Eilish", "Everything I Wanted", 201);
		myPlaylist.add(newRecording);
		newRecording = new Recording("Eminem", "Godzilla", 245);
		myPlaylist.add(newRecording);
		newRecording = new Recording("The Weeknd", "Blinding Lights", 145);
		myPlaylist.add(newRecording);
		newRecording = new Recording("Nicki Minaj", "Yikes", 217);
		myPlaylist.add(newRecording);
		newRecording = new Recording("Justin Bieber", "Intentions", 234);
		myPlaylist.add(newRecording);		
		
		// "Play" the playlist
		myPlaylist.play();
		
		// Display playlist "summary"
		System.out.println(myPlaylist.toString());
	}
}

