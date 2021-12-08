package FinalProj;

/** Represents the failure of loading in a playlist
 * 
 *
 */

public class FailedLoad extends Exception {
	public FailedLoad(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public FailedLoad(String errorMessage) {
		super(errorMessage);
	}
}
