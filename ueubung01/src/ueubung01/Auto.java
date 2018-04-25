package ueubung01;

// Aktive Klasse
import java.util.Random;
import java.util.concurrent.TimeUnit;

public class Auto extends Thread {

	private boolean faehrt;
	private String kennzeichen;
	private Parkhaus parkhaus;

	public Auto(String kennzeichen, Parkhaus parkhaus) {
		this.faehrt = true;
		this.kennzeichen = kennzeichen;
		this.parkhaus = parkhaus;
		// System.out.println("Auto mit kennzeichen " + this.kennzeichen +
		// "erstellt!");
	}

	public Auto(String kennzeichen) {
		this.faehrt = true;
		this.kennzeichen = kennzeichen;

	}

	public boolean isFaehrt() {
		return faehrt;
	}

	public void setFaehrt(boolean faehrt) {
		this.faehrt = faehrt;
	}

	public String getKennzeichen() {
		return kennzeichen;
	}

	public void setKennzeichen(String kennzeichen) {
		this.kennzeichen = kennzeichen;
	}
	/*
	 * a-b
	 * 
	 * @Override public void run() {
	 * 
	 * while (true) {
	 * 
	 * // Auto f�hrt nach max 10 Sek in Parkhaus try { Thread.sleep(new
	 * Random().nextInt(10000)); parkhaus.autoFaehrtEin(this); //
	 * this.wait30Secs(); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * // Auto verl�sst nach max 10 Sek Parkhaus try { Thread.sleep(new
	 * Random().nextInt(10000)); parkhaus.autoFaehrtAus(this); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */
	/*
	 * a - b Aufgabe
	 * 
	 * @Override public void run() {
	 * 
	 * while (true) {
	 * 
	 * // Auto f�hrt nach max 10 Sek in Parkhaus try { Thread.sleep(new
	 * Random().nextInt(10000)); parkhaus.autoFaehrtEin(this); //
	 * this.wait30Secs(); } catch (InterruptedException e) { // TODO
	 * Auto-generated catch block e.printStackTrace(); }
	 * 
	 * // Auto verl�sst nach max 10 Sek Parkhaus try { Thread.sleep(new
	 * Random().nextInt(10000)); parkhaus.autoFaehrtAus(this); } catch
	 * (InterruptedException e) { // TODO Auto-generated catch block
	 * e.printStackTrace(); } }
	 * 
	 * }
	 */

}
