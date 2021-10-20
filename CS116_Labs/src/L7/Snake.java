package L7;

public class Snake extends Animal{
	@Override
	public void move() {
		System.out.println("I am a Snake. I slither");
	}
	
	@Override
	public void makeSound() {
		System.out.println("I am a Snake. I hiss");
	}
}
