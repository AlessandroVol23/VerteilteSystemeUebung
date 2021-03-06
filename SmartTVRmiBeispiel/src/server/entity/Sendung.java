package server.entity;

import java.io.Serializable;
import java.util.Date;

public class Sendung implements Serializable{
	
	private String name;
	private String beschreibung;
	private Date startZeitpunkt = new Date();
	private Date endZeitpunkt  = new Date();

	public Sendung(String name, String beschreibung) {
		super();
		this.name = name;
		this.beschreibung = beschreibung;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBeschreibung() {
		return beschreibung;
	}
	public void setBeschreibung(String beschreibung) {
		this.beschreibung = beschreibung;
	}
	public Date getStartZeitpunkt() {
		return startZeitpunkt;
	}
	public void setStartZeitpunkt(Date startZeitpunkt) {
		this.startZeitpunkt = startZeitpunkt;
	}
	public Date getEndZeitpunkt() {
		return endZeitpunkt;
	}
	public void setEndZeitpunkt(Date endZeitpunkt) {
		this.endZeitpunkt = endZeitpunkt;
	}
	@Override
	public String toString() {
		return "Sendung [name=" + name + ", beschreibung=" + beschreibung + ", startZeitpunkt=" + startZeitpunkt
				+ ", endZeitpunkt=" + endZeitpunkt + "]";
	}
	
	
	

}
