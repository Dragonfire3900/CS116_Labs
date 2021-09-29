package L5;

public class UnsortedData {
	public static int countOutOfPosition(double [] nL) {
		int count = 0;
		for (int i = 0; i < 99; i++) {
			for (int j = i + 1; j < 100; j++) {
				if(nL[j] < nL[i]) {
					count++;
				}
			}
		}
		return count;
	}
	
	public static void bubble(double [] nL) {
		double sw;
		for (int i = 0; i < 99; i++) {
			if(nL[i] > nL[i+1]) {
				sw = nL[i];
				nL[i] = nL[i+1];
				nL[i+1] = sw;
			}
		}
	}
	
	
}
