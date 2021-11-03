package L9;
import java.util.*;
public class SequentialSearch implements SearchInterface {

	@Override
	public int findIndex(ArrayList<Double> data, double target, int lowBound, int upperBound) {
		if(data.size() >= 1) {
			for (int i = lowBound; i < upperBound; i++) {
				if(data.get(i) >= target) return i;
			}
		}
		
		return -1;
	}

}
