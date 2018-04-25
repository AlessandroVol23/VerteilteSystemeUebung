package uebung02;

import java.util.Random;

public class Student implements Runnable {

	private KitchenCounter theke;
	private String name;

	public Student(KitchenCounter theke, String string) {
		this.theke = theke;
		this.name = string;

	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(new Random().nextInt(10000));
				System.out.println("Student " + this.name + " will Leberkasssemmel essen.");
				theke.take();
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
