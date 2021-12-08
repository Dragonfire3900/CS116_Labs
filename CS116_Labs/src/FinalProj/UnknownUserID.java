package FinalProj;

/** Represents the user ID not being found in the database
 * 
 *
 */
public class UnknownUserID extends Exception {
	public UnknownUserID(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public UnknownUserID(String errorMessage) {
		super(errorMessage);
	}
}
