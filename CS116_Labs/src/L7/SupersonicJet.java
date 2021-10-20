package L7;

public class SupersonicJet extends Vehicle {
	
	@Override
	public void makeSound() {
		System.out.println("I am Supersonic Jet. I create sonic boom");
	}

	public void move(){
		System.out.println("I am Supersonic Jet. I fly");
	}

}
