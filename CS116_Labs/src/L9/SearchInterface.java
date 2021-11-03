package L9;
import java.util.*;
public interface SearchInterface {
	/**
	 * Finds the index where the target should be inserted. Assumes that the list needs to be lowest to greatest
	 * @param data The data to search through
	 * @param target The target to find
	 * @param lowBound The lower bound to search in (inclusive)
	 * @param upperBound The upper bound to search in (exclusive)
	 * 
	 * @return the index of where the target should be inserted
	 */
	public int findIndex(ArrayList<Double> data, double target, int lowBound, int upperBound); 
}
