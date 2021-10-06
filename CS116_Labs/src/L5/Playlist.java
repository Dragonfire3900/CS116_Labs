package L5;

public class Playlist {
	//Instance variables
	protected String name;
	private int numberOfRecordings = 0;
	private int durationInSeconds = 0;
	private final int MAX_PLAYLIST_SIZE;
	protected Recording[] recordList;
	
	//Class variables
	private static final String DEFAULT_PLAYLIST_NAME = "UNKNOWN";
	private static final int DEFAULT_MAX_PLAYLIST_SIZE = 5;
	
	Playlist() {
		this.name = Playlist.DEFAULT_PLAYLIST_NAME;
		
		this.MAX_PLAYLIST_SIZE = Playlist.DEFAULT_MAX_PLAYLIST_SIZE;
		
		recordList = new Recording[this.MAX_PLAYLIST_SIZE];
	}
	
	Playlist(String name, int maxPlaylistSize) {
		if (name != null) {
			this.name = name;
		} else {
			this.name = Playlist.DEFAULT_PLAYLIST_NAME;
		}
		
		if (maxPlaylistSize <= 0) {
			this.MAX_PLAYLIST_SIZE = Playlist.DEFAULT_MAX_PLAYLIST_SIZE;
		} else {
			this.MAX_PLAYLIST_SIZE = maxPlaylistSize;
		}
	}

	//Getters
	public String getName() {
		return this.name;
	}

	public int getNumberOfRecordings() {
		return this.numberOfRecordings;
	}

	public int getDurationInSeconds() {
		return this.durationInSeconds;
	}

	public int getMaxPlaylistSize() {
		return this.MAX_PLAYLIST_SIZE;
	}

	public Recording[] getRecordList() {
		return recordList;
	}
	
	/**
	 * Returns a specific record inside of the playlist
	 * @param recordIndex The index of the record the user would like
	 * @return The specific record they asked for
	 */
	public Recording getOneRecord(int recordIndex) {
		if (recordIndex >= 0 && recordIndex < this.MAX_PLAYLIST_SIZE) {
			return this.recordList[recordIndex];
		} else {
			return new Recording();
		}
	}
	
	//The lone setter
	public boolean setName(String newName) {
		if (newName != null) {
			return false;
		} else {
			this.name = newName;
			return true;
		}
	}
	
	//Custom methods
	public boolean add(Recording newRecord) {
		if (newRecord == null) { return false; } //Tried to add a null record
		
		if (this.numberOfRecordings == this.MAX_PLAYLIST_SIZE) { return false; } //Tried to add too many records to the playlist
		
		this.recordList[this.numberOfRecordings] = newRecord;
		this.numberOfRecordings += 1;
		this.durationInSeconds += newRecord.getDurationInSeconds();
		return true;
	}
	
	public void play() {
		
	}
}
