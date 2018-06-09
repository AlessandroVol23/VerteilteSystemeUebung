package uebung02_1_040618;

public class Student implements Runnable {

	private String name;
	private KitchenCounter counter;

	public Student(KitchenCounter counter, String name) {
		super();
		this.name = name;
		this.counter = counter;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this.name + " wants to take a Leberkasssemmel...");
			this.counter.take();
			try {
				Thread.sleep(10000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
