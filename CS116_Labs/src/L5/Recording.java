package L5;

public class Recording {
	//Instance variables
	protected final String ARTIST;
	protected final String NAME;
	protected final int DURATION_IN_SECONDS;
	
	//Class variables
	private static final String DEFAULT_ARTIST = "UNKNOWN";
	private static final String DEFAULT_NAME = "UNKNOWN";
	private static final int DEFAULT_DURATION = 0;
	
	public Recording() {
		this.ARTIST = Recording.DEFAULT_ARTIST;
		this.NAME = Recording.DEFAULT_NAME;
		this.DURATION_IN_SECONDS = Recording.DEFAULT_DURATION;
	}
	
	public Recording(String artist, String name, int duration) {
		if (artist != null) {
			this.ARTIST = artist;
		} else {
			this.ARTIST = Recording.DEFAULT_ARTIST;
		}
		
		if (name != null) {
			this.NAME = name;
		} else {
			this.NAME = Recording.DEFAULT_NAME;
		}
		
		if (duration < 0) {
			this.DURATION_IN_SECONDS = Recording.DEFAULT_DURATION;
		} else {
			this.DURATION_IN_SECONDS = duration;
		}
	}
	
	public String getArtist() { return this.ARTIST; }
	public String getName() { return this.NAME; }
	public int getDurationInSeconds() { return this.DURATION_IN_SECONDS; }
	
	public int getDurationInMin() { return this.DURATION_IN_SECONDS / 60; }
	
	public void play() {
		if (this.DURATION_IN_SECONDS == 0) {
			System.out.println("ERROR: cannot play this recording");
		} else {
			System.out.println("Now playing: " + this.toString());
		}
	}
	
	public String toString() {
		return String.format("%s - %s [%dm%ds]", this.ARTIST, this.NAME, this.getDurationInMin(), this.getDurationInSeconds() - 60 * this.getDurationInMin());
	}
}
