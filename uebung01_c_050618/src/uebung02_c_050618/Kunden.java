package uebung02_c_050618;

import java.util.Random;

public class Kunden implements Runnable {

	private Parkhaus parkhaus;
	private Object monitor = new Object();

	public Kunden() {

	}

	public Kunden(Parkhaus auslieferungslager) {
		this.parkhaus = auslieferungslager;
	}

	public void autoKaufen() {

		Auto a = parkhaus.autoHolen();
		System.out.println("Kunde: Kaufe Auto " + a.getKennzeichen());
	}

	@Override
	public void run() {
		while (true) {
			try {
				Thread.sleep(new Random().nextInt(5000));
				this.autoKaufen();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}

	}

}
