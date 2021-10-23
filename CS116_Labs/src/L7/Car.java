package L7;

public class Car extends Vehicle {

	@Override
	public void makeSound() {
		System.out.println("I am Car. I honk");
	}
	
	public void move(){
		System.out.println("I am Car. I drive");
	}
}
