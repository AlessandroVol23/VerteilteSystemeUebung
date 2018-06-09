package uebung02_1_040618;

public class Waiter implements Runnable {

	private KitchenCounter counter;
	private String name;

	public Waiter(KitchenCounter counter, String name) {
		super();
		this.counter = counter;
		this.name = name;
	}

	@Override
	public void run() {
		while (true) {
			System.out.println(this.name + " creates Leberkassemmel...");
			this.counter.put();
			try {
				Thread.sleep(500);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
