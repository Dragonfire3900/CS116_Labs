package L6;
import L5.Recording;
public class AudioRecording extends Recording{
	final double bitrate;
	AudioRecording() {
		super();
		bitrate = 0;
	}
	AudioRecording(String artist, String name, int duration, double br) {
		super(artist, name, duration);
		if (br < 0) {
			bitrate = 0;
		} else {
			bitrate = br;
		}
	}
	
	public double getBitrate() {
		return bitrate;
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s [%dm%ds] [AUDIO | bitrate: %.3f kbps]", this.getArtist(), this.NAME, this.getDurationInMin(), this.getDurationInSeconds() - 60 * this.getDurationInMin(), this.getBitrate());
	}
}
