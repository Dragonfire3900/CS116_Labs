package FinalProj;

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
		return String.format("%s - %s [%dm%ds] [AUDIO | bitrate: %.3f kbps]", this.getArtist(), this.getName(), this.getDurInMin(), this.getDurInSeconds() - 60 * this.getDurInMin(), this.getBitrate());
	}
}
