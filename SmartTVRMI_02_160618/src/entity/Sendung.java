package entity;

import java.io.Serializable;
import java.rmi.RemoteException;
import java.util.Date;

public class Sendung implements SendungIF {

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

	@Override
	public String getName() throws RemoteException {
		// TODO Auto-generated method stub
		return this.name;
	}

	@Override
	public String getBeschreibung() throws RemoteException {
		// TODO Auto-generated method stub
		return this.beschreibung;
	}

	@Override
	public Date getStartzeitpunkt() throws RemoteException {
		// TODO Auto-generated method stub
		return this.startzeitpunkt;
	}

	@Override
	public Date getEndzeitpunkt() throws RemoteException {
		// TODO Auto-generated method stub
		return this.endzeitpunkt;
	}

	@Override
	public void setName(String _name) throws RemoteException {
		this.name = _name;
	}

	@Override
	public void setBeschreibung(String _beschreibung) throws RemoteException {
		this.beschreibung = _beschreibung;
	}

	@Override
	public void setStartzeitpunkt(Date _start) throws RemoteException {
		this.startzeitpunkt = _start;
	}

	@Override
	public void setEndzeitpunkt(Date _end) throws RemoteException {
		this.endzeitpunkt = _end;
	}

	@Override
	public String ausgabe() throws RemoteException {
		String ausgabe = "Name: " + this.name + "\nBeschreibung: " + this.beschreibung;
		return ausgabe;
	}

}
