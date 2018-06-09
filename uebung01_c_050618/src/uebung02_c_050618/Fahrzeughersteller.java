package uebung02_c_050618;

import java.util.Random;

public class Fahrzeughersteller implements Runnable {

	private Parkhaus parkhaus;

	public Fahrzeughersteller(Parkhaus _parkhaus) {
		this.parkhaus = _parkhaus;
	}

	@Override
	public void run() {
		while (true) {

			try {

				this.herstellen();
				Thread.sleep(new Random().nextInt(1000));

			} catch (InterruptedException e) {
				e.printStackTrace();
			}

		}
	}

	public void herstellen() {
		Auto a = new Auto("R-FH-" + new Random().nextInt(1000));
		parkhaus.autoEinstellen(a);
	}
}
