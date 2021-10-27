package L8;

import java.util.Arrays;
import java.util.Random;

public class SwitchPlayer extends Player implements PlayerInterface {
	public int selectDoor() {
		Random rng = new Random();
		this.selectedDoor = rng.nextInt(2) + 1;
		return this.selectedDoor;
	}
	
	public int selectDoorAgain(int openDoor) {
		int[] possibleDoors = {1, 2, 3};
		Random rng = new Random();
		
		possibleDoors = Arrays.stream(possibleDoors).filter(x -> x != openDoor && x != this.selectedDoor).toArray();
		
		return possibleDoors[rng.nextInt(possibleDoors.length)];
	}
}
