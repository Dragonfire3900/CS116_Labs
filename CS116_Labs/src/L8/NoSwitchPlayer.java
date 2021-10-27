package L8;

import java.util.Random;

public class NoSwitchPlayer extends Player implements PlayerInterface{
	public int selectDoor() {
		Random rng = new Random();
		this.selectedDoor = rng.nextInt(2) + 1;
		return this.selectedDoor;
	}
	
	public int selectDoorAgain(int openDoor) {
		return this.selectedDoor;
	}
}
