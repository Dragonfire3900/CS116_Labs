package L4;

public class MyArrayGenerator {
	private int numberOfElements;
	private int[] Arr;
	
	private int[] elem = new int[11];
	
	public MyArrayGenerator() {
		numberOfElements = 0 + (int)(Math.random() * 15);
		Arr = new int[numberOfElements];
		
		for (int i = 0; i < numberOfElements; i++)
        {
			Arr[i] = 0 + (int)(Math.random() * 10);
			switch(Arr[i]) {
				case 0:
					elem[0]++;
					break;
				case 1:
					elem[1]++;
					break;
				case 2:
					elem[2]++;
					break;
				case 3:
					elem[3]++;
					break;
				case 4:
					elem[4]++;
					break;
				case 5:
					elem[5]++;
					break;
				case 6:
					elem[6]++;
					break;
				case 7:
					elem[7]++;
					break;
				case 8:
					elem[8]++;
					break;
				case 9:
					elem[9]++;
					break;
				case 10:
					elem[10]++;
					break;
			}
			
        }
	}
	
	public int getArrSize() {
		return numberOfElements;
	}
	
	public int[] getArr() {
		return Arr;
	}
	
	public int[] getElem() {
		return elem;
	}
}
