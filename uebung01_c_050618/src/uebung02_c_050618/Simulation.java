package uebung02_c_050618;

public class Simulation {

	public static void main(String[] args) {

		Parkhaus auslieferungslager = new Parkhaus(10);

		Thread fhThread = new Thread(new Fahrzeughersteller(auslieferungslager));
		fhThread.setDaemon(true);
		fhThread.start();

		for (int i = 0; i < 5; i++) {
			Kunden kunde = new Kunden(auslieferungslager);
			Thread t = new Thread(kunde);
			t.setDaemon(true);
			t.start();
		}

		try {

			Thread.sleep(30000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Ende der Simulation");
	}

}
