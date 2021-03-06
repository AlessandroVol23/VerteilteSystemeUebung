package uebung02;

import java.util.Random;

public class Waiter implements Runnable {

	private String name;
	private KitchenCounter theke;

	public Waiter(KitchenCounter theke, String name) {
		this.theke = theke;
		this.name = name;

	}

	@Override
	public void run() {
		// Waiter erstellt durchgehend Leberkassemmeln
		while(true) {

				try {
					Thread.sleep(new Random().nextInt(10000));
					System.out.println("Waiter " + this.name + " will Leberkasssemmel hinlegen.");
					theke.put();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		}
		
	}

}
