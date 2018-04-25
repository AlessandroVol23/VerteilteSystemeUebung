package ueubung01;

import java.util.Random;

public class Kunde implements Runnable {

	private String name;
	private Parkhaus parkhaus;

	public Kunde(String name, Parkhaus ph) {
		this.name = name;
		this.parkhaus = ph;
	}

	public void kaufeAuto() {

	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(new Random().nextInt(10000));
				if (parkhaus.autos.isEmpty() == false) {
					System.out.println(
							"Kunde " + this.name + " kauft Auto: " + parkhaus.autos.pollFirst().getKennzeichen());
				} else {
					System.out.println("Kunde " + this.name + ": Kein Auto verfügbar. Warten....");
				}
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}

		}
	}

}
