package ueubung01;

import java.util.ArrayDeque;
import java.util.Deque;

//Passive Klasse
public class Parkhaus {

	private int anzahlParkplaetzeGesamt;
	private int anzahlFreieParkplaetze;
	private int autoInParkhaus;
	public Deque<Auto> autos = new ArrayDeque<Auto>();
	
	/* a-b

	public Parkhaus(int kapa) {
		this.anzahlParkplaetzeGesamt = kapa;
		this.anzahlFreieParkplaetze = kapa;
		this.autoInParkhaus = 0;
	}

	public synchronized void autoFaehrtEin(Auto auto) {
		if (this.anzahlFreieParkplaetze > 0) {
			this.anzahlFreieParkplaetze--;
			this.autoInParkhaus++;
			System.out.println("Auto " + auto.getKennzeichen() + " fährt in Parkhaus ein!");
			this.printStatus();
		} else {
			System.out.println("Warten an Schranke: " + auto.getKennzeichen());
		}
	}

	public synchronized void autoFaehrtAus(Auto auto) {
		if (this.autoInParkhaus >= 2) {
			this.anzahlFreieParkplaetze++;
			this.autoInParkhaus--;
			System.out.println("Auto " + auto.getKennzeichen() + " fährt aus Parkhaus aus!");
			this.printStatus();
		} else {
			System.out.println("Zu wenig Autos in Parkhaus");
		}

	}

	public void printStatus() {
		System.out.println("Noch verfügbare Parkplätze: " + this.anzahlFreieParkplaetze);

	}
	
	*/

	public int getAnzahlParkplaetzeGesamt() {
		return anzahlParkplaetzeGesamt;
	}

	public void setAnzahlParkplaetzeGesamt(int anzahlParkplaetzeGesamt) {
		this.anzahlParkplaetzeGesamt = anzahlParkplaetzeGesamt;
	}

	public int getAnzahlFreieParkplaetze() {
		return anzahlFreieParkplaetze;
	}

	public void setAnzahlFreieParkplaetze(int anzahlFreieParkplaetze) {
		this.anzahlFreieParkplaetze = anzahlFreieParkplaetze;
	}

	public int getAutoInParkhaus() {
		return autoInParkhaus;
	}

	public void setAutoInParkhaus(int autoInParkhaus) {
		this.autoInParkhaus = autoInParkhaus;
	}
	
	
}
