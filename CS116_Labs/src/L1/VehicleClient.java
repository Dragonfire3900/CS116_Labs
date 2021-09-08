package L1;

public class VehicleClient {

	public static void main(String[] args) {
		//Testing if the default constructor works
		Vehicle v1 = new Vehicle();
		
		System.out.print(v1);
		
		//Testing if the parameterized constructor works
		Vehicle v2 = new Vehicle(10);
		
		System.out.print(v2);
		
		
		//Testing out the mutator methods
		System.out.print("\nTesting Mutators\n___________________________\n");
		
		System.out.print("Set bad arrival time bool: " + v2.setArrivalTime(-10) + "\nTest: " + v2);
		System.out.print("Set good arrival time bool: " + v2.setArrivalTime(11) + "\nTest: " + v2 + "\n");
		
		v2.setArrivalTime(5);
		v2.setLeavingTime(8);
		System.out.print("Original state: " + v2 + "\n");
		System.out.print("Set good toll booth time bool: " + v2.setTollBoothTime(5) + "\nTest: " + v2);
		System.out.print("Set bad toll booth time bool: " + v2.setTollBoothTime(9) + "\nTest: " + v2);
		System.out.print("Set bad toll booth time bool: " + v2.setTollBoothTime(4) + "\nTest: " + v2 + "\n");
		
		v2.setArrivalTime(3);
		v2.setTollBoothTime(4);
		System.out.print("Original state: " + v2 + "\n");
		System.out.print("Set good leaving time bool: " + v2.setLeavingTime(7) + "\nTest: " + v2);
		System.out.print("Set bad leaving time bool: " + v2.setLeavingTime(2) + "\nTest: " + v2 + "\n");
		
		
	}

}
