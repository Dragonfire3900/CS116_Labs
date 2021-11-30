package FinalProject;

import java.util.ArrayList;
import java.util.Collections;

public class Playlist {
	protected String name;
	protected int numPlayedCount = 0;
	private static final String DEFAULT_PLAYLIST_NAME = "UNKNOWN";
	protected ArrayList<Recording> recordList;
	
	public Playlist() {
		this.name = DEFAULT_PLAYLIST_NAME;
		this.recordList = new ArrayList<Recording>(); 
	}
	
	public Playlist(String n) {
		if (n != null) {
			this.name = n;
		} else {
			this.name = DEFAULT_PLAYLIST_NAME;
		}
		this.recordList = new ArrayList<Recording>();
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getNumRecordings() {
		return this.recordList.size();
	}
	
	public int getDuration() {
		int d = 0;
		for(int i = 0; i < this.recordList.size(); i++) {
			d += this.recordList.get(i).getDurationInSeconds();
		}
		return d;
	}
	
	public Recording getRecord(int r) {
		return this.recordList.get(r);
	}
	
	public void setName(String n) {
		if (n != null) {
			this.name = n;
		}
	}
	
	public void addRecord(String s) {
		
	}
	
	public void addRecord(Recording r) {
		this.recordList.add(r);
	}

	public void addRecord(Playlist p) {
		
	}
	
	public void remRecord(int n) {
		
	}
	
	public void remRecord(String a, String b) {
		
	}
	
	public void shuffle() {
		Collections.shuffle(this.recordList);
	}
	
	public static Playlist load() {
		
	}
	
	public void save() {
		
	}
	
	public void stats() {
		
	}
	
	public String toString() {
		
	}
}
