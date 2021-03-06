package uebung02_c_050618;

import java.util.ArrayDeque;
import java.util.Deque;

public class Parkhaus {

	private int kapazitaet;
	private Deque<Auto> autosInParkhaus = new ArrayDeque<>();
	private Object monitor = new Object();

	public Parkhaus(int maxKapazitaet) {
		this.kapazitaet = maxKapazitaet;
	}

	public void autoEinstellen(Auto a) {

		synchronized (monitor) {
			while (this.autosInParkhaus.size() >= kapazitaet) {
				try {
					System.out.println("Zu viele Autos im Parkhaus. " + a.getKennzeichen() + " muss warten.");
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}

			monitor.notifyAll();

			this.autosInParkhaus.addLast(a);

			System.out.println("Parkhaus: Auto eingestellt " + a.getKennzeichen());
			System.out.println("Anzahl an Autos " + this.autosInParkhaus.size());
			System.out.println("========================================================\n");
		}
	}

	public Auto autoHolen() {

		synchronized (monitor) {
			while (this.autosInParkhaus.size() <= 0) {
				try {
					monitor.wait();
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
			monitor.notifyAll();

			System.out.println("Parkhaus: Gebe Auto raus: " + this.autosInParkhaus.getLast().getKennzeichen());
			
			int anzahl = this.autosInParkhaus.size() - 1;
			
			System.out.println("Anzahl an Autos " + anzahl);
			
			System.out.println("========================================================\n");
			
			return autosInParkhaus.pollLast();
		}
	}

	public boolean istKapazitaetFrei() {
		if (this.autosInParkhaus.size() >= this.kapazitaet) {
			return false;
		} else {
			return true;
		}
	}

	public boolean autosVorhanden() {
		if (this.autosInParkhaus.size() == 0) {
			return false;
		} else {
			return true;
		}
	}

}
