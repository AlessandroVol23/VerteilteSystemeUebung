package uebung02_020618;

public class Parkhaus {

	private int parkplaetze;
	private Object monitor = new Object();

	public Parkhaus(int anzahlParkplaetze) {
		this.parkplaetze = anzahlParkplaetze;
	}

	public int getParkplaetze() {
		return parkplaetze;
	}

	public void setParkplaetze(int parkplaetze) {
		this.parkplaetze = parkplaetze;
	}

	public void einparken(Auto a) {
		synchronized (monitor) {
			while (this.parkplaetze == 0) {
				System.out.println("Warte an Schranke: " + a.getKennzeichen());
				try {
					monitor.wait();

				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			monitor.notifyAll();
			this.parkplaetze--;
		}

		System.out.println("Aktuelle Parkplätze: " + this.parkplaetze);

	}

	public void ausparken(Auto a) {
		synchronized (monitor) {

			while (this.parkplaetze <= 8) {
				System.out.println("Zu wenig Autos im Parkhaus. " + a.getKennzeichen() + " muss warten");

				try {
					monitor.wait();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
			monitor.notifyAll();
			this.parkplaetze++;
		}
		System.out.println("Aktuelle Parkplätze: " + this.parkplaetze);

	}
}
