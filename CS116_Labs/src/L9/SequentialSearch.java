package L9;
import java.util.*;
public class SequentialSearch implements SearchInterface {

	@Override
	public int findIndex(ArrayList<Integer> data, double target, int lowBound, int upperBound) {
		if(data.size() >= 1) {
			for (int i = lowBound; i <= upperBound; i++) {
				if(data.get(i) >= target) {
//					System.out.println(String.format("Seq found lower at: %d", i));
					return i;
				}
			}
			return upperBound;
		}
		
//		System.out.println("Seq search broke");
		return -1;
	}
	
	public String toString() { return "SeqSearch"; }
}
