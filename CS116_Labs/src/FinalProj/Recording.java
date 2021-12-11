package FinalProj;

public abstract class Recording {
	//Class defaults
	protected final static String DEF_ARTIST = "UNK";
	protected final static String DEF_NAME = "UNK";
	protected final static int DEF_DUR = 0;
	protected final static String DEF_DELIM = " ";
	
	//Attributes
	protected String artist;
	protected String name;
	protected int dur; //This is in second
	protected int playNum;
	
	public Recording() {
		this.artist = Recording.DEF_ARTIST;
		this.name = Recording.DEF_NAME;
		this.dur = Recording.DEF_DUR;
	}
	
	public Recording(String nArtist, String nName, int nDur) {
		if (nArtist.isBlank()) {
			this.artist = Recording.DEF_ARTIST;
		} else {
			this.artist = nArtist.trim();
		}
		
		if (nName.isBlank()) {
			this.name = Recording.DEF_NAME;
		} else {
			this.name = nName.trim();
		}
		
		if (nDur <= 0) {
			this.dur = Recording.DEF_DUR;
		} else {
			this.dur = nDur;
		}
	}
	
	public Recording(Recording oldRec) {
		this.artist = oldRec.getArtist();
		this.name = oldRec.getName();
		this.dur = oldRec.getDurInSeconds();
		this.playNum = oldRec.getPlayNum();
	}
	
	//Accessors
	public String getArtist() { return this.artist; }
	
	public String getName() { return this.name; }
	
	public int getPlayNum() { return this.playNum; }
	
	public int getDurInSeconds() { return this.dur; }
	
	public int getDurInMin() { return this.dur / 60; }
	
	//Comparators
	public boolean equals(Recording other) {
		return this.artist.equals(other.getArtist()) &&
				this.name.equals(other.getName()) && 
				this.dur == other.dur;
	}
	
	public boolean equalNames(Recording other) {
		return this.artist.equals(other.getArtist()) &&
				this.name.equals(other.getName());
	}
	
	public int playNumComp(Recording other) {
		if (this.getPlayNum() < other.getPlayNum()) {
			return -1;
		} else if (this.getPlayNum() == other.getPlayNum()) {
			return 0;
		} else {
			return 1;
		}
	}
	
	//String manipulations
	public void play() throws Unplayable {
		if (this.dur == 0) {
			throw new Unplayable(String.format("%s is unplayable", this.toString()));
		} else {
			System.out.println("Now playing: " + this.toString());
			this.playNum += 1;
		}
	}
	
	protected String baseCSV(String delim) {
		return String.format("%s%s %s%s %d%s", this.getArtist(), delim, this.getName(), delim, this.getDurInSeconds(), delim);
	}
	
	public abstract String asCSV(String delim);
	
	public String toString() {
		return String.format("%s - %s [%dm%ds]", this.artist, this.name, this.getDurInMin(), this.getDurInSeconds() - 60 * this.getDurInMin());
	}
	
	//Special functions
	public abstract Recording makeCopy();
}
