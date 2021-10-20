package L7;

public class Bird extends Animal {
	@Override
	public void move() {
		System.out.println("I am a Bird. I fly");
	}
	
	@Override
	public void makeSound() {
		System.out.println("I am a Bird. I chirp");
	}
}
