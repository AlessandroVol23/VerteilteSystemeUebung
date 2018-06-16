package entity;

import java.io.Serializable;
import java.util.Date;

public class Sendung implements Serializable{
	
	private String name;
	private String beschreibung;
	private Date startzeitpunkt;
	private Date endzeitpunkt;
	
	
	
	public Sendung(String name, String beschreibung) {
		this.name = name;
		this.beschreibung = beschreibung;
		this.startzeitpunkt = new Date();
		this.endzeitpunkt = this.startzeitpunkt;
	}



	@Override
	public String toString() {
		return "Sendung [name=" + name + ", Beschreibung=" + this.beschreibung + ", startzeitpunkt=" + startzeitpunkt
				+ ", endzeitpunkt=" + endzeitpunkt + "]";
	}
	
	

}
