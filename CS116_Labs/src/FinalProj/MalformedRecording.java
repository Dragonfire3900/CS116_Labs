package FinalProj;

/** Represents a recording trying to be built with incorrect arguments
 * 
 *
 */
public class MalformedRecording extends Exception{
	public MalformedRecording(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public MalformedRecording(String errorMessage) {
		super(errorMessage);
	}
}
