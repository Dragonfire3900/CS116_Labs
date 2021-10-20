package L7;

public class Vehicle implements MovementInterface, SoundInterface {

	@Override
	public void makeSound() {
		System.out.println("I am Vehicle. I make sounds");
		
	}
	
	public void memberOf() {
		System.out.println("I am member of the Vehicle class");
	}

}
