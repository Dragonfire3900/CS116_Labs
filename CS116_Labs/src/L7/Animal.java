package L7;

public class Animal implements MovementInterface, SoundInterface{
	public void makeSound() {
		System.out.println("I am an Animal. I make sounds");
	}
	
	public void memberOf() {
		System.out.println("I am member of the Animal Kingdom");
	}
}
