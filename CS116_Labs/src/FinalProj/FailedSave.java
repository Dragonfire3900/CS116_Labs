package FinalProj;

/** Represents the failure of saving a playlist
 * 
 *
 */
public class FailedSave extends Exception{
	public FailedSave(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public FailedSave(String errorMessage) {
		super(errorMessage);
	}
}
