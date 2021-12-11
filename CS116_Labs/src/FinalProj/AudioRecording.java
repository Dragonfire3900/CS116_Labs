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
	
	AudioRecording(AudioRecording oldRec) {
		super(oldRec);
		
		this.bitrate = oldRec.getBitrate();
	}
	
	public double getBitrate() {
		return bitrate;
	}
	
	public String asCSV(String delim) {
		return String.format("A%s%s %f%s\n", delim, this.baseCSV(delim), this.getBitrate(), delim);
	}
	
	@Override
	public String toString() {
		return String.format("%s - %s [%dm%ds] [AUDIO | bitrate: %.3f kbps]", this.getArtist(), this.getName(), this.getDurInMin(), this.getDurInSeconds() - 60 * this.getDurInMin(), this.getBitrate());
	}
	
	@Override
	public AudioRecording makeCopy() {
		return new AudioRecording(this);
	}
}
