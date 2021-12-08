package FinalProj;

/** Represents a recording being completely unplayable (duration of zero)
 * 
 *
 */
public class Unplayable extends Exception {
	public Unplayable(String errorMessage, Throwable err) {
		super(errorMessage, err);
	}
	
	public Unplayable(String errorMessage) {
		super(errorMessage);
	}
}
