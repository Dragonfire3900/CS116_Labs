package FinalProj;

import java.util.ArrayList;
import java.util.Collections;
import java.util.NoSuchElementException;
import java.util.Optional;
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
	
	public Playlist(Playlist oldPlay) {
		this.name = oldPlay.getName();
		this.numPlayedCount = oldPlay.getPlayNum();
		
		this.recordList = new ArrayList<Recording>();
		
		oldPlay.getRecordings().stream().forEach(rec -> this.recordList.add(rec.makeCopy()));
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
	
	public Recording getRecord(String name) throws NoSuchElementException {
		return this.recordList.stream().filter(rec -> rec.name.equals(name)).findFirst().orElseThrow();
	}
	
	public int getPlayNum() { return this.numPlayedCount; }
	
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
	
	public void cpyPlaylist(Playlist other) {
		other.getRecordings().forEach(rec -> this.addRecord(rec));
	}
	
	//IO operations
	public void load(String file, String delim) throws FileNotFoundException {
		File readFile = new File(file);
		
		Scanner fileRead = new Scanner(readFile);
		
		while(fileRead.hasNextLine()) {
			String data = fileRead.nextLine();
			try {
				this.addRecord(RecordingFactory.build(data, delim));
			} catch (MalformedRecording e) {
				System.out.println(String.format("tried to make a malformed recording: %s", data));
			}
		}
		fileRead.close();
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
			
			csvWrite.close();
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
		this.numPlayedCount += 1;
	}
	
	public void play(int index) {
		try {
			this.getRecord(index).play();
		} catch (Unplayable e) {
			System.out.println("Unplayable recording");
		}
	}
	
	public void play(String name) {
		try {
			this.getRecord(name).play();
		} catch (NoSuchElementException e) {
			System.out.println("Could not find the record you wanted to play");
		} catch (Unplayable e) {
			System.out.println("Unplayable recording");
		}
	}
	
	//Misc operations
	public void stats() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("Playlist %s stats\n", this.getName()));
		output.append("Index Artist - Song Name - Number of plays\n");
		
		@SuppressWarnings("unchecked") //It's okay to suppress this warning because its known to be this type
		ArrayList<Recording> copy = (ArrayList<Recording>) this.recordList.clone();
		
		copy.sort((o1, o2) -> o1.playNumComp(o2));
		
		for (int i = 0; i < copy.size(); i++) {
			output.append(String.format("%s - %s - %d\n", i, copy.get(i).getArtist(), copy.get(i).getName(), copy.get(i).getPlayNum()));
		}
		
		System.out.println(output);
	}
	
	public void shuffle() {
		Collections.shuffle(this.recordList);
	}
	
	public String toString() {
		StringBuilder output = new StringBuilder();
		output.append(String.format("Playlist name: %s\n", this.getName()));
		
		for (int i = 0; i < this.recordList.size(); i++) {
			output.append(String.format("%d %s\n", i, this.getRecord(i)));
		}
		
		return output.toString();
	}
}
