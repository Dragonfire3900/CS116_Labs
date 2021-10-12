package L6;
import L5.*;
public class VideoRecording extends Recording{
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
		return String.format("%s - %s [%dm%ds] [Video | framerate: %d fps]", this.getArtist(), this.NAME, this.getDurationInMin(), this.getDurationInSeconds() - 60 * this.getDurationInMin(), this.getFramerate());
	}

}
