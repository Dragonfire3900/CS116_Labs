package FinalProj;

public class VideoRecording extends Recording {
	final double framerate;
	VideoRecording(){
		super();
		framerate = 0;
	}
	VideoRecording(String artist, String name, int duration, double fr) {
		super(artist, name, duration);
		if (fr < 0) {
			framerate = 0;
		} else {
			framerate = fr;
		}
	}
	
	public double getFramerate() {
		return framerate;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s [%dm%ds] [VIDEO | framerate: %.3f fps]", this.getArtist(), this.getName(), this.getDurInMin(), this.getDurInSeconds() - 60 * this.getDurInMin(), this.getFramerate());
	}

}
