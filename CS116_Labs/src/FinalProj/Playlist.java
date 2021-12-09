package FinalProj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;

public class Playlist {
	private static final String DEFAULT_PLAYLIST_NAME = "UNK";
	
	protected String name;
	protected int numPlayedCount = 0;
	protected ArrayList<Recording> recordList;
	
	public Playlist() {
		this.name = DEFAULT_PLAYLIST_NAME;
		this.recordList = new ArrayList<Recording>();
	}
	
	public Playlist(String nName) {
		if (nName != null) {
			this.name = nName;
		} else {
			this.name = DEFAULT_PLAYLIST_NAME;
		}
		this.recordList = new ArrayList<Recording>();
	}
	
	//Accessors
	public String getName() {
		return this.name;
	}
	
	public int getNumRecordings() {
		return this.recordList.size();
	}
	
	public int getDuration() {
		return this.recordList.stream().mapToInt(s -> s.getDurInSeconds()).sum();
	}
	
	public ArrayList<Recording> getRecordings() {
		return this.recordList;
	}
	
	public Recording getRecord(int index) {
		return this.recordList.get(index);
	}
	
	public Recording getRecord(String name) {
		return this.recordList.in
	}
	
	//Mutators
	public void setName(String nName) {
		if (nName != null) {
			this.name = nName;
		}
	}
	
	public void addRecord(String stringRecord) {
		try {
			this.addRecord(RecordingFactory.build(stringRecord));
		} catch (MalformedRecording e) {
			System.out.println("tried to make a malformed recording");
		}
	}
	
	public void addRecord(Recording nRecord) {
		this.recordList.add(nRecord);
	}

	public void addRecord(Playlist other) {
		this.recordList.addAll(other.getRecordings());
	}
	
	public void remRecord(int index) {
		this.recordList.remove(index);
	}
	
	public void remRecord(String songName) {
		this.recordList.removeIf(rec -> rec.getName().equals(songName));
	}
	
	//IO operations
	public static Playlist load(String file, String delim) throws FileNotFoundException {
		File readFile = new File(file);
		Playlist tmpPlay = new Playlist(readFile.getName().split(".")[0]);
		
		Scanner fileRead = new Scanner(readFile);
		
		while(fileRead.hasNextLine()) {
			String data = fileRead.nextLine();
			try {
				tmpPlay.addRecord(RecordingFactory.build(data, delim));
			} catch (MalformedRecording e) {
				System.out.println(String.format("tried to make a malformed recording: %s", data));
			}
		}
		fileRead.close();
		
		return tmpPlay;
	}
	
	public void save(String file, String delim) {
		File readFile = new File(file);
		
		try {
			if (!readFile.createNewFile()) {
				System.out.println("file already existed. Overwritting");
			}
			
			FileWriter csvWrite = new FileWriter(readFile);
			
			this.recordList.forEach(rec -> {
				try {
					csvWrite.write(rec.asCSV(delim));
				} catch (IOException e) {
					// TODO Auto-generated catch block
					System.out.println("Write error");
				}
			});
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("Write error");
		}
	}
	
	//Music operations
	public void play() {
		this.recordList.forEach(rec -> {
			try {
				rec.play();
			} catch (Unplayable e) {
				System.out.println("Unplayable recording");
			}
		});
	}
	
	public void play(int index) {
		try {
			this.getRecord(index).play();
		} catch (Unplayable e) {
			System.out.println("Unplayable recording");
		}
	}
	
	public void play(String name) {
	}
	
	//Misc operations
	public void stats() {
		//TODO: Sort according to the 
	}
	
	public void shuffle() {
		Collections.shuffle(this.recordList);
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("Playlist name: %s", this.getName()));
		
		this.recordList.forEach(rec -> output.append("\n\t" + rec.toString()));
		
		return output.toString();
	}
}
