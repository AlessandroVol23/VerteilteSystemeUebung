package ueubung01;

import java.util.Random;

public class Hersteller implements Runnable {

	Parkhaus parkhaus;

	public Hersteller(Parkhaus ph) {
		this.parkhaus = ph;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (true) {

			try {
				Thread.sleep(new Random().nextInt(10000));
				Auto auto = new Auto("R-FH-" + new Random().nextInt(1000));

				while (parkhaus.autos.size() >= 10) {
					// Wenn >= 10 Autos in Parkhaus sind 10 Sekunden warten so
					// lange bis Platz ist
					System.out.println("Parkhaus ist voll. Auto wartet: " + auto.getKennzeichen());
					Thread.sleep(10000);
				}

				parkhaus.autos.add(auto);
				System.out.println("Auto ist in Parkhaus gefahren. Auto: " + auto.getKennzeichen());

			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}

	}

}
