package L8;

import java.util.Arrays;
import java.util.Random;

public class Game {
	private int prizeLocation;
	
	Game() {
		Random rand = new Random();
		
		prizeLocation = rand.nextInt((3 - 1) + 1) + 1;
	}
	
	public int getPrizeLocation() {
		return prizeLocation;
	}

	public void reset() {
		Random rand = new Random();
		prizeLocation = rand.nextInt((3 - 1) + 1) + 1;
	}
	
	public int getOpenDoor(int p) {
		int[] doors = {1, 2, 3};
		Random rand = new Random();
		doors = Arrays.stream(doors).filter(x -> x != p && x != prizeLocation).toArray();
		return doors[rand.nextInt((doors.length - 1) + 1) + 1];
	}
}
