package uebung02_020618;

import java.util.Random;

public class Auto implements Runnable {

	private String kennzeichen;
	private Parkhaus parkhaus;

	public Auto(String kennzeichen, Parkhaus parkhaus) {
		this.kennzeichen = kennzeichen;
		this.parkhaus = parkhaus;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}

	public Parkhaus getParkhaus() {
		return parkhaus;
	}

	public void setParkhaus(Parkhaus parkhaus) {
		this.parkhaus = parkhaus;
	}

	@Override
	public void run() {
		while (true) {

			try {
				Thread.sleep(new Random().nextInt(10000));
				this.parkhaus.einparken(this);
				System.out.println("Einfahrt: " + this.kennzeichen);

				Thread.sleep(new Random().nextInt(10000));
				this.parkhaus.ausparken(this);
				System.out.println("Ausfahrt: " + this.kennzeichen);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

}
