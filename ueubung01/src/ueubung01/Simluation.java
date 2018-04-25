package ueubung01;

public class Simluation {

	public static void main(String[] args) throws InterruptedException {
		/*
		 * a - b Parkhaus parkhaus = new Parkhaus(10);
		 * 
		 * for(int i=1; i<=20; i++) { Auto a = new Auto("R-FH " + i, parkhaus);
		 * a.setDaemon(true); a.start(); }
		 * 
		 * Thread.sleep(30000); System.out.println("Ende der Simulation!");
		 */

		Parkhaus parkhaus = new Parkhaus();

		Hersteller hersteller = new Hersteller(parkhaus);
		Thread tHersteller = new Thread(hersteller);
		tHersteller.setDaemon(true);
		tHersteller.start();

		for (int i = 1; i <= 5; i++) {
			Kunde kunde = new Kunde("Autohaus" + i, parkhaus);
			Thread tKunde = new Thread(kunde);
			tKunde.setDaemon(true);
			tKunde.start();
		}

		Thread.sleep(30000);
		System.out.println("Ende der Simulation!");

	}

}
