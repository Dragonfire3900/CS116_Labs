package L8;

import java.util.Arrays;
import java.util.Random;

public class RandomSwitchPlayer extends Player implements PlayerInterface{
	public int selectDoor() {
		Random rng = new Random();
		this.selectedDoor = rng.nextInt(2) + 1;
		return this.selectedDoor;
	}
	
	public int selectDoorAgain(int openDoor) {
		Random rng = new Random();
		
		if (rng.nextInt(2) == 1) {
			int[] possibleDoors = {1, 2, 3};
			possibleDoors = Arrays.stream(possibleDoors).filter(x -> x != openDoor && x != this.selectedDoor).toArray();
			
			this.selectedDoor = possibleDoors[rng.nextInt(possibleDoors.length)];
			return this.selectedDoor;
		} else {
			return this.selectedDoor;
		}
	}
}
